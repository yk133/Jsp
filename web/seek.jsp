<%@ page import="com.yk133.factory.DAOFactory" %><%--
  Created by IntelliJ IDEA.
  User: 10606
  Date: 2017/6/29
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Seek</title>
</head>
<body>
<a href="user.jsp" style="margin-left: 1%;font-size: 24px">返回主页</a>
<%
    request.setCharacterEncoding("UTF-8");
    String userid=(String)request.getSession().getAttribute("userid");
    String Key=request.getParameter("seeks");
    if(Key==null || Key.equals(""))
    {
        out.print("请输入正确关键字");
        response.setHeader("refresh","2;URL = user.jsp");
    }
    else
    {
        try{
            String Find[][]= DAOFactory.getViewDaoInstance().ViewFindText(Key);
            if(Find==null)
            {
                out.println("未找到相关内容，请核对关键字重新查找！！");
            }
            else
            {
                int i=0;
                for(;Find[i][0]!=null;i++)
                {
                    %>
<div >
    <table width="1178" border="1" cellspacing="1" cellpadding="1" align="center" >
    </table><p style="width:20%;margin-left:370px; font-size: 20px"><%
    out.println("<br>"+Find[i][1]);
%></p>
</div>
<form action="ViewTextFind.jsp" method="post" >
    <input type="text" value="<%=Find[i][0]%>" name="TextId" hidden>
    <input type="submit" value="查看原文"   style=" width:8% ; margin-left:370px; font-size: 20px" >
</form>
                    <%

                }

            }

        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }


    }







%>
<a href="user.jsp" style="margin-left: 1%;font-size: 24px">返回主页</a>
</body>
</html>
