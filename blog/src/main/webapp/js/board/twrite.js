//alert('글쓰기')

/* 썸머노트 실행 */
$(document).ready(function() {
  //$('#summernote').summernote( {설정객체} );
  $('#summernote').summernote( {
	
		plasceholder : '내용 입력 해주세요' , 
		maxHeight : null , 
		minHeight : 300
	});
  
});

/* 글쓰기 버튼을 눌렀을때 */
function bwrite(){
	
	// form 버전 
	let form = document.querySelector('form') 	// 1. form 태그 호출
	console.log( form )
	
	alert('ddd');
	let formdata = new FormData( form )			// 2. 객체화된 form 정보 호출	
	console.log( formdata )						// [ form안에 입력받은 데이터 input 모두 가져오기 ] 
	
	$.ajax({ // ajax 통신 전송타입 : 문자열
		url : "/blog/board/twrite",	// 1. 서블릿주소 
		data : formdata , 									// 2. ajax 기본값으로 form 전송 불가능 
		// 첨부파일 전송시 : 아래 코드 추가 [ post방식[get방식불가] ]
		type : 'POST' , // http메소드 [ get(첨부파일x) vs post ]
		contentType : false , 
		processData : false , // string : 기본값 vs   전송시 사용되는 타입 
	
		success : function( re ){
			if( re === 'true'){ 
				alert('글등록 성공!!'); 
				$(".mainbox").load("/blog/board/tlist.jsp");
			}
			else{ alert('글등록 실패..') }
		}
	})
	
}


