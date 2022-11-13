package controller.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TBoardDao;
import model.dto.TBaordDto;

/**
 * Servlet implementation class tbfiledelete
 */
@WebServlet("/board/tbfiledelete")
public class tbfiledelete extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int blogno = (Integer)request.getSession().getAttribute("blogno");
		// 1. 삭제할 게시물번호 = 현제 보고있는 게시물번호 = 세션( Object --> 형변환 )
		int bno = (Integer)request.getSession().getAttribute("bno");
		
		// 삭제할 게시물 정보호출
		ArrayList<TBaordDto> list = TBoardDao.getInstance().getboard(bno , blogno );
			
		// 2. DAO 처리[ 업데이터 ]
		boolean result = TBoardDao.getInstance().tbfiledelete( bno );
		
		// 3. 실제 파일 삭제처리
		if( result ) {
			String deletepath = request.getSession().getServletContext().getRealPath("/upload/"+list.get(0).getBfile() );
	 		File file = new File(deletepath);
			if( file.exists() ) file.delete();
		}
		// 4. 결과반환
		response.getWriter().print(result);
	}
	
	private static final long serialVersionUID = 1L;
       
   
    public tbfiledelete() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

