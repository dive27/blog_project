

let best_img = document.querySelector('.best_img')		// 인기게시물 3개 
let recent_box = document.querySelector('.recent_box') 	// 최근 게시물 5개




tlistall();
function tlistall(  ){
	$.ajax({
		url : "/blog/board/tlistall" , 
		success : function( re ){
			
			let boards = JSON.parse(re);
			console.log( boards );
			
			
			// ------------------- recent_box -----------------------------
			let recent_boxhtml = '';
			for( let i = 0 ; i<boards.length ; i++ ){
				let b = boards[i];
				 recent_boxhtml +=  '<div class="r_info_box">'+
						'	<div class="recent"> <!-- 최근게시물 [이미지 제외 ] -->'+
						'		<div class="updated">'+
						'			<div class="udpated_img"> <!-- 프로필 이미지 -->'+
						'				<img src="'+profileimg.src+'" width="38px" height="38px">'+
						'			</div>'+
						'			<div class="m_name">'+
						'				<span class="nick_name"> '+b.mid+' </span>'+
						'				<span class="update_time"> '+b.bdate+' </span>'+
						'			</div>'+
						'		</div>'+
						'		'+
						'		<div class="me_title"> <!-- 게시물 제목  -->'+
						'			<h3> '+b.btitle+' </h3>'+
						'		</div>'+
						'		<div class="me_content"> <!-- 게시물 내용 -->'+
						'			<span class="content_list">'+b.bcontent+'</span>'+
						'		</div>'+
						'		<div class="ah">'+
						'			<span> 공감 1024 </span>'+
						'			<span> / 댓글 98 </span>'+
						'		</div>'+
						'	</div> <!-- 최근게시물 [이미지 제외 ]end -->'+
						'	<div class="me_img"> <!-- 게시물 이미지 -->'+
						'		<img src="/blog/upload/'+b.bfile+'" width="228px" height="228px"></a>'+
						'	</div>'+
						'					</div>';
				
			}
			
			recent_box.innerHTML = recent_boxhtml;
			
			
			
			// ------------------- best_img -----------------------------
			
			
			/* 조회순 으로 정렬 */
			var sortingField = "bview";
			
			boards.sort(function(a, b) { // 내림차순
			    return b[sortingField] - a[sortingField];
			});
						
			let best_imghtml =''
			for( let i = 0 ; i<boards.length ; i++ ){
				if( i == 3 ){ break; }
				let b = boards[i];
				best_imghtml +=  '<div class="container">'+
						'	  <img src="/blog/upload/'+b.bfile+'" width="20%" alt="Avatar" class="image">'+
						'	  <div class="overlay">'+
						'	    <div class="text"> '+b.btitle+' </div>'+
						'	  </div>'+
						'	</div>';
			}
			best_img.innerHTML = best_imghtml;
		}
	})
}





























