<%@ page import="com.yk133.factory.DAOFactory" %>
<%@ page import="java.lang.Math" %>

<%--
  Created by IntelliJ IDEA.
  User: 10606
  Date: 2017/6/23
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MainPage</title>
</head>
<style>
    .div-a{ background: url(img/3333gif.gif);   fixed ; width:1900px; margin-left: 0.001%;height:auto; padding:0px;color:black;  }
    .div-b{ background:white ;width:1900px; height:auto;margin-left: 0.001%;padding:0px;color:black;
        filter:alpha(Opacity=74);-moz-opacity:0.740;opacity: 0.740}
</style>

<body><div class="div-b"><div class="div-a"><font size="18"><p style="font-size: 38px; div-left;">&nbsp;最近更新：<br><br></p>
    <%
        try{
            String res[][]=DAOFactory.getViewDaoInstance().ViewAllTextAndAuthor();
            if(res==null)
            {
                out.println("数据库查询出错，请检查数据库！！");
            }
            else
            {
                int i=0;
                while(res[i][0]!=null)
                {
                    %><div >
               <table width="1178" border="1" cellspacing="1" cellpadding="1" align="center" >
				  <tr><p style=" text-align:center ;font-size: 30px"><strong>
    <%
        out.println(res[i][2]+"<br>");
    %></strong></p>
    </tr>
    <div align="center">
        <tr>
            <td height="140" valign="top"><p style=" font-size: 22px">
                <%
                    out.println(res[i][3].substring(0,Math.min(10,res[i][3].length()))+"<br>....<br>");
                %>
            </p> </td></tr>
        </table><p style="width:20%;margin-left:370px; font-size: 20px"><%
    out.println("作者："+res[i][1]);
%></p>
</div>
    <form action="ViewText.jsp" method="post" >
        <input type="text" value="<%=res[i][0]%>" name="TextId" hidden>
        <input type="submit" value="查看原文"   style=" width:8% ; margin-left:370px; font-size: 20px" >
    </form>

    <%              i++;
                }
            }
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }

    %>
<br><br>
</font></div></div><br>
</body>
</html>
