const searchForm = document.querySelector('#searchBox-form')
const resultContainer = document.querySelector('#search-result-container');
const searchTitle = document.querySelector(".search__title")
const searchStartDate = document.querySelector(".search__startDate");
const searchEndDate = document.querySelector(".search__endDate");

const searchKeywordHandler = (event) => {
	let title = searchTitle.value;
	console.log("데이터===>", searchEndDate.value)
	
	if(searchStartDate.value === "" || searchEndDate.value === ""){
		alert("시작, 끝 날짜를 정해주세요!");
		event.preventDefault();
		return;
	}
	const startDate = searchStartDate.value.replaceAll('-','');
	const endDate = searchEndDate.value.replaceAll('-','');
	
	const url = `http://localhost:8088/AllJobGo/search/api/hrd?srchTraProcessNm=${title}&srchTraStDt=${startDate}&srchTraEndDt=${endDate}`;
	
	const fetchOptions = {
		method:'GET',
		headers:{
			'Content-Type':'text/xml',
		}
	}
	
	getFetchData(url,fetchOptions)
	.then(printResult)
	
	title = '';
	event.preventDefault();
}

const printResult = (result) => {
	const parser = new DOMParser();
    const xml = parser.parseFromString(result, "text/xml");
	const subTitles = xml.getElementsByTagName("subTitle");
	const addresses = xml.getElementsByTagName("address");
	 
	const child = {
		subTitle: [...subTitles],
		address:[...addresses]	
	}
	resultContainer.innerHTML = '';
	console.log(xml)
	console.log(child);
	for(let i = 0 ; i < child.address.length; i++){
		resultContainer.innerHTML += `<div><h3>${child.subTitle[i].innerHTML}</h3><div>${child.address[i].innerHTML}</div></div>`
	}
}

const getFetchData = async(url,options) => {
	resultContainer.innerHTML = '로딩중 ...';
	return await (await fetch(url,options).catch(catchFetchError)).text();
}

const catchFetchError = (err) => {
	console.warn(err);
}

searchForm.addEventListener('submit',searchKeywordHandler)