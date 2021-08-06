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
	const CalendarRegex = /[^0-9]/g;
	
	const retStr = this.replaceAll(CalendarRegex, '');
	if(retStr.length !== 8){
		return false;
	}
	return retStr;
}