/**
 * 
 */
 
 
alert('dd')


imglist()

// 이미지 전체 출력 
function imglist(){
	
	alert('cc')
	
  $.ajax({
	url: "/blog/board/bimgOutPut",
	type:"get",
	success : function( re ){
	
		let output = JSON.parse(re)
		console.log (output)
		
		let html = '';
		
		for ( let i = 0; i<output.length; i++){
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
	}
	
})
	
	
}


/// 이미지 클릭시  상세 출력
function detailload( imgb_no ){
	$.ajax({
		 url:"/blog/board/detailload",
		 data: { "imgb_no" : imgb_no },
		 success : function ( re) {
			 alert( imgb_no)
			
			//$(".mainbox").load("/blog/gallery/pdtail.jsp")
			 location.href = "/blog/gallery/pdtail.jsp"
			
		}
		
		
		
	})
	
}


 
 
 