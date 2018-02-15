<%@ page import="com.yk133.factory.DAOFactory" %><%--
  Created by IntelliJ IDEA.
  User: 10606
  Date: 2017/6/23
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <%
        String userid=(String)request.getSession().getAttribute("userid");
        String Mydis=request.getParameter("discuss");
        String Textid=request.getParameter("TextId");
        int f=0;

        try {
            DAOFactory.getViewDaoInstance().AddTextDiscuss(Textid, userid, Mydis);
        }
        catch (Exception e)
        {
            f=1;
            e.printStackTrace();
        }
        if(f==1)
        {
            out.print("添加失败，服务器忙！请稍候再试！！");
        }
        else
        {
            out.print("添加成功！！");
        }


    %>
<a href="user.jsp">返回主页</a>

</body>
</html>
