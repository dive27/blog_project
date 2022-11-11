/* 다이어리 작성 관련 */
let date = null;											// 선택한 날짜
let today = null;											// 오늘 날짜

/* 제어 변수 */
let count = false;											// 수정 메소드 연결을 위한 변수 t이면 작성가능 / f이면 작성불가
let choecedate = -1;										// 날짜 선택 안하고 작성 눌렀을 경우 작성 막기위한 변수 0이면 글 작성함수 가능 / -1이면 불가능
	
/* 감정관련 */	
let emo_no = -1;											// 선택한 하트 / 선택 안한 경우 -1
let choice_emo = document.querySelector('.choice_emo')		// 클릭한 하트
let emosrc = null;											// 클릭한 하트 이미지 경로
let emotionlist = document.querySelectorAll('.emotioninput')// 감정 설명 부분
	
/* 배경 이미지 변경 */
let backno = 1;
let emotableimg = document.querySelector('.emotableimg')
let back_img = document.querySelector('.diary_img')
let datebox = document.querySelector('.dateboximg')

/* 로그인한 사람 회원번호 */
let cy_num = localStorage.getItem("cy_num_se");	



	
if( cy_num > 0 ){
	alert('하루에 한번만 작성 가능한 일기장입니다.☝️\n오늘의 감정과 일기를 작성한 후 연필모양을 눌러주시면 됩니다✍️')
	
	getToday()		  // 오늘 날짜 가져오는 함수		
	getemotiontable() // 감정 테이블 출력하는 함수


	function getToday(){		// 오늘 날짜 가져오는 함수
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

	function getemotiontable(){		// 감정 테이블 나타내기 
		
		let html = '';
		$.ajax({
			url : "/blog/emotion" ,
			async:false,
			success : function(re){
				let json = JSON.parse(re)
				 for( let i = 0 ; i <json.length; i++ ){
				 	html += '<tr><td onclick="choiceemono('+json[i].emo_no+');" class="emo_img'+i+'"><img ondblclick="getemoindex()" class="emoji emoji'+json[i].emo_no+'" src="/blog/img/'+json[i].emo_img+'"></td> <td><input ondblclick="updateemotion('+i+')" class="emotioninput" readonly type="text" value="'+json[i].emotion+'"></td></tr>'
				 }
				document.querySelector('.c_emobox').innerHTML = html
			}
		})
	}
	
	function choiceemono(no){												// 선택한 감정 일기장에 띄우기 DB 비워져 있으면 안돌아감♥♥♥
		emo_no = no;
		let emosrc = '/blog/img/하트반짝'+emo_no+'.gif'
		choice_emo.src=emosrc;							
	}
	
//////////////////////////////////////////////// 다이어리 관련 함수 ////////////////////////////////////////////////
	
	function loadtoday(){		// 오늘일기장으로 전환 [ 완 ]
		document.getElementById('content').value = ''						// 일기장 비워주기
		document.getElementById('content').readOnly=false;					// 글 수정 가능
		document.querySelector('.stamp').src = "/blog/img/투명.png"			// 도장 없애
		choice_emo.src='/blog/img/투명.png';									// 감정없애
	}
	
	function load_diary(){			// - 선택한 날짜의 일기 불러오기
	getToday()
		date = document.getElementById('date').value			// 캘린더에서 선택한 값을 date변수에 넣어주고
		document.getElementById('date').innerText = date;		// 그걸 캘린더에 넣어주고 ?? 왜했더라
		document.querySelector('.todaydate').innerText = date	// 오늘 날짜 나타내는 곳에 넣어줌
		
		$.ajax({
			url : "/blog/Diary" ,
			type : "post" ,
			async:false,
			data : { "date" : date  , "cy_num" : cy_num } ,
			success : function(re){	
				choecedate = 0;					// 날짜를 선택하면 0이 돼서 이때만 글 작성 가능
				let json = JSON.parse( re )	
				if( re != 'null' ){	// 일기가 있으면
						if( emo_no == -1 ){emosrc = '/blog/img/투명.png'}									// 하트를 아직 선택 안했으면 투명으로
						else{ emosrc = '/blog/img/입체하트'+json[0].em_no+'.png'; choice_emo.src=emosrc; }	// 선택했으면 선택한 이미지로 변경
				
						if( date != today ){ // 일기가 있고 오늘이 아니면 글 불러오기
							
									document.querySelector('.todaydate').value = date						// 선택한 날짜 보이도록
									document.getElementById('content').value = '';							// 일기장 비워주기
									document.getElementById('content').value = json[0].di_content;			// 이전 내용 불러오기
									document.getElementById('content').readOnly=true;						// 글 수정 불가
									document.querySelector('.stamp').src = "/blog/img/도장.png";				// 도장 찍어주기	
									changebackno()															// 꾸미기 및 감정 가져옴

						}else if( date == today ){		
							  loadtoday() 																	// 일단은 비워주고
							  ifalreadywr()																	// 오늘 일기가 있는지 확인하는 함수 호출
							  return;
						}
							
					}else if( re == 'null' ){
						alert('일기를 쓰지 않은 날이에요😅')
							back_img.src = "/blog/img/배경1.png"											// 기본 이미지로 변경
							emotableimg.src = "/blog/img/배경1.png"
							datebox.src = "/blog/img/날짜상자1.png"
							document.querySelector('.stamp').src = "/blog/img/일기안씀.png";				// 도장 찍어주기	
							document.getElementById('content').value = '';								// 일기장 비워주기
							choice_emo.src='/blog/img/투명.png';											// 감정 없애주기
						if( date != today ){
							document.getElementById('content').readOnly=true;							// 글 수정 불가
						}else{
							loadtoday()
						}
							
					}
			}
		})
	}
	
//////////////////////////////////////////////// 일기수정 관련 함수 //////////////////////////////////////////////// 
	// 수정했던거같은데 배경 이미지 번호를 안보내고 있다.. 수정하기~
	function ifalreadywr(){ // 오늘 일기가 있는지 확인하는 메소드
		
		today = document.querySelector('.todayinput').value
		$.ajax({	
			url : "/blog/Diary_update" ,
			type : "get" , 
			async:false,
			data : { "today" : today , "cy_num" : cy_num } ,	
			success : function( re ){
					if ( re == 'true' ){	
					alert('오늘은 이미 작성한 일기가 있습니다.')
						if(confirm('수정할까요?')){
							count = true;	
							choecedate = -2		// -1로 두면 작성함수로 들어가서 -1로 둠 어차피 날짜 체인지하면 0됨
						}else{document.getElementById('content').readOnly=true;}
					}
			}
		})
	}
	
	function writediary(){			// 다이어리 작성 함수 
		let content = document.querySelector('#content').value
		
		$.ajax({
			url : "/blog/Diary" ,
			type : "get" ,
			data : { "content" : content , "cy_num" : cy_num , "emono" : emo_no , "backno" : backno } ,
			async:false,
			success : function( re ){
				if( choecedate == 0 && date == today && count == false ){ // 날짜를 선택해서 값이 0일때만 작성가능
					if( emo_no == -1 ){ alert('이모티콘을 선택해주세요');}
					if( re == 'true' && emo_no != -1 ){
						alert('다이어리 작성 완료🤗');
						return;
					}else if( re == null ){
						alert('다이어리 내용을 입력해주세요😅');
					}else{
						alert('다이어리 작성 실패😅 \n [관리자 문의]');
					}		
				}
				if( choecedate == -1 ){	// 만약 체인지를 안하고 기본값에서 작성을 누르면 작성 막아줌
					alert('날짜를 선택하고 다시 눌러주세요😅')
					loadtoday();
				}else if( date != today ){
					alert('일기는 당일에만 작성할 수 있어요😅')
				}
			}
		})
	}

	function update_today_di(){ // 오늘 일기 수정하는 메소드
		if( count == true ){
			
			let content = document.querySelector('#content').value
			today = document.querySelector('.todayinput').value
	
			$.ajax({	
				url : "/blog/Diary_update" ,
				type : "post" ,
				data : { 
				"today" : today , 
				"content" : content ,
			 	"emono" : emo_no ,
			 	"cy_num" : cy_num,
			 	"backno" : backno } ,
				async:false,
				success : function( re ){
					if( count == true ){
						if( emo_no == -1 ){ alert('이모티콘을 선택해주세요');}
						if( re == 'true' ){
							alert('오늘 일기 수정완료👍')
							document.getElementById('content').readOnly=true;						// 글 수정 불가
							document.querySelector('.stamp').src = "/blog/img/도장.png";				// 도장 찍어주기
							count = false
							choecedate = -1
							return;
						}
					}
					
				}		
			})
		}
	}

	
//////////////////////////////////////////////// 그 외 효과 함수 //////////////////////////////////////////////// 
		function change_back_img(){		// 배경 더블클릭시 배경 이미지 변경해주는 함수 
		$.ajax({
			url : "/blog/backimg" ,
			async:false,
			success : function(re){
					backno++;	
					emotableimg.src="/blog/img/배경"+backno+".png"
					back_img.src="/blog/img/배경"+backno+".png"
					datebox.src="/blog/img/날짜상자"+backno+".png"
					if( backno == re ){
						backno = 1;
 						return;
					}
				}
			})
		}
		
		
	function changebackno(){	// 지난 일기 테마/선택한 감정 가져오기
		$.ajax({
		url : "/blog/Diary" ,
		type : "post" ,
		async:false,
		data : { "date" : date  , "cy_num" : cy_num } ,
		success : function(re){
			let json = JSON.parse( re )	
	
			let back_img_src2 = "/blog/img/배경"+json[0].backno+".png"
			let load_emo_src = "/blog/img/하트반짝"+json[0].backno+".gif"
			let todayback = "/blog/img/날짜상자"+json[0].backno+".png"
			
			back_img.src = back_img_src2
			emotableimg.src = back_img_src2		
			choice_emo.src = load_emo_src
			datebox.src = todayback
			
			}	
		})
	}
	
	
	// 기능 알려주는 함수
	let oncealarm = 1;								
	function oncealarmback (){
		if(oncealarm == 1){
			back_img.style.opacity="0.5"
			alert('더블클릭하면 테마를 수정할 수 있어요!')
			setTimeout(() => back_img.style.opacity="1.0", 200);
			oncealarm--;
		}
	}
	
}else{
	alert('로그인 하지 않으면 이용할 수 없어요😥')			// 모든게 cy_num과 연결되어 있어서 없으면 열람 불가능 - 로그인 안하면 세션에 암것도 없어서 이게 안됨
	pagechange('/blog/member/login.jsp')			// 깨진다.. 왜?!
}



///////////////////////////// 잘되다가 안돼서 뺌ㅠㅠ
/*
	function updateemotion(i){	// 더블클릭하면 감정설명 수정하게 해주는 메소드 [ 완 ]
		if(confirm('감정 수정이 가능해요! 수정할까요?')){
			emotionlist[i].readOnly=false;											// 잘만 되다가 갑자기 왜이럴가?
			emotionlist[i].style.color="#656565";	
			emotionlist[i].value = '';
		
			document.addEventListener("keyup", function(e) {
			    if (e.keyCode === 13) {
					emotionlist[i].readOnly=true;
					emotionlist[i].style.color="black";
					let emotion = emotionlist[i].value;
					let emono = i+1;												// DB 번호 수정되면 안됨!♥♥♥
			        	$.ajax({
							url : "/blog/emotion" ,
							type : "post" ,
							async:false,
							data : { "emono" : emono , "emotion" : emotion , "cy_num" : cy_num } ,
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
	
	// 기능 알려주는 함수 / 알려줄 기능이 안돼서 뺌
	let oncealarmemo = 1;
	function alarmchangeemo(){
		if(oncealarmemo == 1){
			emotableimg.style.opacity="0.5"
			alert('더블클릭하면 감정 설명을 수정할 수 있어요!')
			setTimeout(() => emotableimg.style.opacity="1.0", 200);
			oncealarmemo--;
		}
	}
*/