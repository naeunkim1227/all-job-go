const idInputBox = document.querySelector("#id");
const insertTarget = document.querySelector('#checkIdResultContainer');

const displayStatus = async () => {
	const result = await checkDuplicate();
	if(!result.ok){
		return changeDisplay(result.ok,result.error);
	}
	return changeDisplay(result.ok, '사용 가능한 아이디입니다.');
}

const changeDisplay = (state, comment) => {
	insertTarget.innerText = comment;
	if(!state){
		insertTarget.style.color = "red";
		return ;
	}
	insertTarget.style.color = "green";
	return ;	
}

const checkDuplicate = async () => {
	const userEmail = idInputBox.value;
	
	const isRight = isIDRight(userEmail);
	if(isRight?.error){
		return isRight;
	}
	
	const url = `http://localhost:8088/AllJobGo/api/user/checkEmail`
	const reqHeader = {
		method:'POST',
		headers:{
			'Content-Type':'application/json'
		},
		body:JSON.stringify({userEmail:userEmail})
	}

	let responseData = await (await fetch(url,reqHeader)).json()
	if(responseData.exist){
		return {
			ok:false,
			error:'이미 존재하는 아이디입니다.'
			}
	}
	return {
		ok:true,
	}
}

const isIDRight = (id) => {
	if(id.indexOf('@') === -1 && id.indexOf('.com') === -1){
		return {
			ok: false,
			error:'올바르지 않은 이메일 형식입니다!'
		}
	}
	if(id.length < 6){
		return {
			ok: false,
			error:'길이가 짧습니다!'
		}
	}
	return {ok:true};
}

idInputBox.addEventListener("keyup", displayStatus);