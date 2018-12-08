<%@ page language="java" import="java.util.*"
import="domain.BlogBean"
 pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>随便逛逛</title>
	<link rel="stylesheet" type="text/css" href="css/blog_article_list.css">
  </head>
  <body>
  	<nav>
  	</nav>
  	<article>
  	<p class="nav"><a href="JavaScript:history.back(-1)">点击返回</a></p>
    <table>
    	<colgroup>
    	  <col span="1" class="col1">
    	  <col span="1" class="col2">
    	  <col span="1" class="col3">
    	  <col span="1" class="col4">
    	</colgroup>
      	<tr><th>标题</th><th>分类</th><th>作者</th><th>简介</th></tr>
      	<c:forEach items="${blog_list }" var="blog">
      	  <tr>
      	    <td>
      	      <a href="<c:url value="blog/blog_article?blogId=${blog.id }"/>">
      	      	<c:out value="${blog.title }"></c:out><!-- 文章标题 -->
      	      </a>
      	    </td>
      	    <td>
      	      	<c:out value="${blog.type }"></c:out><!-- 文章类型 -->
      	    </td>
      	    <td>
      	      <a href="<c:url value="blog/blog_main?userId=${blog.userID }"/>">
      	      	${blog.author.nickname }<!-- 作者博客 -->
      	      </a>
      	    </td>
      	    <td>
      	      	<c:out value="${blog.info }"></c:out><!-- 文章简介 -->
      	    </td>
      	  </tr>
      	</c:forEach>
    </table>
    </article>
  </body>
</html>
