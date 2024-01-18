package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			String sql = "select id from member_db where id=? and pw=?";

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
			String sql = "delete from member_db where id=? and pw=?";
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
	
	//고양이 정보 등록 메소드
	public int enrollCat(MemberVO member) {
		getConn();
		int row = 0;
		try {
			String sql = "update member_db set type=?, name=? where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getType());
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
	
	//특정 회원 정보 조회 메소드
	public MemberVO selectMem(MemberVO member) {
		getConn();
		try {
			String sql = "select * from member_db where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
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
				member = new MemberVO(id,pw,rank,type,name,level,tired,stress,exp,date);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			getClose();
			
		} // try - catch
		
		return member;
	} // selectList
	
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
				typeList.add(new CatVO(type,info));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
			
		} // try - catch
		
		return typeList;
	} // selectList
	
}// DAO
