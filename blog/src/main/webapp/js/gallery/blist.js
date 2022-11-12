

let pageinfo = { 
 	listsize: 9 ,	// 게시물 표시 개수 
	page: 1	// 현재 페이지 번호 
}


imglist( 1 )




// 이미지 전체 출력 
function imglist( page ){
	pageinfo.page = page;
	
  $.ajax({
	url: "/blog/board/bimgOutPut",
	data:  pageinfo ,
	success : function( re ){
		let output = JSON.parse(re)
		let outputlist = output.data
		let html = ""		
	
		
	
		for ( let i = 0; i<outputlist.length; i++){  // size vs length 사용 기준 ?
           let b = outputlist[i]
			 html +=  '<div class="box_s2">'+
			          '<ul>'+
                      '<li><img class="bimg" onclick="detailload('+b.imgb_no+')" src="/blog/upload/'+b.imgb_file+'"style= width:220px;height:250px;"></li>'+
                      '</ul>'+
                      '</div>';
                      //'<div class="imgtitle">'+output[i].imgb_title+'</div>'+
                      //'<div class="imgdate">'+output[i].imbb_view +'</div>'+
                       
			}
		
		document.querySelector('.box_s').innerHTML = html

	
	///////////////////////// 3.페이징처리 //////////////////
			// 1. 페이징버튼 html 구성 
			
			let pagehtml = '';
				// 2. 이전 버튼  // 만일 현재페이지가 첫페이지이면 이전페이지 불가
				if( page <= 1 ) { pagehtml += '<button onclick="imglist('+(page)+')">이전</button>'; }
				else { pagehtml += '<button onclick="imglist('+(page-1)+')">이전</button>'; }
				
				
				// 4. 페이지번호 버튼 [ 시작버튼 ~ 마지막버튼 ]
				for( let page = output.startbtn ; page<= output.endbtn ; page++ ){
					pagehtml +='<button type="button" onclick="imglist('+page+')">'+page+'</button>'
				}
				
				
				// 3. 다음 버튼 // 만일 현재페이지가 마지막페이지이면 다음페이지 불가 
				if( page >= output.totalpage ){ pagehtml += '<button onclick="imglist( '+(page)+');">다음</button>'; }
				else{ pagehtml += '<button onclick="imglist('+(page+1)+')">다음</button>'; }
				
				
			
			document.querySelector('.pagebox').innerHTML = pagehtml
		
		}
})

	
}





/// 이미지 클릭시  상세 출력
function detailload( imgb_no ){
	$.ajax({
		 url:"/blog/board/detailload",
		 data: { "imgb_no" : imgb_no },
		 success : function ( re) {
		
			$(".mainbox").load("/blog/gallery/pdtail.jsp")
			
		}
		
		
		
	})
	
}



 