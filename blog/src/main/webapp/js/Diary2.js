
alert('하루에 한번만 작성 가능한 일기장입니다.☝️\n모두 작성한 후에는 연필을 클릭해주세요.✍️')

let date = null;
let today = null;
let choice_emo = document.querySelector('.choice_emo')
let emosrc = null;


getToday()		  // 오늘 날짜 가져오는 함수		
getemotiontable() // 감정 테이블 출력하는 함수

function getToday(){		// 오늘 날짜 가져오는 함수
    date = new Date();
    let year = date.getFullYear();
    let month = ("0" + (1 + date.getMonth())).slice(-2);
    let day = ("0" + date.getDate()).slice(-2);
    today = year + "-" + month + "-" + day;
    document.querySelector('.todaydate').innerText = today;
    return year + "-" + month + "-" + day;
}



function loadtoday(){		// 오늘일기장으로 전환 [ 완 ]
	document.querySelector('.todaydate').value = today					// 오늘 날짜 보이도록
	document.getElementById('content').value = ''						// 일기장 비워주기
	document.getElementById('content').readOnly=false;					// 글 수정 가능
	document.querySelector('.stamp').src = "/blog/img/투명.png"			// 도장 없애기
	choice_emo.src='/blog/img/투명.png';
}

//////////////////////////////////////////////// 다이어리 관련 함수 ////////////////////////////////////////////////

function load_diary(){			// [ 미완 ] - 선택한 날짜의 일기 불러오기

getToday()
	date = document.getElementById('date').value
	document.getElementById('date').innerText = date;
	document.querySelector('.todaydate').innerText = date
	choice_emo = document.querySelector('.choice_emo') 
	
	$.ajax({
		url : "/blog/Diary" ,
		type : "post" ,
		data : { "date" : date } ,
		success : function(re){
			let json = JSON.parse( re )	
			if( json[0].di_date == today ){
				let to_day = today
				$.ajax({
					url : "/blog/Diary" ,
					type : "put" , 
					data : { "to_day" : today } ,
					success : function(re){
						if( re == 'false' ){ // 오늘 작성한 일기가 있으면 - 왜 여기를 안들어오니?
							alert('오늘은 이미 작성한 일기가 있습니다.')
							if(confirm('수정할까요?')){
								alert('네 수정하게 해드릴게요')
								document.getElementById('content').value = json[0].di_content;		// 이전 내용 불러오기 왜 안되냐고~ 콘솔에는 뜨네?
								document.getElementById('content').readOnly=false;					// 글 수정 가능
								document.querySelector('.stamp').src = "/blog/img/투명.png"			// 도장 없애기
								choice_emo.src='/blog/img/투명.png';
							}
						}//없으면 뭐.. 작성해도 되는거고
					}
				})				
			}

			
			if( re != 'null' ){	// 일기가 있으면 로드
					if( json[0].di_date == today ){
						}else{
								document.querySelector('.todaydate').value = date						// 선택한 날짜 보이도록
								document.getElementById('content').value = '';							// 일기장 비워주기
								document.getElementById('content').value = json[0].di_content;			// 이전 내용 불러오기
								document.getElementById('content').readOnly=true;						// 글 수정 불가
								document.querySelector('.stamp').src = "/blog/img/도장.png";				// 도장 찍어주기					
								
								if( emo_no == -1 ){
									emosrc = '/blog/img/투명.png'
								}else{
									emosrc = '/blog/img/입체하트'+json[0].em_no+'.png'
								}
								
								choice_emo.src=emosrc;
						}
			}else if(  re == 'null'  ){alert('일기를 쓰지 않은 날이에요')	// 만약 일기가 존재하지 않는다면 오늘로 이동
				loadtoday()	// 날짜 왜 안바뀜?
			}
		}
	})
}

function writediary(){			// 다이어리 작성 함수 [ 완 ] 
	let content = document.querySelector('#content').value

	if( emo_no == -1 ){ alert('이모티콘을 선택해주세요'); return; }
	
	let to_day = today
	alert('왜 이게 널이죠?' + to_day )
	$.ajax({	
		url : "/blog/Diary" ,
		type : "put" , 
		data : { "to_day" : today } ,
		success : function(re){
				if ( re == 'false' ){
				alert('오늘은 이미 작성한 일기가 있습니다.')
				return;
			}
		}
	})
	
	$.ajax({
		url : "/blog/Diary" ,
		data : { "content" : content  , "emono" : emo_no  } ,
		success : function( re ){
			if( re == 'true' ){
				alert('다이어리 작성 완료🤗')
			}else if( re == null ){
				alert('다이어리 내용을 입력해주세요')
			}else{
				alert('다이어리 작성 실패😅 \n [관리자 문의]')
			}
		}
	})
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
	let emo = sessionStorage.setItem("emono" , no );	// 선택한 감정의 db 번호를 가져옴
	let emosrc = '/blog/img/입체하트'+emo_no+'.png'
	choice_emo.src=emosrc;
}

let emo_no = -1;

function updateemotion(i){	// 더블클릭하면 감정설명 수정하게 해주는 메소드 [ 완 ]
	let emonolist = document.querySelectorAll('.emotioninput')	
	let emotionlist = document.querySelectorAll('.emotioninput')
	
	emotionlist[i].readOnly=false;
	emotionlist[i].style.color="#656565";	
	emotionlist[i].value = '';
	alert('글 수정 가능✍️')
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



