


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
				/*alert("로그인성공");*/ 				
				get_cy_num() // 11/7 로그인할때 세션에 cy_num 저장 추가 
				location.href="/blog/main.jsp";
				
			 	alreadytable()	// 유정

				

			}else if(re==='2'){
				alert("비밀번호틀림")				
			}else if(re==='3'){
				alert("db오류 관리자에게 문의 주세요")
			}
		}
	})

}

   let login_diary = 1;  
   function myemotable(){
      if( login_diary == 1 ){
            $.ajax({
            url : "/blog/emotable" ,
            async:false,
            data : { "cy_num" : cy_num } ,
            success : function(re){
               login_diary = 0;
               }
            })
      }
   }





// 11/7 로그인할때 세션에 cy_num 저장 추가
let cy_num = -1
get_cy_num()
function get_cy_num(){                     // 회원번호 가져오는 함수
   $.ajax({
      url : "/blog/member/myinfor" ,         // 인포 서블릿에서
      async:false,                     
      success : function(re){
         let logininfo = JSON.parse( re )   
         localStorage.setItem( "cy_num_se" , logininfo.cy_num ) //11/10 수정  // 가져온 cy_num js 세션에 저장하고            													// 변수 cy_num에 저장해줌      
         return cy_num;                                    			// 어차피 자동실행 하니까 안해도 되나?   
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



// 유정
function alreadytable(){	
	
	$.ajax({
		url : "/blog/backimg",
		async:false,
		type : "post" ,
		success : function(re){
			if(re == 'true'){
				youremotable()
			}
		}
	})
	
}

function youremotable(){	// 아직 디비가 추가 안됐을때만 실행
	
	$.ajax({
		url : "/blog/yourtable" ,
		async:false ,
		type : "get" ,
		success : function(re){
		}
	})
	
}
