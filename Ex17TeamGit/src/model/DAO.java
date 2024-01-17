package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
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

	//중복 검사 메소드
	public void checkID(String id) {
		getConn();
		try {
			String sql = "select id from member_db where id=?";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			if (rs.next()) {
				System.out.println("이미 사용중인 아이디입니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		} // try-catch
	} // checkID

	//회원가입 메소드
	public int join(MemberVO member) {
		// DB 연결 메소드 호출
		getConn();
		int row = 0;
		try {
			String sql = "insert into member_db values(?, ?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPw());

			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;
	}

	//로그인 메소드
	public String login(MemberVO member) {
		getConn();
		String name = null;
		try {
			String sql = "select name from jdbc_member where id=? and pw=?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPw());

			rs = psmt.executeQuery();

			if (rs.next()) {
				name = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			getClose();

		} // try-catch
		return name;
	} //login

	//고양이 정보 등록 메소드
	public int updateCat(MemberVO member) {
		getConn();
		int row = 0;
		try {
			String sql = "update member_db set type=?, name=? where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getType());
			psmt.setString(2, member.getName());
			psmt.setString(2, member.getId());
			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		} // try-catch
		return row;
	} // updateCat
}// DAO
