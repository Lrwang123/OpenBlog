<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>其他错误</title>
    
	<meta charset="UTF-8">
  </head>
  
  <body>
    服务器繁忙，请稍后再试！
  </body>
</html>
