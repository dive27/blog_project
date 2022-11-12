
function pagechange( page ){
	$(".mainbox").load(page)
}

/* */
document.querySelector('.imgadd').addEventListener( 'click' , e=>{
	
	let form = document.querySelector(".form1");
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
let change_profile_div = document.querySelector(".change_profile_div>img")

console.log(profileimg)
console.log(change_profile_div)

// 프로필 이미지 수정
$.ajax({
	url: "/blog/member/imgadd",
	success: function(img) {
		// 이미지가 없으면 기본 프로필 적용
		if (img == 'null') {
			profileimg.src = '/blog/member/img/pforileimg.jpg';
		}
		else {			
			profileimg.src = '/blog/member/img/' + img;
			change_profile_div.src ='/blog/member/img/'+ img;			
		}
	}
})


document.querySelector('.followadd').addEventListener( 'click' , e=>{
	
	let data = {
		cy_id : document.querySelector(".cy_id").value ,
		cy_follow_message : document.querySelector(".cy_follow_message").value 
	}
	console.log( data )
	
		// 1. 이미 이웃신청한 사람인지 유효성검사 진행 해서 이미 이웃신청한 사람이면 이웃신청 불가 아님녀 이웃신청  ㄱㄱ 
		
	// 이웃신청 
	$.ajax({
		url: "/blog/member/followadd",
		data : data , 
		type : "post",
		success: function(re) { 
			if( re =="true"){alert('이웃신청이 완료되었습니다..');}
			else{ alert("없는 회원 입니다."); }
		}

	})

})
	











