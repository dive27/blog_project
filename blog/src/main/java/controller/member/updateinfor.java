package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;


@WebServlet("/member/updateinfor")
public class updateinfor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public updateinfor() {super();}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 변수요청
		 
		// 식별할 데이터가 필요 / 로그인 정보 / 세션
		String cy_id = (String)request.getSession().getAttribute("cy_id");
		
			//System.out.println("updateinfor.java cy_id 확인"+cy_id);
		
		String cy_name =  request.getParameter("cy_name");
		String cy_phone =  request.getParameter("cy_phone");
		String cy_email =  request.getParameter("cy_email");
		
			//System.out.println("updateinfor.java cy_name 확인 : " + cy_name);
			//System.out.println("updateinfor.java cy_phone 확인 : " + cy_phone);
			//System.out.println("updateinfor.java cy_email 확인 : " + cy_email);

		// dao 가서 작성하고 오기
		
		//결과	
		//MemberDao 12. 회원정보 수정하기
		boolean result =  MemberDao.getInstance().updateinfor(cy_id, cy_name, cy_phone, cy_email)	;
			//System.out.println("updateinfor.java result 확인"+result);	
		
		response.getWriter().print(result);	
		
	}

}
