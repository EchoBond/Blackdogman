<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <a href="add.jsp">增加</a>
    <a href="delete.jsp">删除</a>
    <a href="update.jsp">修改</a>
    <a href="select.jsp">查询</a>
    
    <form action="upFile.action" enctype="multipart/form-data" method="post">  
     <input name="uploadfile" type="file">  
     <input type="submit" value="上传">  
 	</form> 
 	
 	 <a href="https://eaassets-a.akamaihd.net/Origin-Client-Download/origin/live/OriginThinSetup.exe"	>下载网络资源</a>
 	 <br/>
 	 <a href="download.action">下载本地资源</a>
  </body>
</html>
