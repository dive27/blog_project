<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  	<!-- 썸머노트 API css -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

    <link href="/blog/css/board/list.css" rel="stylesheet">

 <title>사진등록</title>
</head>
<body>

   <div id="img_sub"> 이미지 등록</div>

    <div class ="gallry_box">
 		<form>
			<div> 제목 : <input type="text" name="imgb_title"> </div>
			<div> 내용 : <textarea name="imgb_content"></textarea> </div>
			<div> 첨부파일 : <input type="file" name ="imgb_file"> </div>
		   
			<button type="button" onclick="imgwrite()">등록</button>
			
		
		</form>
 
      </div>
 
  
    <!-- 사용자정의 js -->
    <script type="text/javascript" src="/blog/js/gallery/imgwirte.js"></script>
 
  

</body>
</html>