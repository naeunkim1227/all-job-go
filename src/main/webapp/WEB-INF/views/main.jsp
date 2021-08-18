<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="resources/css/main.css">
<script
	src='${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js'></script>

<body>

	<div class="main-layout">

	<%@include file ="layout/header.jsp"%>

		<article>
			<div id="title">
				<div>
					<h1 id="subtitle">ALL JOB GO</h1>
					<div id="text_section">
						<h1 class="text"></h1>
					</div>
					<div class="lg_btn_section">
						<h4 style="color: black;">* 아이디가 없으신가요?</h4>
						<button id="lg_btn"
							onclick="location.href='${pageContext.request.contextPath}/user/login'">로그인</button>
						<button id="lg_btn"
							onclick="location.href='${pageContext.request.contextPath}/user/signup'">회원가입</button>
					</div>
				</div>


				<div id="image_bl">
					<img
						src="${pageContext.request.contextPath}/resources/img/main.png"
						id="image">
				</div>
			</div>
			<script
				src='${pageContext.request.contextPath}/resources/js/typing.js'></script>
			<div id="search_main">
				<div id="search_text">
					<h1>관심 있는 과정을 검색해보세요.</h1>
				</div>
				<div id="search_content">
					<jsp:include page="search/searchTrain.jsp" />
				</div>
			</div>
			<div id="example_section">
				<div id="cal_txt">
					<h1 id="sec_title">ABOUT</h1>

					<div id="sec_content">
						<h1>CALENDAR</h1>
						<h3>나의 관심 과정을 한눈에 볼 수 있어요.</h3>
						<h4>검색을 통해 찜을 해보세요.</h4>
					</div>
				</div>
				<div>
					<img
						src="${pageContext.request.contextPath}/resources/img/calendar_ex.png"
						id="cal_img">
				</div>

			</div>
			<div id="example_section">
				<div id="img_section">
					<img
						src="${pageContext.request.contextPath}/resources/img/calendar_ex.png"
						id="cal_img">
				</div>
				<div id="cal_txt">
					<h1 id="sec_title">ABOUT</h1>

					<div id="sec_content">
						<h1>SEARCH</h1>
						<h3>과정을 검색해 볼 수 있어요.</h3>
						<h4>알아서 쓰고 싶은말 적으셈</h4>
					</div>
				</div>


			</div>
			<div id="example_section">
				<div id="cal_txt">
					<h1 id="sec_title">ABOUT</h1>

					<div id="sec_content">
						<h1>REVIEW</h1>
						<h3>리뷰를 볼 수 있어요</h3>
						<h4>알아서 적을 말 쓰세요</h4>
					</div>
				</div>
				<div>
					<img 
						src="${pageContext.request.contextPath}/resources/img/calendar_ex.png"
						id="cal_img">
				</div>

			</div>

		</article>

		<jsp:include page="layout/footer.jsp"></jsp:include>
	</div>
</body>
</html>