<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> 글 조회 </title>
	
	<!-- 사용자정의 css 호출 -->
	<link  rel="stylesheet" href="/blog/css/board/tview.css">

</head>
<body>

	
	<!-- 성지혜 : 게시판 - 글조회[ 세부 글목록 ] 페이지 -->
	
	<div class="webbox"> <!-- 웹페이지 전체 -->
		
		<div class="view_box"> <!-- 글조회 전체 박스권  -->
			<div class="title_box"> <!-- 글조회 타이틀 박스권 -->
					<span> 글 조회 </span>
			</div> <!-- 글 조회 타이틀 박스권 end -->
			
			<div class="view_list"> <!-- 조회테이블 내용 -->
				<div class="v_table">
					<table>
						<tr> <td> 번호 <td> 	<td class="bno"> 		</td> </tr>
						<tr> <td> 제목 <td> 	<td class="btitle">  	</td> </tr>
						<tr> <td> 내용 <td> 	<td class="bcontent"> 	</td> </tr>
						<tr> <td> 작성자 <td> <td class="mid"> 		</td> </tr>
						<tr> <td> 첨부파일 <td> <td class="bfile"> 	</td> </tr>
					</table>
				</div>
			</div> <!-- 조회테이블 내용 end -->
			
			<div class="replybox">
				<div class="r_box"> <!-- 댓글달기 -->
					<textarea rows="" cols="" class="rcontent"></textarea>
					<button type="button" onclick="rwrite()">댓글 작성</button>
				</div>
				
				<div class="replylist"> <!-- 댓글출력 -->
				
				</div>
			</div>
			
			<div class="list_box"> <!-- 이전, 이후 글 조회 테이블 박스 -->
				<div class="l_box">
					<div class="before_list">
						<button type="button">이전</button>
						<span> 이전 글제목 </span> <!-- 이전글 이동 -->
					</div>
				</div>
				<div class="l_box">
					<div class="after_list">
						<button type="button">다음</button>
						<span> 다음 글제목 </span> <!-- 다음글 이동 -->
					</div>
				</div>
			</div> <!-- 이전, 이후 글 조회 테이블 박스 end -->
			
			<div class="b_btn">
				<div class="btnbox">
					<a href="/blog/board/tlist.jsp"><button>목록보기</button></a>
				</div>
				
			</div>
		</div> <!-- 글조회 박스권 전체 end -->
		
	</div> <!-- 웹페이지 전체 end -->
	
	<script src="/blog/js/board/tview.js" type="text/javascript"></script>

</body>
</html>