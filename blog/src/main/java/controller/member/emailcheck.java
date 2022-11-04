package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;


@WebServlet("/member/emailcheck")
public class emailcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public emailcheck() {super();}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cy_email =  request.getParameter("cy_email");
		
		//DAO 호출
		//MemberDao 3. 이메일 중복체크
		boolean result = MemberDao.getInstance().emailcheck(cy_email);
		response.getWriter().print(result);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
