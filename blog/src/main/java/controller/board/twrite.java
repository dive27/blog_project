package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dao.TBoardDao;
/**
 * Servlet implementation class write
 */
@WebServlet("/board/twrite")
public class twrite extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	private static final long serialVersionUID = 1L;
     
    public twrite() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// 1. 저장 경로 [ 배포된 프로젝트의 (서버) 폴더 저장 ]
			// 1. 현재 배포된 프로젝트의 경로 찾기 
			//String uploadpath = request.getSession().getServletContext().getRealPath("/") ; // jspweb
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload") ; // jspweb/폴더명
		
		// 2. Multipart 객체 생성 
		MultipartRequest multi = new MultipartRequest(
							request ,  						// 1. 요청방식 
							uploadpath , 					// 2. 저장 경로 
							1024 * 1024 * 10, 				// 3. 용량 10MB		[ 1024 : 1kb   /  1024*1024 : 1mb  /  1024*1024*1024  : 1G ] 
							"UTF-8" , 						// 4. 인코딩
							new DefaultFileRenamePolicy() 	// 5. 업로드된 파일의 이름이 중복일경우 자동으로 이름 변경
				); // 생성자 end
		
		// 3. 해당 저장경로에 첨부파일 업로드가 된다. 
		// 4. 나머지 데이터를 직접 요청 
		String btitle = multi.getParameter("btitle");	// request -> multi 
			System.out.println( btitle ); // 확인 
		
			String bcontent = multi.getParameter("bcontent");
			System.out.println( bcontent );	// 확인
			// * 어떤파일을 업로드 했는지 db에 저장할 첨부파일된 경로/이름 호출
		
			String bfile = multi.getFilesystemName("bfile"); // 첨부파일된 이름 호출시 : getFilesystemName
			System.out.println( bfile );
			
			// * 회원아이디 ----> 회원번호 
		int mno  = MemberDao.getInstance().getcy_id( (String)request.getSession().getAttribute("cy_id") );
			System.out.println( mno );
		
			// 5. db처리 
		boolean result = TBoardDao.getInstance().twrite( btitle, bcontent, mno , bfile );
			System.out.println( result );
		
			// 6. 응답 
		response.getWriter().print(result);

			
	}

}

