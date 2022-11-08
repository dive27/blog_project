package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.ImgBoardDao;


@WebServlet("/board/bwirte")
public class bwirte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bwirte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
/*   세션 사용하는 기준 , 파일 업로드 설정 , 써머노트로 파일 업로드 할 수있는 방법*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload") ; 
		
		System.out.println( "위치 :" + uploadpath );
		
		MultipartRequest multi = new MultipartRequest(
				request ,  						
				uploadpath , 					
				1024 * 1024 * 10, 				
				"UTF-8" , 						
				new DefaultFileRenamePolicy() 	
	); 
		
		String imgb_title = multi.getParameter("imgb_title");	
		
		System.out.println( imgb_title ); // 확인 
		
		String imgb_content = multi.getParameter("imgb_content");
		System.out.println( imgb_content );	// 확인
		
		
		String imgb_file = multi.getFilesystemName("imgb_file"); 
		System.out.println( imgb_file );
		

		// 5. db처리 
		
		boolean result = ImgBoardDao.getInstance().imgwrite( imgb_title, imgb_content, imgb_file );
		
		System.out.println(  "결과값" + result );
		
		// 6. 응답 
		response.getWriter().print(result);
		
	}

}
