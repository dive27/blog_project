package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import model.dao.TBoardDao;

/**
 * Servlet implementation class trlist
 */
@WebServlet("/reply/trlist")
public class trlist extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 1. 요청
		String type = request.getParameter("type");
		int bno = (Integer)request.getSession().getAttribute("bno");
		JSONArray array = new JSONArray();
			
		// 2. dao처리 
		if( type.equals("reply") ) {	// 댓글 
			array = TBoardDao.getInstance().getrlist( bno ); 		
		}else if( type.equals("rereply") ) { // 대댓글
			int rindex = Integer.parseInt( request.getParameter("rno") ); // 상위댓글의 번호 호출
			array = TBoardDao.getInstance().getrrlist( bno , rindex ); 		
		}
		
		// 3. 결과
		response.setCharacterEncoding("UTF-8"); 		
		response.getWriter().print( array );

}

private static final long serialVersionUID = 1L;
   

public trlist() {
    super();
    // TODO Auto-generated constructor stub
}





protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}

}
