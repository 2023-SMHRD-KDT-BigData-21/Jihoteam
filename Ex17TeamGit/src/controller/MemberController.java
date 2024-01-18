package controller;

import model.MemberDAO;
import model.MemberVO;

public class MemberController {
	MemberDAO mdao = new MemberDAO();
	
	
//	회원가입
	public String joinConn(MemberVO member) {
		int row = mdao.join(member);
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
		String id = mdao.login(member);
		return id;
	}
	
//	회원탈퇴
	public String deleteConn(MemberVO member) {
		int row = mdao.delete(member);
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
	

}
