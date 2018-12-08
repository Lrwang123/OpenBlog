<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <title>用户管理</title>
     <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
  </head>
  <body>
    <nav id="nav1"><a href="<%=basePath %>">返回首页</a>&gt;&gt;用户管理</nav>
    <article>
    	<table>
    		<caption>用户管理</caption>
    		<thead>
    			<tr>
    				<th>顺序</th>
    				<th>用户名</th>
    				<th>状态</th>
    				<th>操作</th>
    			</tr>
    		</thead>
    		<tbody>
    			<c:forEach items="${userList }" var="user" varStatus="index">
    				<tr>
    					<td>${index.index+1 }</td>
    					<td>${user.username }</td>
    					<td>${user.status==1 ? 	"正常" : "封印" }</td>
    					<td>
    						<c:choose>
    							<c:when test="${user.status == 1 }" >   						
    								<a href="admin/ban?id=${user.id }">封号</a>
    							</c:when>
    							<c:otherwise>
    								<a href="admin/unban?id=${user.id }">解封</a>
    							</c:otherwise>
    						</c:choose>
    					</td>
    				</tr>
    			</c:forEach>
    		</tbody>
    	</table>
    </article>
  </body>
</html>
