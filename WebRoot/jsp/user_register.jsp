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
    <title>注册</title>
   
	<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/distpicker.data.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/distpicker.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/main.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/user_register.js"></script>
	
	<style>
	  #body {
	    margin:20px auto; 
	    width:1200px; 
	    font-size:1.3em; 
	    background-image:url("image/bg2.jpg");
	  }
	  #nav1 {}
	  nav #left {float:left;}
	  nav #right {float:right;}
	  section {}
	  table tr td {border:1px solid black;}
	  table {font-size:1.3em; margin-left:100px; margin-top:50px;}
	  table .col1 {width:180px;}
	  table .col2 {width:400px;}
	  table input[type|="text"],input[type|="password"] {height:30px; width:200px;}
	  td span {font-size:1em;}
	  td img {width:100px; height:100px}
	  a:link {color:green;text-decoration:none;}
	  a:visited {color:green;text-decoration:none;}
	  a:hover {text-decoration:underline;}
	  a:active {}
	</style>
  </head>
  
  <body id="body">
    <nav id="nav1">
      <div id="left"><a href="<%=basePath %>">首页</a>&gt;&gt;注册</div>
      <div id="right">预留1|预留2|预留3|预留4&nbsp;&nbsp; &gt;&gt;<a href="user/login">登陆</a></div>
      <div style="clear:both" ><!-- 解决父级元素塌陷用 --></div> 
    </nav>
    <section>
      <form method="post" action="user/register">
      <input type="hidden" name="action" value="register">
        <table>
          <caption>用户注册</caption>
          <colgroup>
          	<col span="1" class="col1">
          	<col span="1" class="col2">
          </colgroup>
          <tr>
          	<td>用户名:</td>
          	<td><input type="text" id="usernameInput" name="username"><span id="usernameMsg"></span></td>
          </tr>
          <tr>
          	<td>昵称:</td>
          	<td><input type="text" id="nicknameInput" name="nickname"><span id="nicknameMsg"></span></td>
          </tr>
          <tr>
          	<td>密码:</td>
          	<td><input type="password" id="passwordInput" name="password"><span id="passwordMsg"></span></td>
          </tr>
          <tr>
          	<td>确认密码:</td>
          	<td><input type="password" id="confirmPasswordInput"><span id="confirmPasswordMsg"></span></td>
          </tr>
          <tr>
          	<td>性别:</td>
          	<td>男<input type="radio" name="sex" value="male" checked> 
          		女<input type="radio" name="sex" value="female"></td>
          <tr>
          <tr>
          	<td>邮箱:</td>
          	<td><input type="text" id="emailInput" name="email"><span id="emailMsg"></span></td>
          </tr>
          <tr>
          	<td>电话:</td>
          	<td><input type="text" id="phoneInput" name="phone"><span id="phoneMsg"></span></td>
          </tr>
          <tr>
          	<td>头像:</td>
          	<td><input type="radio" name="sign" value="t1.jpg" checked><img src="image/t1.jpg">
          		<input type="radio" name="sign" value="t2.jpg"><img src="image/t2.jpg">
          		<input type="radio" name="sign" value="t3.jpg"><img src="image/t3.jpg"></td>
          </tr>
          <tr>
          	<td>住址:</td>
          	<td><div data-toggle="distpicker">
					  <select data-province="---- 选择省 ----" name="province" id="province"></select>
					  <select data-city="---- 选择市 ----" name="city" id="city"></select>
					  <select data-district="---- 选择区 ----" name="district" id="district"></select>
				</div>
			</td> 
		  </tr>
		  <tr>
		  	<td colspan="2">
		  	  <input type="submit" value="注册">
		  	  <input type="reset" value="重置"> 
		  	</td>
		  </tr>
        </table>
      </form>
    </section>
  </body>
</html>
	