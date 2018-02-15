<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "">
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.yk133.factory.DAOFactory" %><%--
  Created by IntelliJ IDEA.
  User: 10606
  Date: 2017/6/24
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<style>
    *{
        padding: 0;
        margin: 0;
    }

    body{
        padding: 0px;
        background:url(img/3333gif.gif) center;
        font-size: 24pt;
        color: black;
        width: auto;
        /*
           text-align:center;
        */
    }

    .demo{
        padding:0px;
        background-color: rgba(0,0,0,0.2);

    }
    .demo p{
        color:white;
        text-align:center;
    }

</style>

<script language="javascript" type="text/javascript">
    function PassWordReturnJavaScript()
    {
        window.location.href = "\Logout.jsp";
    }
</script>

<div class="demo">
    <body>
    <p style="font-size: 36px;color: black; text-align: center" >后台管理</p>
    <%
        String userid = request.getParameter("userid");
        userid = (String)request.getSession().getAttribute("userid");
        //out.println("Amdin+"+userid);
        request.getSession().setAttribute("userid",userid);

        if(!(userid==null ||"".equals(userid))){
            request.getSession().setAttribute("userid",userid);
            session.setAttribute("admin",1);
        }
        if(!userid.equals("yk133"))
        {
            response.setHeader("refresh","0;URL = user.jsp");
        }
        request.setCharacterEncoding("UTF-8");
        List<String> info = (List<String>)request.getAttribute("info");
        if(info != null){
            Iterator<String> it = info.iterator();
            while(it.hasNext()){
    %>
            <h5><%=it.next()%></h5>
    <%
            }
        }

    %>yk133
    <div class="col-xs-9"><input type=button align="left" onClick="PassWordReturnJavaScript()" value="注销" style=" width:8%;margin-left:1px; font-size: 20px">
        <h3>在线用户:</h3>
        <%
            Set all = (Set)this.getServletContext().getAttribute("online");
            Iterator iter = all.iterator();
            while(iter.hasNext()){
                String  t=(String)iter.next();
                if(t.equals("userid"))
                {
                    iter.next();
                    continue;
                }
        %>
        <%=iter.next()%>
        <%
                out.println("<br>");
            }
        %>

        <div class="row">
            <br><a href="user.jsp" >主页</a><br></div>
        <div class="col-xs-4">
            <form action="AA1Con.jsp" method="post" >
                <input type="submit" value="管理文章"   style=" width:8%; margin-left:40px; font-size: 20px;margin-top:200px;float:left " >
            </form>
            <form action="AA1Aut.jsp" method="post" >
                <input type="submit" value="管理账户"   style=" width:8%; margin-left:0px; font-size: 20px;margin-top:200px;float:left " >
            </form>
            <br></div>
        <div class="col-xs-6"><br>
            <!--<Iframe align="left" src="AdminPageRightContext.jsp" id="test" width="1300" height="1000"  scrolling="yes" frameborder="0"  class="demo" style="margin-left:120px;margin-top:0px;"></iframe>!-->
        </div>
    </div>
    <br>

    <article>
        <fieldset style="width: 700px">
            <%
                request.setCharacterEncoding("UTF-8");

                userid=(String)request.getSession().getAttribute("userid");
                if(userid==null || !userid.equals("yk133"))
                {
                    response.setHeader("refresh","2;URL = user.jsp");
                    out.println("<br><p style=\" font-size: 24px;margin-right: 100px \"> 您没有操作权限！！");
                    out.println("<br><a href=\" user.jsp \" 返回主页></a>");
                }
                else
                    {
                        try
                        {
                            String res[][]= DAOFactory.getViewDaoInstance().ViewAllAuthor();

                            if(res[0][0]==null)
                            {
                                out.println("数据库查询出错！！！");
                            }
                            else
                            {
                                int i=0;
                                for(i=i;res[i][0]!=null;i++)
                                {
                                    if(res[i][0].equals("yk133"))continue;
                %><p align="center">
                    <table  border="1" cellspacing="1" cellpadding="1" align="center" style="font-size: 24px">
                        <tr>
                            <th width="360" ><%out.print("用户："+res[i][0]);%></th>
                            <th width="180" >
                                <form action="/admin/DeleteUser.jsp" method="post"  >
                                    <div style="width:500px;padding:0;margin-left:0px;float:left;box-sizing:border-box;">
                                        <input type="text" value="<%=res[i][0]%>" name="userid" hidden >
                                        <input type="text" value="yk133" name="mode" hidden >
                                        <input type="submit"   value="删除"  style=" font-size: 24px;margin-right: 100px "onclick = "return confirm('确定要删除吗？')"></div>
                                </form>
                            </th>
                        </tr>
                    </table>
                </p>

                <%
                                }
                            }

                        }
                        catch (Exception E)
                        {
                            E.printStackTrace();
                        }
                }
            %>
        </fieldset>
    </article>

    </body><br> <br> <br> <br> <br><br> <br> <br> <br>
</div>
</html>
