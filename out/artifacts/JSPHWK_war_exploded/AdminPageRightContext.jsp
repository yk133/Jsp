<%@ page import="com.yk133.factory.DAOFactory" %><%--
  Created by IntelliJ IDEA.
  User: 10606
  Date: 2017/6/24
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ManageContext</title>
</head>

<script language = "JavaScript">
    function val(f){
        if (window.confirm('您确认要删除吗?')) {
            if (confirm(msg)==true){
                return true;
            }else{
                return false;

            }
        }
    }
</script>
<%
    request.setCharacterEncoding("UTF-8");
    String userid=(String)request.getSession().getAttribute("userid");

    if(userid==null||(!userid.equals("yk133")))
    {
        response.setHeader("refresh","2;URL = user.jsp");
        out.println("<br><p style=\" font-size: 24px;margin-right: 100px \"> 您没有操作权限！！");
        out.println("<br><a href=\" user.jsp \" 返回主页></a>");
    }
    else
    {
        try{
            String res[][]=DAOFactory.getViewDaoInstance().ViewAllTextAndAuthor();

            if(res[0][0]==null)
            {
                out.println("数据库查询出错！！！");
            }
            else
            {
                int i=0;
                for(i=i;res[i][0]!=null;i++)
                {
                    if(res[i][1].equals("yk133"))continue;
    %><p align="center">
    <div style="width:1100px;padding:0;box-sizing:border-box;font-size: 20px; " align="center">
    <table width="1100" border="1" cellspacing="1" cellpadding="1" align="center">
        <tr>
            <th width="70" height="53" scope="col"><%out.println(i+1);%></th>
            <th width="570"  scope="col"><%out.println(res[i][2]);%></th>
            <th width="274" scope="col"><%out.print("作者：&nbsp; "+res[i][1]);%></th>
            <th width="226" scope="col">
                <form action="/admin/DeleteContext.jsp" method="post"  onclick ="return confirm('确定要删除吗？')">

                    <input type="text" value="<%=res[i][0]%>" name="numid" hidden align="right">
                    <input type="text" value="<%=res[i][1]%>" name="userid" hidden align="right">
                    <input type="submit"   value="删除"  style=" font-size: 20px; margin-top: 5% " align="right">
                </form>
            </th>
        </tr>
    </table>
        <%

        %></div>
    </p>

    <%
                    }
                }

        }
        catch (Exception E)
        {
            E.printStackTrace();
        }
    }

%><br><br><br><br><br><br><br><br><br><br><br>
<form action="AdminPage.jsp" method="post"  ><div style="width:500px;padding:0;margin-left:0px;float:left;box-sizing:border-box;">
    <input type="text" value="<%=userid%>" name="userid" hidden >
    <input type="text" value="userid" name="mode" hidden >
    <input type="submit"   value="返回管理界面"  style="margin-right: 310px ; font-size: 24px;"></div>
</form>


</body>
</html>