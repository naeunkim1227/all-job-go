<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  

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

	<table border="0" >
		<tr>
			<td colspan="2" id="tableLine">
				<img src="${pageContext.request.contextPath}/resources/img/headerLogo02.png" 
					 alt="headerLogo" id="header_logo">
					<p>수강후기</p></td>
		</tr>
		<tr>
			<td colspan="2" id="acaInfor">${acaInformation }</td>
			
		</tr>
		<c:choose>
			<c:when test="${fn:length(comments) eq 0 }">
				<td><img id="review_img" src="${pageContext.request.contextPath}/resources/img/en.jpg" alt="review"></td> 
				<td>수강후기가 없습니다!</td>
			</c:when>
			<c:otherwise>
				<c:forEach var="comt" items="${comments }">
					<tr>
						<td><img id="review_img" src="${pageContext.request.contextPath}/resources/img/en.jpg" alt="review"></td> 
						<td id="comt_review">${comt }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	
	</table>
	
	</div>

</div>
<%@ include file="../layout/footer.jsp" %>
</div>
</body>
</html>