package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TBoardDao;


@WebServlet("/board/tbdelete")
public class tbdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tbdelete() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 1. 삭제할 번호 요청 
		int bno = Integer.parseInt( request.getParameter("bno") );
		
		//TBaordDto dto = TBoardDao.getInstance().getboard(bno);	// 삭제할 게시물정보 호출 
		
		// 2. DAO 처리 [ db내 데이터 삭제 ]
		boolean result = TBoardDao.getInstance().tdelete( bno );
		
		/*
		if( result ) { 
			String deletepath = request.getSession().getServletContext().getRealPath("/upload/"+ dto.getBfile() );
			File file = new File( deletepath );
			if( file.exists() ) file.delete();	// 해당 경로에 존재하는 파일을 삭제
		
		}
		*/
		
		// 3. 결과 응답 
		response.getWriter().print(result);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}