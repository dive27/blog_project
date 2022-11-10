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
			
			

	
		   	
		   let btnbox = document.querySelector('.btnbox')
		   
		    if(Iboard.btnaction == true){
			 let deletebtn ='<button onclick="imgdelete('+Iboard.imgb_no+')"> 삭제 </button>'
			 btnbox.innerHTML += deletebtn;
			
			
		}
		    
		    
		    
		   
		   	

                    }
             })
}


//삭제 
function imgdelete( imgb_no ){
	$.ajax({
		url:"/blog/board/bimgdelete",
		data : { "imgb_no" : imgb_no },
		success: function( re ){
	    if ( re == 'true'){
		   alert('사진 삭제 성공')
		   $(".mainbox").load("/blog/gallery/plist.jsp")
	}else { alert (' 삭제 실패')}
	    
	    		
		}
		
	})
	
} 