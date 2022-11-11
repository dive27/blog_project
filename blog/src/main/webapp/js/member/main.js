
let cy_profile_img =  document.querySelector('.cy_profile_img')
let profileimg = document.querySelector(".profileimg>img")
console.log(profileimg)

$.ajax({
	url: "/blog/member/imgadd",
	success: function(img) {
		// 이미지가 없으면 기본 프로필 적용
		if (img == 'null') {
			cy_profile_img.src = '/blog/member/img/pforileimg.jpg';
		}
		else {
			cy_profile_img.src = '/blog/member/img/' + img;
			//profileimg = '/blog/member/img/' + img;
			//test
		}
	}
})



