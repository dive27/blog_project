package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

@WebServlet("/member/idcheck")
public class idcheck extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//변수요청
		String cy_id =  request.getParameter("cy_id");		
		//MemberDao에 있는 idcheck 소환
		// MemberDao 2. 아이디 중복체크 
		boolean result = MemberDao.getInstance().idcheck(cy_id);
		//DAO 결과 응답
		response.getWriter().print(result);
	}
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
	
    public idcheck() { super();}

	
	

	
	
}
