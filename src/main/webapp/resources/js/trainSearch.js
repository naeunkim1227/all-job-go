const searchForm = document.querySelector('#searchBox-form')
const resultContainer = document.querySelector('#search-result-container')

const searchKeywordHandler = (event) => {
	console.log('Hello')
	
	event.preventDefault();
}

searchForm.addEventListener('submit',searchKeywordHandler)