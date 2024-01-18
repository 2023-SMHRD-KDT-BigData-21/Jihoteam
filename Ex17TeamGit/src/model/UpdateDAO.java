package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateDAO {

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

	
//	Exp 수치 업데이트 메소드	
	public int updateExp(MemberVO member, int exp) {
		getConn();
		int row = 0;
		try {
			String sql = "update member_db set c_exp=? where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, member.getExp() + exp);
			psmt.setString(2, member.getId());
			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		} // try-catch
		return row;
	}//updateExp
	
//	Lvl 수치 업데이트 메소드
	public int updateLvl(MemberVO member) {
		getConn();
		int lvl = member.getLvl();
		int exp = member.getExp();
		if(lvl==1) {
			if(exp>=50) {
				exp = 0;
				lvl++;
			}
		}else if(lvl==2) {
			if(exp>=70) {
				exp = 0;
				lvl++;
			}
		}else if(lvl==3) {
			if(exp>=100) {
				exp = 0;
				lvl++;
			}
		}else if(lvl==4) {
			if(exp>=100) {
				exp = 0;
				lvl++;
			}
		}else if(lvl==5) {
			if(exp>=100) {
				exp = 0;
				lvl++;
			}
		}
		int row = 0;	
		try {
			String sql = "update member_db set c_exp=?, c_lvl=? where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, exp);
			psmt.setLong(2, lvl);
			psmt.setString(3, member.getId());
			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		} // try-catch
		return row;
	}//updateLvl
	
//	스트레스 수치 업데이트 메소드
	public int updateStress(MemberVO member, int stress) {
		getConn();
		int row = 0;
		try {
			String sql = "update member_db set c_stress=? where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, member.getStress() + stress);
			psmt.setString(2, member.getId());
			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		} // try-catch
		return row;
	} // updateStress
	
//	Tired 수치 업데이트 메소드
	public int updateTired(MemberVO member, int tired) {
		getConn();
		int row = 0;
		try {
			String sql = "update member_db set c_tired=? where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, member.getTired() + tired);
			psmt.setString(2, member.getId());
			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		} // try-catch
		return row;
	}//updateTired
	
//	Date 수치 업데이트 메소드
	public int updateDate(MemberVO member, int date) {
		getConn();
		int row = 0;
		try {
			String sql = "update member_db set c_date=? where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, member.getDate() + date);
			psmt.setString(2, member.getId());
			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		} // try-catch
		return row;
	}//updateDate
}
