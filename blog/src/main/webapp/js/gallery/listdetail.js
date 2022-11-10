/**
 * 
 */


detail();
function detail(){  //1. 글쓰기 출력
	$.ajax({
		url: "/blog/board/bimgdetail" , 
	    async : false , // 비동기식 -> 동기식으로 변경   // (ajax가 두개(list, beviw) 동시에 들어올 경우 설정 -  한쪽에  wait을 걸음 ( 이전 기능을 다 실행되기 전까지  대기상태))
		success : function( re ){ 
			let Iboard  = JSON.parse( re )
			
			
			document.querySelector('.imno').innerHTML = Iboard.imgb_no;
			document.querySelector('.title').innerHTML = Iboard.imgb_title;
			document.querySelector('.b_img').innerHTML = Iboard.imgb_file;
			document.querySelector('.b_content').innerHTML = Iboard.imgb_content;
			
		   	

                    }
             })
}