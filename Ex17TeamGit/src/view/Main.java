package view;

import java.util.Scanner;

import controller.CatController;
import controller.MemberController;
import controller.Controller;
import model.MemberVO;

public class Main {
	static Scanner sc = new Scanner(System.in);//
	static MemberController  mCon = new MemberController();//
	static CatController ccon = new CatController();

//	public static int inputMenu1() {
//		while(true) {			
////			System.out.print("[1]회원가입 [2]로그인 [3]종료 >> ");
////			try {
//				int menu1 = sc.nextInt();
////				break;
////			} catch (Exception e) {
////				System.out.println("숫자를 입력해주세요.");
////				inputMenu1();
////			}
//		}
//	}
	
	public static void main(String[] args) {
		while (true) {// 초기화면
			// 입력
			System.out.print("[1]회원가입 [2]로그인 [3]종료 >> ");
			int menu1 = sc.nextInt();
			if (menu1 == 1) {// 회원가입
				doJoin();
			} // 회원가입
			else if (menu1 == 2) {// 로그인
				String id = doLogin();
				if (id != null) {//일치하는 아이디가 있으면
					System.out.println("로그인 성공");
					MemberVO member = mCon.joinMemberDB(id);
					if (member.name == null) {//동물정보가 없으면
						System.out.println("앞으로 함께할 고양이를 선택해주세요");
						ccon.typeConn();
						System.out.println("1)페르시안 2)샴 3)메인 쿤 4)스코티시 폴드 5)러시안 블루");
						int cat = sc.nextInt();
						System.out.print("고양이 이름을 입력해주세요 >>");
						String name = sc.next();
						ccon.enrollCatConn(member, cat, name);
					}
					mainPage(member);
				}
				else {//일치하는 아이디가 없으면
					System.out.println("아이디와 비밀번호를 확인하세요");
				}
<<<<<<< HEAD
				if (id2 != null && member.name == null) {//id는 존재하지만 동물정보는 없으면
					System.out.println("앞으로 함께할 고양이를 선택해주세요");
					System.out.println("1)페르시안 2)샴 3)메인 쿤 4)스코티시 폴드 5)러시안 블루");
					
				}
				else if (id2 != null && member.name != null){
					while (true) {// 메인 홈페이지
						System.out.println("무엇을 하시겠습니까?");
						System.out.print("[1]게임하기 [2]랭킹확인 [3]종료 >> ");
						int menu2 = sc.nextInt();

						if (menu2 == 1) {// 게임하기
							System.out.println("무엇을 하시겠습니까?");
							System.out.print("[1]밥주기 [2]놀아주기 [3]낮잠자기");
							int menu3 = sc.nextInt();

							if (menu3 == 1) {// 밥주기

							} // 밥주기

							else if (menu3 == 2) {// 놀아주기

							} // 놀아주기

							else if (menu3 == 3) {// 낮잠자기

							} // 낮잠자기

							else {// 잘못 입력
								System.out.println("잘못 입력하셨습니다.");
							} // 잘못 입력
						} // 게임하기

						else if (menu2 == 2) {// 랭킹확인
							System.out.println("당신의 랭킹은 : ");
						} // 랭킹확인

						else if (menu2 == 3) {// 종료
							System.out.println("안녕히 가십시오.");
							break;
						} // 종료

						else {// 잘못 입력
							System.out.println("잘못 입력하셨습니다.");
						} // 잘못 입력
					} // 메인 홈페이지
				} // 동물 정보 일치
//				else if (id != null && member.name != null){
//					while (true) {// 메인 홈페이지
//						System.out.println("무엇을 하시겠습니까?");
//						System.out.print("[1]게임하기 [2]랭킹확인 [3]종료 >> ");
//						int menu2 = sc.nextInt();
//
//						if (menu2 == 1) {// 게임하기
//							System.out.println("무엇을 하시겠습니까?");
//							System.out.print("[1]밥주기 [2]놀아주기 [3]낮잠자기");
//							int menu3 = sc.nextInt();
//
//							if (menu3 == 1) {// 밥주기
//
//							} // 밥주기
//
//							else if (menu3 == 2) {// 놀아주기
//
//							} // 놀아주기
//
//							else if (menu3 == 3) {// 낮잠자기
//
//							} // 낮잠자기
//
//							else {// 잘못 입력
//								System.out.println("잘못 입력하셨습니다.");
//							} // 잘못 입력
//						} // 게임하기
//
//						else if (menu2 == 2) {// 랭킹확인
//							System.out.println("당신의 랭킹은 : ");
//						} // 랭킹확인
//
//						else if (menu2 == 3) {// 종료
//							System.out.println("안녕히 가십시오.");
//							break;
//						} // 종료
//
//						else {// 잘못 입력
//							System.out.println("잘못 입력하셨습니다.");
//						} // 잘못 입력
//					} // 메인 홈페이지
//				} // 동물 정보 일치
//github.com/2023-SMHRD-KDT-BigData-21/Jihoteam.git

			} // 로그인

			else if (menu1 == 3) {// 탈퇴
				System.out.println("==회원탈퇴==");
				System.out.println("탈퇴할 ID : ");
				String id = sc.next();
				System.out.println("탈퇴 확인 PW : ");
				String pw = sc.next();
				// DB에서 id, pw 대조
				System.out.println("회원 탈퇴하셨습니다.");
			} // 탈퇴

			else if (menu1 == 4) {// 종료
=======
			}//로그인
			else if (menu1 == 3) {// 종료
>>>>>>> branch 'master' of https://github.com/2023-SMHRD-KDT-BigData-21/Jihoteam.git
				System.out.println("안녕히 가십시오.");
				break;
			} // 종료

			else {// 잘못 입력
				System.out.println("잘못 입력하셨습니다.");
			} // 잘못 입력
		}// 초기화면
	}// main(String[] args)
	
	//회원가입
	public static void doJoin() {
		System.out.println("==회원가입==");
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();
		
		// DB에 id, pw, name 등록하기
		MemberVO member = new MemberVO(id,pw);
		String result = mCon.joinConn(member);
		
		System.out.println("회원가입에 " + result + "하셨습니다.");// 성공실패 유무 표기하기
	} //doJoin
	//로그인
	public static String doLogin() {
		System.out.println("==로그인==");
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();

		MemberVO member = new MemberVO(id,pw);
		String result = mCon.loginConn(member);
		
		return result;
	} //doLogin
	//탈퇴하기
	public static void doDelete(MemberVO member){
		
		System.out.println("==회원탈퇴==");
		System.out.println("탈퇴할 ID : ");
		String id = sc.next();
		System.out.println("탈퇴 확인 PW : ");
		String pw = sc.next();
		
		if(id.equals(member.getId())&&pw.equals(member.getPw())) {
			String isSuccess = mCon.deleteConn(member);
			System.out.println(String.format("탈퇴에 %s하였습니다", isSuccess));
		}
		// DB에서 id, pw 대조
	}

	public static boolean mainPage(MemberVO member) {
		while(true) {// 메인 홈페이지
			System.out.println("무엇을 하시겠습니까?");
			System.out.print("[1]게임하기 [2]랭킹확인 [3] 다마고치 종료 [4]탈퇴하기 >> ");
			int menu2 = sc.nextInt();
			
			if (menu2 == 1) {// 게임하기
				game();
			}// 게임하기
				
			else if (menu2 == 2) {// 랭킹확인
				System.out.println("당신의 랭킹은 : ");
			} // 랭킹확인
				
			else if (menu2 == 3) {// 종료
				System.out.println("안녕히 가십시오.");
				return true;
			} // 종료
				
			else if (menu2 == 4) {// 탈퇴
				doDelete(member);
				return true;
			} // 탈퇴
			else {// 잘못 입력
				System.out.println("잘못 입력하셨습니다.");
			} // 잘못 입력
			} // 메인 홈페이지}
	}//mainPage
	
	
	public static void game() {
		System.out.println("무엇을 하시겠습니까?");
		System.out.print("[1]밥주기 [2]놀아주기 [3]낮잠자기 >>");
		int menu3 = sc.nextInt();
		
		if (menu3 == 1) {// 밥주기
			
		} // 밥주기
		
		else if (menu3 == 2) {// 놀아주기
			
		} // 놀아주기
		
		else if (menu3 == 3) {// 낮잠자기
			
		} // 낮잠자기
		
		else {// 잘못 입력
			System.out.println("잘못 입력하셨습니다.");
		} // 잘못 입력
	}//game
	}// Main