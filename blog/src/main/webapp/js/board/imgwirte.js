/**




/* 썸머노트 실행 */


$(document).ready(function() {

  $('#summernote').summernote( {
	
		plasceholder : '내용 입력 해주세요' , 
		maxHeight : null , 
		minHeight : 300, 
		lang: 'ko-KR' // default: 'en-US'
		
	});
  
}); 

alert('cc')

 function imgwrite(){

    //form 버전
    let form = document.querySelector('form') 	
	console.log( form )
	
	let formdata = new FormData( form )		
	 console.log( formdata )						


     $.ajax({
	    url : "/board2/bwirte",
	   	data : formdata , 									
		type : 'POST' , 
		contentType : false , 
		processData : false , 
		success : function( re ){
			
			
			if( re === 'true'){ 
				alert('사진등록 '); 
				location.href="plist.jsp"
			}
			else{ alert('등록실패') }
		}
	})
	
}