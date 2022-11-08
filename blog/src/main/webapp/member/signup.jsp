<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/blog/css/member/signup.css">
</head>
<body>

	<div class="wrap">
	
		<div class="logo_section">
			로고가 들어 갈 자리
		</div>
	
		<div class="signup_section">
			<h2 class="signup_h2">회원가입</h2>
			<h4 class="signup_h4">기본정보</h4>
			<span class="signupinfo"> * 은 필수로 입력해 주셔야 합니다.</span>
			<form>
				
				<table>

					<tr class="tr tr1">
						<td class="td1">
							<span class="form_text">아이디 * </span>
						</td>
						<td class="td2">
							<span class="inputbox">
								<input type="text" class="tdinput" id="cy_id" name="cy_id" onkeyup="cy_id1()">
							</span>						
						</td>
						<td class="td3"><span class="form_check"></span></td>
					</tr>

					<tr class="tr tr2">
						<td class="td1"><span class="form_text">비밀번호 * </span></td>
						
						<td class="td2">
							<span class="inputbox">
								<input type="password" class="tdinput" id="cy_password" name="cy_password" onkeyup="cy_password2()">
							</span>	
						</td>							
						<td class="td3" rowspan="2"><span class="form_check"></span></td>
					</tr>

					<tr class="tr tr3">
						<td class="td1"><span class="form_text">비밀번호 확인 * </span></td>
						<td class="td2">
							<span class="inputbox">
								<input type="password" class="tdinput" id="cy_password_check" name="cy_password_check" onkeyup="cy_password_check3()">
							</span>
						</td>
					</tr>
					
					<tr class="tr tr4">
						<td class="td1"><span class="form_text">이름 * </span></td>
						<td class="td2">
							<span class="inputbox">
								<input type="text" class="tdinput" id="cy_name" name="cy_name" onkeyup="cy_name4()">							
							</span>
						</td>
						<td class="td3"><span class="form_check"></span></td>
					</tr>
					
					<tr class="tr tr5">
						<td class="td1"><span class="form_text">전화번호 * ( - 포함)
						</span></td>
						<td class="td2">
							<span class="inputbox">
								<input type="text" class="tdinput" id="cy_phone" name="cy_phone" onkeyup="cy_phone5()">
							</span>
						</td>
						<td class="td3"><span class="form_check"></span></td>
					</tr>
					
					<tr class="tr tr6">
						<td class="td1"><span class="form_text">이메일 * </span></td>
						<td class="td2">
							<span class="inputbox">
								<input type="text" class="tdinput" id="cy_email" name="cy_email" onkeyup="cy_email6()">
							</span>
						</td>
						<td class="td3"><span class="form_check"></span></td>
					</tr>

				</table>
				<div class="btn_section">
					<button type="reset" class="cancelbtn">취소하기</button>
					<button type="button" onclick="signup()" class="signupbtn">회원가입하기</button>
				</div>
				<!-- btn_section -->


			</form>

		</div>
		<!-- signup_section -->
	</div>
	<!-- wrap -->

	<!-- jquery  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- javascript -->
	<script type="text/javascript" src="/blog/js/member/signup.js"></script>
	<script type="text/javascript" src="/blog/js/member/signupcheck.js"></script>
</body>
</html>