<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 onclick="sessionremove()"> 로그아웃페이지</h2>

<%
	//jsp script  태그
	//session.invalidate(); 모든 세션을 제거한다. 장바구니나 나머지 세션도 날아가는 경우도 있다
	//특정세션만 지우고 싶을 때
	
	
	session.setAttribute("cy_id", null);
	
	//페이지전환
	//알림창을 띄우고싶어요  로그아웃되었습니다 이런식으로요
	response.sendRedirect("/blog/index.jsp");
%>

<script type="text/javascript">
sessionremove()
function sessionremove(){
	//alert("login.js")
	//alert('함수 실행')
	localStorage.removeItem("cy_num_se");
}
</script>







</body>
</html>