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
			<td>수강후기</td>
		</tr>
		
		<c:forEach var="comt" items="${comments }">
			<tr>
				<td>${comt }</td>
			</tr>
		</c:forEach>
	
	</table>
	
	</div>

</div>
<%@ include file="../layout/footer.jsp" %>
</div>
</body>
</html>