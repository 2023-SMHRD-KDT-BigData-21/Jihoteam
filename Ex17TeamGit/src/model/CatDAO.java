package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CatDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	//DB연결 메소드
	public void getConn() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
		String user = "seocho_21K_bigdata_mini_3";
		String pw = "smhrd3";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
		} // try-catch
	}// getConn()
	
	//DB연결 종료 메소드
	public void getClose() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} // try-catch
	}// getClose()
	
//	고양이 종류 가져오는 메소드
	public ArrayList<CatVO> typeList() {
		getConn();
		ArrayList<CatVO> typeList = new ArrayList<CatVO>();
		try {
			String sql = "select * from cat_db";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
						
			while(rs.next()) {
				String type = rs.getString(1);
				String info = rs.getString(2);
				String info2 = rs.getString(3);
				typeList.add(new CatVO(type,info,info2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
			
		} // try - catch
		
		return typeList;
	} // selectList
	
	//고양이 정보 등록 메소드
	public int enrollCat(MemberVO member, String type) {
		getConn();
		int row = 0;
		try {
			String sql = "update member_db set type=?, name=? where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, type);
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getId());
			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		} // try-catch
		return row;
	} // enrollCat
	
}
