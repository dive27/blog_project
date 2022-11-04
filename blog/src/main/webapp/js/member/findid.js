function findid(){
	// MemberDao 5. 아이디찾기 
	
	let findidInfo = {
		cy_name : document.querySelector("#cy_name").value,
		cy_email : document.querySelector("#cy_email").value
	}	
	
	let findidbox = document.querySelector(".findidbox") //아이디를 알려주는 박스
	
	$.ajax({
		url: "/blog/member/findid",
		data: findidInfo,
		type: "post",
		success : function(re){			
			if(re !== 'null'){ findidbox.innerHTML = '회원님의 아이디는' + re + '입니다.'}
			else{findidbox.innerHTML = '동일한 회원정보가 없습니다.'}
		}
	})
	
	
	
}//findidend