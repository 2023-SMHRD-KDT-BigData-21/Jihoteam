package view;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {// 초기화면
			System.out.print("[1]회원가입 [2]로그인 [3]탈퇴 [4]종료 >> ");
			int menu1 = sc.nextInt();

			if (menu1 == 1) {// 회원가입
				System.out.println("==회원가입==");
				System.out.print("ID : ");
				String id = sc.next();
				System.out.print("PW : ");
				String pw = sc.next();
				System.out.print("NAME : ");
				String name = sc.next();

				// DB에 id, pw, name 등록하기
				System.out.println("회원가입에 " + "하셨습니다.");// 성공실패 유무 표기하기
			} // 회원가입

			else if (menu1 == 2) {// 로그인
				System.out.println("==로그인==");
				System.out.print("ID : ");
				String id = sc.next();
				System.out.print("PW : ");
				String pw = sc.next();

				if (pw != null) {// 동물정보 일치, pw를 동물정보로 바꾸기
					// 동물 등록
				} // 동물 정보 일치
				else {// 동물 정보 일치
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
				System.out.println("안녕히 가십시오.");
				break;
			} // 종료

			else {// 잘못 입력
				System.out.println("잘못 입력하셨습니다.");
			} // 잘못 입력
		} // 초기화면
	}// main(String[] args)
}// Main