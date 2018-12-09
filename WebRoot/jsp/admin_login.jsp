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
    <title>管理员登陆</title>
     <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
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
	  table .col2 {width:400px;}
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
    <nav id="nav1"><a href="<%=basePath %>">返回首页</a>&gt;&gt;管理员登陆</nav>
    <div id="main">
      <form method="post" action="admin/login" onsubmit="return true">
      	<input type="hidden" name="action" value="login">
      	<table>
      	  <caption>管理员登陆</caption>
      	  <colgroup>
      	  	<col span="1" class="col1">
      	  	<col span="1" class="col2">
      	  </colgroup>
      	    <tr>
      	  	  <td>用户名:</td>
      	  	  <td><input type="text" id="usernameInput" name="username" value="${username }"><span id="usernameMsg"></span></td>
      	    </tr>
      	    <tr>
      	  	  <td>密码:</td>
      	  	  <td><input type="password" id="passwordInput" name="password"><span id="passwordMsg">${status }</span></td>
      	    </tr>
      	    <tr>
      	      <td colspan="2"><input type="submit" value="登陆"></td>
      	    </tr>
      	</table>
      </form>
    </div>
 
  </body>
</html>
