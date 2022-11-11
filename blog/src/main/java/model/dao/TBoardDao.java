package model.dao;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import model.dto.TBaordDto;


public class TBoardDao extends Dao{

	private static TBoardDao bdao = new TBoardDao();
	public static TBoardDao getInstance() { return bdao; }
	
	// 1. 글등록
	public boolean twrite( String btitle, String bcontent, int cy_num, String bfile ) {
		
		String sql = "insert into board( btitle, bcontent, cy_num, bfile ) values( ?, ?, ?, ? )";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , btitle );
			ps.setString( 2 , bcontent );
			ps.setInt( 3 , cy_num );
			ps.setString( 4 , bfile );
			ps.executeUpdate();
			return true;
		}catch( Exception e ) { System.out.println("글등록 오류 : " + e ); }
		return false;
	} // end
	
	// 2. 글출력
	public ArrayList< TBaordDto > getlist( int startrow , int listsize , String key , String keyword ) {
		ArrayList< TBaordDto > list = new ArrayList<>();
		String sql = "";
		if( !key.equals("") && !keyword.equals("") ) { // 검색이 있을경우 
			sql = "select b.* , m.cy_id "
					+ "from cywold_signup m , board b "
					+ "where m.cy_num = b.cy_num and "+key+" like '%"+keyword+"%' "
					+ "order by b.bdate desc "
					+ "limit "+startrow+" , "+listsize;
		}else { // 검색이 없을경우
			sql = "select b.* , m.cy_id from cywold_signup m , board b "
					+ "where m.cy_num = b.cy_num "
					+ "order by b.bdate desc limit "+startrow+" , "+listsize;
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				TBaordDto dto = new TBaordDto(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6),
						rs.getInt(7), rs.getInt(8),
						rs.getString(9)
						);
				list.add(dto); // 리스트에 담기
			}
			return list;
		}
		catch (Exception e) {System.out.println(e);} return list;
	}
	
	
	
	// 3. 글 조회
	public ArrayList<TBaordDto> getboard( int bno ) {
																			// +bno : 선택한 게시물 출력
		ArrayList<TBaordDto> list = new ArrayList<>();
		
		String sql ="select b.* , m.cy_id from cywold_signup m , board b where m.cy_num = b.cy_num and bno = "+bno
				+ " union all (  select b.* , m.cy_id from cywold_signup m , board b where m.cy_num = b.cy_num and bno < "+bno+" order by bno desc limit 1)"
				+ " union all (  select b.* , m.cy_id from cywold_signup m , board b where m.cy_num = b.cy_num and bno > "+bno+" order by bno asc limit 1);";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				TBaordDto dto = new TBaordDto(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6),
						rs.getInt(7), rs.getInt(8),
						rs.getString(9) );
				list.add(dto);
			}
		}catch (Exception e) {System.out.println( "글조회 오류"+e );}
		return list;
	} // end
	
	// 4. 글삭제
	public boolean tdelete( int bno ) {
		String sql = "delete from board where bno="+bno;
		
		try {
			ps = con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch (Exception e) {
			System.out.println( "글삭제 오류 : "+e ); 
		}return false;
	}
	
	
	
	// 5. 첨부파일만 삭제
	public boolean tbfiledelete( int bno ) {
		
		String sql = "update board set bfile = null where bno = "+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate(); return true;
		} catch( Exception e ) { System.out.println( "첨부파일삭제 오류"+e ); } return false;
	} // end
	
	// 6. 게시물 수정
	public boolean bupdate( int bno, String btitle, String bcontent, String bfile ) {
		
		String sql = "update board set btitle = ? ,"
				+ " bcontent = ? ,bfile = ? "
				+ " where bno = ? ";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , btitle );
			ps.setString( 2 , bcontent );
			ps.setString( 3 , bfile );
			ps.setInt( 4 , bno );
			ps.executeUpdate(); return true;
		} catch( Exception e ) { System.out.println( "게시물수정 DB오류"+e ); }; return false;
	} // end
	
	// 6. 게시물 수정
	public boolean tbupdate( int bno, String btitle, String bcontent, String bfile ) {
		
		String sql = "update board set btitle = ? ,"
				+ " bcontent = ? ,bfile = ? "
				+ " where bno = ? ";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , btitle );
			ps.setString( 2 , bcontent );
			ps.setString( 3 , bfile );
			ps.setInt( 4 , bno );
			ps.executeUpdate(); return true;
		} catch( Exception e ) { System.out.println( "게시물수정 DB오류"+e ); }; return false;
	} // end

	
	// 7. 글 조회수 증가
	public void tbviewupdate( int bno ) {
		String sql = "update board "
				+ " set bview = bview+1 "
				+ " where bno = "+ bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		}catch( Exception e ) { System.out.println( "조회수증가 DB오류" + e ); }	
	} // end
	
	
	// 8. 전체 게시물 수 
	public int tgettotalsize( String key, String keyword ) {
		String sql = "";
		// 검색이 있을 경우
		if( !key.equals("") && !keyword.equals("") ) {
			sql = "select count(*) from cywold_signup m, board b where m.cy_num = b.cy_num and "+key+" like '%"+keyword+"%'";
		}else {  // 검색이 없을경우
			sql = "select count(*) from cywold_signup m, board b where m.cy_num = b.cy_num";
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next() ) return rs.getInt( 1 );
		}catch ( Exception e ) { System.out.println( "전체 게시물출력 DB오류" + e ); }
		return 0;
	} // end
	
	
	
	// 9. 댓글작성
	public boolean rwrite( String rcontent , int cy_num , int bno ) {
		String sql = "insert into reply( rcontent , cy_num , bno ) values( ? , ? , ? )";	
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , rcontent );
			ps.setInt( 2 , cy_num );
			ps.setInt( 3 , bno );
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println( "댓글등록 DB오류"+e ); } return false;
	} // end
	
	// 9-2. 대댓글 작성
	public boolean rrwrite( String rcontent , int cy_num , int bno, int rindex ) {
		String sql = "insert into reply( rcontent , cy_num , bno, rindex ) values( ? , ? , ?, ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , rcontent );
			ps.setInt( 2 , cy_num );
			ps.setInt( 3 , bno );
			ps.setInt( 4 , rindex );
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println( "대댓글등록 DB오류" + e ); } return false;
	}

	// 10. 댓글 호출
	public JSONArray getrlist( int bno ) {
		JSONArray array = new JSONArray();
		String sql = " select r.rcontent ,r.rdate,m.cy_id, r.rno "
		        + " from reply r, cywold_signup m where r.cy_num = m.cy_num and "
		        + " r.bno = "+bno+" and r.rindex = 0 "
		        + " order by r.rdate desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				JSONObject object = new JSONObject();
				object.put( "rcontent", rs.getString(1) );
				object.put( "rdate", rs.getString(2) );
				object.put( "mid", rs.getString(3) );
				object.put( "rno", rs.getInt(4) );
				array.add(object);
			}
		}catch (Exception e) { System.out.println( "댓글출력 DB오류"+e ); } return array;
	} // end
	
	// 10-2. 대댓글 호출
		public JSONArray getrrlist( int bno, int rindex ) {
			JSONArray array = new JSONArray();
			String sql = " select r.rcontent, r.rdate, m.cy_id, r.rno"
					+ " from reply r, cywold_signup m"
					+ " where r.cy_num = m.cy_num and r.bno = "+bno+" and r.rindex = "+rindex
					+ " order by r.rdate desc";
			System.out.println( sql );
			
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					JSONObject object = new JSONObject();
					object.put( "rcontent", rs.getString(1) );
					object.put( "rdate", rs.getString(2) );
					object.put( "mid", rs.getString(3) );
					object.put( "rno", rs.getInt(4) );
					array.add(object);
				}
			}catch (Exception e) { System.out.println( "대댓글출력 DB오류"+e ); } return array;
		}
		

		
		
	
} // class end
