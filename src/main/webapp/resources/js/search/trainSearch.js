const searchForm = document.querySelector('#searchBox-form')
const resultContainer = document.querySelector('#search-result-container');
const searchTitle = document.querySelector(".search__title")

const searchKeywordHandler = (event) => {
	const title = searchTitle.value;
	const fetchOptions = {
		method:'GET',
		headers:{
			'Content-Type':'text/xml',
		}
	}
	getFetchData(title,fetchOptions)
	.then(printResult)
	
	title = '';
	event.preventDefault();
}

const printResult = (result) => {
	const parser = new DOMParser();
    const xml = parser.parseFromString(result, "text/xml");
	const subTitles = xml.getElementsByTagName("subTitle"); 
	const child = [...subTitles]
	
	child.map(one => console.log(one.innerHTML))
}

const getFetchData = async(title,options) => {
	return await (await fetch(`http://localhost:8088/AllJobGo/search/api/hrd?srchTraProcessNm=${title}`,options).catch(catchFetchError)).text();
}

const catchFetchError = (err) => {
	console.warn(err);
}

searchForm.addEventListener('submit',searchKeywordHandler)