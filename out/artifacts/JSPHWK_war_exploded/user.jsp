<%@page import="java.util.List" %>
<%@ page import="com.jspsmart.upload.SmartUpload" %>
<%@ page import="file.IpTimeStamp" %>
<%@ page import="java.io.File" %>
<%@ page import="javax.servlet.ServletContext"%>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.yk133.servlet.UpdateTextServlet"%>
<%--

Created by 10606 on 2017/6/22.

--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
  .div-a{ background:url(img/3333gif.gif)   fixed;width:1920px;padding:0px;color:black}
  .div-b{ background:black;width:1920px;padding:0px;color:red;
    filter:alpha(Opacity=40);-moz-opacity:0.4;opacity: 0.4}
</style>

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

<head>
  <title>user</title>
</head>
<script language="javascript" type="text/javascript">
    function PassWordReturnJavaScript()
    {
        window.location.href = "\Logout.jsp";
    }
</script>

<%
request.setCharacterEncoding("UTF-8");
  String userid = (String)request.getSession().getAttribute("userid");
List<String>info = (List<String>)request.getAttribute("info");
  if(info != null){
  Iterator<String> it = info.iterator();
    while(it.hasNext()){
    %>
    <h5><%=it.next()%></h5>
      <%
        }
    }
%><div class="demo">

<body>

<h3 align="left"></label>当前用户:</h3>
  <!--
  Set all = (Set)this.getServletContext().getAttribute("online");
  Iterator iter = all.iterator();
  String sp[]=new String[100];
  int i=0;
  while(iter.hasNext()){
    //sp[i++]= (String) iter.next();

  }
  !-->
<%
  out.print(userid+" 您好");

%>

<input type=button align="left" onClick="PassWordReturnJavaScript()" value="注销" style="font-size: 24px"><br>
<!--
<form action="file.jsp"method="get"enctype="multipart/form-data" >
  请选择文件:<input type="file" name = "pic" >
  <input type="submit"value="上传">
</form>
!-->

<a href="WriteNewText.jsp" >写文章</a>
<a href="ReadMyText.jsp" >我的文章</a>
<a href="user.jsp" >主页</a>



<%

if("yk133".equals(userid))
{
    request.getSession().setAttribute("yk133","userid");
    //out.println("user + "+userid);
    request.getSession().setAttribute("admin",1);
    out.println("<a href=\"AdminPage.jsp\" >后台管理</a>");

}%>
<form action="seek.jsp" method="post" style="margin-left: 1%;font-size: 24px">
  <input width="30" type="text" name="seeks" style="font-size: 24px">
  <input type="submit" value="查找" style="margin-left: 1%;font-size: 24px">
</form>
<br>

<Iframe style="margin-left: 0.001%" src="MainPage.jsp" id="test" width="1900" height="1000"  scrolling="yes" frameborder="0" noresize class="demo"></iframe>
</div>
</div>
</html>
