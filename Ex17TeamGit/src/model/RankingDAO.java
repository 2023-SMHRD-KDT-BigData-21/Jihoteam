package model;

import java.util.Arrays;

public class RankingDAO extends DAO{
	
	public String[] getRank(String id) {
		try {
			getConn();
			String sql = "SELECT * FROM (SELECT rownum AS rownumber , a.* FROM (SELECT * FROM MEMBER_DB ORDER BY m_rank DESC)a) b where m_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String ranking = rs.getString(1);
				String rank = String.valueOf(rs.getInt(4));
				
				String[] result = {ranking, rank};
				return result;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public MemberVO[] getRanker() { // 랭커 상위 5명의 정보 가져오기

		MemberVO[] rankerArr = new MemberVO[5]; 
		
		for (int i = 1; i <= rankerArr.length; i++) {
			try {
				getConn();
				String sql = "SELECT * FROM (SELECT rownum AS rownumber , a.* FROM (SELECT * FROM MEMBER_DB ORDER BY m_rank DESC) a WHERE rownum < 6) b WHERE b.rownumber = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, i);
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					String id = rs.getString(2);
					String pw = rs.getString(3);
					int rank = rs.getInt(4);
					String type = rs.getString(5);
					String name = rs.getString(6);
					int level = rs.getInt(7);
					int tired = rs.getInt(8);
					int stress = rs.getInt(9);
					int exp = rs.getInt(10);
					int date = rs.getInt(11);
					MemberVO member = new MemberVO(id,pw,rank,type,name,level,tired,stress,exp,date);

					rankerArr[i-1] = member;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				getClose();
			}
		}
		return rankerArr;
	}
}
