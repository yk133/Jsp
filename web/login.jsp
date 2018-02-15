<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>

<%@page contentType="text/html;charset=UTF-8" import="java.util.*" %>
<html>
<head>
    <title>MyLogin</title>
</head>
<style>
    .div-a{ background:url(img/36-1F529205925534.jpg)   fixed;width:1920px;padding:0px;color:black;}
    .div-b{ background:black;width:1920px;padding:0px;color:black;
        filter:alpha(Opacity=40);-moz-opacity:0.4;opacity: 0.4}
</style>
<style>
    *{
        padding: 0;
        margin: 0;
    }

    body{
        padding: 0px;
        background: url(img/3333gif.gif) center center fixed ;
        font-size:16pt;
        color: black;
        text-align:center;
    }
    .demo{
        padding: 0px;
        background-color: rgba(0,0,0,0.1);/* IE9、标准浏览器、IE6和部分IE7内核的浏览器(如QQ浏览器)会读懂 */
    }
    .demo p{
        color:white;

    }
</style>


<body style="background:url('img/timg.jpg') no-repeat"></body>


<script language = "JavaScript">
    function validate(f){
        if(!(/^\w{5,15}$/.test(f.userid.value))){
            alert("用户ID必须是5 ~ 15位~");
            f.userid.focus();
            return false;
        }
        if(!(/^\w{5,15}$/.test(f.pwd.value))){
            alert("用户密码必须是5 ~ 15位~");
            f.pwd.focus();
            return false;
        }
    }
</script>

<marquee behavior=alternate scrollamount=22><font size="7">欢迎来到文笔论坛</marquee>

<%
    request.setCharacterEncoding("UTF-8");
    List<String>info = (List<String>)request.getAttribute("info");
    if(info != null){
        Iterator<String> it = info.iterator();
        while(it.hasNext()){
%>
<h5><%=it.next()%></h5>
<%
        }
    }

    String userid=(String) request.getSession().getAttribute("userid");
    if(userid!=null )
    {
        request.setAttribute("userid",userid);
        response.setHeader("refresh","2;URL = user.jsp");
        out.println("您已登录！将自动跳入您的主页");
    }
    else
    {
%>

<form action="LoginServlet" method="post" onSubmit="return validate(this)">
    <div align="right" style="font-size: 24px">用户ID:
        <input type="text"name = "userid">
        &nbsp;
        密&nbsp;码:
        <input type="password" name = "pwd" >
        &nbsp;
        <input type="submit" value="登录" style="font-size: 22px">
        &nbsp;
        <input type="reset" value="重置"style="font-size: 22px">
        &nbsp;<a href="registered.jsp">用户注册</a>
    </div>
</form>


    <p>&nbsp;</p>
<p>&nbsp;</p>
<Iframe align="left" src="UnMainPage.jsp" id="test" width="1900" height="1000"  scrolling="yes" frameborder="0" noresize class="demo"></iframe>
<%



    }


%>

</div>
</div>
</html>
