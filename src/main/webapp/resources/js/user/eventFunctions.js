import {toggleEventByID, setDisplay} from "../toggleEvent.js"

const favCateTitle = document.getElementById('fav_cate-title');
const favCateTitleListIcon = document.getElementById('fav_cate-title__list_icon');

let eventCache = {};

const toggleEvent = async (event) => {
	const triggerID = event.target.id;
	
	if(!eventCache.hasOwnProperty(triggerID)){
		const reqURL = '/AllJobGo/api/data/event-mapping/sign';
		const targetID = await toggleEventByID(triggerID,reqURL);
		
		eventCache[triggerID] = targetID;
		setListIcon();
		return;
	}
	
	setDisplay(eventCache[triggerID], 'block');
	setListIcon();
	return;
}

const setListIcon = () => {
	if(favCateTitleListIcon.innerText === '∧'){
		favCateTitleListIcon.innerText = '∨';
		return;
	}
	favCateTitleListIcon.innerText = '∧'
}

favCateTitle.addEventListener('click',toggleEvent);