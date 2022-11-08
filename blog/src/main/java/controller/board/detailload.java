package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TBoardDao;





/**
 * Servlet implementation class detailload
 */
@WebServlet("/board/detailload")
public class detailload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detailload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 요청 [ 클릭한 게시물의 번호 저장 = backend ]
		int imgb_no = Integer.parseInt( request.getParameter("imgb_no") ) ;
		
		// 2. 세션 객체 만들기 
		HttpSession session = request.getSession();
		
		// 3. 클릭한 게시물 번호를 세션에 저장 
		session.setAttribute("imgb_no", imgb_no);
		
		/*
		// 4. 로그인한 회원아이디
		String mid = (String)session.getAttribute("mid");
		*/
		
		/*
		
		// 4.해당 유저가 24시간내 한번도 클릭한 적이 없으면 [ 세션이 없으면 ] 
		if( session.getAttribute(imgb_no+mid) == null ) {
			// 3. DAO 조회수 증가 
			TBoardDao.getInstance().bviewupdate( bno );
			// 3. 현재 유저가 조회수 한 기록 남기기 [ 해당 유저가 조회수 올린적있다/없다 ]
			request.getSession().setAttribute( imgb_no+mid , true );
			request.getSession().setMaxInactiveInterval(60*60*24); // 하루
		}
		*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
