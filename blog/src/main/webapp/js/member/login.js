
function login(){
	//MemberDao 4.로그인
	let logininfo = {
		cy_id : document.querySelector("#cy_id").value,
		cy_password : document.querySelector("#cy_password").value
	}	

	//console.log(logininfo)
	
	$.ajax({
		url:"/blog/member/login",
		data:logininfo,
		type:"post",
		success : function(re){ 
			if( re === '0' ){
				 alert("회원이 아닙니다.")
			}else if( re ==='1'){
				/*alert("로그인성공");*/ location.href="/blog/index.jsp";
			}else if(re==='2'){
				alert("비밀번호틀림")				
			}else if(re==='3'){
				alert("db오류 관리자에게 문의 주세요")
			}
		}
	})

}


// 엔터키를 눌렀을 때 
function enterkey(){
	//엔터를 눌렀을 때
	if(window.event.keyCode == 13){ //window.event.keycode : 키보드에 입력된 데이터를 숫자표현 : enter는 13번!
		login();
	}
}

