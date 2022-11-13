package controller.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.TBoardDao;
import model.dto.TBaordDto;

/**
 * Servlet implementation class tbupdate
 */
@WebServlet("/board/tbupdate")
public class tbupdate extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 서버내 업로드 폴더 경로 찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload");
				
		
		// 2. MultipartRequest 객체
		MultipartRequest multi = new MultipartRequest(
				request, 		// 요청방식
				uploadpath,		// 경로
				1024*1024*10,	// 용량
				"UTF-8",		// 한글 인코딩
				new DefaultFileRenamePolicy() );
		
		// 3. 요청
		String btitle = multi.getParameter("btitle");		// 수정할 제목
		String bcontent = multi.getParameter("bcontent");	// 수정할 내용
		String bfile = multi.getFilesystemName("bfile");	// 새로운 첨부파일
			
		// * 수정할 게시물의 번호
		int bno = (Integer)request.getSession().getAttribute("bno");
		
		// 수정되기 전 게시물 정보
		 ArrayList<TBaordDto> list = TBoardDao.getInstance().getboard(bno);
		
		// * 기존 첨부파일 변경여부 판단
		boolean bfilechange = true;
		
		// * 수정시 첨부파일 등록 없을 경우[ 기존 첨부파일 호출 ]
			// 오류 : if( bfile == null ) { bfile = dto.getBfile();	bfilechange = false; }
			
		// 4. dao 처리[ 업데이트 = 새로운 첨부파일 ]
		boolean result = TBoardDao.getInstance().bupdate( bno, btitle, bcontent, bfile );
		
		if( result ) { // 업데이트 성공시 [ 기존 첨부파일 변경되었을때 ] 기존파일 삭제
			if( bfilechange ) {
//		오류:		String deletepath = request.getSession().getServletContext().getRealPath("/upload"+dto.getBfile() );
//	 			File file = new File( deletepath );	if( file.exists() ) file.delete();
			}
			
		}
		// 5. 결과반환
		response.getWriter().print(result);
		
		
	}
	
	private static final long serialVersionUID = 1L;
       

    public tbupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}