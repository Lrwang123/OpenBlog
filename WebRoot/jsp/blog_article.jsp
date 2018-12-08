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
    <title>${blog.title }</title>
    <link rel="stylesheet" type="text/css" href="css/blog_article.css">
 </head>
  
  <body>
    <nav></nav>
    <article>
      <p class="nav"><a href="JavaScript:history.back(-1)">点击返回</a></p>
      <h1>${blog.title }</h1>
      <h3><a href="<c:url value="blog/blog_main?userId=${blog.userID }"/>">作者:${blog.author.nickname }</a></h3>
      <h5>${blog.blog_text }</h5>
    </article>
    
    <section> <!-- 评论区 -->
     <c:forEach items="${blog.messages }" var="message" varStatus="status">
       <p>
         <span>${status.count }楼:&nbsp;&nbsp;</span>
         <span><a href="<c:url value="blog/blog_main?userId=${message.author.id}"/>">${message.author.nickname }</a> </span>
         <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${message.createdate }</span>
          <c:if test="${message.userId==user.id || blog.userID==user.id}"> <!-- 删除评论选项 -->
  	  	      <a href="blog/deleteMessage?messageId=${message.id}&blogId=${blog.id}"><img src="image/shanchu.png" class="button">删除评论</a>
  	   	  </c:if>
       </p>
       <c:choose>
         <c:when test="${message.status == 1 }">
           <p> &nbsp;&nbsp;&nbsp;&nbsp;${message.text}</p>
         </c:when>
         <c:otherwise>
           <del>&nbsp;&nbsp;&nbsp;&nbsp;该评论已被删除</del>
         </c:otherwise>
       </c:choose>
     </c:forEach>
     <form action="blog/addMessage" method="post">
       <input type="hidden" id="blogId" name="blogId" value="${blog.id}">
       <textarea rows="3" cols="20" name="text"></textarea>
       <input type="submit" value="发表评论">
     </form>
    </section>
  </body>
</html>
