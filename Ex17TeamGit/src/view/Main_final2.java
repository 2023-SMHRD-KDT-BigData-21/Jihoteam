package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.CatController;
import controller.MemberController;
import controller.RankingController;
import controller.Controller;
import model.CatVO;
import model.MemberVO;

public class Main_final2 {
	static Scanner sc = new Scanner(System.in);//
	static MemberController mCon = new MemberController();//
	static CatController ccon = new CatController();

	public static void main(String[] args) {
		ArrayList<CatVO> typeList = new ArrayList<CatVO>();
		while (true) {// 초기화면
			// 입력
			System.out.print("[1]회원가입 [2]로그인 [3]종료 >> ");
			int menu1 = sc.nextInt();
			if (menu1 == 1) {// 회원가입
				doJoin();
			} // 회원가입
			else if (menu1 == 2) {// 로그인
				String id = doLogin();
				MemberVO member = mCon.joinMemberDB(id);
				if (id == null) {// 일치하는 아이디가 없으면
					System.out.println("저런, ID나 PW를 틀리신 걸까요?");
					System.out.println("고양이는 당신을 환영하지 않는 것 같습니다.");
				} else if (id != null) { // 일치하는 아이디가 있으면
					System.out.println(id + "님, 환영합니다.");
					if (member.name == null) {// 동물정보가 없으면
						String catShop = "⠀⠀⠀⠀⠀⠀⡀⠄⠄⠄⠂⠂⠄⡀⠀⠀⠀⠀⠀⠀⠀⡠⡢⣂⠄\n"
								+ "⠀⠀⢀⠠⠄⠔⠀⠀⠀⠀⠀⠀⠀⡈⠄⢀⡀⡠⢄⡒⡐⠤⠑⠂⠀\n"
								+ "⢀⠊⠑⠂⠀⠀⠀⠀⠀⠀⠀⣀⡣⠾⠭⡒⠈⠈⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠘⡀⠀⠀⠀⢀⡀⠄⣒⠩⣅⡖⡢⠖⢐⠎⡢⡀⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠐⡄⠀⢂⠅⢆⠏⠉⠰⠀⠁⠀⠀⠠⠒⡃⠄⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠐⠊⠀⠘⡀⠀⡊⠍⠄⠀⠀⠀⠊⠖⠎⡄⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⢐⠨⡌⠄⠐⠄⠘⠃⠀⢀⣀⣀⡀⢜⢤⠰⠤⢄⡀⠀⠀⠀⠀\n"
								+ "⠀⠀⢀⡓⡒⡎⠒⠚⡀⠤⠦⠒⠂⠒⠐⠁⠀⠀⠀⠀⠙⢄⠀⠀⠀\n"
								+ "⠀⠀⠀⠊⠘⠰⡀⢀⢎⠀⠀⠀⠀⠀⠀⠘⠁⠀⠀⠀⠀⢙⡀⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⠀⠐⠤⡸⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠁⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⢄⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠈⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠃⠢⠰⠄⠦⠄⠄⠖⠉⠀⠀⠀⠀⠀";
						System.out.println(catShop);
						System.out.println("고양이 상점 주인 :");
						System.out.println("어서 와! 고양이를 고르러 왔지?");
						System.out.println("여기 이 귀염둥이들 좀 보라고!");
						ccon.typeConn();
						System.out.println("1)페르시안 2)샴 3)메인 쿤 4)스코티시 폴드 5)러시안 블루");
						System.out.println();
						typeList = ccon.typeConn();
						for (CatVO cat : typeList) {
							System.out.println(cat.getInfo());
							System.out.println(cat.getInfo2());
							System.out.println();
						}
						System.out.print("고양이 종류 선택 >> ");
						int cat = sc.nextInt();
						System.out.print("고양이 이름을 입력해주세요 >> ");
						String name = sc.next();
						ccon.enrollCatConn(member, cat, name);
					} else {// 고양이 정보가 있으면
						mainPage(member);
					}
				} // 로그인
			}
			else if (menu1 == 3) {// 종료
				System.out.println("안녕히 가십시오.");
				break;
			} // 종료

			else {// 잘못 입력
				System.out.println("아이디와 비밀번호를 확인하세요");;
			} // 잘못 입력
		} // else-if
	}// while

	// 회원가입
	public static void doJoin() {
		System.out.println("==회원가입==");
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();

		// DB에 id, pw, name 등록하기
		MemberVO member = new MemberVO(id, pw);
		String result = mCon.joinConn(member);

		System.out.println("회원가입에 " + result + "하셨습니다.");// 성공실패 유무 표기하기
	} // doJoin
		// 로그인

	public static String doLogin() {
		System.out.println("==로그인==");
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();

		MemberVO member = new MemberVO(id, pw);
		String result = mCon.loginConn(member);

		return result;
	} // doLogin
		// 탈퇴하기

	public static void doDelete(MemberVO member) {

		System.out.println("==회원탈퇴==");
		System.out.println("탈퇴할 ID : ");
		String id = sc.next();
		System.out.println("탈퇴 확인 PW : ");
		String pw = sc.next();

		if (id.equals(member.getId()) && pw.equals(member.getPw())) {
			String isSuccess = mCon.deleteConn(member);
			System.out.println(String.format("탈퇴에 %s하였습니다", isSuccess));
		}
		// DB에서 id, pw 대조
	}

	public static boolean mainPage(MemberVO member) {
		while (true) {// 메인 홈페이지
			System.out.println("무엇을 하시겠습니까?");
			System.out.print("[1]게임하기 [2]랭킹확인 [3]게임종료 [4]탈퇴하기 >> ");
			int menu2 = sc.nextInt();

			if (menu2 == 1) {// 게임하기
				game(member);
			} // 게임하기

			else if (menu2 == 2) {// 랭킹확인
				ranking(member);
			} // 랭킹확인

			else if (menu2 == 3) {// 종료
				System.out.println("로그아웃 합니다.");
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
	}// mainPage

	public static void game(MemberVO member) {
		while (true) {
			System.out.println("무엇을 하시겠습니까?");
			System.out.print("[1]먹이주기 [2]놀아주기 [3]낮잠자기 [4]종료 >> ");
			int menu3 = sc.nextInt();

			if (menu3 == 1) {// 밥주기
				System.out.println("어떤걸 주시겠습니까?");
				System.out.print("[1]사료 [2]츄르 [3]캔참치 [4]닭고기 >> ");
				int food = sc.nextInt();
				if (food == 1) {
					String catFood = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⡀⠀⠀⠀⠀⣀⣀⣀⠤⣀⠤⣀⡀⡀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⢀⣤⢖⣹⢬⢓⠼⢰⢃⣎⣚⡢⢝⢠⢣⢆⡄⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⡼⡎⢲⢑⡒⢕⠫⣇⠃⡎⢧⠸⢘⢰⢢⣣⢝⡄⠀⠀⠀\n"
							+ "⠀⠀⠀⠰⠀⠈⠋⠶⠻⡭⣭⣖⡯⣯⣓⢮⠽⠤⠗⠋⠁⠰⡀⠀⠀\n"
							+ "⠀⠀⢐⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣵⠀⠀\n"
							+ "⠀⠀⠀⠫⡂⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠤⡊⠂⠀⠀\n"
							+ "⠀⠀⠀⣆⢪⠁⠒⣙⠢⠒⣒⣐⣐⣐⣒⢒⠢⠭⣋⡢⠈⢎⠵⠀⠀\n"
							+ "⠀⠀⠀⠀⠁⢀⠠⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠈⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀";
					System.out.println("사료를 주었습니다.");
					System.out.println(catFood);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					ccon.updateTiredConn(member, -1);
					member = mCon.joinMemberDB(member.getId());
					System.out.println("만족스러운 식사였나봅니다.");
					System.out.println("고양이가 가르릉 거리는군요.");
					status(member);
				} else if (food == 2) {
					String turu = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠊⠀⡀⢀⣀⡴⠊⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡾⠉⠳⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠖⠋⠀⠀⠀⣿⣯⢌⢧⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡟⢠⡇⠀⠘⣇⠀⠀⠀⠀⠀⠀⠀⠀⢀⡞⠁⣸⠁⠀⢀⡴⠃⢇⢇⣫⡳⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠀⢸⣥⣤⡀⢸⡄⠀⠀⠀⠀⠀⠀⠀⣼⡴⣺⠃⠀⣰⣯⡴⣶⡴⠛⠉⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣶⡛⢿⣄⠈⠈⠁⢁⣈⣳⣦⣄⠀⠀⣀⡴⢊⠡⠊⣏⢀⣼⡟⢸⠷⠋⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⡴⠒⠛⠛⠛⠛⠒⠶⢻⣄⠈⢿⣦⠙⠆⠀⡴⣿⢛⣿⡶⢟⣷⡸⡅⢊⣵⣶⠆⢈⣏⣸⠛⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⡇⠀⠚⠋⠙⣻⡦⠀⠀⠙⠳⠀⠉⠃⠀⠀⢧⡿⢿⣿⣷⣏⣼⠛⠹⡌⢛⣭⠞⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⢳⡀⠀⠀⠀⣿⠀⠀⣴⣺⣟⣶⡄⠀⠰⣾⡇⠉⠉⠁⠁⠓⠛⣶⣒⣙⠉⣇⡼⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠓⢦⣄⣈⠁⣀⣸⡿⣿⣶⣇⡇⠀⢀⡴⡟⠿⣆⠀⠀⠀⣰⢻⢿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⡟⣋⣤⠛⣾⠿⠋⠀⠀⠊⠀⠉⠓⣃⣀⣀⡴⣧⡀⢉⡽⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⣴⠟⢛⣷⣄⠀⠀⠀⠀⢷⡟⣻⣿⠞⡫⠀⠀⠀⠀⣠⡖⠋⠀⠈⢺⣧⣈⡵⠚⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠹⣶⠟⢁⡼⢷⡀⠀⠀⠀⠉⠛⠦⢬⣤⣄⣤⣴⣟⠉⠻⣆⢀⣴⡿⠚⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠙⢶⡟⠁⣤⠟⢦⡀⠀⠀⠀⠀⣰⠷⠖⠊⠁⠙⢷⣤⠞⠻⣾⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠙⢾⡃⢠⣾⠛⣦⣀⠀⡼⠻⠿⠗⠂⠀⠐⠋⠁⠰⣶⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⢧⣰⡟⢉⡿⠷⠶⠒⠀⠀⠀⠀⠀⣤⣴⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⣿⣥⣤⣄⢀⣀⣀⠀⠀⡀⣰⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⢰⠏⠀⡏⠀⠈⢙⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⠀⠀⢸⡄⠀⢳⡀⠀⠀⢧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠓⠶⠟⠁⠀⠀⠙⠚⠖⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
					System.out.println("츄르를 주었습니다.");
					System.out.println(turu);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					member = mCon.joinMemberDB(member.getId());
					System.out.println("만족스러운 식사였나봅니다.");
					System.out.println("고양이가 가르릉 거리는군요.");
					status(member);
				} else if (food == 3) {
					System.out.println("캔참치");
					String can = "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⡛⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"
							+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠸⢞⢭⡹⢂⣬⣼⢴⣅⢻⣿⣿⣿⣿⣿\n"
							+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡖⣰⣼⣿⣿⣤⣿⡏⢼⣿⣿⣿⣿⣿\n"
							+ "⣿⣿⣿⣿⣿⣿⣿⣿⢿⠿⢃⣾⣿⣿⣿⣿⣿⡟⢰⣿⣿⣿⣿⣿⣿\n"
							+ "⣿⣿⣿⣿⠟⣫⡥⠶⠪⣰⣿⣿⣿⡿⠿⢛⠋⡘⠶⢬⣍⠻⢿⣿⣿\n"
							+ "⣿⣿⣿⡇⣭⠡⢶⠯⡰⠟⣛⣉⣥⣶⠛⠲⡶⢦⣤⡄⠌⣹⠌⣿⣿\n"
							+ "⣿⣿⣿⡇⢈⠻⢲⢴⣄⣝⣙⡋⣛⢙⢛⢛⣝⣍⡥⡞⠟⠉⠨⣿⣿\n"
							+ "⣿⣿⣿⡇⠠⠀⠄⠠⠀⡁⠡⠙⠉⠋⠍⠡⠁⠁⠄⢀⠂⢈⠨⣿⣿\n"
							+ "⣿⣿⣿⡇⠐⠀⠂⠄⣡⣴⣶⣶⣷⣤⣆⡐⣨⣤⣌⠀⠄⠂⠨⣿⣿\n"
							+ "⣿⣿⣿⡇⢈⠀⡁⢸⣿⣅⣽⣿⣿⣿⣿⣿⣿⣿⡏⠀⢂⠠⢑⣿⣿\n"
							+ "⣿⣿⣿⡇⡠⠀⡐⠀⠛⠿⣿⣿⣿⠿⠟⠋⠹⠿⠟⠀⠄⠠⡐⣿⣿\n"
							+ "⣿⣿⣿⣧⡑⢦⣔⣈⢀⢁⢀⠀⡀⠄⠐⢈⢀⢂⢠⣡⡴⢛⣰⣿⣿\n"
							+ "⣿⣿⣿⣿⣿⣷⣴⣍⣝⣙⣑⡳⡺⡺⣚⣚⣊⣫⣍⣦⣾⣿⣿⣿⣿\n"
							+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿";
					System.out.println("캔참치를 주었습니다.");
					System.out.println(can);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					member = mCon.joinMemberDB(member.getId());
					System.out.println("만족스러운 식사였나봅니다.");
					System.out.println("고양이가 가르릉 거리는군요.");
					status(member);
				} else if (food == 4) {
					String chicken = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⢐⠐⠨⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠈⠈⠌⠢⢠⢰⢠⢠⢀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠐⢕⢕⢕⢕⢕⠩⠪⡑⡑⢕⠢⡢⢄⠄⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⢕⢕⢕⢱⠡⡃⢕⢡⢑⢌⢢⢑⢕⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢣⢣⢣⢣⢣⢱⢨⠢⡑⡔⢅⢪⢊⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡸⡸⡸⡸⡸⡱⡱⡱⡱⡱⡁⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠃⠏⠮⠪⠎⠞⠘⠁⠁⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
					System.out.println("닭고기를 주었습니다.");
					System.out.println(chicken);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					member = mCon.joinMemberDB(member.getId());
					System.out.println("만족스러운 식사였나봅니다.");
					System.out.println("고양이가 가르릉 거리는군요.");
					status(member);
				} else {
					System.out.println("줄 수 있는 먹이가 없습니다. . .");
				}
			} // 밥주기

			else if (menu3 == 2) {// 놀아주기
				System.out.println("어떤걸로 주시겠습니까?");
				System.out.print("[1]사료 [2]츄르 [3]캔참치 [4]닭고기 >> ");
				int food = sc.nextInt();
				if (food == 1) {
					System.out.println("사료주기");
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else if (food == 2) {
					System.out.println("츄르주기");
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else if (food == 3) {
					System.out.println("캔참치");
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else if (food == 4) {
					System.out.println("닭고기");
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else {
					System.out.println("줄 수 있는 먹이가 없습니다. . .");
				}

			} // 놀아주기

			else if (menu3 == 3) {// 낮잠자기
				System.out.println("낮잠 재우기 ?");
				System.out.print("[1]사료 [2]츄르 [3]캔참치 [4]닭고기 >> ");
				int food = sc.nextInt();
				if (food == 1) {
					System.out.println("사료주기");
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else if (food == 2) {
					System.out.println("츄르주기");
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else if (food == 3) {
					System.out.println("캔참치");
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else if (food == 4) {
					System.out.println("닭고기");
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else {
					System.out.println("줄 수 있는 먹이가 없습니다. . .");
				}

			} // 낮잠자기

			else if (menu3 == 4) {
				System.out.println("메인홈으로 돌아갑니다.");
				break;
			}

			else {// 잘못 입력
				System.out.println("먹이주기, 놀아주기, 낮잠자기만 가능합니다.");
			} // 잘못 입력
		} // while

	}// game

	public static void ranking(MemberVO member) {
		RankingController rCon = new RankingController();
		rCon.showRanker(member);
	}
	
	public static void status(MemberVO member) {
		System.out.println(member.getName() + "의 현재 레벨은 " + member.getLvl() + ", 경험치는 " + member.getExp() + ", 피로도는 "
				+ member.getTired() + ", 스트레스 지수는 " + member.getStress() + "입니다.");
	}

}// Class Main