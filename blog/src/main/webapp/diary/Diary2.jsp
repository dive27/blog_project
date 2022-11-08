<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="https://unpkg.com/destyle.css@1.0.5/destyle.css">
<style type="text/css">
		@font-face {
	    font-family: 'Humanbumsuk';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2210-2@1.0/Humanbumsuk.woff2') format('woff2');
	    font-weight: normal;
	    font-style: normal;
		}
		
		body{
			position: relative;
		}
		
		*{
			box-sizing: border-box;
			font-family: 'Humanbumsuk';
		}
		
		.mainbox{					/* 전체박스 */
			width: 850px;
			height: 30vh;
			position: absolute;
			top : 60px;				/* 나중엔 깨질 배친데 지금만 이렇게~ */
			left : 200px;	
		}
		
		#calendar{					/* 인풋 데이트 넣을 th */
			width: 30%;
		}
		
		#date{						/* 인풋 데이트 */
			font-size: 2vh;
		}
		
		.diary{						/* 다이어리 넣을 박스 */
			width: 60%;
			position: relative;
		}
		
		.emotableimg {				/*감정 테이블 배경*/
			z-index: 0;
			width: 95%;
			padding-left: 2.5%;
			height: 46%;
			background-repeat: no-repeat;
			background-size: contain;
			background-position: top;
			position: absolute;
			bottom: 0%;
		}
		
		.emotabletextbox{			/* 감정테이블 흰 박스 */
			z-index: 1;
			width: 85%;
			height: 36%;
			background-color: white;
			border-radius: 15px;
			position: absolute;
			left: 7%;
			bottom: 5%;
			opacity: 0.95;
		}
		
		.c_emobox{					/* 감정테이블 */
			z-index: 1;
			width: 100px;
			height: 100px;
			position: absolute;
			bottom: 6%;
			left: 13%;
		}
				
		.choice_emo{				/* 선택한 감정 */
			position: absolute;
			z-index: 5;
			width: 6%;
			height: 6%;
			top: 8%;
			left: 87%;
		}
		
		.diary_img{					/* 다이어리 배경 */
			z-index: 0;
			position: absolute;
			top: 0px;
			width: 100%;
			height: 100%;
			background-repeat: no-repeat;
			background-size: contain;
			background-position: top;
		}
		
		.diatytextbox{				/* 다이어리 흰색박스 */
			z-index: 2;
			position: absolute;
			top: 10%;
			left: 5%;
			width: 90%;
			height: 80%;
			background-repeat: no-repeat;
			background-size: cover;
			background-position: center;
			position: absolute;
			bottom: 10%;
			opacity: 0.95;
		}
		
		#content{					/* 다이어리 내용박스 */
			z-index: 3;
			position: absolute;
			top: 20%;
			left: 12.5%;
			width: 75%;
			height: 65%;
									
			resize: none;
			
			line-height: 1.8;
			 
			font-size: 30px;
												
			color: #3D3C39;
			flex-wrap: wrap;		/* 텍스트 넘어가면 줄 넘어가게 */
			border: none;
			text-align: center;
			
			overflow: hidden;		/* 스크롤 숨기기 */
		}
		
		.todaydate{					/* 오늘 날짜 띄워줄 곳 */
			z-index: 3;
			position: absolute;
			top: 70px;
			right: 100px;
			font-size: 35px;
		}
		
		.clickbtn{					/* 연필 */
			resize: none;
			background-repeat: no-repeat;
			width: 70%;										
			float: right;
			margin-top: 30%;
			
		}
				
		.c_emotion_t{				/* 감정 테이블 포함한 박스 */
			height: 700px;
			position: relative;
		}		
				

				
		.c_emotion_t tr{
			width: 100%;
		}

		.c_emotion_t td:nth-child(1) {
			width: 30%;
			text-align: center;
		}
		
		.c_emotion_t td:nth-child(2) {
			width: 70%;
			text-align: left;
		}
		
		.emoji{
			width: 45px;
			height: 45px;
		}
		
		.c_emobox td{
			font-size: 25px;
			vertical-align: middle;
			text-align: center;
			z-index: 1;
		}		
		
		.emotioninput{
			margin-left: 5%;
		}
		
		/* tr을 선택하면 두개가 같이 적용되게 함수로 만들고 싶은데 왜 함수에선 적용안됨? 적용되는게 제한적인가? 
		
		.c_emobox tr > .emotioninput , .emoji{
			opacity: 0.8;
			background-color: red;
			color: red;
		}
	
		{

			transform: rotate( -20deg );
			transition: all ease 0.3s;
		}
		*/
		 
		.emotioninput:hover{
			-webkit-text-stroke-width: 1px;
			-webkit-text-stroke-color: black;
		}
		
		
		.stamp{						
			z-index: 3;
			position: absolute;
			right: 10%;
			bottom: 8%;
		}
		
	</style>
</head>
<body>

	<input type="text" class="todayinput">
	<table class="mainbox">
		<th id="calendar">
			<input id="date" type="date" onchange="load_diary()">
			<div class="calendar_day">
			</div>
		</th>
		
		<th rowspan="2" class="diary">
			<img class="stamp" src="/blog/img/투명.png">
			<img class="diatytextbox" src="/blog/img/레이스종이.png">
			<img ondblclick="change_back_img()" class="diary_img" src="/blog/img/배경1.png">
			<h3 class="todaydate"></h3>
			<img class="choice_emo" src="/blog/img/투명.png">
			<textarea id="content"></textarea> 
		</th>
		
		<th rowspan="2" class="pencil"> <img onclick="writediary(); update_today_di();" class="clickbtn" src="/blog/img/연필.png"> </th>
		
		
		<tr> <td class="c_emotion_t"> <!-- 감정박스 -->
			<img class="emotableimg" onmouseover="alarmback()" alt="감정테이블배경" src="/blog/img/배경1.png">	<!-- 사이즈 조절하기 -->
			<div class="emotabletextbox" ></div>
			<table class="c_emobox" onmouseover="alarmemo()">
			</table>
		 </td> </tr> 
	</table>

	<!-- JQUERY 자바를 편하게  사용하기 위한 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 내 js -->
	<script src="/blog/js/Diary2.js" type="text/javascript"></script>
</body>
</html>