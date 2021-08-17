<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="resources/css/main.css">
<script src='${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js'></script>

<body>

<div class="main-layout">


<jsp:include page="layout/header.jsp"></jsp:include>

<article>
	<div id="title">
		<div>
		<h1 id="subtitle">ALL JOB GO</h1>
		<h1 class="text"></h1>
		</div>
		<div id="image_bl">
			<img src="${pageContext.request.contextPath}/resources/img/main.png" id="image">
		</div>
	</div>
<script src='${pageContext.request.contextPath}/resources/js/typing.js'></script>




<a href="./calendar/seecalendar">캘린더 보러가기</a>

</article>

<jsp:include page="layout/footer.jsp"></jsp:include>
</div>
</body>
</html>