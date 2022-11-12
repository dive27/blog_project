
let cy_profile_img =  document.querySelector('.cy_profile_img')

//////////////////////////// 본인 프로필 가져오기 ////////////////////////
// 처음 js 실행되면
let img = 'null'; // 가져온 이미지 저장하는 변수 
imgadd(0) // 현재 로그인된 회원의 이미지 가져오기
// 이미지가 없으면 기본 프로필 적용
if (img == 'null') {
	cy_profile_img.src = '/blog/member/img/pforileimg.jpg';
}
else {
	cy_profile_img.src = '/blog/member/img/' + img;
}
/////////////////////////////////////////////////////////////////

function imgadd(mno){
	$.ajax({
		url: "/blog/member/imgadd",
		data : {"mno" : mno} , 
		async : false, // 반복실행시 대기상태를 만들기.
		success: function(re) { img = re; }
	})
}

// 본인이 이웃신청한 사람들 정보 가져오기 ~ [ 이웃들 정보 뭐가 필요할까요?? 일단 회원번호,아이디,이미지는 필수고 또 있을까요? 음 이름도 혹시 모르니 가져올까  그럼 일단 다 가져오세요~ 그리고 사용할것만 사용하세요 ]
$.ajax({
	url: "/blog/member/followadd",
	type : "get",
	success: function(re) {
		// 1. 서블릿을 통해 현재 로그인한 회원이 이웃신청한 이웃회원목록 가져오기
		let jsonlist = JSON.parse( re ) 
		// 2. 이웃 프로필 출력하기 위한 html 구성 변수 
		let html = '';
		
		// 3. 이웃회원목록 만큼 반복문 돌리기 [ 리스트에서 하나씩 m 에 반볻대입 하여 m 변수 사용 ]
		jsonlist.forEach( (m) =>{
			//4. 해당 m변수의 이웃회원 번호의 이미지 가져오기 
			/////////////////////// 이웃 프로필 가져오기 /////////////
			imgadd(m.cy_num)
			
			let imgsrc = null; // 가져온 이미지 변수 
			
			if (img == 'null') { // 만일 가져온 이미지가 null 이면 
				imgsrc = '/blog/member/img/pforileimg.jpg'; // 기본 이미지 적용 
			}
			else { // null 이 아니면 
				imgsrc = '/blog/member/img/'+img; // 해당 이미지 적용 
			}
			///////////////////////////////////////////////////
			// html 구성한다.. 
			html += 
					'<div class="follower">'+
						'<div class="follower_profile_img">'+
							'<img alt="" src="'+imgsrc+'">'+		// 반복하여 위에서 구성된 이미지 넣기 
						'</div>'+
						'<div class="follower_name">'+m.cy_id+'</div>'+ // 반복하여 이웃회원명 넣기 
					'</div>'
		}) // 반복 종료
		
		document.querySelector('.my_follower_list').innerHTML = html;
		
	}
})
























