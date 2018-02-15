<%@ page import="com.yk133.factory.DAOFactory" %><%--
  Created by IntelliJ IDEA.
  User: 10606
  Date: 2017/6/26
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DiscussThis</title>
</head>
<body style="font-size: 26px ;color: red" >
<%
    request.setCharacterEncoding("UTF-8");
    String userid=(String)request.getSession().getAttribute("userid");
    String Mydis=request.getParameter("Mydis");
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
        out.print("评论成功！！");
        response.setHeader("refresh","2;URL = ViewText.jsp?TextId="+Textid);
        out.println("2秒后返回");
    }

%>
<br>
<form action="ViewText.jsp" method="post" >
    <input type="text" value="<%=Textid%>" name="TextId" hidden>
    <input type="text" value="<%=userid%>" name="Mydis" align="center" hidden>
    <input type="submit" value="返回" align="center" style="font-size: 26px">
</form>

</body>
</html>
