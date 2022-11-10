
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


