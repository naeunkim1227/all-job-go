const searchForm = document.querySelector('#searchBox-form')
const resultContainer = document.querySelector('#search-result-container');
const API_KEY = "4m3FdV2kNxlMop0qg7B5WAfxgr64fMGb"
const searchTitle = document.querySelector(".search__title")

const searchKeywordHandler = async (event) => {
	console.log('Hello')
	const title = searchTitle.value
	console.log(title)
	
	const url = "https://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA62/HRDPOA62_1.jsp"
	const needPram = `authKey=${API_KEY}&returnType=XML&outType=2&pageNum=1&pageSize=10`
	
	const result = fetch(`${url}?${needPram}&srchTraProcessNm=${title}`);
	
	/*console.log(result);
	
	title = '';*/
	
	event.preventDefault();
}

searchForm.addEventListener('submit',searchKeywordHandler)