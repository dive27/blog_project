package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;



@WebServlet("/member/infordelete")
public class infordelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public infordelete() {super(); }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.변수요청
		String cy_password =  request.getParameter("cy_password");
			//System.out.println("infordelete cy_password 확인 : " + cy_password);
		//2.세션호출
		String cy_id = (String)request.getSession().getAttribute("cy_id");
			//System.out.println("infordelete cy_id 확인 : " + cy_id);
			//dao 작성하고 돌아오기
		// MemberDao 11. 회원 탈퇴하기
		boolean result =  MemberDao.getInstance().deleteinfor(cy_id, cy_password);
		
		response.getWriter().print(result);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
