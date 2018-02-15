<%@ page import="com.yk133.factory.DAOFactory" %><%--
  Created by IntelliJ IDEA.
  User: 10606
  Date: 2017/6/24
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<title>View</title>
</head>
<style>
    .div-a{ background:url(img/3333gif.gif)   fixed;width:1920px;padding:0px;color:black}
    .div-b{ background:white;width:1920px;padding:0px;color:red;
        filter:alpha(Opacity=80);-moz-opacity:0.8;opacity: 0.8}
</style>

<body><div class="div-a"><div class="div-b" align="center"><font size="18">
    <%
        request.setCharacterEncoding("UTF-8");
        String Textid=request.getParameter("TextId");

        if(Textid==null)
        {
            out.println("读取Id错误！！");
        }
        else
        {
            String s[]=null;
            try {

                s=DAOFactory.getViewDaoInstance().ViewAuthor(Textid);
            }
            catch (Exception e) {

            }
            if(s==null)
            {
                out.println("读取错误！！");
            }
            else
            {
    %><div align="center">
    <table width="1200" border="1" cellspacing="1" cellpadding="1" >
        <tr>
            <%
                out.println(s[0]+"<br>");
            %>
        </tr>
        <div align="center">
            <tr>
                <td><font size=4><strong>
                    <%
                        out.println(s[1]+"<br>....<br>");
                    %>
                </strong></font> </td></tr>
    </table></div><%

        }
    }

%>
    <a href="user.jsp">返回我的主页</a>
    <a href="MainPage.jsp">返回主站</a>


</font></div></div>

</body>
</html>
