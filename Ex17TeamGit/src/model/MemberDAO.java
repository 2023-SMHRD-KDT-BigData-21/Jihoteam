package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	
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
	//회원가입 메소드
	public int join(MemberVO member) {
		// DB 연결 메소드 호출
		getConn();
		int row = 0;
		try {
			String sql =  "insert into member_db values(?, ?, 0, null, null, 0, 0, 0, 0, 0)";

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

	//중복 검사 메소드
	public boolean checkID(String id) {
		getConn();
		try {
			String sql = "select m_id from member_db where m_id=?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				System.out.println("이미 사용중인 아이디입니다.");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		} // try-catch
		return true;
	} // checkID

	
	//로그인 메소드
	public String login(MemberVO member) {
		getConn();
		String name = null;
		try {
			String sql = "select m_id from member_db where m_id=? and m_pw=?";

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

//	회원탈퇴 메소드
	public int delete(MemberVO member) {
		getConn();
		int row=0;
		try {
			String sql = "delete from member_db where m_id=? and m_pw=?";
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
	}//회원탈퇴 메소드
	
	//특정 회원 정보 조회 메소드
	public MemberVO selectMem(String inputId) {
		getConn();
		try {
			String sql = "select * from member_db where m_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, inputId);
			rs = psmt.executeQuery();
						
			if(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				int rank = rs.getInt(3);
				String type = rs.getString(4);
				String name = rs.getString(5);
				int level = rs.getInt(6);
				int tired = rs.getInt(7);
				int stress = rs.getInt(8);
				int exp = rs.getInt(9);
				int date = rs.getInt(10);
				MemberVO member = new MemberVO(id,pw,rank,type,name,level,tired,stress,exp,date);
				return member;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			getClose();
			
		} // try - catch
		
		return null;
	} // selectList
}
