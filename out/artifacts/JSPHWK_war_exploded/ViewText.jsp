<%@ page import="com.yk133.factory.DAOFactory" %>
<%@ page import="javax.xml.soap.Text" %><%--
  Created by IntelliJ IDEA.
  User: 10606
  Date: 2017/6/24
  Time: 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<style>
    .div-a{ background:url(img/3333gif.gif)   fixed;width:1880px; padding:0px;color:black}
    .div-b{ background:white;width:1880px; padding:0px;color:Black;
        filter:alpha(Opacity:85);-moz-opacity:0.85;opacity: 0.85}
</style>

<body><div class="div-a"><div class="div-b" align="center"><font size="18">
    <%
        request.setCharacterEncoding("UTF-8");
        String Textid=request.getParameter("TextId");
        String res[] = null;
        String discuss[][] = null;
        if(Textid==null)
        {
            out.println("读取Id错误！！");
        }
        else
        {

            int flag=0;

            try {
                res=DAOFactory.getViewDaoInstance().ViewText(Textid);
                discuss=DAOFactory.getViewDaoInstance().ViewTextDiscuss(Textid);
            }
            catch (Exception e) {
                e.printStackTrace();
                flag=1;
            }
            if(flag==0&&(res == null))
            {
                out.println("数据库内无内容！！");
            }
            else if(flag==1)
            {
                out.println("读取错误！！");
            }
            else
            {
                %><div align="center">
               <table width="1179"  border="1" cellspacing="1" cellpadding="1" >
				  <tr>
    <%
        out.println(res[0]+"<br><br>");
    %>
    </tr>
    <div align="center">
        <tr>
            <td><p style="font-size: 20px; line-height:40px">
                <%
                    out.println(res[1]+"<br>....<br>");
            }
        }
        %>
            </p> </td></tr>
               </table></div><br>------------------------------------------------------------------------------<br><br>
        <p style="font-size:28px;">留言板：</p>
                <%
                int i=0;
                if(discuss==null)
                {
                    out.print("暂无评论");
                }
                else {
                    while (discuss[i][0] != null) {

                     %>

    <table width="900" border="1" cellspacing="1" cellpadding="1" style="font-size:18px;" align="center" >

        <tr>
            <th width="200" scope="col">&nbsp;</th>
            <th width="599" scope="col"><%
                    out.println("留言于："+discuss[i][2].substring(0,19) + "<br>");
            %></th>

        </tr>
        <tr>
            <th height="175" scope="row" >
                <% out.println(discuss[i][0] + "<br>");%></th>
            <td valign="top" style="font-size: 20px">
                <%out.println("&nbsp;"+discuss[i][1] + "<br>");%>
            </td>
        </tr>


    </table><br>
    <%
                i++;
            }
        }


    %>
                </p> </td></tr>
    </table>
        <p style="font-size: 26px;color: black;" >我要留言：</p>
    <form action="DiscussThis.jsp" method="post" align="center" width="300px" height="200px">
        <input type="text" value="<%=Textid%>" name="TextId" hidden>
        <textarea name="Mydis" rows="6" cols="70" style="font-size: 20px">请输入留言</textarea><br>
        <input type="submit" value="评论" align="center"style="font-size: 20px">
    </form>


    <form action="MainPage.jsp" method="post" >
        <input type="submit" value="返回浏览" style="font-size: 24px">
    </form>

</div>
</font></div></div>
</body>
</html>
