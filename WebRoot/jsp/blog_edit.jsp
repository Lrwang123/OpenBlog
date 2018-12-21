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
    <title>修改文章</title>
    <link rel="stylesheet" type="text/css" href="css/blog_add&edit.css">
  </head>
  
  <body>
    <article>
    <p class="nav"><a href="JavaScript:history.back(-1)">点击返回</a></p>
    <form method="post">
      <table>
      	<tr>
      	  <td>文章标题:</td>
      	  <td><input type="text" name="title" value=${old_blog.title }></td>
    	</tr>
    	<tr>
      	  <td>类别:</td>
      	  <td><input type="text" name="type" value=${old_blog.type }></td>
    	</tr>
    	<tr>
      	  <td>简介:</td>
      	  <td><textarea rows="3" cols="30" name="info">${old_blog.info }</textarea>
    	</tr>
    	<tr>
      	  <td>内容:</td>
      	  <td><textarea rows="20" cols="50" name="blog_text">${old_blog.blog_text }</textarea>
    	</tr>
    	<tr>
    	  <td><input type="hidden" name="id" value="${old_blog.id }"></td>
    	  <td><input type="hidden" name="action" value="edit"></td>
    	  <td colspan="2" style="text-align:center;"><input type="submit" value="确认修改"></td>
    	</tr>
      </table>
    </form>
    </article>
  </body>
</html>
