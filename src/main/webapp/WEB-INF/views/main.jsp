<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AllJobGo</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/search.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.id" var="id" />
	<meta id="curUserID" content="${id}">
</sec:authorize>
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
						src="${pageContext.request.contextPath}/resources/img/search_about.png"
						id="cal_img">
				</div>
				<div id="cal_txt">
					<h1 id="sec_title">ABOUT</h1>

					<div id="sec_content">
						<h1>SEARCH</h1>
						<h3>과정을 검색해 볼 수 있어요.</h3>
						<h4>훈련 기간을 정해서 과정을 알아볼 수 있어요! 만약 과정을 신청하고 
						싶다거나 관심이 있다면 찜버튼을 클릭해서 캘린더에서 확인할 수 있어요.</h4>
					</div>
				</div>


			</div>
			<div id="example_section">
				<div id="cal_txt">
					<h1 id="sec_title">ABOUT</h1>

					<div id="sec_content">
						<h1>REVIEW</h1>
						<h3>리뷰를 볼 수 있어요</h3>
						<h4>확인하고 싶은 과정의 수강후기를 쉽게 확인할 수 있습니다.</h4>
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
	<script> let ee = "${user_nameT}" </script>
	<script type="module" src="${pageContext.request.contextPath }/resources/js/search/trainSearch.js"></script>
</body>
</html>