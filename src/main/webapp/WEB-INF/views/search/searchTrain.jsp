<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<main class="searchBox-container">
			<form id="searchBox-form">
				<input class="searchInput search__startDate" type="date" />
				<img style="width: 35px;" src="https://img.icons8.com/emoji/48/000000/wavy-dash-emoji.png"/>
				<input class="searchInput search__endDate" type="date" />
				<select id="search__region">
					<option value="">전체</option>
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
				</select>
				<input class="searchInput search__title" type="text"
					placeholder="찾을 훈련을 검색해주세요." />
				<button class="search__btn" type="submit"><i class="fas fa-search"></i></button>
			</form>
			<div id="search-result-container" class="search-result__container"></div>
		</main>
