export const toggleEventByID = async (id, jsonURL) => {
	const res = await (await fetch(jsonURL,{method:"GET"}).catch(getInfoError)).json();
	
	if(!res.hasOwnProperty(id)){
		throw new Error('해당하는 id에 대한 매핑값이 없습니다.'); 
	}
	const target = res[id];
	setDisplay(target)
	return target;
}

export const setDisplay = (target, displayAttr = 'block') => {
	const targetElement = document.querySelector(target);
	if(targetElement.style.display === 'none'){
		targetElement.style.display = displayAttr;
		return;
	}
	targetElement.style.display = 'none';
}

const getInfoError = (err) => {
	console.warn(err);
	return new Response();
}