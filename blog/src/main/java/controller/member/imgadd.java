package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;

@WebServlet("/member/imgadd")
public class imgadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //test
  
    public imgadd() {super();}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 이미지를 가져올 회원번호 요청 
		int mno = Integer.parseInt(  request.getParameter("mno") ) ;
		if( mno == 0  ) { // 0 이면 현재 로그인된 회원번호로 이미지 호출 
			int cy_num = MemberDao.getInstance().getcy_id((String) request.getSession().getAttribute("cy_id"));
			String img = MemberDao.getInstance().getimg( cy_num );
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(img);
			
		}else if( mno == -1){
			int cy_num = (Integer)request.getSession().getAttribute("blogno");
			String img = MemberDao.getInstance().getimg( cy_num );
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(img);
		}else { // 0이 아니면 요청으로 부터 가져온 회원번호로 이미지 호출  [이웃회원들]
			String img = MemberDao.getInstance().getimg( mno );
			response.setCharacterEncoding("UTF-8");
			
			
			response.getWriter().print(img);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MultipartRequest multi = new MultipartRequest(
				request ,  						// 1. 요청방식 
				request.getSession().getServletContext().getRealPath("/member/img") , 					// 2. 저장 경로 
				1024 * 1024 * 10, 				// 3. 용량 10MB		[ 1024 : 1kb   /  1024*1024 : 1mb  /  1024*1024*1024  : 1G ] 
				"UTF-8" , 						// 4. 인코딩
				new DefaultFileRenamePolicy() 	// 5. 업로드된 파일의 이름이 중복일경우 자동으로 이름 변경
		); // 생성자 end
		
		// 11/10 프로필이미지 수정
		String cy_profile_img = multi.getFilesystemName("cy_profile_img"); //파일명가져올때 사용함 
		
		
		int cy_num = MemberDao.getInstance().getcy_id((String) request.getSession().getAttribute("cy_id"));		
		
		
		
		
			
		
		
		//
		boolean result =  MemberDao.getInstance().imgadd(cy_profile_img, cy_num);
		

		
		response.getWriter().print(result);
		
		
	}

}
