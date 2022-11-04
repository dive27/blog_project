

const divs = document.querySelectorAll('.divs')
const tds = document.querySelectorAll('td')
const imgs = document.querySelectorAll('.img')

tds.forEach((td, index)=>{
	tds[index].addEventListener('mouseover',()=>{
		divs.forEach((div,div_i)=>{
			imgs.forEach((img,img_i)=>{
				if(index==div_i && div_i==img_i){
					div.style.display='block'
					img.style.opacity='0.2'
					
				}
			})
		})
		
	})
	
	tds[index].addEventListener('mouseout',()=>{
		divs.forEach((div,div_i)=>{
			imgs.forEach((img,img_i)=>{
				if(index==div_i && div_i==img_i){
					div.style.display='none'
					img.style.opacity='1'
				}
			})
		})
		
	})
	
})