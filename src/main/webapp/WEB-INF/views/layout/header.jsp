<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<header>
		<div id="logo">
			<a href="${root }/main">
				<img id="logo_img" src="${root}/resources/img/all_job_go_logo.png" alt="logo">
			</a> 
		</div>
		<div id="top">
			<div style="width: 70%;"></div>
			<div id="nav">
				<ul>
					<li><a href="${root}/main">all-job-go</a></li>
					<li><a href="${root}/calendar/seecalendar">캘린더로 보기</a></li>
					<sec:authorize access="hasRole('ANONYMOUS')">
						<li><a href="${root}/user/login">로그인</a></li>
						<li><a href="${root}/user/signup">회원가입</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li><a href="${root}/user/logout">로그아웃</a></li>
					</sec:authorize>
					<li>
						<sec:authorize access="isAuthenticated()">
							<sec:authentication property="principal.name" var="user_name"/>
							<span>안녕하세요! ${user_name}님</span>				
						</sec:authorize>
					</li>
				</ul>
			</div>
		</div>
</header>

<script>
	$(function(){
		var $window = $(window);
		
		
		$window.on('scroll',function(){
			
			$('#top').css("background-color","rgba(35,60,144,0.9)");
			$('#top').css("color","white");
			
		});
		
	});

</script>