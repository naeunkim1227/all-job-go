const searchForm = document.querySelector('#searchBox-form')
const resultContainer = document.querySelector('#search-result-container');
const API_KEY = "4m3FdV2kNxlMop0qg7B5WAfxgr64fMGb"
const searchTitle = document.querySelector(".search__title")

const searchKeywordHandler = async (event) => {
	console.log('Hello')
	const title = searchTitle.value
	console.log(title)
	
	const result = fetch(`http://localhost:8088/AllJobGo/api/hrd?srchTraProcessNm=${title}`);
	
	console.log(result);
	title = '';
	
	event.preventDefault();
}

searchForm.addEventListener('submit',searchKeywordHandler)