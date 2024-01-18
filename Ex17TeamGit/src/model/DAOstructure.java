package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class DAOstructure {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public abstract void getConn(); //DB 연결
	public abstract void getClose(); //DB 연결 해제
	//-----------------------------------------
	//초기화면
	public abstract void checkID(String id);//아이디 중복 검사
	public abstract int join(MemberVO member); //회원가입
	public abstract String login(MemberVO member);//로그인
	
	//-----------------------------------------
	//동물 등록 화면
	public abstract String[] getCat();//동물 정보 가져올 때 사용, return 값이 string 리스트, list[0] = 동물 정보, list[1] = 동물 소개
	//등록시
	public abstract int enrollCat(MemberVO member);//회원 DB에 고양이 정보 업데이트 + 고양이 점수 모두 초기화
	//-----------------------------------------
	//메인화면
	public abstract int showRanking(MemberVO member);//특정 회원의 랭킹을 보여주는 메소드
	public abstract int[] showRanker(MemberVO member);//상위 n명의 점수를 리스트로 반환하는 메소드, 필요하다면 MemberVO 리스트 생성
	public abstract int deleteMem(MemberVO member);//회원탈퇴 메소드
	//-----------------------------------------
	//회원 정보
	public abstract MemberVO selectMem();//id를 통해 특정 회원 정보 조회
	//-----------------------------------------
	//게임하기
	// 사용자 행동에 따른 업데이트
	public abstract int updateStress(MemberVO member);//스트레스 업데이트
	public abstract int updateExp(MemberVO member);//Exp 업데이트
	public abstract int updateLvl(MemberVO member);//레벨 업데이트
	public abstract int updateTired(MemberVO member);//피곤도 업데이트
	// 자동 업데이트
	public abstract int updateDate(MemberVO member);//날짜 업데이트
	//-----------------------------------------
	// 고양이 사망시
	public abstract boolean deleteCat(MemberVO member);//id를 통해 특정 회원의 고양이 정보 삭제
	
}
