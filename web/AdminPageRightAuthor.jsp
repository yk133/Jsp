<%@ page import="com.yk133.factory.DAOFactory" %><%--
  Created by IntelliJ IDEA.
  User: 10606
  Date: 2017/6/24
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>


<body>
<%
    request.setCharacterEncoding("UTF-8");

    String userid=(String)request.getSession().getAttribute("userid");
    if(userid==null || !userid.equals("yk133"))
    {
        response.setHeader("refresh","2;URL = user.jsp");
        out.println("<br><p style=\" font-size: 24px;margin-right: 100px \"> 您没有操作权限！！");
        out.println("<br><a href=\" user.jsp \" 返回主页></a>");

    }else
    try {
         String res[][]= DAOFactory.getViewDaoInstance().ViewAllAuthor();

        if(res[0][0]==null)
        {
            out.println("数据库查询出错！！！");
        }
        else
        {
            int i=0;
           for(i=i;res[i][0]!=null;i++)
            {
                if(res[i][0].equals("yk133"))continue;
%><p style="font-size: 24px; margin-left:100px ">
<div style="width:50%;padding:0;margin:0;float:left;box-sizing:border-box;font-size: 26px;">

    <%
         //out.println(res[i][1]);
         out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+res[i][0]);
    %></div>
</p><form action="/admin/DeleteUser.jsp" method="post"  onclick = "return confirm('确定要删除吗？')">
    <div style="width:500px;padding:0;margin-left:0px;float:left;box-sizing:border-box;">
    <input type="text" value="<%=res[i][0]%>" name="userid" hidden ><input type="text" value="yk133" name="mode" hidden >
    <input type="submit"   value="删除"  style=" font-size: 24px;margin-right: 100px "></div>
</form>

<%
            }
        }

    }
    catch (Exception E)
    {
        E.printStackTrace();
    }

%><br><br><br><br><br><br><br><br><br><br><br>
<form action="AdminPage.jsp" method="post"  ><div style="width:500px;padding:0;margin-left:0px;float:left;box-sizing:border-box;">
    <input type="text" value="<%=userid%>" name="userid" hidden >
    <input type="text" value="userid" name="mode" hidden >
    <input type="submit"   value="返回管理界面"  style="margin-right: 310px ; font-size: 24px;"></div>
</form>

</body>
</html>
