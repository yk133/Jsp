<%--

 Created by 10606 on 2017/6/21.

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logout</title>
</head>
<body>
<%
  response.setHeader("refresh","10;URL = login.jsp");
  session.invalidate();
%>
<h3>您已成功注销，两秒后跳转回登录页面</h3>
<h3>如果没有成功跳转，请点击<a href="login.jsp">这里</a></h3>
</body>
</html>
