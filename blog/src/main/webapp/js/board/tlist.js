
// 전역변수 [ 상단 ]
let pageinfo = {  // js 객체 선언 
 	listsize : 5 ,	// 게시물 표시 개수 
	page  : 1 ,		// 현재 페이지 번호 
	key : '',		// 검색 키 
	keyword : '',	// 검색 키워드
}

list( 1 ) // js 열람시 메소드 1번 실행 

// 1. 게시물 출력 함수
function list( page ){ // 함수 정의한다
	pageinfo.page = page;
	$.ajax({
		url : "/blog/board/tlist" , 
		data : pageinfo,	// 페이지 정보 객체 전달
		success : function( re ){
			
			let boards = JSON.parse( re )
			let boardlist = boards.data
			let html = "<tr><th> 번호 </th> <th> 제목 </th><th> 작성일 </th> <th> 조회수 </th></tr>"
			

			// 게시물 출력
			for( let i = 0 ;  i<boardlist.length ; i++){
				// 1. i번째 객체 호출 
				let b = boardlist[i]	// i번째 객체호출
				console.log( b )
				// 2. i번쨰 객체의 정보를 html 형식으로 변환해서 문자열에 저장
				html += '<tr>' +
							'<td>'+b.bno+'</td>'+
							'<td onclick="viewload('+b.bno+')">'+b.btitle+'</td>'+
							'<td>'+b.bdate+'</td>'+
							'<td>'+b.bview+'</td>'+
						'</tr>';
						
			} // for end 
			console.log( html )
				
			document.querySelector('.btable').innerHTML = html
			
			// 페이징처리
			let pagehtml = '';
				// 2. 이전 버튼  // 만일 현재페이지가 첫페이지이면 이전페이지 불가
				if( page <= 1 ) { pagehtml += '<button onclick="list( '+(page)+')">이전</button>'; }
				else { pagehtml += '<button onclick="list( '+(page-1)+')">이전</button>'; }
				// 4. 페이지번호 버튼 [ 시작버튼 ~ 마지막버튼 ]
				for( let page = boards.startbtn ; page<= boards.endbtn ; page++ ){
					pagehtml += '<button type="button" onclick="list('+page+')">'+page+'</button>'
				}
				// 3. 다음 버튼 // 만일 현재페이지가 마지막페이지이면 다음페이지 불가 
				if( page >= boards.totalpage ){ pagehtml += '<button onclick="list( '+(page)+')">다음</button>'; }
				else{ pagehtml += '<button onclick="list( '+(page+1)+')">다음</button>'; }
			
			document.querySelector('.pagebox').innerHTML = pagehtml
			
			// 5. 전체vs검색 된 게시물수 표시 
			document.querySelector('.totalsize').innerHTML = boards.totalsize
			
			
		}
	})
}// end
			
			
// 2. 제목 클릭했을때 이동
function viewload( bno ){
	$.ajax({
		url : "/blog/board/tviewload" , 
		data : { "bno" : bno },
		success : function( re ){
			$(".mainbox").load("/blog/board/tview.jsp");
								// 이동할 페이지 경로
		}
	})
}

// 3. 검색처리 함수 
function bsearch(){
	pageinfo.key = document.querySelector('.key').value
	pageinfo.keyword = document.querySelector('.keyword').value
	list( 1 )
} // end

// 4.게시물 표시 개수 
function blistsize(){
	pageinfo.listsize = document.querySelector('.listsize').value
	list( 1 )
} // end

