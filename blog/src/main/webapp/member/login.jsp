<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/blog/css/member/login.css">
</head>
<body>
	<div class="wrap">
		<div class="logo_section">
				<span>로고가 들어갈 예정</span>
		</div>
		<div class="login_wrap">		
			<div class="login_section">
				<div class="login_box">
					<span class="text_box"> 아이디 </span> 
					<span class="span_box">
						<input type="text" class="inputbox" id="cy_id">
					</span>
				</div><!-- login_box -->

				<div class="login_box">
					<span class="text_box"> 비밀번호 </span> 
					<span class="span_box">
						<input type="password" class="inputbox" id="cy_password">
					</span><!-- text_box -->
				</div><!-- login_box -->


				<button type="button" class="loginbtn" onclick="login()">로그인하기</button>

				<ul class="find_ul">
					<li class="find_li"><a href="/blog/member/signup.jsp" class="signup">회원가입</a></li>
					<li class="find_li"><a href="/blog/member/findid.jsp" class="findid">아이디찾기</a></li>
					<li class="find_li"><a href="/blog/member/findpassword.jsp" class="findpassword">비밀번호찾기</a></li>
				</ul><!-- find_ul -->
				
			</div><!-- login_section -->
		</div><!-- login_wrap -->
	</div><!-- wrap -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src ="/blog/js/member/login.js"></script>


</body>
</html>