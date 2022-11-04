<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/blog/css/member/myinfor.css">
</head> 
<body>
	<%@include file="../header.jsp" %>
	
	<% 
		//만약에 로그인을 하지 않았으면 로그인페이지로 보내버림
		if(loginid == null) { response.sendRedirect("login.jsp");}
	%>

	<div class="wrap">
	
		<div class="infor_wrap">
			<h3 class="myinfor_title">내정보</h3>



			<table class="infor_table">
				<tr>
					<td class="td_1">회원번호</td>
					<td class="td_2" id="cy_num"></td>
				</tr>

				<tr>
					<td class="td_1">아이디</td>
					<td class="td_2" id="cy_id"></td>
				</tr>
				<tr>
					<td class="td_1">이름</td>
					<td class="td_2" id="cy_name"></td>
				</tr>
				<tr>
					<td class="td_1">전화번호</td>
					<td class="td_2" id="cy_phone"></td>
				</tr>
				<tr>
					<td class="td_1">이메일</td>
					<td class="td_2" id="cy_email"></td>
				</tr>
				<tr>
					<td class="td_1">가입날짜</td>
					<td class="td_2" id="cy_signuptime"></td>
				</tr>
			</table>

		</div><!-- infor_wrap -->


		<div class="btn_sectrion">
			<button type="button" onclick="viewdelete()" class="inforbtn deletebtn">회원탈퇴</button>
			<a href="/blog/member/updateinfor.jsp"><button type="button" class="inforbtn updatebtn">회원수정</button></a>
			<div id="deletebox"></div>
		</div>
		<!-- btn_sectrion -->


	</div><!-- wrap -->




	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/blog/js/member/myinfor.js"></script>

</body>
</html>

<!-- 
	일단 회원정보를 수정하는 곳은 로그인을 해야 들어 올 수 있는 곳이기 때문에 
	1-1 로그인을 했다 안했다 판단을 해야함
		header in clude했으니 header에 Session을 해놨으니 상속받아놓음
	
	
	처음에 입력을 할 때 아이디,비밀번호,이름,전화번호,이메일 등을 받았는데
	일단은 수정이 불가능한건 회원번호, 아이디,가입날짜 등은 절대로 변경이 불가능하고 
	이거는 막아놔야 할 듯 아니면 읽기모드로 설정해두면 괜찮을 듯
	
	비밀번호?? 이건 그냥 비밀번호 잊어버렸을 때만 찾으면 안되나?? 아니면
	비밀번호를 잊어버리면 그냥 비밀번호 찾기 jsp로 넘겨버리는 것도 좋은 방법인 듯 하다
	
	무튼 다시 본론으로 돌아와서
	이제 개인정보를 수정해야 하는데
	최종적으로 정리를 하면 이름,전화번호,이메일정도로 수정을 하면되는건가?
	
	따로따로 해야하는건가 아니면 같이 해야한는건가 보통 사이트보면 그냥 수정하고 싶은 것만 수정하던데
	
	일단 회원가입 할 때 입력받은 값을 모조리 가져온다
	
	수정이 가능한 이름, 전화번호 이메일만 수정이 가능하도록 한다
	
	javascript로 넘어가서 이름,전화번호,이메일을 객체로 저장해서 ajax로 넘긴다
	(컴퓨터는 묶는거 좋아한다 그랬음)
	
	서블릿으로 넘어가서 요청한다 
	
	이름이랑 전화번호랑 이메일
	
	DAO로 넘어가서 update 테이블명 set~~~ 어쩌고 저쩌고 저쩌고 한다
	update는 돌려받는 값이 없으니 수정을 했다 안했다 boolean 으로 하면 되는거겠지?








 







































 -->