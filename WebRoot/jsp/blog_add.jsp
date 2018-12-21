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
    <title>发表文章</title>
    <link rel="stylesheet" type="text/css" href="css/blog_add&edit.css">
  </head>
  
  <body>
    <article>
    <p class="nav"><a href="JavaScript:history.back(-1)">点击返回</a></p>
    <form method="post">
      <table>
      	<colgroup>
          <col span="1" class="col1">
          <col span="1" class="col2">
      	</colgroup>
      	<tr>
      	  <td>文章标题:</td>
      	  <td><input type="text" name="title"></td>
    	</tr>
    	<tr>
      	  <td>类别:</td>
      	  <td><input type="text" name="type"></td>
    	</tr>
    	<tr>
      	  <td>简介:</td>
      	  <td><textarea rows="3" cols="30" name="info"></textarea>
    	</tr>
    	<tr>
      	  <td>内容:</td>
      	  <td><textarea rows="20" cols="50" name="blog_text"></textarea>
    	</tr>
    	<tr>
    	  <td><input type="hidden" name="action" value="add"></td>
    	  <td colspan="2" style="text-align:center;"><input type="submit" value="发表"></td>
    	</tr>
      </table>
    </form>
    </article>
  </body>
</html>
