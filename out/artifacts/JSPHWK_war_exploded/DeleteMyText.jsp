<%@ page import="com.yk133.factory.DAOFactory" %>
<%@ page import="com.yk133.servlet.LoginServlet" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: 10606
  Date: 2017/6/23
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String userid=(String)request.getSession().getAttribute("userid");
    List<String>info = (List<String>)request.getAttribute("info");
    if(info != null){
        Iterator<String> it = info.iterator();
        while(it.hasNext()){
%>
<h5><%=it.next()%></h5>
<%
        }
    }


    request.setCharacterEncoding("UTF-8");
    String TextId=request.getParameter("TextId");
    //out.println("bbbbbbbbb$$$$$$$$");
    try {
        DAOFactory.getEditMyTextDaoInstance().DeleteMyText(LoginServlet.user, TextId);
        out.println("删除成功！<br><br> ");
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }

%>
<a href="ReadMyText.jsp">点击返回</a>
</body>
</html>
