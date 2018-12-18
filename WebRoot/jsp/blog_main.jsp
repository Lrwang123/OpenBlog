<%@ page language="java" 
 import="java.util.*"
 import="domain.*"
 import="java.sql.Timestamp"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>个人首页</title>
	<link rel="stylesheet" type="text/css" href="css/user_main.css">
  </head>
  
  <body>
    <c:set var="isOwner" value="${user.id == owner.id }"></c:set><!-- 放置访问者是否是本人的变量isOwner -->
    <c:out value="session woner id:${sessionScope.owner.id }" />
    <br>
    <c:out value="reqiest owner id:${requestScope.owner.id } ${sessionScope.user.username }" />
    <br>	
    <c:out value="session user id:${sessionScope.user.id } ${sessionScope.user.username }"/>
    <br>
    <c:out value="request user id:${requestScope.user.id }" />
  	<nav> <!-- 导航栏 -->
  	  <c:choose> 
  	    <c:when test="${isOwner }"> <!-- 当是本人的时候 -->
	  	  <div class="left">
	  	  	<span>&gt;&gt;个人首页</span>
	  	  </div>
	  	  <div class="right">
	  	  	<a href="blog/blog_article_list">随便逛逛</a>
	  	  	<a href="user/exit">&nbsp;&nbsp;&nbsp;退出</a>
	  	  </div>
	  	</c:when>
	  	<c:otherwise> <!-- 不是本人 -->
	  	   <div class="left">
  	 	      <a href="JavaScript:history.back(-1)">点击返回</a>
  	  	   	 <span>&gt;&gt;${user.nickname }的个人首页</span>
  	  	   </div>
  	 	   <div class="right">
  	  		 <a href="user/exit">退出</a>
  		   </div>
	  	</c:otherwise>
  	  </c:choose>
  	  <div style="clear:both"></div><!-- 解决父级元素塌陷用 -->
  	</nav>
  	
  	<aside> <!-- 左边侧栏 -->
  	  <table>
  	  	<tr><td><img src="image/${owner['sign'] }"></td></tr>
  	  	<tr><td>${owner.nickname }</td></tr>
  	  	<tr><td>${owner.email }</td></tr>
  	  	<c:if test="${isOwner }"> <!-- 新建文章选项 -->
  	  	  <tr><td><a href="blog/blog_add?action=add"><img alt="" src="image/xinjian.png" class="button">新建文章</a></td></tr>
  	 	</c:if>
  	  </table>
  	</aside>
  	
  	<article> <!-- 文章区域 -->
  	  <c:if test="${fn:length(blog_list) == 0 }" var="flag1"> 太懒了，一篇文章都没有~~</c:if>
  	  <c:if test="${not flag1 }">
  	  <ul>
  	   	<c:forEach items="${blog_list }" var="blog">
  	  	<li>
  	  	  <p>
  	  	    <span>
  	  	      <a href="<c:url value="blog/blog_article?blogId=${blog.id }"/>">
  	  	        <c:out value="${blog.title }"/>&nbsp;
  	  	      </a>
  	  	    </span>
  	  	    <span><c:out value="${blog.type }"/>&nbsp;</span>
  	  	    <span><c:out value="${blog.createDate }"/>&nbsp;</span>
  	  	    <c:if test="${isOwner }"> <!-- 编辑和删除选项 -->
  	  	   	  <a href="blog/blog_edit?blog_id=${blog.id }"><img src="image/bianji.png" class="button">编辑</a>
  	  	      <a href="blog/blog_delete?blog_id=${blog.id }"><img src="image/shanchu.png" class="button">删除</a>
  	   	    </c:if>
  	   	  </p>
  	  	  <p><c:out value="${blog.info }"></c:out></p> 
  	  	</li>
  	  	</c:forEach>	  	
  	  </ul>
  	  </c:if>
  	</article>
  </body>
</html>
