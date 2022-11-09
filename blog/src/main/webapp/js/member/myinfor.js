

/*-----------회원정보 호출----------- */
myinfor();
function myinfor() {
	
	
	
	$.ajax({
		url: "/blog/member/myinfor",	
		success: function(re) {
			// 통신된 json형식의 문자타입을 JSON 타입으로 형변환 
			let inforlist = JSON.parse(re) //여기서 왜 오류가 나지?
			//console.log(inforlist)//??오류나는걸까?			
			document.querySelector("#cy_num").innerHTML = inforlist.cy_num
			document.querySelector("#cy_id").innerHTML = inforlist.cy_id
			document.querySelector("#cy_name").innerHTML = inforlist.cy_name
			document.querySelector("#cy_phone").innerHTML = inforlist.cy_phone
			document.querySelector("#cy_email").innerHTML = inforlist.cy_email
			document.querySelector("#cy_signuptime").innerHTML = inforlist.cy_signuptime
		}
	});
}//myinfor end
	
/*-----------회원탈퇴----------- */
	
function viewdelete()	{
	// 1. html에 있는  tag를 가져온다
	let deletebox = document.querySelector("#deletebox");
	// 2. tag에 넣을 html 구성
	let deletebtn = 
		'<span> 비밀번호를 입력해주세요. </span>'+
		'<input type="password" id="cy_password">'+	
		'<button type="button" onclick="memberdelete()" placeholder="비밀번호를 입력해주세요">확인</button>'	
	// 3. tag에 html 넣기
	deletebox.innerHTML = deletebtn;	
}
	
function memberdelete(){
	
		//alert("확인")		
	//1.입력된 비밀번호를 가져온다
	let cy_password = document.querySelector("#cy_password").value;
		console.log(" 1. myinfor.js : 패스워드 확인 : ")
		console.log(cy_password);
	//2.ajax를 이용한 회원탈퇴 처리
	
	
	// MemberDao 11. 회원 탈퇴하기		
	$.ajax({
		url: "/blog/member/infordelete",
		data:{"cy_password" : cy_password},
		success : function(re){ 			
				//alert(re)
			if(re === 'true'){
				alert("회원탈퇴가 완료되었습니다. 이용해 주셔서 감사합니다.");
				location.href="/blog/member/logout.jsp"
			}else{
				alert("동일하지 않은 비밀번호 입니다.")
			}
			
		}
	})	
}//memberdelete end

	
	
	