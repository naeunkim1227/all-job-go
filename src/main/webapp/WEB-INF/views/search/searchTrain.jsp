<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>훈련 검색</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/search.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
	<article class="main-layout">
		<%@ include file="../layout/header.jsp"%>
		<main>
			<form id="searchBox-form">
				<input class="searchInput search__startDate" type="date" />
				~
				<input class="searchInput search__endDate" type="date" />
				<select id="search__region">
					<option value="">전체</option>
					<option value="11">서울</option>  
					<option value="26">부산</option>  
					<option value="27">대구</option>  
					<option value="28">인천</option>  
					<option value="29">광주</option>
					<option value="30">대전</option>  
					<option value="31">울산</option> 
					<option value="36">세종</option> 
					<option value="41">경기</option> 
					<option value="42">강원</option> 
					<option value="43">충북</option> 
					<option value="44">충남</option> 
					<option value="45">전북</option> 
					<option value="46">전남</option> 
					<option value="47">경북</option> 
					<option value="48">경남</option> 
					<option value="50">제주</option>
				</select>
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