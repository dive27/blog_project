	
	// 1. 변수지정
	let btt = document.querySelector("#back_to_top"); // 클릭 객체 가져옴
		//console.log(btt)
	let docElem = document.documentElement; // 스크롤을 움직이기 위해서 html문서 전체를 가지고 옴
		//console.log(docElem);
	let offset = ""; // 스크롤을 어느정도 내렸을 때 .back_to_top 이 나타나는 구간
		//console.log(offset); 
	let scrollPos = ""; // 내가 내린 스크롤의 양
		//console.log(scrollPos);
	let docHeight = '';// 요소의 높이
	
	// 문서 높이 계산하기
	//body의 전체 높이를 구함
	docHeight = docElem.scrollHeight; // 지금 html 문서 전체 높이를 docHeight로 지정
		//console.log(docHeight);
	
	if (docHeight != 0) {//문서전제의 scrolltop높이가 0 이 아니면
		offset = docHeight / 4; // 전제적인 html높이를 4분의 1로 나눈 값을 offset에 저장
			//console.log(offset);
	}
	
	// 스크롤 이벤트
	window.addEventListener('scroll', function() {
		scrollPos = docElem.scrollTop; //실시간 스크롤의 양
		//console.log(scrollPos);    		          
		if(scrollPos>offset){//문제 만약에  4분의 1값으로 나눈 양보다 내가 내린 스크롤의 양이 더 크면
			btt.className = 'visible'; //if문을 사용하지 않으면 class추가가 되는데 if문을 사용하면 나타나지 않음..
		}else{
			btt.className = '';//아니면 공백 class명이 없으면 넣고 있으면 교체한다
		}		
	})//window.addEventListener end
	
	
	// 클릭 이벤트 
	btt.addEventListener('click', function() {		
		scrollToTop();     //scrollToTop 실행          
	})
	
	function scrollToTop() {
		// 일정시간마다 스크롤양을 조금씩 빼다가 0이되면 멈추게 해야함	
		//일정시간마다 해야 할 일
		let scrollInterval = setInterval(function() {
			if (scrollPos != 0) { // 내가 내린 스크롤의 양이 0이 아니면
				window.scrollBy(0, -55) // 스크롤의 양을 조금 씩 뺄건데, x축은 안하고 y축으로만 조금 씩 뺄 예정
			} else {//그렇지 않으면 , 스크롤의 양이 0 이면
				clearInterval(scrollInterval) // clearInterval 해서 스크롤을 멈춰라
			}
		}, 15)//0.0015s
	}

	