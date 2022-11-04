function findpassword(){
	//MemberDao 6. 비밀번호 찾기 난수를 발생시켜 임시비밀	번호를 발급 여부 판단
	//MemberDao 7. 임시비빌번호 업데이트
	
	let findpsInfo = {
		cy_id : document.querySelector("#cy_id").value,
		cy_email : document.querySelector("#cy_email").value
	}
	
	let findpsbox = document.querySelector(".findpsbox");

	$.ajax({
		url: "/blog/member/findpassword",
		data:findpsInfo,
		type:"post",
		success : function(re){ 
			if(re ===''){findpsbox.innerHTML = '동일한 회원정보가 없습니다.'}
			else {findpsbox.innerHTML='회원님의 임시번호는' + re + '입니다.'}
		}
	})
	
}
