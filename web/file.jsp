<%@ page import="com.jspsmart.upload.SmartUpload" %>
<%@ page import="file.IpTimeStamp" %>
<%@ page import="java.io.File" %>
<%--

 Created by 10606 on 2017/6/22.

--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
  request.setCharacterEncoding("UTF-8");
%>
<%
  SmartUpload smart = new SmartUpload();
  smart.initialize(pageContext);
  try{
  smart.upload();
  //String name = smart.getRequest().getParameter("uname");
  IpTimeStamp its = new IpTimeStamp(request.getRemoteAddr());
  String ext = smart.getFiles().getFile(0).getFileExt();
  String fileName = its.getIpTimeRand() + "." + ext;
%>
  <%=fileName%>
<%
  smart.save("D:\\test");//.getFiles().getFile(0).saveAs("D:\\" + "test" + File.separator + fileName,SmartUpload.SAVE_PHYSICAL);


  }
  catch (Exception e)
  {
      e.printStackTrace();
  }
%>


<h3>成功上传</h3>
</body>
</html>
