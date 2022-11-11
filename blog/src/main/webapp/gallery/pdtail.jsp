<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

   <link href="/blog/css/board/list.css" rel="stylesheet">
</head>
<body>
    
    
		   <div class ="gallry_detail_box">
		   
		     <div id="img_sub"> 사진상세</div>
		   
		     <table id="d_box">
		     
		     <tr class="box1">	     
		       <td id="n_b"> 번호<div class="imno"></div> </td>
		       <td> <div class="title"></div></td>  <!--  제목 -->
		    </tr>
		    
		    <tr>
		      <td colspan='2'>
		      <div class="b_img"></div> <!--  첨부한 이미지 -->
		      </td>  
		    </tr>
		    
		    <tr>  
		     <td colspan='2'>
		      <div class="b_content"> </div> <!--  내용 -->
		      </td>
		    </tr>
		    
		    
            </table>


           
		    <div class ="sebtn">
		    <div class = "sebtn2">
			   <button type="button"  onclick="pagechange('/blog/gallery/plist.jsp')">목록보기</button>
		    </div>	
		    <div class="btnbox"></div>
		    
		    </div>
          
          </div> <!-- 전체 박스 end -->
    

   
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/blog/js/gallery/listdetail.js" type="text/javascript"></script>
    
</body>
</html>