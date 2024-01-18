package view;

import java.sql.Connection;
import java.sql.DriverManager;

import model.CatVO;

public class PracticeMain {

	public static void main(String[] args) {
		CatVO cat = new CatVO();
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
		String user = "seocho_21K_bigdata_mini_3";
		String pw = "smhrd3";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, pw);
			
			if (conn != null) {
				System.out.println("DB연결 성공");
			}else {
				System.out.println("DB연결 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println(cat.getType());
		System.out.println(cat.getInfo());
		
	}

}
