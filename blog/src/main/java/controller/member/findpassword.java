package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;



@WebServlet("/member/findpassword")
public class findpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public findpassword() {super();}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.getWriter().append("Served at: ").append(request.getContextPath());	}

	//MemberDao 6. 비밀번호 찾기 난수를 발생시켜 임시비밀	번호를 발급 여부 판단
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cy_id = request.getParameter("cy_id");
		String cy_email = request.getParameter("cy_email");		
			//System.out.println(cy_id);
			//System.out.println(cy_email);		
		boolean result =  MemberDao.getInstance().findpassword(cy_id, cy_email);
		String randstr = ""; // 2. 랜덤문자를 저장할 문자열 [임시비밀번호]
		//아이디와 이메일이 동일한 경우 임시비밀번호를 발급
		if(result) {
			//문자 난수 15자리 :  랜덤클래스 [임시비밀번호] 
			Random random = new Random(); 	//1.랜덤객체선언		
			//반복문
			for(int i=0; i<15; i++) {
				randstr += (char)(random.nextInt(26)+97);//int로 빼옴 //3. 숫자를 -> char로 강제 형변환을 시켜 문자로 변환시킬 예정
										//영소문자 [아스키코드] : 97~122
										//26 -> 0부터 25까지의 난수 발생
										//random.nextInt(26)+97 : 97~122
										//(char)random.nextInt(26)+97; 강제형변환				
			}			
			//해당 회원의 비밀번호를 임시 비밀번호로 교체 [업데이트처리] DAO ㄱㄱ
			//MemberDao 7. 임시비빌번호 업데이트
			MemberDao.getInstance().passwordchange(cy_id, randstr);				
		}
		response.getWriter().print(randstr); // ajax에게 임시 비밀번호 전송	
	}

}
