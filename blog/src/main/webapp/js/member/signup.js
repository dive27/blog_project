



//비동기식 signup script
//MemberDao 1. 회원가입 
function signup(){	
	let signupBox={
		cy_id : document.querySelector("#cy_id").value,
		cy_password : document.querySelector("#cy_password").value,
		cy_name : document.querySelector("#cy_name").value,
		cy_phone : document.querySelector("#cy_phone").value,
		cy_email : document.querySelector("#cy_email").value,		
	}	
	$.ajax({
				url: "/Cywold_Project/member/signup",
				type:"post",
				data:signupBox,
				success : function(re){}
	})	
}