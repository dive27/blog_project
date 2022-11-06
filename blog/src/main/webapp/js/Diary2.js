
alert('하루에 한번만 작성 가능한 일기장입니다.☝️\n모두 작성한 후에는 연필을 클릭해주세요.✍️')

let date = null;
let today = null;
let choice_emo = document.querySelector('.choice_emo')
let emosrc = null;
let count = -1;
let emo_no = -1;

getToday()		  // 오늘 날짜 가져오는 함수		
getemotiontable() // 감정 테이블 출력하는 함수

function getToday(){		// 오늘 날짜 가져오는 함수

	alert('자동실행이니다')

    date = new Date();
    
    let year = date.getFullYear();
    let month = ("0" + (1 + date.getMonth())).slice(-2);
    let day = ("0" + date.getDate()).slice(-2);
    today = year + "-" + month + "-" + day;
    
    document.querySelector('.todayinput').value = today;
  
    //document.querySelector('.todaydate').innerText = today;
    return year + "-" + month + "-" + day;
 
}

//////////////////////////////////////////////// 감정 관련 함수 ////////////////////////////////////////////////

function getemotiontable(){		// 감정 테이블 나타내기 [ 완 ] 
	
	let html = '';
	$.ajax({
		url : "/blog/emotion" ,
		success : function(re){
			let json = JSON.parse(re)	
			for( let i = 0 ; i <json.length; i++ ){
				html += '<tr onmouseover="hovercss('+i+')"><td onclick="choiceemono('+json[i].emo_no+'); emojiclick('+i+');" class="emo_img'+i+'"><img class="emoji emoji'+json[i].emo_no+'" src="/blog/img/'+json[i].emo_img+'"></td> <td><input ondblclick="updateemotion('+i+')" class="emotioninput" readonly type="text" value="'+json[i].emotion+'"></td></tr>'
			}
			document.querySelector('.c_emobox').innerHTML = html
		}
	})
}

function choiceemono(no){				// 선택한 감정 일기장에 띄우기 [ 완 ] 
	emo_no = no;
	let emosrc = '/blog/img/입체하트'+emo_no+'.png'
	sessionStorage.setItem("emono",emo_no);		// 다른데서 쓰려고 세션에 저장
	choice_emo.src=emosrc;
}

//////////////////////////////////////////////// 다이어리 관련 함수 ////////////////////////////////////////////////

function loadtoday(){		// 오늘일기장으로 전환 [ 완 ]
	document.querySelector('.todaydate').value = today					// 오늘 날짜 보이도록
	document.getElementById('content').value = ''						// 일기장 비워주기
	document.getElementById('content').readOnly=false;					// 글 수정 가능
	document.querySelector('.stamp').src = "/blog/img/투명.png"			// 도장 없애기
	choice_emo.src='/blog/img/투명.png';
}



function load_diary(){			// [ 완 ] - 선택한 날짜의 일기 불러오기

getToday()
	date = document.getElementById('date').value			// 캘린더에서 선택한 값을 date변수에 넣어주고
	document.getElementById('date').innerText = date;		// 그걸 캘린더에 넣어주고 ?? 왜했더라
	document.querySelector('.todaydate').innerText = date	// 오늘 날짜 나타내는 곳에 넣어줌
	choice_emo = document.querySelector('.choice_emo') 		// 뭐지? 선택한 감정같은데 이게 뭐지? 이미지 경로때매 만든거같은데 잘 모르겠음
	
	$.ajax({
		url : "/blog/Diary" ,
		type : "post" ,
		data : { "date" : date } ,
		success : function(re){
			let json = JSON.parse( re )	
			if( re != 'null' ){	// 일기가 있으면 로드
					if( emo_no == -1 ){emosrc = '/blog/img/투명.png'}		// 하트를 아직 선택 안했으면 투명으로
					else{emosrc = '/blog/img/입체하트'+json[0].em_no+'.png'; choice_emo.src=emosrc;}	// 선택했으면 선택한 이미지로 변경
					
					if( json[0].di_date != today ){
								alert('여기는 지난 일기가 있으면서 오늘이 아닐때 오는 페이지고요')
								document.querySelector('.todaydate').value = date						// 선택한 날짜 보이도록
								document.getElementById('content').value = '';							// 일기장 비워주기
								document.getElementById('content').value = json[0].di_content;			// 이전 내용 불러오기
								document.getElementById('content').readOnly=true;						// 글 수정 불가
								document.querySelector('.stamp').src = "/blog/img/도장.png";				// 도장 찍어주기					
					}else if( json[0].di_date == today ){	// 만약 오늘 일기면
								  alert('여기는 오늘이면 들어오는 곳이에요[1]')
								  loadtoday() 				// 일단은 비워주고
								  ifalreadywr()				// 오늘 일기가 있는지 확인하는 함수 호출
					}
						
			}else if(  re == 'null'  ){alert('일기를 쓰지 않은 날이에요')	// 만약 일기가 존재하지 않는다면 오늘로 이동
				loadtoday()	// 날짜 왜 오늘로 안바뀜?
			}
		}
	})
}

function ifalreadywr(){ // 오늘 일기가 있는지 확인하는 메소드
	alert('여기는 오늘 일기가 있는지 확인하는 메소드죠[2]')
	
	today = document.querySelector('.todayinput').value
	
	alert('오늘 일기 유무 확인하는 메소드 오늘 날짜 : '+today)
	$.ajax({	
		url : "/blog/Diary" ,
		type : "put" , 
		data : { "today" : today } ,	// 이게 왜 널이야~ alert하면 뜨는데
		success : function(re){
				//if ( re == 'false' ){	// true여야 하지만 지금  데이터를 못읽으니 false라 치고 작업
				alert('오늘은 이미 작성한 일기가 있습니다.')
					if(confirm('수정할까요?')){
						count = 1;		// 만약 수정한다면 - 오늘 글이 있으면 카운트 수 바꿔주고
						alert('카운트 : '+count)
					}
				//}
		}
	})
}


function writediary(){			// 다이어리 작성 함수 [ 완 ] 
	let content = document.querySelector('#content').value
	
	if( count > 0 ){ // 새로 작성이 아니라 수정일 경우
		alert('여기는 수정과정을 거친 후 연필을 클릭하면 연결되는 곳입니다[4]')
		update_today_di()
		return;
	}
	
	$.ajax({
		url : "/blog/Diary" ,
		data : { "content" : content  , "emono" : emo_no  } ,
		success : function( re ){
			if( count == -1 ){ // 카운트가 변동하지 않고 그대로 -1일때만 글쓰기 작동
				if( emo_no == -1 ){ alert('이모티콘을 선택해주세요');}
				if( re == 'true' ){
					alert('다이어리 작성 완료🤗'); return;
				}else if( re == null ){
					alert('다이어리 내용을 입력해주세요');
				}else{
					alert('다이어리 작성 실패😅 \n [관리자 문의]');
				}				
			}

		}
	})
}

function update_today_di(){ // 오늘 일기 수정하는 메소드

	if( count > 0 ){
		alert('최종적으론 수정버튼을 거쳐 연필을 선택하면 여기서 데이터를 보내는겁니다![5]')
		
		let content = document.querySelector('#content').value
		let emono = sessionStorage.getItem("emono")
		today = document.querySelector('.todayinput').value
		
		alert('내용 : '+content+'감정번호 : '+emono+'today : '+today)
		
		$.ajax({	
			url : "/blog/Diary" ,
			type : "delete" ,
			data : { "today" : today , "content" : content , "emono" : emo_no } ,
			success : function( re ){
				alert('아작스 들어옴')
				if( emo_no == -1 ){ alert('이모티콘을 선택해주세요');}
				//if( re == 'false' ){// true여야 하지만 지금  데이터를 못읽으니 false라 치고 작업
					alert('수정완료~!~!~!!!!')
					
				//}
				//return;
			}		
		})
	}
}
	




function updateemotion(i){	// 더블클릭하면 감정설명 수정하게 해주는 메소드 [ 완 ]
	if(confirm('감정 수정이 가능해요! 수정할까요?')){
		let emonolist = document.querySelectorAll('.emotioninput')	
		let emotionlist = document.querySelectorAll('.emotioninput')
		
		emotionlist[i].readOnly=false;
		emotionlist[i].style.color="#656565";	
		emotionlist[i].value = '';
	
		document.addEventListener("keyup", function(e) {
		    if (e.keyCode === 13) {
				emotionlist[i].readOnly=true;
				emotionlist[i].style.color="black";
				let emotion = emotionlist[i].value;
				let emono = i+1;					// DB 번호 수정되면 안됨!
				alert(emono)
		        	$.ajax({
						url : "/blog/emotion" ,
						type : "post" ,
						data : { "emono" : emono , "emotion" : emotion } ,
						success : function(re){
				    		if( re == 'true' ){
								alert('감정 수정 완료🤗')
							}else{
								alert('감정 수정 실패😅 \n [관리자 문의]')
							}
				   		 }
				});
			}
		})		
	}
	

}



// ///////////////////////////////////////////// 미완성 함수 ////////////////////////////////////////////////
let img_count = 1;


let emotableimg = document.querySelector('.emotableimg')
let back_img = document.querySelector('.diary_img')

function change_back_img(){
	let back_img_src = "/blog/img/배경"+img_count+".png";
	alert('함수 들어옴'+back_img_src)
	img_count++;
	
	emotableimg.src=back_img_src
	back_img.src=back_img_src
	
	// 다이어리 이미지 테이블 따로 만들어서 사용한 배경 이미지 저장하기 / 일기 불러올 때 그 배경으로 불러오기 위해 / 그리고 이미지 수만큼만 돌게 설정하기 / 근데 테이블이 안만들어져!
}

/*
	더 구현해야되는 부분
	 
	집가서 이미지 바꾸기~!
	 
	1. 호버 효과 같이
	2. 클릭 효과 하나만
	
	3. 달력에 그날 선택한 색상 or 하트 이미지 출력하기
		3-1 다른 일기 열람할때 하트 선택하면 바뀌니까 막아주기
	
	4. 하트가 일기장이랑 겹쳐서 잘 안보이니까 효과주기 1-gif로 광택효과 2-흰테두리 그린 이미지로 대체 


function hovercss(){
	let emoimglist = document.querySelectorAll('.emoji')
	let emotextlist = document.querySelectorAll('.emotioninput')
	
	let emoimg = emoimglist[i];
	let emotext = emotextlist[i];
	
}

function emojiclick(no){				// 클릭한 감정만 효과주기 [ 미완 ]
	let emoimglist = document.querySelectorAll('.emoji')
	emo = sessionStorage.getItem("emono")
	for(let i = 0; i<emoimglist.length; i++){
		document.querySelector('.emoji'+i+'').style.transform="scale(1.0)";
		if( emo == no ){						// 만약 가져온 번호가 일치하면 ( 클릭한 번호에 )
			document.querySelector('.emoji'+no+'').style.transform="scale(1.2)";	// 왜 이건 for문에만 넣으면 안되지?
			document.querySelector('.emoji'+no+'').style.transition="transform .2s";		
			emo = sessionStorage.removeItem("emono");	// 비워줌
		}
	}
}

//calendar_day()
function calendar_day(){				// [ 미완 ] - 어차피 이 방법으론 안쓸듯
	let html = '';
	for( let i = 0; i<31; i++ ){
		if( i % 7 == 0 ){
			html += '<br>'	
		}
		html += '<img src="/blog/img/패닉.png" style="width: 40px" id="day'+i+'" style="border-radius: 50%; width: 10px; height: 10px; background-color: #eeeeee;"></img>';
	}
	document.querySelector('.calendar_day').innerHTML = html
}

*/



