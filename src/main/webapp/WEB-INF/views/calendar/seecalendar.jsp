<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/review.css">
<link href='${pageContext.request.contextPath}/resources/css/calendar.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath}/resources/js/calendar/calendar.js'></script>
<script src='${pageContext.request.contextPath}/resources/js/calendar/jquery-3.6.0.min.js'></script>
<script src='${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js'></script>
<script src='${pageContext.request.contextPath}/resources/js/calendar/ko.js'></script>

<style>
  #calendar {
    max-width: 80%;
    margin: 0 20% 0 20%;
    padding: 0;
  }

</style>
<body>
<div class="main-layout">
<%@ include file="../layout/header.jsp" %>
<div>
	<div class="container">
		
		<table border="1">
			<tr>
				<td>나의 관심 클래스</td>
				<td>개강일</td>
				<td>종강일</td>
			</tr>
		<c:choose>
			<c:when test="${fn:length(allfavlist) eq 0}">
				<h1>나의 관심 클래스가 없습니다. 추가해보세요.</h1>
			</c:when>
			<c:otherwise>
				<c:forEach var="list" items="${allfavlist}">
					<tr class="fav_list">
						<td><b>${list.trprNm}</b>(${list.trprDegr}회차)</td>
						<td>${list.trStaDt}</td>
						<td>${list.trEndDt}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</table>
		<div id='calendar'>
		
		</div>
		
		
		
	</div>

</div>
<%@ include file="../layout/footer.jsp" %>
</div>
<script type="text/javascript">
const favList = document.querySelectorAll('.fav_list');

	  document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		var today = new Date();
		  let events = [];
		  favList.forEach(function(item, index){
				events.push({title: item.children[0].innerText , start: item.children[1].innerText , end: item.children[2].innerText});
		  })
		  
		  var calendar = new FullCalendar.Calendar(calendarEl, {
			  customButtons: {
				    myCustomButton: {
				      text: '관심 과정보기',
				      click: function() {
				        alert('clicked the custom button!');
				      }
				    },
				    myCustomButton2: {
					      text: '관심 학원과정만 보기',
					      click: function() {
					        alert('clicked the custom button!');
					      }
					    }
				  },
				  headerToolbar: {
					left: 'title',
				    center: '',
				    right: 'prev,next today myCustomButton myCustomButton2'
				  },
		    initialDate: today,
		    locale : 'ko',
		    editable: false,
		    selectable: true,
		    businessHours: true,
		    dayMaxEvents: true, // allow "more" link when too many events
		    events,
		  })

		  calendar.render();
		});
</script>
</body>
</html>