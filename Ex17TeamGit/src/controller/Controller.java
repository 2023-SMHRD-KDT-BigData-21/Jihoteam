package controller;

import model.DAO;
import model.MemberVO;

public class Controller {
	DAO dao = new DAO();
	
//	회원가입
	public String joinConn(MemberVO member) {
		int row = dao.join(member);
		String result;
		if(row>0) {
			System.out.println("회원가입 성공");
			result = "성공";
			return result;
		}else {
			System.out.println("회원가입 실패");
			result = "실패";
			return result;
		}
	}
	
//	로그인
	public String loginConn(MemberVO member) {
		String id = dao.login(member);
		return id;
	}
	
//	회원탈퇴
	public String deleteConn(MemberVO member) {
		int row = dao.delete(member);
		String result;
		if(row>0) {
			System.out.println("회원탈퇴 성공");
			result = "성공";
			return result;
		}else {
			System.out.println("회원탈퇴 실패");
			result = "실패";
			return result;
		}
	}
	
//	스트레스 업데이트
	public String updateStressConn(MemberVO member) {
		int row = dao.updateStress(member);
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
	public String updateExpConn(MemberVO member) {
		int row = dao.updateExp(member);
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
	public String updateLvlConn(MemberVO member) {
		int row = dao.updateLvl(member);
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
	public String updateTiredConn(MemberVO member) {
		int row = dao.updateTired(member);
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
		int row = dao.updateDate(member);
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
}