
// 1. 해당 게시물 출력 
bview()

function bview(){
	$.ajax({
		url : "/blog/board/tview" , 
			/*async : false ,	 동기식 */
		success : function( re ){ 
			let board  = JSON.parse( re )
			console.log( board )
			document.querySelector('.bno').innerHTML = board.bno;
			document.querySelector('.btitle').innerHTML = board.btitle;
			document.querySelector('.bcontent').innerHTML = board.bcontent;
			document.querySelector('.mid').innerHTML = board.mid;
	
			
			if( board.bfile !== null ){	// null , undefined , 0 , false
				let filelink = '<a href="/blog/board/tfiledown?bfile='+board.bfile+'">'+board.bfile+'</a>'
				// ' ' : 전체 문자열 처리
				// " " : 전체 문자열내 문자열 구분  
				document.querySelector('.bfile').innerHTML = filelink;
			}
			
			console.log( board.btnaction )
			
			let btnbox = document.querySelector('.btnbox')
			
			if( board.btnaction == true ){
				// 삭제 버튼 활성화
				let deletebtn = '<button onclick="bdelete('+board.bno+')"> 삭제 </button>'
				btnbox.innerHTML += deletebtn;
				// 수정 버튼 활성화 
				let updatebtn = '<button onclick="pagechange()">수정</button>'
				btnbox.innerHTML += updatebtn;
			}
			////////////////// 댓글출력 ///////////////////
			rlist()
		
		}
	})
	
	
}

function pagechange(  ){
	$(".mainbox").load("/blog/board/tupdate.jsp")
}


// 2. 게시물 삭제 함수 
function bdelete( bno ){ // 삭제 버튼 클릭시 삭제할 번호를 인수[식별]
	$.ajax({
		url : "/blog/board/tbdelete" , 
		data : { "bno" : bno } , // 삭제할 게시물의 식별번호[pk->bno]
		success : function( re ){
			if( re === 'true'){
				alert('글삭제 성공 ');
				$(".mainbox").load("/blog/board/tlist.jsp");
			}
			else{ alert('글삭제 실패 : [관리자에게문의]') }
		}
	})
}

// 3. 댓글 작성함수 
function rwrite(){
	let rcontent = document.querySelector(".rcontent").value;
	$.ajax({
		url : "/blog/reply/trwrite" ,
		data : {"rcontent" :  rcontent , "type" : "reply" } , 
		type : "POST" , /* HTTP 메소드 : 1.GET방식=기본값 2. POST방식 */
		success : function( re ){
			 if( re == 1 ){
				alert('댓글작성') // location.reload();
				rlist()
			}else if( re == 0){
				alert('로그인후 작성가능합니다.')
				$(".mainbox").load("/blog/member/tlogin.jsp");
			}else{
				alert('댓글실패')
			}
		}
	})
}

// 4. 댓글 출력 함수 
function rlist(){
	$.ajax({ // 댓글 호출 ajax
		url : "/blog/reply/trlist" ,
		data : { "type" : "reply" } , 	// type : reply    댓글용
		success : function(re){ // 댓글 호출이 성공했을떄
			let replylist = JSON.parse(re)
			let html = ''
			for( let i = 0 ; i<replylist.length ; i++){ // 댓글마다 반복문 
				let reply = replylist[i]
				
				
				$.ajax({ // 댓글마다 대댓글 호출 ajax 호출  = rno ----> rindex 
					url : "/blog/reply/trlist" ,
					data : { "type" : "rereply" , "rno" : reply.rno } , // type : rereply    대댓글용
					async : false ,	/* 동기식 */ 
					success : function(re){ 
						let rereplylist = JSON.parse( re )
						/////// 상위 댓글 html 구성 
						html += '<div>'+
									'<span>'+reply.rcontent+'</sapn>'+
									'<span>'+reply.rdate+'</sapn>'+
									'<span>'+reply.mid+'</sapn>'+
									'<button type="button" onclick="rereplyview('+reply.rno+')">답글</button>'+
									'<div class="reply'+reply.rno+'"></div>';	
						////// 대댓글 html 구성 
						for( let j = 0 ; j<rereplylist.length ; j++ ){
							let rereply = rereplylist[j]
							html += '<div style="margin : 20px;">'+
										'<span>'+rereply.rcontent+'</sapn>'+
										'<span>'+rereply.rdate+'</sapn>'+
										'<span>'+rereply.mid+'</sapn>'+
									'</div>';
						} // 대댓글 반복문
						// 마지막 닫기 html 구성
						html += '</div>';
					 }
				})
			} // 댓글 반복문 end 
			document.querySelector('.replylist').innerHTML = html;
			
		}
	})
}

// 5. 대댓글[답글] 작성 구역 표시 함수
function rereplyview( rno ){
	let replydiv = document.querySelector('.reply'+rno)
	replydiv.innerHTML = 
			'<input type="text" class="rerecontent'+rno+'">'+
			'<button onclick="rereplywrite('+rno+')">답글작성</button>';
}

// 6. 대댓글[답글] 작성 함수 
function rereplywrite( rno ){
	let rcontent = document.querySelector('.rerecontent'+rno).value
	$.ajax({
		url : "/blog/reply/trwrite" ,
		data : {"rcontent" :  rcontent , "rno" : rno , "type" : "rereply" } , 
		type : "POST" , 
		success : function( re ){ 
			if( re == 1 ){ alert('답글 작성'); rlist() }
			else if( re == 0){ alert('로그인후 작성가능합니다.');location.href='/blog/member/tlogin.jsp' }
			else{ alert('답글 실패') }
		 }
	});
}

