/**




/* 썸머노트 실행 */


/*$(document).ready(function() {

  $('#summernote').summernote( {
	
		plasceholder : '내용 입력 해주세요' , 
		maxHeight : null , 
		minHeight : 300, 
		lang: 'ko-KR' // default: 'en-US'
		
	});
  
}); 

*/


/*function pagechange(  ){

}
*/

function imgwrite(){

    //form 버전
    let form = document.querySelector('form') 	
	console.log( form )
	
	let formdata = new FormData( form )		
	 console.log( formdata )						


     $.ajax({	
	    url : "/blog/board/bwirte",
	   	data : formdata , 									
		type : 'POST' , 
		contentType : false , 
		processData : false , 
		success : function( re ){
			if( re === 'true'){ 
	           $(".mainbox").load("/blog/gallery/plist.jsp");
	           alert('등록성공')
			}
			else{ alert('등록실패') }
		}
	})
	
}