<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sign.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
	<article class="main-layout">
		<%@ include file="../layout/header.jsp"%>
	<main>
	<div class="container">
			<section></section>
			<section>
			<h1 id="signup">로그인</h1>

			<div>
				<c:if test="${not empty fail}">
					<div class="login-fail__msg">${fail}</div>
				</c:if>
				<form method="post">
					<div id="login">
						<input type="text" name="id" id="id" placeholder="이메일"><br>
						<input type="password" name="pass" id="pass" placeholder="비밀번호"><br>
					</div>
					<section id="loginB1"></section>
					<section id="loginB2">
						<button type="submit">로그인</button>
					</section>
				</form>
			</div>
				<br>
			<div id="login_sign">
				아직 회원이 아니신가요? <a href="./signup">회원가입</a>
			</div>
			
			</section>
		</div>	
	</main>		
		<%@ include file="../layout/footer.jsp"%>
	</article>
</body>
</html>