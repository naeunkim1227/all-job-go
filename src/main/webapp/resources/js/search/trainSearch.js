import '../custom_proto.js';

const searchForm = document.querySelector('#searchBox-form')
const resultContainer = document.querySelector('#search-result-container');
const searchTitle = document.querySelector(".search__title")
const searchStartDate = document.querySelector(".search__startDate");
const searchEndDate = document.querySelector(".search__endDate");
const searchRegion = document.querySelector("#search__region");

const searchKeywordHandler = (event) => {
	let title = searchTitle.value;
	
	if(searchStartDate.value === "" || searchEndDate.value === ""){
		alert("시작, 끝 날짜를 정해주세요!");
		event.preventDefault();
		return;
	}
	
	const startDate = searchStartDate.value.getCalendarFormat();
	const endDate = searchEndDate.value.getCalendarFormat();

	if(!startDate || !endDate){
		alert("날짜 형식이 올바르지 않습니다!");
		event.preventDefault();
		return;
	}	
	
	const url = `http://localhost:8088/AllJobGo/api/hrd?srchTraProcessNm=${title}&srchTraStDt=${startDate}&srchTraEndDt=${endDate}&srchTraArea1=${searchRegion.value}`;
	
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
	const resultObj = getResult(result);
	resultContainer.innerHTML = '';

	for(let i = 0 ; i < resultObj.length; i++){
		resultObj[i].titleIcon = resultObj[i].titleIcon.insertAfter('src=','https://');
		resultContainer.innerHTML += 
		`
		<div class="result_data" data-train-id="${resultObj[i].trprId}" data-train-deg="${resultObj[i].trprDegr}" data-con-id="${resultObj[i].trainstCstId}">
			<div>
				<a href="../AllJobGo/review/data?conId=${resultObj[i].titleIcon}">
					<div>
						${resultObj[i].titleIcon.replaceStrs({'&lt;':'<', '&gt;':'>'})}
						<h1 class="subject__Title">${resultObj[i].title}</h1>
					</div>
					<h3>${resultObj[i].subTitle}</h3>
					<div>${resultObj[i].address}</div>
				</a>
				<div>
					<i class="far fa-heart"></i>
				</div>
			</div>
		</div>`
	}
	console.log(document.getElementById('curUserID').content);
}

const getFetchData = async(url,options) => {
	resultContainer.innerHTML = '로딩중 ...';
	return await (await fetch(url,options).catch(catchFetchError)).text();
}

const getResult = (domStr) => {
	const parser = new DOMParser();
    const xml = parser.parseFromString(domStr, "text/xml");
	const wantTags = ['title',
		'subTitle',
		'address',
		'titleIcon',
		'trprId', //훈련과정 아이디
		'trprDegr', //훈련과정 회차
		'trainstCstId' //훈련기관 id
		] 
	const results = [...xml.getElementsByTagName('scn_list')].map(item => getTagObject(item.children, wantTags))//nodeName
	console.log(results)
	return results;
}

const getTagObject = (item, tags) => {
	let retObj = {};
	tags.map(tag => retObj[tag] = getTagContent(item, tag, item.length))
	return retObj;
}

const getTagContent = (items, target, len) => {
	let start = 0;
	let end = len - 1;
	let mid = 0;

	while(start < end){
		mid = Math.floor((start + end)/2);
		if(target <= items[mid].nodeName){
			end = mid;
			continue;
		}
		start = mid + 1;
	}
	return items[end].innerHTML;
}

const catchFetchError = (err) => {
	console.warn(err);
}


searchForm.addEventListener('submit',searchKeywordHandler)