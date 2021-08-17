const content = "이 세상 모든 직업을 잡다!"
const text = document.querySelector(".text")
let index = 0; //글자를 하나씩 읽기 위해서 지정해준다.

function typing() {
	text.textContent += content[index++];
	if(index > content.length){ //인덱스가 읽을 문자열보다 커지면 
		text.textContent = ""
		index = 0; //초기화 해준다.
	}
}

setInterval(typing, 200)
//300마다 타이핑 함수가 호출 된다.

