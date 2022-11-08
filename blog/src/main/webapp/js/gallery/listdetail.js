/**
 * 
 */
 

alert('dd')


imglist()

// 이미지 전체 출력 
function imglist(){
	
alert('sss')
 
  $.ajax({
	url : "/blog/board/bimgOutPut",
	type :"get",
	success : function( re ){
		let output = JSON.parse(re)
		
		console.log ( output)
		
		let html = '';
		
		for ( let i = 0; i<output.length; i++){

			 html +=  '<div id ="box1">'+
                      '<div>'+
                      '<img class="bimg" onclick="detailload('+ output[i].imgb_no+')"src="/board2/upload/'+output[i].imgb_file+'"style= width:250px;height:250px;">'+
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
		 url:"/blog/board/bimgdetail",
		 date: { "imgb_no" : imgb_no },
		 success : function ( re ) {
			$(".mainbox").load("/blog/gallery/pdtail.jsp")
			
			
		}
		
		
		
	})
	
}
