<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<article class="main-layout">
		<%@ include file="../layout/header.jsp"%>
		<main>
			<h1>회원가입</h1>

			<div style="margin-bottom: 50px;">
				<textarea cols="130" rows="11" readonly>['다잡고' 개인정보 처리방침]
다잡고(AllJobGo, 이하 다잡고)에 방문해주셔서 감사합니다. 저희 다잡고에서
고객님들의 개인정보를 수집하고 있으며 이는 어쩌고 저쩌고 입니다.
공무원의 직무상 불법행위로 손해를 받은 국민은 법률이 정하는 바에 의하여 국가 또는 공공단체에 정당한 배상을 청구할 수 있다. 이 경우 공무원 자신의 책임은 면제되지 아니한다.
위원은 정당에 가입하거나 정치에 관여할 수 없다. 국방상 또는 국민경제상 긴절한 필요로 인하여 법률이 정하는 경우를 제외하고는, 사영기업을 국유 또는 공유로 이전하거나 그 경영을 통제 또는 관리할 수 없다.
재판의 심리와 판결은 공개한다. 다만, 심리는 국가의 안전보장 또는 안녕질서를 방해하거나 선량한 풍속을 해할 염려가 있을 때에는 법원의 결정으로 공개하지 아니할 수 있다.
비상계엄하의 군사재판은 군인·군무원의 범죄나 군사에 관한 간첩죄의 경우와 초병·초소·유독음식물공급·포로에 관한 죄중 법률이 정한 경우에 한하여 단심으로 할 수 있다. 다만, 사형을 선고한 경우에는 그러하지 아니하다.
</textarea>
				<br> '개인정보처리방침'에 동의하십니까? <input type="radio" name="agreebtn" value="yes">동의합니다. <input type="radio"
					name="agreebtn" value="no" checked>동의하지 않습니다.<br>
			</div>

			<div>
				<form method="post">
					<div>
						<span id="checkIdResultContainer"></span>
					</div>
					<input type="text" name="id" id="id" placeholder="이메일">
					<button>인증메일 전송</button>
					<input type="password" name="pass" id="pass" placeholder="비밀번호">
					<input type="password" name="pass1" id="pass1" placeholder="비밀번호 확인">
					<input type="text" name="name" id="name" placeholder="성명">
					<input type="text" name="phonenumber" id="phonenumber" placeholder="'-'제외 입력"><br>
					<!-- 다음 우편번호 api -->
					<input type="text" id="zonecode" name="zonecode" placeholder="우편번호" readonly>
					<input type="button" id="addr_btn" value="주소 찾기">
					<br>
					<input type="text" id="address" name="address" placeholder="주소" readonly> 
					<br>
					<input type="text" id="address_detail" name="address_detail" placeholder="상세주소"> <br>
					<br>

					<h4>선택 입력정보</h4>
					희망지역 <select name="fav_Area">
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
					</select> <br> <br>
					<button type="submit">가입하기</button>
					<button type="reset">취소하기</button>
					<input type="hidden" name=${_csrf.parameterName } value="${_csrf.token }">
				</form>
			</div>
		</main>
		<%@ include file="../layout/footer.jsp"%>
	</article>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
	<script type="module" src="${root}/resources/js/user/checkDuplicateId.js"></script>
	<script type="module" src="${root}/resources/js/user/addressFunc.js"></script>
</body>
</html>