<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="resources/css/main.css">
</head>
<body>
<%@ include file="../layout/header.jsp" %>

<h1>로그인</h1>

<div>
 <form role="form" action="#" method="post">
  <input type="text" name="id" id="id" placeholder="이메일"><br>
  <input type="password" name="pass" id="pass" placeholder="비밀번호"><br>
  <button type="submit">로그인</button>
 </form>
</div>

<div>
 아직 회원이 아니신가요? <a href="./user/signup">회원가입</a>
</div>



<%@ include file="../layout/footer.jsp" %>
</body>
</html>