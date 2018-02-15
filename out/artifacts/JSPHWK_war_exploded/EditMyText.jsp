
<%--
  Created by IntelliJ IDEA.
  User: 10606
  Date: 2017/6/23
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditMyContxet</title>
</head>
<body>

<script language = "JavaScript">
    function validate(f){
        if(!(/^[\s\S]{1,25}$/.test(f.Title.value))){
            alert("标题长度最长25位");
            f.Title.focus();
            return false;
        }
        if(!(/^[\s\S]{1,20000}$/.test(f.Text.value))){
            alert("您的文章太长啦！最长20000字哦！");
            f.Text.focus();
            return false;
        }
    }
</script>

<%
    request.setCharacterEncoding("UTF-8");
    String TextId=request.getParameter("TextId");
    String Title=request.getParameter("Title");
    String Context=request.getParameter("Context");
    String tcontext=Context;
    //context.replaceAll(" ","&bnsp;");
    Context=Context.replaceAll("<br>","\r\n");

    %>
<form action ="EditMyTextServlet" method="post" onSubmit="return validate(this)">
    &nbsp;
    <div align="center">
        <p>
            <textarea name="Title" cols="50"><%=Title%></textarea>
        </p>
        <textarea name="Text" rows="30" cols="150" style="font-size: 20px"><%=Context%>
        </textarea>
        <input type="text" name="TextId" value="<%=TextId%>" hidden>
        </p>
        <p align="center">
            <input type="submit" value="保存修改" style="font-size: 24px">
        </p>
        <p align="center">
            <input type="reset" name="Submit" value="重置" style="font-size: 24px">
        </p>
    </div>
</form>


<form action="user.jsp" method="post">
    <input type="submit" value="返回我的文章" style="font-size: 24;">
</form>
</body>

</html>
