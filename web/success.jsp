<%--

 Created by 10606 on 2017/6/21.

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
  response.setHeader("refresh","2;URL = user.jsp");
  String userid = request.getParameter("userid");
  if(!(userid==null ||"".equals(userid)))
  {
      session.setAttribute("userid",userid);
      request.getSession().setAttribute("userid",userid);
      //out.println("A+"+userid);
      session.setAttribute("admin",1);
  }
%>
<h3>您已成功登录，两秒后跳转到用户页面</h3>
<h3>如果没有成功跳转，请点击<a href="user.jsp">这里</a></h3>
</body>
</html>
