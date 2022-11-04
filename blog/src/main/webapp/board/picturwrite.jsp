<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  	<!-- 썸머노트 API css -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

    <link href="/CSS/list.css" rel="stylesheet">

 <title>사진등록</title>
</head>
<body>

     <div id = "b1"> 상단 </div>
     <div id = "b2"> 메인상단 </div>
   
     <div id = "b3"> 좌측1box</div>
     <div id = "b4"> 촤측2box</div> 

     <div id = "b5">
 		<form>
			제목 : <input type="text" name="imgb_title"> <br>
			
			<textarea id="summernote" name="imgb_content"></textarea><br>
			 첨부파일 : <input type="file" name ="imgb_file"> <br>
		
			<button type="button" onclick="imgwrite()">등록</button>
		
		</form>
 
     </div>
 
 
 
  	<!-- 썸머노트 API js -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script src="lang/summernote-ko-KR.js"></script>
 
 
  <script src="/JS/board2/imgwirte.js" type="text/javascript"></script>

</body>
</html>