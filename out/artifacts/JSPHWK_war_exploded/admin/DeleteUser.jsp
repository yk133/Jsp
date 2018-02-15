<%@ page import="sun.security.smartcardio.SunPCSC" %>
<%@ page import="com.yk133.factory.DAOFactory" %><%--
  Created by IntelliJ IDEA.
  User: 10606
  Date: 2017/6/25
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body  style="font-size: 24px">
<%
    String userid=request.getParameter("userid");
    try {
        if(DAOFactory.getEditMyTextDaoInstance().DeleteMyAllText(userid) && DAOFactory.getIUserDAOInstance().DeleteUser(userid)){
            out.println("用户:"+userid+" 已经被成功删除！！");
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }


%>
<form action="/AdminPageRightAuthor.jsp" method="post" style="font-size: 24px">
    <input type="submit" value="返回">
</form>

</body>
</html>
