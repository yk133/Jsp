<%--

 Created by 10606 on 2017/6/21.

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head><title>registered</title></head>
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
<form action="InsertServlet" method="post"onSubmit="return validate(this)">
  <table align = "center" border="1" style="border-collapse: collapse;">
    <tr>
      <td colspan="2">用户注册</td>
    </tr>
    <tr>
      <td>用户ID：</td>
      <td><input type="text" name="userid" /></td>
    </tr>
    <tr>
      <td>用户名：</td>
      <td><input type="text" name="name" /></td>
    </tr>
    <tr>
      <td>密码：</td>
      <td><input type="password" name="pwd" /></td>
    </tr>
    <tr>
      <td class="tdstyle" colspan="2">
        <input type="submit" value="注册" />
      </td>
    </tr>
  </table>
</form>