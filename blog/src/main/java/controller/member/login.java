package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.dao.MemberDao;

@WebServlet("/member/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public login() {super();}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		// 1. 변수
		String cy_id =  request.getParameter("cy_id");
		String cy_password = request.getParameter("cy_password");
		
		
		
		// 3. DB 메소드 반환 결과를 js ajax에게 응답.
			//MemberDao 4.로그인
			int result = MemberDao.getInstance().login(cy_id, cy_password);
				
				
		// +10/26 세션추가 예은
		// 만약에 로그인에 성공하면 세션을 할당함.				
		// 만약에 결과가 1이면 ( 로그인에 성공하면 -> MemberDao login 메소드확인!)
			//header 가서 로그인 확인하기
		if(result == 1) {
			HttpSession Session =  request.getSession(); // 1. 객체생성
			Session.setAttribute("cy_id", cy_id);		// 2. 세션 메모리를 할당
		}	 
		
				
		response.getWriter().print(result);
		
			
	}

}
