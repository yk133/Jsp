<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "">
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %><%--
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
        height: 1000px;
        /*
           text-align:center;
        */
    }

    .demo{
        padding:0px;
        background-color: rgba(0,0,0,0.2);
        height: 1000px;
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
    request.getSession().setAttribute("userid",userid);

    if(!(userid==null ||"".equals(userid))){
        request.getSession().setAttribute("userid",userid);
        session.setAttribute("admin",1);
    }
    if(!userid.equals("yk133"))
    {
        response.setHeader("refresh","2;URL = user.jsp");
        out.println("<br><p style=\" font-size: 24px;margin-right: 100px \"> 您没有操作权限！！");
        out.println("<br><a href=\" user.jsp \" 返回主页></a>");
    }
    else
    {
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
        {iter.next();continue;}
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
        <input type="submit" value="管理文章"   style=" width:8%; margin-left:0px; font-size: 20px;margin-top:200px;float:left " >
    </form>
        <form action="AA1Aut.jsp" method="post" >
            <input type="submit" value="管理账户"   style=" width:8%; margin-left:0px; font-size: 20px;margin-top:200px;float:left " >
        </form>
        <br></div>
    <div class="col-xs-6"><br>
        <!--<Iframe align="left" src="AdminPageRightContext.jsp" id="test" width="1300" height="1000"  scrolling="yes" frameborder="0"  class="demo" style="margin-left:120px;margin-top:0px;"></iframe>!-->
    </div>
</div>
<br><br><br><br>

<%
    }
%>
</body>
</div>
</html>
