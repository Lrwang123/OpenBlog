<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>请先登陆</title>
	<meta charset="UTF-8">
	<script>
		alert("请先登陆");
		window.location.href ="<%=basePath%>/user/login";
	</script>
  </head>
  
  <body>
    请先登陆
  </body>
</html>
