const idInputBox = document.querySelector("#id");

const checkDuplicate = async () => {
	const curUserID = idInputBox.value;
	const url = `http://localhost:8088/AllJobGo/api/user/checkEmail/${curUserID}`
	const reqHeader = {
		method:'GET',
		headers:{
			'Content-Type':'application/json'
		}
	}
	let responseData = await (await fetch(url,reqHeader)).json()
	console.log(responseData)
}

idInputBox.addEventListener("keyup", checkDuplicate);