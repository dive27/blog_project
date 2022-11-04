<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 글 조회 </title>
</head>
<body>

	<!-- 성지혜 : 게시판 - 글조회[ 세부 글목록 ] 페이지 -->
	
	<div class="webbox">
		<h3> 글 조회 </h3>
		<table>
			<tr> <td> 번호 <td> 	<td class="bno"> 		</td> </tr>
			<tr> <td> 제목 <td> 	<td class="btitle">  	</td> </tr>
			<tr> <td> 내용 <td> 	<td class="bcontent"> 	</td> </tr>
			<tr> <td> 작성자 <td> <td class="mid"> 		</td> </tr>
			<tr> <td> 첨부파일 <td> <td class="bfile"> 	</td> </tr>
		</table>
		
		<div class="btnbox">
			<a href="/blog/board/tlist.jsp"><button>목록보기</button></a>
			
		</div>
		
		<div class="replybox">
			<textarea rows="" cols="" class="rcontent"></textarea>
			<button type="button" onclick="rwrite()">댓글작성</button>
		</div>
		
		<div class="replylist">
			
		</div>
		
	</div>
	
	<script src="/blog/js/board/tview.js" type="text/javascript"></script>

</body>
</html>