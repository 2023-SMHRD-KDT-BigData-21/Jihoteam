package controller;

import model.MemberDAO;
import model.MemberVO;

public class MemberController {
	MemberDAO mdao = new MemberDAO();
	
//	회원가입
	public String joinConn(MemberVO member) {
		String result = "실패";
		if (mdao.checkID(member.getId())) {
			int row = mdao.join(member);
			if(row>0) {
				System.out.println("회원가입 성공");
				result = "성공";
				return result;
			}else {
				System.out.println("회원가입 실패");
				return result;
			}
		}else {
			return result;			
		}
	}//joinConn
		
//		로그인
		public String loginConn(MemberVO member) {
			String id = mdao.login(member);
			return id;
		}

//		회원 정보 조회
		public MemberVO joinMemberDB(String id) {
			MemberVO member= mdao.selectMem(id);
			return member; // 유효한 id면 값 return, 아니면 null return
		}
//		회원탈퇴
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
