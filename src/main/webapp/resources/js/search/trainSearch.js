import '../custom_proto.js';

const searchForm = document.querySelector('#searchBox-form')
const resultContainer = document.querySelector('#search-result-container');
const searchTitle = document.querySelector(".search__title")
const searchStartDate = document.querySelector(".search__startDate");
const searchEndDate = document.querySelector(".search__endDate");
const searchRegion = document.querySelector("#search__region");
const curUser = document.getElementById('curUserID');

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

const printResult = async (result) => {
	const resultObj = getResult(result);
	const resultTrainIDStack = [];
	
	if(resultObj.length === 0){
		return resultContainer.innerHTML = '검색에 맞는 훈련이 없습니다.';	
	}
	resultContainer.innerHTML = '';

	for(let i = 0 ; i < resultObj.length; i++){
		resultTrainIDStack.push(resultObj[i].trprId);
		
		resultObj[i].titleIcon = resultObj[i].titleIcon.insertAfter('src=','https://');
		resultContainer.innerHTML += 
		`
		<div class="result_data" data-train-id="${resultObj[i].trprId}" data-train-deg="${resultObj[i].trprDegr}" data-con-id="${resultObj[i].trainstCstId}">
			<div>
				<a href="../AllJobGo/review/data?conId=${resultObj[i].trprId}">
					<div>
						${resultObj[i].titleIcon.replaceStrs({'&lt;':'<', '&gt;':'>'})}
						<h1 class="subject__Title">${resultObj[i].title}</h1>
					</div>
					<h3>${resultObj[i].subTitle}</h3>
					<div>${resultObj[i].address}</div>
				</a>
			</div>
		</div>`
	}
	await printLikes(document.querySelectorAll('.result_data'), resultTrainIDStack);
}

const printLikes = async (elements, nowResultsID) => {
	
	let div = document.createElement('div');
	div.className = "wish-container";
	
	let icon = document.createElement('i');
	icon.className = "far fa-heart";
	
	div.appendChild(icon);
	
	let userLike
	if(curUser){
		userLike = await printUserLike(nowResultsID);
		console.log(userLike);
	}
	
	elements.forEach(element => {
		icon.className = curUser && userLike?.hasOwnProperty(element.dataset.trainId) ? 'fas fa-heart' : 'far fa-heart';
		const tem = div.cloneNode(true)
		tem.addEventListener('click',wishBtnEvent)
		element.appendChild(tem);
	})
}

const printUserLike = async (nowResultsID) => {
	if(!curUser){
		return;
	}
	
	let reqURL = 'http://localhost:8088/AllJobGo/api/wish'
	
	for(var i = 0; i < nowResultsID.length; i++){
		if(i == 0){
			reqURL += '?'
		}else{
			reqURL += '&';
		}
		reqURL += `trainId=${nowResultsID[i]}`
	}
	
	const fetchData = await (await fetch(reqURL).catch(catchFetchError)).json(); 
	return fetchData;
}

const wishBtnEvent = async(event) => {
	const target = event.target;
	const nowEle = target.closest(".fa-heart");
	const isInsert = nowEle.className === 'far fa-heart' ? true : false;

	if(!curUser){
		if(confirm("찜을 위해 로그인을 하시겠습니까?")){
			location.href = "/AllJobGo/user/login";
		}
		return;
	}
	
	const resultData = nowEle.parentNode.parentNode;
	const bodyData = {
		fav_classId: resultData.dataset.trainId,
		fav_classDegr: resultData.dataset.trainDeg,
		fav_academyId: resultData.dataset.conId,
	}
	const reqURL = "http://localhost:8088/AllJobGo/api/wish"
	const reqHeader = {
		method: isInsert ? 'POST' : 'DELETE',
		headers: {
			'Content-Type': 'application/json'
		},
		body:JSON.stringify(bodyData)
	}
	console.log(reqHeader)
	const result = await (await fetch(reqURL,reqHeader).catch(catchFetchError)).json();
	console.log(result);
	if(result.ok){
		nowEle.className = isInsert ? 'fas fa-heart' : 'far fa-heart';
	}
	return;
}

const getFetchData = async(url,options) => {
	resultContainer.innerHTML = '로딩중 ...';
	return await (await fetch(url,options).catch(catchFetchError)).text();
}

const getResult = (domStr) => {
	const parser = new DOMParser();
    const xml = parser.parseFromString(domStr, "text/xml");
	const wantTags = [
		'title',
		'subTitle',
		'address',
		'titleIcon',
		'trprId', //훈련과정 아이디
		'trprDegr', //훈련과정 회차
		'trainstCstId' //훈련기관 id
		] 
	const results = [...xml.getElementsByTagName('scn_list')].map(item => getTagObject(item.children, wantTags))
	
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