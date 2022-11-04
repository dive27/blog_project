/*
정규표현식
정규표현식의 시작	 	: /^ 
정규표현식의 끝 		: $/
[a-z]				: 소문자패턴
[A-Z]				: 대문자패턴
[0-9]				: 숫자패턴
[]가-힣]				: 한글패턴
{최소길이,최대길이}		: 문자열 길이 패턴	
(+)	 				: 앞에있는 패턴이 1개이상 반복이 되고
(?)					: 앞에있는 패턴이 0개 혹은 1개이상 반복
(*)					: 앞에있는 패턴 0개 반복

(?=.*[a-z]) : 		: 최소1개이상의 소문자 영문사용
(?=.*[A-Z]) : 		: 최소1개이상의 대문자 영문사용
(?=.*[0-9]) : 		: 최소1개이상의 숫자
(?=.*[!@#$%^&*()_]) : 최소 1개이상의 특수문자	
1. /^[a-z0-9]{5,20} $/								: 소문자/숫자조합 5~20글자 패턴
2. /^[a-zA-Z0-9]{8-20}$/ 							: 대소문자숫자 최소8자리부터 최대20자리까지
3. /^[a-zA-Z가-힣]{2,20}$/ 							: 대소문자 한글 포함 2~20 자리 패턴
4. /^([0-9]{2,3})-([0-9]{3,4})-([0-9]{3,4})$/		: 숫자 2~3 - 숫자3~4 - 숫자3~4
5. /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z]{}$/		: 대소문자/숫자 @ 
6. /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9]+\.[a-zA-Z0-9-]+$/ 이메일형식
				-_.
					
검사 : 정규표현식.test(데이터)  : 맞으면 true , 아니면 false


 */
let form_check = document.querySelectorAll(".form_check") // 호출 ALL할때는 배열로 가지고 온다
//console.log(form_check);

// MemberDao 2.아이디 중복체크

/*----------아이디----------*/
function cy_id1(){					
	// MemberDao 2. 아이디 중복체크 							//아이디를 입력[keyup] 하면 이벤트가 발생
	let cy_id = document.querySelector("#cy_id").value;			// 입력받은 아이디 호출
	//console.log(cy_id);										//console.log로 확인
	let idcheck = /^[a-z0-9]{5,20}$/; 							//정규표현식 작성 소문자/숫자조합 5~20글자
		
	if( idcheck.test(cy_id) ){									//정규표현식 검사
		$.ajax({//아이디 중복체크 [비동기식]
				url: "/blog/member/idcheck",	
				data: {"cy_id":cy_id},		
				success : function(re){ 
					//만약에 결과값이 true이면 (중복이면) 
					if( re ==='true'){form_check[0].innerHTML='사용중인 아이디 입니다.'+ '놉' }
					else{form_check[0].innerHTML='성공'}
					//그렇지 않으면 사용가능한 아이디라고 알려준다.
				}
		})//ajax end		
		//유효성검사에 통과를 하지 못한경우
	}else{form_check[0].innerHTML='소문자/숫자조합 5~20글자'} //정규표현식이 다를경우에
}//cy_id1 end

/*----------비밀번호----------*/
function cy_password2(){
	let cy_password = document.querySelector("#cy_password").value;
	
	let pscheck = /^[a-zA-Z0-9]{8,20}$/ //대소문자숫자 최소8자리부터 최대20자리까지	
	if(pscheck.test(cy_password)){
		form_check[1].innerHTML='성공';
		cy_password_check3() //서로 체크를 위해 실행!
	}else{
		form_check[1].innerHTML='영대소문자/숫자조합 8~20글자'+'놉'
	}
}
/*----------비밀번호 확인----------*/
function cy_password_check3(){	
	let cy_password = document.querySelector("#cy_password").value; //첫번째 비밀번호
	let cy_password_check = document.querySelector("#cy_password_check").value; //비밀번호 확인
	let pscheck = /^[a-zA-Z0-9]{8,20}$/
	if(!pscheck.test(cy_password_check)) {//정규표현식이 다르면
		form_check[1].innerHTML='영대소문자/숫자조합 8~20글자'+'놉'
	}
	else if(cy_password_check!=cy_password){// 입력받은 비밀번호가 서고 다르면
		form_check[1].innerHTML='비밀번호가 서로 다릅니다'+'놉'
	}
	else{ //정규표현식과 비밀번호가 둘다 일치하면
		form_check[1].innerHTML='성공'; cy_password2();
	}	
}//cy_password_check3 end
/*----------이름----------*/
function cy_name4(){
	let cy_name = document.querySelector("#cy_name").value;
	let namecheck = /^[a-zA-Z가-힣]{2,20}$/ //대소문자와 한글 포함 최소2글자~20자까지
	if(namecheck.test(cy_name)){
		form_check[2].innerHTML='성공'; 
	}
	else{form_check[2].innerHTML='대소문자한글포함 2~20글자 '+'놉'; }
}
/*----------전화번호----------*/
function cy_phone5(){
	let cy_phone = document.querySelector("#cy_phone").value;	
	let phonecheck = /^([0-9]{2,3})-([0-9]{3,4})-([0-9]{3,4})$/ //0부터 9사이에 2~3글자
	if(phonecheck.test(cy_phone)){form_check[3].innerHTML='성공'; } // 번호 4->3
	else{form_check[3].innerHTML='지역번호-xxxx-xxxx'+'놉'; }
}
/*----------이메일----------*/

// MemberDao 3. 이메일 중복체크

function cy_email6(){
	let cy_email = document.querySelector("#cy_email").value;	
	let emailcheck = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9]+\.[a-zA-Z0-9-]+$/ //문자를 원하는 경우에는 앞에 \을 넣어야한다.
								//-_.
	if(emailcheck.test(cy_email)){
		$.ajax({
				url: "/blog/member/emailcheck",
				data:{"cy_email":cy_email},
				success : function(re){ 
					if(re==='true'){
						form_check[4].innerHTML='사용중인아이디입니다.'+'놉';
					}
					else{form_check[4].innerHTML='성공';}					
				}
		})
	}
	else{form_check[4].innerHTML='이메일형식으로 입력해주세요.'+'놉';}	
}//cy_email6
/*----------전송확인----------*/


function signup(){
	
	for(let i=0; i<=4; i++){
		if(form_check[i].innerHTML !== '성공'){ // 문구가 모두 성공이에여 합니다.
			alert("입력이 되지 않은 정보가 있습니다.");  return false;
		}
	}
	
	let info = {
		cy_id : document.querySelector("#cy_id").value ,
		cy_password : document.querySelector("#cy_password").value ,
		cy_name : document.querySelector("#cy_name").value ,
		cy_phone : document.querySelector("#cy_phone").value ,
		cy_email : document.querySelector("#cy_email").value
	}
	
	$.ajax({
		url : "/blog/member/signup",
		type : "POST" , 
		data : info ,
		success : function( re ){
			if( re == 'true') { alert("회원가입이 완료되었습니다. 로그인 페이지로 이동합니다!"); location.href="login.jsp"; }
			else{ alert('로그인실패') }
		 }
	})
	
}//signup

