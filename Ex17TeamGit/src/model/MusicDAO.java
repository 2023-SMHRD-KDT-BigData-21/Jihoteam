package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MusicDAO {
	Connection conn=null;
	PreparedStatement psmt=null;
	ResultSet rs = null;
	int row=0;
	
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

	// DB연결 종료 메소드
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
	
//	모든 곡 정보
	public ArrayList<MusicVO> musicList(){
		getConn();
		ArrayList<MusicVO> musicList = new ArrayList<MusicVO>();
		try {
			String sql = "select * from cat_music";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString(1);
				String path = rs.getString(2);
				musicList.add(new MusicVO(name,path));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		} return musicList;
	}

	

}
