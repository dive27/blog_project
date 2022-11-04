package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;



@WebServlet("/member/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 인코딩
		request.setCharacterEncoding("UTF-8"); 
		//1.form 소환
		
		String cy_id = request.getParameter("cy_id");
		String cy_password = request.getParameter("cy_password");
		String cy_name = request.getParameter("cy_name");
		String cy_phone = request.getParameter("cy_phone");
		String cy_email = request.getParameter("cy_email");
		
		MemberDto dto = new MemberDto(0, cy_id, cy_password, cy_name, cy_phone, cy_email, null, null, 0);
		
			//System.out.println(dto.toString());
		
		
		//db 찍고 컴백
		//MemberDao 1. 회원가입 
		boolean result = MemberDao.getInstance().signup(dto);
			//if(result) {System.out.println("로그인성공"); response.sendRedirect("/Cywold_Project/member/login.jsp");}
			//else {System.out.println("로그인실패");response.sendRedirect("/Cywold_Project/member/signup.jsp"); }
		response.getWriter().print(result);
		
	}

}
