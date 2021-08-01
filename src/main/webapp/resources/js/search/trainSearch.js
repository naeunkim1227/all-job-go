const searchForm = document.querySelector('#searchBox-form')
const resultContainer = document.querySelector('#search-result-container');
const searchTitle = document.querySelector(".search__title")

const searchKeywordHandler = (event) => {
	const title = searchTitle.value;
	const startDate = 20210401;
	const endDate = 20210731;
	const url = `http://localhost:8088/AllJobGo/search/api/hrd?srchTraProcessNm=${title}&srchTraStDt=${startDate}&srchTraEndDt=${endDate}`;
	
	const fetchOptions = {
		method:'GET',
		headers:{
			'Content-Type':'text/xml',
		}
	}
	
	getFetchData(url,fetchOptions)
	.then(printResult)
	
	//title = '';
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
	console.log(xml)
	console.log(child);
	for(let i = 0 ; i < child.address.length; i++){
		resultContainer.innerHTML += `<div><h3>${child.subTitle[i].innerHTML}</h3><div>${child.address[i].innerHTML}</div></div>`
	}
}

const getFetchData = async(url,options) => {
	return await (await fetch(url,options).catch(catchFetchError)).text();
}

const catchFetchError = (err) => {
	console.warn(err);
}

searchForm.addEventListener('submit',searchKeywordHandler)