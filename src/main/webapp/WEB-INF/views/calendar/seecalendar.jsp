<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/calendar_set.css">
<link href='${pageContext.request.contextPath}/resources/css/calendar.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath}/resources/js/calendar/calendar.js'></script>
<script src='${pageContext.request.contextPath}/resources/js/calendar/jquery-3.6.0.min.js'></script>
<script src='${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js'></script>
<script src='${pageContext.request.contextPath}/resources/js/calendar/ko.js'></script>

<body>
<div class="main-layout">
<%@ include file="../layout/header.jsp" %>
	<div class="container">
		
		<div id="table">
			<table id="table1">
				<tr id="title">
					<td>나의 관심 클래스</td>
					<td>개강일</td>
					<td>종강일</td>
				</tr>
			<c:choose>
				<c:when test="${fn:length(classlist) eq 0}">
					<h3>나의 관심 클래스가 없습니다. 추가해보세요.</h3>
				</c:when>
				<c:otherwise>
					<c:forEach var="clist" items="${classlist}">
						<tr class="clist">
							<td id="subtitle"><b>${clist.trprNm}</b>(${clist.trprDegr}회차)</td>
							<td>${clist.trStaDt}</td>
							<td>${clist.trEndDt}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			</table>
			<table id="table2">
				<tr id="title">
					<td>나의 관심 학원 커리큘럼</td>
					<td>개강일</td>
					<td>종강일</td>
				</tr>
			<c:choose>
				<c:when test="${fn:length(academylist) eq 0}">
					<h3>나의 관심 학원이 없습니다. 추가해보세요.</h3>
				</c:when>
				<c:otherwise>
					<c:forEach var="alist" items="${academylist}">
						<tr class="alist">
							<td id="subtitle"><b>${alist.trprNm}</b>(${alist.trprDegr}회차)</td>
							<td>${alist.trStaDt}</td>
							<td>${alist.trEndDt}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			</table>
		</div>
					
		<div id="cal_set">
		<div id='calendar'></div>
		</div>
		
		
	</div>

<%@ include file="../layout/footer.jsp" %>
</div>
<script type="text/javascript">
const alist = document.querySelectorAll('.alist');
const clist = document.querySelectorAll('.clist');

	  document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		var today = new Date();
		var act = 0;
		
		let Event = [];  
		  clist.forEach(function(item, index){
			  Event.push({title: item.children[0].innerText , start: item.children[1].innerText , end: item.children[2].innerText});
		  })
		  
		  
		let academyEvent = [];
		  alist.forEach(function(item, index){
			  academyEvent.push({title: item.children[0].innerText , start: item.children[1].innerText , end: item.children[2].innerText});
		  })
		  
		  var calendar = new FullCalendar.Calendar(calendarEl, {
			  customButtons: {
				    myCustomButton: {
				      text: '관심학원 커리큘럼 모두 보기',
				      click: function() {
				    	 if(act == 0){ 
				    	  alist.forEach(function(item, index){
				    	  calendar.addEvent({id: index , title: item.children[0].innerText , start: item.children[1].innerText , end: item.children[2].innerText , backgroundColor : "#ccccff" , borderColor: "#ffffff"});
				    	  
				    	  })
				    	  return act=1;
				    	 }
				      }
				    },
				    myCustomButton2: {
					      text: '관심 클래스만 보기',
					      click: function() {
						    	 location.reload();
					   	  
					      }
					},
				    myCustomButton3: {
					      text: '리스트로 보기',
					      click: function() {
					    	  	calendar.changeView('listview');
					   	  
					      }
					}
				  },
				  headerToolbar: {
					left: 'title',
				    center: '',
				    right: 'prev,next today myCustomButton myCustomButton2 myCustomButton3'
				  },
		    initialDate: today,
		    locale : 'ko',
		    editable: false,
		    selectable: true,
		    height: 800,
		    businessHours: true,
		    dayMaxEvents: true, // allow "more" link when too many events
		    events : Event,
		    eventColor: '#b3d1ff',
		    borderColor: "#ffffff",
		    views: {
		    	listview: {
		          type: 'listYear',
		          duration: { month: 1},
		          buttonText: 'year',
		        }
		      }

		
		  })

		  calendar.render();
		});
	  
</script>


</body>
</html>