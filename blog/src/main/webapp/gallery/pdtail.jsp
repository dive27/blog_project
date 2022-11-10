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
    
    
   <div class=gallery_img>
    
		   <div class ="gallry_box">
		     <table>
		     <tr> <td> 번호 : <div class="imno"> </div></td></tr>
		     <tr> <td> 제목 : <div class="title"> </div>  </td> </tr>
		     <tr> <td> 첨부한이미지 : <div class="b_img"></div> </td> </tr>
		     <tr> <td>  내용 : <div class="b_content"> </div>  </td></tr>
		    
            </table>

		    <div>	
			   <button type="button" id="sebtn"  onclick="pagechange('/blog/gallery/plist.jsp')">목록보기</button>
			</div>
		    
    
		    <div class="btnbox">
		    	
		    
		    </div>
		    
          
          </div>
    
   </div> 
   
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/blog/js/gallery/listdetail.js" type="text/javascript"></script>
    
</body>
</html>