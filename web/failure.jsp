<%--

 Created by 10606 on 2017/6/22.

--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" %>
<html>
<head>
    <title>Failure</title>
</head>
<%
  List<String>info = (List<String>)request.getAttribute("info");
  if(info != null){
    Iterator<String> it = info.iterator();
    while(it.hasNext()){
%>
<h4><%=it.next()%></h4>
<%
    }
  }
%>
<a href="login.jsp">返回重新登录</a>
<body>
</body>
</html>
