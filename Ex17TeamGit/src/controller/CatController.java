package controller;

import java.util.ArrayList;

import model.CatDAO;
import model.CatVO;
import model.DAO;
import model.MemberVO;
import model.UpdateDAO;

public class CatController {
	UpdateDAO udao = new UpdateDAO();
	CatDAO cdao = new CatDAO();
	
//	스트레스 업데이트
	public String updateStressConn(MemberVO member, int stress) {
		int row = udao.updateStress(member, stress);
		String result;
		if(row>0) {
			System.out.println("stress 수치 변경");
			result = "성공";
			return result;
		}else {
			System.out.println("stress 수치 변경 실패");
			result = "실패";
			return result;
		}
	}
	
//	경험치 업데이트
	public String updateExpConn(MemberVO member, int exp) {
		int row = udao.updateExp(member, exp);
		String result;
		if(row>0) {
			System.out.println("exp 수치 변경");
			result = "성공";
			return result;
		}else {
			System.out.println("exp 수치 변경 실패");
			result = "실패";
			return result;
		}
	}
	
//	레벨 업데이트
	public String updateLvlConn(MemberVO member, int lvl) {
		int row = udao.updateLvl(member);
		String result;
		if(row>0) {
			System.out.println("lvl 수치 변경");
			result = "성공";
			return result;
		}else {
			System.out.println("lvl 수치 변경 실패");
			result = "실패";
			return result;
		}
	}
	
//	피로도 업데이트
	public String updateTiredConn(MemberVO member, int tired) {
		int row = udao.updateTired(member, tired);
		String result;
		if(row>0) {
			System.out.println("tired 수치 변경");
			result = "성공";
			return result;
		}else {
			System.out.println("tired 수치 변경 실패");
			result = "실패";
			return result;
		}
	}
	
//	날짜 업데이트
	public String updateDateConn(MemberVO member) {
		int row = udao.updateDate(member, 1);
		String result;
		if(row>0) {
			System.out.println("date 수치 변경");
			result = "성공";
			return result;
		}else {
			System.out.println("date 수치 변경 실패");
			result = "실패";
			return result;
		}
	}
	
//	고양이 종류와 정보를 가져오는 메소드
	public ArrayList<CatVO> typeConn(){
	      ArrayList<CatVO> typeList = cdao.typeList();
	      return typeList;
	   }
	

}
