document.querySelector('.search_btn').addEventListener('click', (e)=>{
	
	let search = document.querySelector('.search_input').value;
	
	location.href="/blog/index.jsp?id="+search
	
})