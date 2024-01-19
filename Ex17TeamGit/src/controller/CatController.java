package controller;

import java.util.ArrayList;

import model.CatDAO;
import model.CatVO;
import model.MemberDAO;
import model.MemberVO;
import model.UpdateDAO;

public class CatController {
	UpdateDAO udao = new UpdateDAO();
	CatDAO cdao = new CatDAO();
	MemberDAO mdao = new MemberDAO();
	
	//고양이 정보 등록
	public String enrollCatConn(MemberVO member, int cat, String name) {
		String type = null;
		if(cat == 1) {
			type = "페르시안";
		}else if(cat == 2) {
			type = "샴";
		}else if(cat == 3) {
			type = "메인쿤";
		}else if(cat == 4) {
			type = "스코티시폴드";
		}else if(cat == 5) {
			type = "러시안블루";
		}
		int row = cdao.enrollCat(member, type, name);
		String result;
		if(row>0) {
			System.out.println("고양이 입력 성공");
			result = "성공";
			return result;
		}else {
			System.out.println("고양이 입력 실패");
			result = "실패";
			return result;
		}
	}
	
//	스트레스 업데이트
	public String updateStressConn(MemberVO member, int stress) {
		int cur = member.getStress();
		int update = cur + stress;
		System.out.println(member.getId()+cur + " "+update);
		String result = "실패";
		if(update >= 0) {
			int row = udao.updateStress(member, update);
			if(row>0) {
				System.out.println("stress 수치 변경");
				result = "성공";
			}			
		}else {
			System.out.println("stress 수치 변경 실패");
		}
		return result;			
	}
	
//	레벨업 할지말지 체크
	public void checkLvlConn(MemberVO member) {
		int lvl = member.getLvl();
		int exp = member.getExp();
		if(lvl==1) {
			if(exp>=50) {
				exp = exp-50;
				lvl++;
			}
		}else if(lvl==2) {
			if(exp>=70) {
				exp = exp-70;
				lvl++;
			}
		}else if(lvl==3) {
			if(exp>=100) {
				exp = exp-100;
				lvl++;
			}
		}else if(lvl==4) {
			if(exp>=140) {
				exp = exp-140;
				lvl++;
			}
		}else if(lvl==5) {
			if(exp>=200) {
				exp = exp-200;
				lvl++;
			}
		}
		if(lvl != member.getLvl()) {
			int row = udao.checkLvl(member, exp, lvl);
			String result;
			if(row>0) {
				System.out.println("lvl 수치 변경");
			}else {
				System.out.println("lvl 수치 변경 실패");
			}// if - else
		}//if
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
	
	public ArrayList<MemberVO> conditionConn(MemberVO member){
		ArrayList<MemberVO> condition = mdao.condition(member);
		return condition;
	}

} //CatController
