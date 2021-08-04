import '../custom_proto.js';

const searchForm = document.querySelector('#searchBox-form')
const resultContainer = document.querySelector('#search-result-container');
const searchTitle = document.querySelector(".search__title")
const searchStartDate = document.querySelector(".search__startDate");
const searchEndDate = document.querySelector(".search__endDate");

const searchKeywordHandler = (event) => {
	let title = searchTitle.value;
	
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
    const subjectTitle = xml.getElementsByTagName("title");
	const subTitles = xml.getElementsByTagName("subTitle");
	const addresses = xml.getElementsByTagName("address");
	const icon = xml.getElementsByTagName('titleIcon');
	const conId = xml.getElementsByTagName('trainstCstId');
	
	if(subTitles.length === 0){
		resultContainer.innerHTML = '검색 결과가 없습니다.';
		return;
	}
	
	const child = {
		Title:[...subjectTitle],
		subTitle: [...subTitles],
		address:[...addresses],
		icon:[...icon],
		conId:[...conId],
	}
	resultContainer.innerHTML = '';
	console.log(xml)
	console.log(child);
	for(let i = 0 ; i < child.address.length; i++){
		child.icon[i].innerHTML = child.icon[i].innerHTML.insertAfter('src=','https://');
		resultContainer.innerHTML += 
		`
		<div>
			<a href="../review/data?conId=${child.conId[i].innerHTML}">
				<div>
					${child.icon[i].innerHTML.replaceStrs({'&lt;':'<', '&gt;':'>'})}
					<h1 class="subject__Title">${child.Title[i].innerHTML}</h1>
				</div>
				<h3>${child.subTitle[i].innerHTML}</h3>
				<div>${child.address[i].innerHTML}</div>
			</a>
		</div>`
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