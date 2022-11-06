<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- 사용자지정 css -->
	<link href="/blog/css/board/write.css" rel="stylesheet">
	
	<!-- include libraries(jQuery, bootstrap) -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	

<title> 글쓰기 </title>
</head>
<body>

	<div class="webbox"> <!-- 웹페이지 전체 -->
		
		<div class="write_box"> <!-- 글쓰기 페이지 전체 -->
			<div class="w_title">
				<span> 글쓰기 </span>
			</div>
			<form> <!-- 글쓰기 작성물 -->
				<div class="a"> <!-- 입력창 전체 -->
					<table class="w_table">
						<tr id="title">
							<td> 제목 </td>
							<td>
								<input name="board_subject" type="text" size="70" maxlength="100" value="">
							</td>
						</tr>
					</div>
					<div>
						<tr id="title"">
							<td> 내용 </td>
							<td>
								<textarea name="board_content" cols="72" rows="20"></textarea>
							</td>
						</tr>
					</div>
					<div>
						<tr id="title"">
							<td> 첨부파일 </td>
							<td>
								<div class="b_file">
									<input type="file" name ="bfile">
								</div>
							</td>
						</tr>
					</div>
					
					<div class="w_btn_box">
					<table></table>
						<tr align="center" valign="middle"> <!-- 버튼구역 -->
							<td colspan="5">
								<button class="btn" type="button" onclick="bwrite()"> 등록하기 </button>
								<button class="btn" type="reset" onclick="bcancel()"> 작성취소 </button>
								<button class="btn" type="button" onclick="location.href='/blog/board/tlist.jsp'"> 목록보기 </button>
							</td>
						</tr>
					</div>
				</table>
			</form>
			
		</div> <!-- 글쓰기 페이지 전체 end -->

	</div> <!-- 웹페이지 전체 ed -->
	
	
	<!-- 사용자정의 js -->
	<script src="/blog/js/board/twrite.js" type="text/javascript"></script>


</body>
</html>