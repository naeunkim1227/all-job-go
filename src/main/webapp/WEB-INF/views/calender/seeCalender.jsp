<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/review.css">
<body>
<div class="main-layout">
<%@ include file="../layout/header.jsp" %>
<div>
	<div class="container">
		
		<table border="1">
			<tr>
				<td>id</td>
				<td>선호과정</td>
			</tr>
			<c:forEach items="${FavoriteVO}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.fav_class}</td>
			</tr>
			</c:forEach>
		</table>
		<form method="post">
			<input type="hidden" name="id" value="${item.id}">
		</form>
	
	</div>

</div>
<%@ include file="../layout/footer.jsp" %>
</div>
</body>
</html>