<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>훈련 검색</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">
</head>
<body>
	<%@ include file="../layout/header.jsp" %>
	<article class="main-layout">
	<form id="searchBox-form">
	<input class="search__title" type="text" placeholder="찾을 훈련을 검색해주세요.">
	</form>
	<div id="search-result-container" class="search-result__container"></div>
	<%@ include file="../layout/footer.jsp" %>
	<script type="module" src="${pageContext.request.contextPath }/resources/js/search/trainSearch.js"></script>
	</article>
</body>
</html>