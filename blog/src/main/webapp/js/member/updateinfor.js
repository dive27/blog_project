 /////////////////////////////////////////////////////////////////////////////

// 1. 수정하기전 기존 정보 호출 
// html 에 출력되는 기본 정보
getinfo();
function getinfo(){
	$.ajax({
		url: "/blog/member/myinfor",
		success: function(re) {
			// 통신된 json형식의 문자타입을 JSON 타입으로 형변환 
			let inforlist = JSON.parse(re) //여기서 왜 오류가 나지?
			//console.log(inforlist)//??오류나는걸까?			
			document.querySelector("#cy_num").innerHTML = inforlist.cy_num
			document.querySelector("#cy_id").innerHTML = inforlist.cy_id
			document.querySelector("#cy_name").value = inforlist.cy_name
			document.querySelector("#cy_phone").value = inforlist.cy_phone
			document.querySelector("#cy_email").value = inforlist.cy_email
			document.querySelector("#cy_signuptime").innerHTML = inforlist.cy_signuptime
		}
	});
}



//MemberDao 12.회원정보 수정하기
function updateinforbtn(){
	let updateinput = {
		cy_name : document.querySelector("#cy_name").value,
		cy_phone : document.querySelector("#cy_phone").value,
		cy_email : document.querySelector("#cy_email").value,		
	}
	
	$.ajax({
		url: "/blog/member/updateinfor",
		type : "post",
		data : updateinput ,  
		success: function(re) { 
			//alert(re)
			if(re=="true"){
				alert("수정이 완료되었습니다.")
			}
			else{alert("수정실패")}
		}
	});
	
}	
