package model.dao;

import java.util.ArrayList;

import model.dto.imgBoardDto;



public class ImgBoardDao extends Dao{
	
	
	private static ImgBoardDao gdao = new ImgBoardDao();
	public static ImgBoardDao getInstance() { return gdao; }
	
	//  갤러리 등록
	public boolean imgwrite( String imgb_title , String imgb_content , String imgb_file , int cy_num) {
		
		String sql ="insert into imgboard( imgb_title , imgb_content , imgb_file , cy_num ) values( ? , ? , ? ,? ) ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , imgb_title );	ps.setString( 2 , imgb_content );
			ps.setString( 3 , imgb_file); ps.setInt( 4 , cy_num);
			ps.executeUpdate(); return true;
		}catch (Exception e) { System.out.println( "등록안됨"  +  e );}
		return false;
	}




   ///// 갤러리 전체 출력

	public ArrayList<imgBoardDto> getImglist() { // list에 매개변수가 안들어 가는 건가?

		ArrayList<imgBoardDto> list = new ArrayList<>();

		String sql = "select * from imgboard where imgb_file is not null order by imbb_date desc ;";

		// set string ( 인덱스 , 명) // get( 인덱스)
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				imgBoardDto dto = new imgBoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
				list.add(dto);
			}

			return list;
		} catch (Exception e) {
			System.out.println("전체출력오류 : " + e);
			return list;

		}

	}

  
	
	/////// 갤러리 상세 출력
	public imgBoardDto getboard(int imgb_no) {

		String sql = "select * from imgboard where imgb_no =" + imgb_no;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				imgBoardDto dto = new imgBoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)

				);
				System.out.println(dto);
				return dto;
				
			}

		} catch (Exception e) {
			System.out.println("개인출력: " + e);
		}
		return null;
	}
		 
   // 수정



	// 삭제
	public boolean imgdelete(int imgb_no) {
		String sql = "delete from imgboard where imgb_no=" + imgb_no;
		try {
			ps = con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if (count == 1)
				return true;
		} catch (Exception e) {
			System.out.println("삭제 오류 :" + e);
		}

		return false;

	}
	 
     
}