<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<%@ page import="com.yk133.factory.DAOFactory" %>
<%@ page import="com.yk133.servlet.LoginServlet" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="static com.yk133.servlet.LoginServlet.user" %>
<%@ page import="com.yk133.vo.User" %><%--
  Created by IntelliJ IDEA.
  User: 10606
  Date: 2017/6/22
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ReadMyText</title>
</head>
<script language = "JavaScript">
    function val(f){
        if (window.confirm('您确认要删除这篇文章吗?')) {
            if (confirm(msg)==true){
                return true;
            }else{
                return false;

            }
        }
    }
</script>
    <script language="javascript">
    window.onload=function(){
    var bt=document.getElementById("bt");
    bt.onclick=function(){
    if(confirm("真的要删除吗?")){
    alert("点击了确认按钮");
    }
    else{
    alert("点击了取消按钮");
    }
    }
    }
    </script>


<style>
    .div-a{ background:url(img/timthumb.jpg)   fixed;width:1900px;height:5000px;padding:0px;color:black}
    .div-b{ background:#000;width:1900px;height:5000px;padding:0px;color:red;
    filter:alpha(Opacity=20);-moz-opacity:0.2;opacity: 0.2}
</style>
<style>

    *{
        padding: 0;
        margin: 0;
    }

    body{
        padding: 0px;
        background: url(img/3333gif.gif) center fixed ;
        font-size: 30pt;
        color: white;
        /*text-align:center;*/
    }

    .demo{
        padding:0px;
        background-color: rgba(0,0,0,0.4);/* IE9、标准浏览器、IE6和部分IE7内核的浏览器(如QQ浏览器)会读懂 */
    }
    .demo p{
        color:white;
        /*text-align:center;*/
    }

</style>


<body>
<div class ="demo">
    <div align="left">
        <%
            request.setCharacterEncoding("UTF-8");
            List<String>info = (List<String>)request.getAttribute("info");
            if(info != null){
                Iterator<String> it = info.iterator();
                while(it.hasNext()){
        %>
        <h5><%=it.next()%></h5>
        <%
                }
            }
            out.println("<br>");
        %>
        <a href="user.jsp" style="font-size: 28px">返回主页</a><br><br>
        <font size=7>我的文章：<p><br></font></div>
<%
        User user = new User();
        user.setUserid((String) request.getSession().getAttribute("userid"));

         String  res[]=null;
        try{
            //out.println("user Read MY Context+"+user.getUserid());
            res = DAOFactory.getReadMyDaoInstance().ReadMyText(user);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if(res==null)
            {
%><font=5>您没有写过一篇文章，请返回！！<br><br><br><br><br><br><br><br><br><br><br><br><br><br><a href="user.jsp">返回我的主页</a></font> <%
            }
            else
            {
%><%
                try{
                    int i=0;
                    while(res[i]!=null)
                    {
                           String dis[][]=null;
                           String strid=res[i++];
                           try{
                               dis=DAOFactory.getReadMyDaoInstance().ViewTextDiscuss(strid);
                           }
                           catch (Exception e)
                           {
                               e.printStackTrace();
                           }
                           String title=res[i++];
                           String context=res[i++];
                           String date=res[i++];
                           date=date.substring(0,19);

                %><br><div align="center">
               <table width="1300" border="2" cellspacing="1" cellpadding="1" >
				  <tr>
					<%
                        out.println(title+"<p>");
                    %>
				  </tr>

				  <tr>
                      <td><p style="font-size: 24px; line-height:38px;text-align:left">
                          <%
                      out.println(context+"<br><br>");
                  %>
                      </p> </td></tr>
                   </table></div>
  <p style="text-align: center;font-size: 24px ;margin-left: 55%">  <%=date%>

    <form action="DeleteMyText.jsp" method="post"  onclick ="return confirm('确定要删除吗？')">
    <input type="text" value="<%=strid%>" name="TextId" hidden >
    <input type="submit"   value="删除"  style=" font-size: 24px;margin-left: 80%">
</form>
    <form action="EditMyText.jsp" method="post" >
        <input type="text" value="<%=strid%>" name="TextId" hidden >
        <input type="text" value="<%=title%>" name="Title" hidden >
        <input type="text" value="<%=context%>" name="Context" hidden >
        <input type="submit" value="编辑"  style=" font-size: 24px;margin-left: 80% ">
    </form>
    </p>
&nbsp;<p style="text-align: center;font-size: 24px" ><%
                      int j=0;
                if(dis==null)
                {
                    out.print("暂无评论<br>");
                }
                else {
                    while (dis[j][0] != null) {

%></p><br>
    <p align="center">
    <table width="900" border="1" cellspacing="1" cellpadding="1" align="center" valign="center" style="font-size:18px;" align="center" >
        <tr>
            <th width="200" scope="col">&nbsp;</th>
            <th width="599" scope="col"><%
                out.println("留言于："+dis[j][2] );
            %></th>

        </tr>
        <tr>
            <th height="175" scope="row" >
                <% out.println(dis[j][0] + "<br>");%></th>
            <td valign="top" style="font-size: 20px">
                <%out.println("&nbsp;"+dis[j][1]);%>
            </td>
        </tr>

    </table></p><%      j++;
                        }
                    }

                    }
                    %><br><%
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    %>
<br><br><br>
    <a href="user.jsp">返回我的主页</a>
</body>
</html>
