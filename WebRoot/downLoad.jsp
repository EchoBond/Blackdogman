<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'downLoad.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@taglib prefix="s" uri="/struts-tags"%>  
  </head>
  
  <body>
   	<table>  
        <!-- 循环显示上传成功文件名 -->  
        <s:iterator value="fileFileName" status="fn">  
        <tr>  
        <td>  
        <!-- 上传成功文件名 -->  
        <s:property />          
        </td>  
        <td>  
        <!-- 下载文件链接内容为定义的下载Action -->  
        <!-- 下载文件名作为链接参数fileName值，用OGNL表达式表达 -->    
        <a href="<s:url value='download.action'>                 
                    <s:param name='fileName'  
 						value='fileFileName[#fn.getIndex()]'/>    
                 </s:url>">下载</a>  
        </td>  
        </tr>  
        </s:iterator>       
       </table>
  </body>
</html>
