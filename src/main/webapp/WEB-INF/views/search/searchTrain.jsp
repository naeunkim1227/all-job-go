<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>훈련 검색</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/search.css">
</head>
<body>
	<article class="main-layout">
		<%@ include file="../layout/header.jsp"%>
		<main>
			<form id="searchBox-form">
				<input class="searchInput search__startDate" type="date" />
				~
				<input class="searchInput search__endDate" type="date" />
				<input class="searchInput search__title" type="text"
					placeholder="찾을 훈련을 검색해주세요." />
				<button class="search__btn" type="submit">검색</button>
			</form>
			<div id="search-result-container" class="search-result__container"></div>
			<script type="module"
				src="${pageContext.request.contextPath }/resources/js/search/trainSearch.js"></script>
		</main>
		<%@ include file="../layout/footer.jsp"%>
	</article>
</body>
</html>