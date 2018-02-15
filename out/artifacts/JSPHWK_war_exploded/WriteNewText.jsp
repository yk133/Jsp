<%--
  Created by IntelliJ IDEA.
  User: 10606
  Date: 2017/6/22
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WriteNewText</title>
</head>

<style>

    *{
        padding: 0;
        margin: 0;
    }

    body{
        padding: 0px;
        background:url(img/3333gif.gif);
        font-size: 24pt;
        color: white;
        width:1920;
        /*
           text-align:center;
        */
    }

    .demo{
        padding:0px;
        background-color: rgba(0,0,0,0.4);

    }
    .demo p{
        color:white;
        text-align:center;
    }

</style>
<style>
    .div-a{ background:url(img/3333gif.gif)   fixed;width:1920px;padding:0px;color:black}
    .div-b{ background:black;width:1920px;padding:0px;color:white;
        filter:alpha(Opacity=90);-moz-opacity:0.9;opacity: 0.9}
</style>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String userid=(String)request.getSession().getAttribute("userid");

%>
<div class="div-a"><div class="canvas-nest.js">
<script language="JavaScript" src="js/canvas-nest.js"
        type="text/JavaScript"></script>

<form action ="UpdateTextServlet" method="post" >
    &nbsp;
    <div align="center">
        <p>
            <textarea name="TextName" cols="50" style="font-size: 18px">请输入文章标题</textarea>
        </p><br>
        <textarea name="NewText" rows="28" cols="150" style="font-size: 20px">请输入文章内容：
    </textarea>
        </p>
        <p align="center">
            <input type="submit" value="保存" style="font-size: 24px" >
        </p>
        <p align="center">
            <input type="reset" name="Submit" value="重置" style="font-size: 24px">
        </p>
    </div>
</form>

<form action ="user.jsp" method="post" align="center">
<input type="submit" value="返回主页" style="font-size: 28px" align="center">
</form>
</div></div>
</body>
</html>
