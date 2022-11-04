package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;


@WebServlet("/member/findid")
public class findid extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public findid(){ super();}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글인코딩
		
		String cy_name = request.getParameter("cy_name"); // 아이디 찾기에 필요한 아이디
		String cy_email = request.getParameter("cy_email"); //아이디 찾기에 필요한 비밀번호
		
			// 잘들어왔나 확인하기! 잘들어옴
			//System.out.println("cy_name : "+cy_name);
			//System.out.println("cy_email : " +cy_email);
		
			//이제 DAO작성하고 오자
		
		// MemberDao 5. 아이디찾기 
		String result =  MemberDao.getInstance().findid(cy_name, cy_email);
		
		//받은 결과를 다시 ajax으로 보냄!
		response.getWriter().print( result );
		
		
	}

}
