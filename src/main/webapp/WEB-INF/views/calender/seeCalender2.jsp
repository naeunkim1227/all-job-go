<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/review.css">
<link href='${pageContext.request.contextPath}/resources/css/calender.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath}/resources/js/calender.js'></script>
<script src='${pageContext.request.contextPath}/resources/js/events.json'></script>
<script>
document.addEventListener('DOMContentLoaded', function() {
  var calendarEl = document.getElementById('calendar');

  var calendar = new FullCalendar.Calendar(calendarEl, {
    initialDate: '2020-09-12',
    editable: true,
    selectable: true,
    businessHours: true,
    dayMaxEvents: true, // allow "more" link when too many events
    events: [
      {
        title: 'All Day Event',
        start: '2020-09-01'
      },
      {
        title: 'Long Event',
        start: '2020-09-07',
        end: '2020-09-10'
      },
      {
        groupId: 999,
        title: 'Repeating Event',
        start: '2020-09-09T16:00:00'
      },
      {
        groupId: 999,
        title: 'Repeating Event',
        start: '2020-09-16T16:00:00'
      },
      {
        title: 'Conference',
        start: '2020-09-11',
        end: '2020-09-13'
      },
      {
        title: 'Meeting',
        start: '2020-09-12T10:30:00',
        end: '2020-09-12T12:30:00'
      },
      {
        title: 'Lunch',
        start: '2020-09-12T12:00:00'
      },
      {
        title: 'Meeting',
        start: '2020-09-12T14:30:00'
      },
      {
        title: 'Happy Hour',
        start: '2020-09-12T17:30:00'
      },
      {
        title: 'Dinner',
        start: '2020-09-12T20:00:00'
      },
      {
        title: 'Birthday Party',
        start: '2020-09-13T07:00:00'
      },
      {
        title: 'Click for Google',
        url: 'http://google.com/',
        start: '2020-09-28'
      }
    ]
  });

  calendar.render();
});

</script>

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
		
		<c:set var="rvo" value="${favlist}" />
		<h1>${rvo.scn_list.trprId}</h1>
		<table border="1">
			<tr>
				<td>제발</td>
				<td>부탁</td>
				<td>합니다</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		
		
		</table>
		<div id='calendar'></div>
		
		
		
		
	</div>

</div>
<%@ include file="../layout/footer.jsp" %>
</div>
</body>
</html>