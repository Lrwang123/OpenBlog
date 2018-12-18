<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>登陆</title>
     <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
     <script type="text/javascript" src="js/user_login.js"></script>
    <style>
      body {
	    margin:20px auto; 
	    width:1200px; 
	    font-size:1.3em; 
	    background-image:url("image/bg4.jpg");
	  }
	  table tr td {border:1px solid black;}
	  table {font-size:1.3em; margin-left:100px; margin-top:50px;}
	  table .col1 {width:120px;}
	  table .col2 {width:230px;}
	  table input[type|="text"],input[type|="password"] {height:30px; width:200px;}
	  td span {font-size:1em;}
	  #passwordMsg {color:red;}
	  a:link {color:green;text-decoration:none;}
	  a:visited {color:green;text-decoration:none;}
	  a:hover {text-decoration:underline;}
	  a:active {}
    </style>
  </head>
  <body>
    <nav id="nav1">
    	<a href="<%=basePath %>">返回首页</a>&gt;&gt;登陆&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<a href="<%=basePath %>/admin/login">管理员登陆</a>
    	<div style="float:right;"><a href="user/register">注册</a></div>
    </nav>
    <div id="main">
      <form method="post" action="user/login" onsubmit="return isOK">
      	<input type="hidden" name="action" value="login">
      	<table>
      	  <caption>用户登陆</caption>
      	  <colgroup>
      	  	<col span="1" class="col1">
      	  	<col span="1" class="col2">
      	  </colgroup>
      	    <tr>
      	  	  <td>用户名:</td>
      	  	  <td><input type="text" id="usernameInput" name="username" value="<%=(request.getAttribute("username") == null) ? "" : request.getAttribute("username")%>"></td>
      	    </tr>
      	    <tr>
      	    	<td>&nbsp;</td>
      	    	<td><span id="usernameMsg"></span></td>
      	    </tr>
      	    <tr>
      	  	  <td>密码:</td>
      	  	  <td><input type="password" id="passwordInput" name="password"></td>
      	    <tr>
      	    	<td>&nbsp;</td>
      	    	<td><span id="passwordMsg">${status }</span></td>
      	    </tr>
      	    <tr>
      	      <td colspan="2" style="text-align:center"><input type="submit" value="登陆" style="height:3rem;width:10rem;font-size:2rem;border-radius:20px;background-color:#668B8B;font-family:Monospace;font-weight:bold;"></td>
      	    </tr>
      	</table>
      </form>
    </div>
 
  </body>
</html>
