/*getlistimg()         // 글 출력 함수 자동 실행

function getlistimg(){
alert('cc')

   $.ajax({
      url : "/blog/board/bimgOutPut" ,
      success : function( re ){
         let json = JSON.parse( re )
         let html = '<table><tr>';
         
        	let i = 0;
     
			for(  i = 0 ; i < 3 ; i++ ){                              // 3*3형식으로 호출할거니까 맨 윗줄 3번 반복 총 0~8반복
               html += '<th><img class="bimg" onclick="detailload('+json[i].imgb_no+')" src="/blog/upload/'+json[i].imgb_file+'"style= width:250px;height:250px;"></th>';      
           		if( json[i].imgb_file == null ){
					 html += '</table>'
					 document.querySelector('#box1').innerHTML = html 
				}
            }
            html += '</tr><tr>'
            
            for( i = 3 ; i < 6 ; i++ ){                              // 3번씩 반복하는데 반복할때마다 <tr>을 닫아버리면 행이 3개씩 만들어지니까
               html += '<td><img class="bimg" onclick="detailload('+json[i].imgb_no+')" src="/blog/upload/'+json[i].imgb_file+'"style= width:250px;height:250px;"></td>';
            	if( json[i].imgb_file == null ){
					 html += '</table>'
					 document.querySelector('#box1').innerHTML = html 
				}
            }
            html += '</tr><tr>'
            
            for( i = 6 ; i < 9 ; i++ ){            
               html += '<td><img class="bimg" onclick="detailload('+json[i].imgb_no+')" src="/blog/upload/'+json[i].imgb_file+'"style= width:250px;height:250px;"></td>';
            	if( json[i].imgb_file == null ){
					 html += '</table>'
					 document.querySelector('#box1').innerHTML = html 
				}
            }
            html += '</tr></table>'                  
            document.querySelector('#box1').innerHTML = html   
		
         
      }
   })
}


*/


imglist( )

// 이미지 전체 출력 
function imglist( page ){
	alert('cc')
  $.ajax({
	url: "/blog/board/bimgOutPut",
	success : function( re ){

		let output = JSON.parse(re)
		
		alert( output )
		
		let html = '';
		
		
		/*let lastpage = 9;
		let startpage = 0;
		*/
		
	
		for ( let i = 0; i<output.length; i++){  // size vs length 사용 기준 ?
           let b = output[i]
			 html +=  '<div id ="box1">'+
                      '<div>'+
                      '<img class="bimg" onclick="detailload('+b.imgb_no+')" src="/blog/upload/'+b.imgb_file+'"style= width:250px;height:250px;">'+
                      '</div><br> '+
                      //'<div class="imgtitle">'+output[i].imgb_title+'</div>'+
                      //'<div class="imgdate">'+output[i].imbb_view +'</div>'+
                       '</div>';
	
			}
		
		document.querySelector('#box1').innerHTML += html;

	
	///////////////////////// 3.페이징처리 //////////////////
			// 1. 페이징버튼 html 구성 
			
			let pagehtml = '';
				// 2. 이전 버튼  // 만일 현재페이지가 첫페이지이면 이전페이지 불가
				if( page <= 1 ) { pagehtml += '<button onclick="imglist('+(page)+')">이전</button>'; }
				else { pagehtml += '<button onclick="imglist('+(page-1)+')">이전</button>'; }
				
				// 3. 다음 버튼 // 만일 현재페이지가 마지막페이지이면 다음페이지 불가 
				if( page >= output.totalpage ){ pagehtml += '<button onclick="imglist( '+(page)+');">다음</button>'; }
				else{ pagehtml += '<button onclick="imglist( '+(page+1)+')">다음</button>'; }
				
				// 4. 페이지번호 버튼 [ 시작버튼 ~ 마지막버튼 ]
				for( let page = output.startbtn ; page<= output.endbtn ; page++ ){
					pagehtml +='<button type="button" onclick="imglist('+page+')">'+page+'</button>'
				}
			
			document.querySelector('.pagebox').innerHTML = pagehtml
		
		}
})

	
}

/*
function plus(){
	alert('함수들어옴')
	html=''
	document.querySelector('.pagebox').innerHTML = pagehtml
	alert('ㅈㅁㅈㅁ')
	lastpage += 9
	startpage+= 9
	alert(lastpage)
	alert(startpage)
}
*/



/// 이미지 클릭시  상세 출력
function detailload( imgb_no ){
	$.ajax({
		 url:"/blog/board/detailload",
		 data: { "imgb_no" : imgb_no },
		 success : function ( re) {
			 alert( imgb_no)
			$(".mainbox").load("/blog/gallery/pdtail.jsp")
			
		}
		
		
		
	})
	
}



 