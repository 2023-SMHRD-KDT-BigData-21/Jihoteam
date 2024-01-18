package controller;

import java.util.ArrayList;
import java.util.Random;

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
	
	//랜덤이벤트 메소드
	public void randomEvent() {
		MemberVO info = dao.selectMem(member);
		Random ran = new Random();
		int stress = info.getStress();
		String name = info.getName();
		int num = ran.nextInt(1, 11); // 랜덤이벤트 발생할지 정하는 변수
		if (num == 1) {
			System.out.println("랜덤이벤트 발생!!");
			int num2 = ran.nextInt(1, 7); // 랜덤이벤트가 발생했을시 준비된 랜덤 이벤트 시나리오중 하나를 랜덤으로 뽑는 변수
			if (num2 == 1) { //목욕하기(스트레스 증가)
				System.out.println("오늘따라 " + name + "(이)가 엄청 더러워 보이네요.");
				System.out.println("싫다고 발버둥 치는 " + name + "(이)를 붙잡고 억지로 씻기니 깨끗해보입니다.");
				System.out.println("다만 상당히 기분이 나빠 보이는군요...");
				stress += 15;
				System.out.println("목욕하기로 스트레스가 15 증가되어 현재 스트레스 지수는 " + stress + "입니다.");
			} else if (num2 == 2) { //물건깨기(스트레스 감소)
				System.out.println("집사가 방을 비운동안 집사의 물건을 깨뜨린 " + name + "!!!");
				stress -= 10;
				if (stress < 0) {
					stress = 0;
				}
				System.out.println("물건깨기로 스트레스가 10 감소되어 현재 스트레스 지수는 " + stress + "입니다.");
			} else if (num2 == 3) { //데이트(스트레스 감소)
				System.out.println("집사가 방을 비운동안 애묘 고양이와 데이트를 하고 온 " + name );
				stress -= 20;
				if (stress < 0) {
					stress = 0;
				}
				System.out.println("애묘 고양이와의 데이트로 스트레스가 20 감소되어 현재 스트레스 지수는 " + stress + "입니다.");
			} else if (num2 == 4) {
				System.out.println("집사가 방을 비운동안 옆집 고양이와 싸운 " + name );
				stress += 20;
				System.out.println("옆집 고양이와의 싸움으로 스트레스가 20 증가하여 현재 스트레스 지수는 " + stress + "입니다.");
			} else if (num2 == 5) {
				System.out.println("추워서 집사의 이불 속에 들어간 " + name );
				stress -= 10;
				System.out.println("포근하고 따뜻해!! 스트레스가 10 감소하여 현재 스트레스 지수는 " + stress + "입니다.");
			} else if (num2 == 6) {
				System.out.println("창문 밖에 눈이 오네요~~");
				System.out.println("눈이 오는 풍경을 구경하며 기분이 좋아진 " + name);				
				stress -= 5;
				if (stress < 0) {
					stress = 0;
				}
				System.out.println("눈 구경으로 스트레스가 5 감소하여 현재 스트레스 지수는 " + stress + "입니다.");
			}
		}
	}
}