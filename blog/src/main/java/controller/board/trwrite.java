package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dao.TBoardDao;

/**
 * Servlet implementation class trwrite
 */
@WebServlet("/reply/trwrite")
public class trwrite extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청 [ 공통 ]
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type"); // 타입 요청 [ 0:댓글 1:대댓글[답글] ]
		String rcontent = request.getParameter("rcontent");	
		int mno = MemberDao.getInstance().getcy_id( 
				(String)request.getSession().getAttribute("cy_id") );
				
		if( mno == 0 ) { response.getWriter().print("0");  return; } // **비로그인 일경우 반환
		int bno = (Integer)request.getSession().getAttribute("bno");
		boolean result = false;
		
		// 2. db처리 
		if( type.equals("reply") ) { // 댓글 일경우 
			result = TBoardDao.getInstance().rwrite( rcontent , mno , bno );
			System.out.println("test");
		}else if( type.equals("rereply") ) { // 대댓글 일경우 
			int rindex = Integer.parseInt( request.getParameter("rno") );
			result = TBoardDao.getInstance().rrwrite( rcontent , mno , bno , rindex );
		}
		
		// 3. 결과 반환 
		if( result )response.getWriter().print("1");	// 성공
		else response.getWriter().print("2");			// db오류
		
	}
	private static final long serialVersionUID = 1L;
       
   
    public trwrite() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
