package model.dao;

import java.util.ArrayList;

import model.dto.imgBoardDto;



public class ImgBoardDao extends Dao{
	
	
	private static ImgBoardDao gdao = new ImgBoardDao();
	public static ImgBoardDao getInstance() { return gdao; }
	
	//  갤러리 등록
	public boolean imgwrite( String imgb_title , String imgb_content , String imgb_file ) {
		
		String sql ="insert into imgboard( imgb_title , imgb_content , imgb_file ) values( ? , ? , ?  )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , imgb_title );	ps.setString( 2 , imgb_content );
			ps.setString( 3 , imgb_file);
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println( e );}
		return false;
	}




   ///// 갤러리 전체 출력

	public ArrayList<imgBoardDto> getImglist() {  // list에 매개변수가 안들어 가는 건가? 
		
		ArrayList<imgBoardDto> list = new ArrayList<>();
		
		String sql = "select * from imgboard";
		
		// set string ( 인덱스 , 명) // get( 인덱스)	
		
		try {          
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while ( rs.next()) {
				imgBoardDto dto  = new imgBoardDto(   
						rs.getInt(1) , rs.getString(2),
						rs.getString(3) , rs.getString(4) ,
						rs.getString(5) , rs.getInt(6));
			  list.add(dto);
			}
			
			return list;
		} catch (Exception e) { System.out.println(e ); return list;
		 
		}
		  
	}

  
	
	/////// 갤러리 상세 출력
	 public imgBoardDto getboard( int imgb_no ) {
	    
		 String sql = "select * from imgboard where imgb_no =" + imgb_no;
		 
		 try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if( rs.next() ) {
					imgBoardDto dto = new imgBoardDto(
							rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(6)
							);
					return dto;
				}
			}catch (Exception e) {System.out.println( "개인출력: " + e);}
			return null;
		}
		 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	

   // 수정





   // 삭제
     
}