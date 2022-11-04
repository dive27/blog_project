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
		
		*{
			box-sizing: border-box;
			font-family: 'Humanbumsuk';
		}
		
		.mainbox{
			width: 900px;
			height: 40vh;
		}
		
		#calendar{
			width: 30%;
		}
		
		#date{
			font-size: 3vh;
		}
		
		.diary{
			width: 60%;
			position: relative;
		}
		
		.emotableimg {	/*감정 테이블 배경*/
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
		
		.emotabletextbox{
			z-index: 1;
			width: 85%;
			padding-left: 12%;
			height: 36%;
			background-repeat: no-repeat;
			background-size: contain;
			background-position: top;
			position: absolute;
			bottom: 5%;
		}
		
		.diary_img{		/* 다이어리 배경 */
			z-index: 0;
			position: absolute;
			top: 0px;
			width: 100%;
			height: 100%;
			background-repeat: no-repeat;
			background-size: contain;
			background-position: top;
		}
		
		.diatytextbox{	/* 흰색박스 */
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
		}
		
		#content{	
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
			flex-wrap: wrap;							/* 텍스트 넘어가면 줄 넘어가게 */
			border: none;
			text-align: center;
			
			overflow: hidden;									/* 스크롤 숨기기 */
		}
		
		.todaydate{
			z-index: 3;
			position: absolute;
			top: 70px;
			right: 100px;
			font-size: 35px;
		}
		
		.clickbtn{
			resize: none;
			background-repeat: no-repeat;
			width: 70%;										
			float: right;
			margin-top: 30%;
			
		}
				
		.c_emotion_t{	/* 감정 테이블 포함한 박스 */
			height: 700px;
			position: relative;
		}		
				
		.c_emobox{		/* 감정테이블 */
			z-index: 1;
			width: 90%;
			height: 40%;
			position: absolute;
			bottom: 2%;
			left: 13%;
		}
				
		.choice_emo{	/* 선택한 감정 */
			position: absolute;
			z-index: 5;
			width: 10%;
			height: 10%;
			top: 8%;
			left: 87%;
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
		*/
		/*
		{
		
			-webkit-text-stroke-width: 1px;
			-webkit-text-stroke-color: black;
			transform: rotate( -20deg );
			transition: all ease 0.3s;
		}
		*/
		 
		
		.stamp{
			z-index: 3;
			position: absolute;
			right: 10%;
			bottom: 8%;
		}
		
	</style>
</head>
<body>

	<table class="mainbox">
		<th id="calendar">
			<input id="date" type="date" onchange="load_diary()">
			<div class="calendar_day">
			</div>
			
		</th>
		
		<th rowspan="2" class="diary">
			<img class="stamp" src="/team3/img/투명.png">
			<img class="diatytextbox" src="/team3/img/레이스종이.png">
			<img ondblclick="change_back_img()" class="diary_img" src="/team3/img/배경1.png">
			<h3 class="todaydate"></h3>
			<img class="choice_emo" src="/team3/img/투명.png">
			<textarea id="content"></textarea> 
		</th>
		
		<th rowspan="2" class="pencil"> <img onclick="writediary()" class="clickbtn" src="/team3/img/연필.png"> </th>
		
		
		<tr> <td class="c_emotion_t"> <!-- 감정박스 -->
			<img class="emotableimg" alt="감정테이블배경" src="/team3/img/배경1.png">	<!-- 사이즈 조절하기 -->
			<img class="emotabletextbox" src="/team3/img/레이스종이.png">
			<table class="c_emobox">
			</table>
		 </td> </tr> 
	</table>

	<!-- JQUERY 자바를 편하게  사용하기 위한 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 내 js -->
	<script src="/blog/js/Diary2.js" type="text/javascript"></script>
</body>
</html>