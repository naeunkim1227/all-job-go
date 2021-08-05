String.prototype.insertAfter = function(afterWord, insertWord){
	let retStr = this;
	let insertIdx = retStr.indexOf(afterWord) + (afterWord.length + 1);
	retStr = [retStr.slice(0,insertIdx),insertWord, retStr.slice(insertIdx)].join('');
	return retStr;
}

String.prototype.replaceStrs = function(convertObj){
	let retStr = this;
	for(var i in convertObj ){
		retStr = retStr.replace(i, convertObj[i]);
	}
	return retStr;
}

String.prototype.getCalendarFormat = function(){
	const appInfo = navigator.appVersion;
	if(appInfo.indexOf('Win') !== -1){
		return this.replaceAll('-','');
	}
	if(appInfo.indexOf('Mac') !== -1){
		return this.replaceAll('.','');
	}
}