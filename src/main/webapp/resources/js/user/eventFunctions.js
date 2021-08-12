import {toggleEventByID, setDisplay} from "../toggleEvent"

const favCateTitle = document.getElementById('fav_cate-title');

let eventCache;

const toggleEvent = async (event) => {
	const triggerID = event.target.id;
	
	if(!eventCache.hasOwnProperty(triggerID)){
		const reqURL = '';
		return toggleEventByID(triggerID,reqURL);
	}
	
	setDisplay(triggerID, 'block');
	return;
}

favCateTitle.addEventListener('click',toggleEvent);