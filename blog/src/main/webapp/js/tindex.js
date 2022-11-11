
function pagechange( page ){
	$(".mainbox").load(page)
}

/* */
document.querySelector('.imgadd').addEventListener( 'click' , e=>{
	
	
	let form = document.querySelector("form");
	let formData = new FormData( form );
	
	$.ajax({
		url: "/blog/member/imgadd",
		data : formData , 
		type : 'POST' ,
		contentType : false , 
		processData : false ,
		success : function(result){ 
			alert( result );
		}
	})
});


let profileimg = document.querySelector(".profileimg>img")
console.log(profileimg)

$.ajax({
	url: "/blog/member/imgadd",
	success: function(img) {
		// 이미지가 없으면 기본 프로필 적용
		if (img == 'null') {
			profileimg.src = '/blog/member/img/pforileimg.jpg';
		}
		else {
			profileimg.src = '/blog/member/img/' + img;
			//profileimg = '/blog/member/img/' + img;
			//test
		}
	}
})


