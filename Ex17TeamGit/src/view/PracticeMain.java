package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.CatController;
import controller.MemberController;
import controller.RankingController;
import controller.Controller;
import model.CatVO;
import model.MemberVO;

public class PracticeMain {
	static Scanner sc = new Scanner(System.in);//
	static MemberController mCon = new MemberController();//
	static CatController ccon = new CatController();
	static Controller ocon = new Controller();
	
	//스트레스 업데이트 메소드만 남겨놨어요!
	public static void game(MemberVO member) {
		while (true) {
			ocon.randomEvent(member);
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
					System.out.println("만족스러운 식사였나봅니다.");
					System.out.println("고양이가 가르릉 거리는군요.");
					ccon.updateStressConn(member, -5);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					ccon.updateTiredConn(member, -1);
					ocon.checkTired(member);
					member = mCon.joinMemberDB(member.getId());
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
					System.out.println("만족스러운 식사였나봅니다.");
					System.out.println("고양이가 가르릉 거리는군요.");
					ccon.updateStressConn(member, -5);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					ccon.updateTiredConn(member, -1);
					ocon.checkTired(member);
					member = mCon.joinMemberDB(member.getId());
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
					System.out.println("만족스러운 식사였나봅니다.");
					System.out.println("고양이가 가르릉 거리는군요.");
					ccon.updateStressConn(member, -5);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					ccon.updateTiredConn(member, -1);
					ocon.checkTired(member);
					member = mCon.joinMemberDB(member.getId());
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
					System.out.println("만족스러운 식사였나봅니다.");
					System.out.println("고양이가 가르릉 거리는군요.");
					ccon.updateStressConn(member, -5);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					ccon.updateTiredConn(member, -1);
					ocon.checkTired(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else {
					System.out.println("줄 수 있는 먹이가 없습니다. . .");
				}
			} // 밥주기

			else if (menu3 == 2) {// 놀아주기
				System.out.println("======뭐하고 놀까요?======");
				System.out.print("[1]레이저 포인트 [2]캣 타워 [3]낚시대 [4]숨바꼭질 >> ");
				int play = sc.nextInt();
				if (play == 1) {
					String laser ="⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⠤⣄⡀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢯⡀⠀⠈⠻⣦⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢢⡀⢀⣽⡇⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡸⢯⣉⣿⠃⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡾⠧⣤⠞⠁⠀⠀⠀\n"
							+ "⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢯⡙⠻⣦⡀⠀⠀⠀\n"
							+ "⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣤⣤⣤⣤⣄⣀⡀⠀⠀⠙⡆⠈⣷⠀⠀⠀\n"
							+ "⠸⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠶⠛⠋⠉⠀⠀⠀⠀⠀⠀⠉⠛⠳⣦⣀⡿⣠⡟⠀⠀⠀\n"
							+ "⠀⢹⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⡏⠀⠀⠀⠀\n"
							+ "⠀⠀⢻⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣆⠀⠀⠀\n"
							+ "⠀⠀⠈⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠞⢧⠀⢠⠏⠀⠀⠀⠀⣠⠿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⡄⠀⠀\n"
							+ "⠀⠀⠀⠘⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠏⠀⢘⣦⣯⣤⠤⠤⣤⣴⣏⡀⠘⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀\n"
							+ "⠀⠀⠀⠀⠸⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣷⡾⠛⠉⠀⠀⠀⠀⠀⠀⠉⠛⢿⣾⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠹⠄⠀⠀⠀⠀⠀⣀⣀⠀⠀⢀⣾⠋⠀⠀⡴⠋⠀⠀⠲⡄⠀⠀⠀⠀⠙⣷⡀⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠇⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠁⠀⠀⢀⠖⠉⠁⠈⢑⣄⢸⣏⠀⠀⠀⠀⣀⡀⢀⡀⠙⠀⠀⠀⠀⠀⠸⡇⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⡆⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣞⣴⠀⡏⢠⠀⠸⡼⣧⠀⠀⢀⣤⡿⠷⠿⣿⣀⣤⣀⠀⠀⠠⢤⡧⢤⣀⡀⠀⠀⠀⠀⠀⢀⣠⡾⠋⠀⣧⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠚⠛⠚⢦⠐⠛⢿⣦⡀⠸⣿⣤⣆⣀⣉⣤⣴⡿⠃⠀⢤⡾⠓⢤⡀⠙⠲⡄⢀⣠⡶⠟⠉⣧⠀⠀⠘⣆⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⢦⣄⣹⣿⣦⣈⠉⠛⠻⣿⡉⠁⠀⣀⣴⢟⣹⣶⠋⠉⠉⠙⢻⡟⠁⠀⠀⣞⣱⣒⣴⠂⣹⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠿⠶⠿⠶⠞⠛⠉⠉⠉⠹⣄⣴⣀⣸⠦⠶⠃⠀⠀⠀⠀⠀⠉⠉⠉⠉⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
					System.out.println("고양이가 레이저에 흥미를 보이나 봅니다.");
					System.out.println(laser);
					System.out.println("세상에, 정말 즐거웠나보군요.");
					System.out.println("저 털 헝클어진 것 좀 보세요.");
					ccon.updateStressConn(member, -5);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					ccon.updateTiredConn(member, -1);
					ocon.checkTired(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else if (play == 2) {
					String tower = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⢶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⣷⠉⡷⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣷⣇⣀⣙⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⢿⠿⠿⡿⢿⡿⠿⠿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⡇⢸⡇⠀⠀⠀⠀⠀⣰⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⡇⢸⡇⢀⣀⣀⣀⣼⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣞⣦⢰⡷⠚⠛⠛⢉⡉⠉⢿⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⣸⣿⣿⣟⣻⣿⣹⣿⣿⣗⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⡟⢻⡟⠛⠛⠛⢻⡟⢻⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠶⠶⠶⠷⠾⠷⠶⠶⠶⢸⡇⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡞⠉⠉⠉⠉⠉⠉⢱⠀⢸⡇⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣇⠀⠀⠀⠀⠀⠀⢸⠀⢸⡇⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣬⣿⣿⣿⣿⣿⣿⣭⣤⢸⡇⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⢸⡇⠀⠀⠀⢸⡇⢸⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⢸⡇⠀⠀⠚⢻⡟⢻⠟⠛⠛⠛⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⡇⢸⡇⠀⠀⠀⢸⡇⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⠀⠀⠀⡇⢸⡇⠀⠀⠀⢸⣷⣼⣄⣀⣤⣤⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡞⠋⣁⣼⠀⠀⠀⡇⢸⡇⠀⠀⠀⢿⣶⣆⣉⣍⠁⠀⠈⢿⣦⣠⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣤⣤⣤⣼⣆⣴⣿⣿⠀⢠⣶⣷⣾⣧⣤⣤⣤⣾⣿⣾⣿⣿⠉⣽⡿⠛⣿⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠁⠉⠀⠀⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠀⠉⠀";
					System.out.println("고양이를 캣 타워에 올려둡니다.");
					System.out.println(tower);
					System.out.println("세상에, 정말 즐거웠나보군요.");
					System.out.println("저 털 헝클어진 것 좀 보세요.");
					ccon.updateStressConn(member, -5);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					ccon.updateTiredConn(member, -1);
					ocon.checkTired(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else if (play == 3) {
					String fishing = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠋⠘⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⠁⠀⠀⠈⢿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⠀⠀⠀⠀⠀⠀⠻⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⢿⣿⣶⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⠁⠀⠀⠀⠀⠀⠀⠀⠙⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡟⢩⢿⡕⠚⣿⣷⣦⣤⣄⡀⢀⣀⣤⣤⣤⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡀⠨⠉⠀⢹⣿⣿⡏⣿⠛⢿⢯⣹⣾⠟⠹⡿⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣦⠀⠀⠀⠀⠀⠀⠀⣠⣴⣛⠁⠀⠀⠀⡠⠀⠐⠉⠀⠉⠂⠀⠀⠉⠃⠀⣸⡇⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⢸⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣷⡀⠀⠀⠀⠘⣿⣿⣿⠟⠀⠀⠀⠾⠇⣀⡀⠀⣠⣴⡄⠀⠀⠀⠀⢰⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⣾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢯⣷⡀⠀⠀⠴⣿⣿⠛⠊⠁⠀⢠⡆⠀⢙⠉⠀⠉⠙⠆⠀⠀⠀⠠⢈⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⣏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡿⣿⣿⡄⠀⠀⢿⠀⠀⠀⠀⠀⠀⠳⣶⠿⣦⣤⡴⠀⠀⠀⢢⠀⣫⣿⣿⣇⣀⡀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣇⠈⣿⢻⣶⠶⢾⣧⡀⠀⠀⠀⠀⠀⢿⣜⣾⠀⠀⠀⠀⠀⠀⠠⡨⣯⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⢘⣆⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡄⠙⣿⣿⡆⠀⠈⠻⣶⣤⣄⣀⠀⠘⠿⠃⠀⠀⠀⠀⠀⠀⠀⢃⣾⡟⠉⠉⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⡿⣿⡛⣷⡀⠰⡿⠟⣿⡿⠛⠶⣦⡄⠀⠀⠀⠀⢀⣀⣤⡟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⡏⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣻⢿⣜⣿⣦⡐⢄⡿⠇⠀⠀⠀⠐⠎⠁⠀⢐⣈⣭⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣧⠸⣆⡀⠀⠀⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⠉⠁⠈⠻⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⡄⠀⠀⠀⠀⠀⡶⠒⣦⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣧⡙⢧⣴⣾⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠈⠛⢷⣦⣀⠄⠀⠀⠀⢢⣨⣥⣴⣽⡇⠀⠀⠀⠀⠀⣿⠀⣹⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣷⣶⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠈⠙⠣⠄⠀⠀⠙⠟⣭⣷⣿⡇⠀⠀⠀⠀⢀⣿⣶⡟⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠉⠛⠿⠟⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⣾⣿⡇⠀⠀⠀⣠⣾⣿⡿⠁⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠂⠩⢛⣡⣽⡇⠀⣠⡾⣿⣿⠏⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⢿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⠀⢀⠸⣻⣽⣷⣛⣽⡿⠟⠁⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⡉⠻⣿⠻⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⠿⠛⢿⣿⡏⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⢿⣧⡀⠀⠀⠁⠀⢠⣀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⣶⣿⢿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⣛⠲⣦⣿⡛⢛⠃⠀⠀⢀⠀⣂⣙⣿⠖⠒⠒⠒⠶⣦⣄⠀⠀⠐⣴⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠿⣤⣀⡹⠃⠉⢀⣠⣶⠾⠛⠛⠉⠀⠀⠀⠀⠀⠀⠈⠻⣧⠀⠀⠀⣰⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠷⣦⣄⣾⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣧⠀⠀⠙⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢦⡀⠐⣿⣟⡆⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠁";
					System.out.println("낚싯대를 고양이 앞에 흔들어 댑니다.");
					System.out.println(fishing);
					System.out.println("세상에, 정말 즐거웠나보군요.");
					System.out.println("저 털 헝클어진 것 좀 보세요.");
					ccon.updateStressConn(member, -5);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					ccon.updateTiredConn(member, -1);
					ocon.checkTired(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else if (play== 4) {
					String hideAndSeek = "⡐⢂⠒⡐⢢⠐⡄⠢⡐⠄⢢⠐⡐⢂⠒⡐⢂⠒⣐⢂⠒⡐⢂⡒⡐⢂⠒⡐⣂⠒⡐⢂⡒⡐⢂⠆⡰⢀⠆⠰⡀⠆⡰⠀⢆⠰⣀⠒⡰⢈\n"
							+ "⠜⢠⠉⡔⢁⠊⠤⣑⣠⣉⡄⢊⠄⡃⢌⠰⢁⠊⠔⡨⠘⠌⡁⠆⣁⠣⠘⡐⢠⠡⢉⠢⢐⠡⢊⡐⡁⠆⣬⣡⣴⠡⡐⡉⢄⠒⡄⢣⠐⡡\n"
							+ "⠎⢠⢁⠒⡈⢌⣰⠋⠹⣯⢟⡷⣾⣔⡈⠆⡌⡘⡐⠄⠣⢘⡐⢌⡠⢂⡱⠈⡔⢂⠡⡘⢠⢁⣦⣴⢾⣻⢏⡿⠉⢳⠠⡑⢌⠒⡌⢢⠑⡄\n"
							+ "⢘⠠⠌⢂⠅⡂⡏⠀⠀⠘⢯⡿⣼⣹⢟⡷⣶⢶⣳⡟⣿⢯⡟⣯⣟⠿⣽⡻⣟⣳⡶⡷⣞⣯⡗⣯⢾⣭⠏⠀⠀⠘⡇⠰⡈⠔⡈⠔⡈⠔\n"
							+ "⠃⡄⠣⡈⠔⠰⡇⠀⠀⢺⣾⡻⣵⢏⣯⢟⣼⣛⣶⣛⣧⡟⣾⢳⡞⣟⣧⠿⣭⠷⣽⣝⣳⢾⣹⡽⣞⡷⣾⠂⠀⠀⣏⠰⢀⠃⢌⠂⢅⠢\n"
							+ "⠌⠤⠑⡠⠉⠆⡇⠀⢀⣴⣳⢻⣝⡾⣽⡺⢧⣟⢶⣛⣶⢻⣭⣟⡹⡽⢮⣟⣭⣟⣳⢾⣹⡞⣧⡟⣾⣹⠶⣄⡀⢀⡧⠘⡠⠉⡄⢊⠰⢈\n"
							+ "⡜⢠⠃⠔⡉⡐⢯⣴⣟⣮⡽⣻⣼⢳⣗⣻⢯⣞⢯⡽⣚⢯⢆⡿⢰⡟⣸⡽⣒⢯⣳⢯⣳⢯⣗⣻⡵⣏⡿⣽⣹⢶⡃⢡⠂⠱⡀⢃⠢⢁\n"
							+ "⡰⠁⠎⠤⠑⣠⣿⣳⢾⣱⡟⣵⡞⣯⣞⢧⣟⡮⣟⡵⣯⢻⣮⢾⡡⣟⢶⣻⢭⡟⣵⢯⣳⢯⣞⢧⣟⠾⣝⡶⣏⡿⣽⡄⢌⠡⡐⠡⠌⢂\n"
							+ "⡐⡉⠔⡨⢱⣟⡧⣟⡞⣧⣟⣧⣟⣳⣞⣯⢾⣝⡾⣽⣞⣻⡼⣳⣻⢭⣟⣮⢯⡽⣏⡾⣽⣺⠽⣞⣭⢿⣹⢾⣹⣳⢏⡿⣆⠐⡡⢘⠠⠃\n"
							+ "⡑⠄⢃⢴⣿⣹⠾⣭⣻⡵⠏⠈⠈⠁⠉⠈⡁⠈⠁⠁⠈⣹⣳⢏⣷⡻⣼⠇⠉⠈⠉⠁⠉⡈⠉⠉⠈⠉⢹⣳⢏⡾⢯⣽⢻⡔⡀⢃⠰⠡\n"
							+ "⠌⠌⣂⡾⣧⢟⣽⡳⣧⢿⠘⡀⠀⠀⠀⠀⡅⠀⠀⢀⡔⢸⣭⡟⣶⣻⢭⡇⢢⠀⠀⠀⠀⠆⠀⠀⠀⣀⠃⣯⢿⣹⣻⠼⣯⢷⠈⡄⢃⠌\n"
							+ "⠊⡔⣸⢿⣵⣻⣮⣷⣛⡎⠰⡉⠒⠤⠠⢄⠢⢄⠊⡔⢨⢸⢷⣹⢧⣯⣛⡆⢡⢊⠒⠤⣀⠃⠤⢠⠒⡄⠣⢼⣏⣷⣭⣟⣧⢿⡿⣶⣌⠰\n"
							+ "⠑⣰⣟⡯⣞⣳⡽⣺⡽⢁⠓⡌⠱⣈⠱⣈⠒⢌⠒⢌⠢⣘⡯⣟⣷⣯⡽⡂⢅⠢⣉⠒⠤⡉⢆⠡⢊⠔⢣⠘⣯⡽⣞⣽⣺⣭⢿⣧⢟⣷\n"
							+ "⣴⣟⢾⣹⣗⣯⣾⠷⡟⢠⠃⡜⢡⢂⠱⢠⠉⢆⡘⢄⠣⡐⣿⣛⣮⣽⣳⠅⡊⠔⡠⢉⠆⡱⠈⢆⠩⡘⢄⠃⢿⢷⣯⣶⣳⡽⣞⡽⣿⣞\n"
							+ "⠳⣾⢯⣳⢯⠾⣵⣻⠅⢢⠑⡌⠢⢌⠢⡁⢎⠰⣈⠦⡱⠄⠻⠙⠖⠣⠛⡤⠱⣌⠰⡁⢎⡐⣉⠢⡑⢌⠢⡉⠼⣏⡾⡵⣏⡷⢯⣷⣟⣳\n"
							+ "⢾⡻⣟⣳⠿⣿⣣⡟⡈⢆⠱⢈⠅⢢⠱⡘⢈⠃⠀⠀⠀⠁⣤⣌⠀⠀⢀⣀⠂⠀⠒⠉⡂⠴⠀⠁⢀⢂⡂⢡⠂⣿⡽⢿⡽⣞⡿⣞⣯⢿\n"
							+ "⢯⢷⣫⡽⣏⣷⢻⡇⡘⢄⠊⡔⡈⠆⠃⢀⠐⠀⠀⠐⠠⡊⡷⣬⢳⠶⢯⣜⡁⢀⣀⠀⠐⠁⠠⣂⠱⡈⠔⡡⢊⢼⣛⣯⠾⣝⡾⣝⣞⢯\n"
							+ "⢯⣳⣏⢷⣻⡼⢯⢐⠁⠊⠐⠠⠁⢣⠂⡀⠀⠀⠀⢀⡬⡵⣙⢧⣫⢞⣱⡺⡜⡂⠄⠌⠓⡁⢮⠀⠃⠘⠠⠑⢈⠆⣟⣮⢿⣹⢾⣹⡞⣯\n"
							+ "⣏⣷⣞⢯⡷⣽⡏⠀⠀⠀⠀⠀⠀⠀⡌⠂⠔⡀⠤⢀⣐⡳⣍⡻⠀⠄⢀⢹⡁⠡⠌⡐⠌⡀⡄⠀⠀⠀⠀⠀⠈⠢⢹⣾⣹⢧⣟⣧⣿⣳\n"
							+ "⠀⠈⠀⡀⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠐⠌⠀⠀⠀⠁⠸⢿⣫⣀⡈⠈⢀⡼⡽⠁⠀⠀⠂⡔⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⢀⠈⠀⠀⠁\n"
							+ "⠈⠀⠁⠀⠄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠢⡄⣀⠀⡀⠂⢸⡵⣳⢝⣷⣄⠀⢀⠠⡐⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠐⠀⠠⠈⠀⠌\n"
							+ "⠠⠈⠀⠁⢀⠀⠀⠀⠠⠀⠀⠀⠄⠀⠀⠀⠀⠀⠁⠆⡑⣼⠏⢣⣉⡫⠄⣦⢃⠌⠁⠀⠀⠀⠀⠀⠀⠄⠀⠀⠠⠀⠀⠀⠠⠈⠀⠀⠁⠠\n"
							+ "⠀⠀⠀⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⢠⠀⠤⣙⢖⡫⠵⡧⠙⡴⣅⠠⣀⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠀⠀⠁⠀⡀\n"
							+ "⠀⠈⠀⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠉⠘⠙⠚⠛⠁⠒⠉⠑⠀⠁⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠁⠀⡀⠀\n"
							+ "⠈⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠂⠀⠀⠀⠀⠀⠀⠀⡀⠠⠀⠂⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⢀";
					System.out.println("간식거리를 흔들어 주의를 끈 다음, 재빨리 다른 곳에 숨습니다.");
					System.out.println(hideAndSeek);
					System.out.println("세상에, 정말 즐거웠나보군요.");
					System.out.println("저 털 헝클어진 것 좀 보세요.");
					ccon.updateStressConn(member, -5);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					ccon.updateTiredConn(member, -1);
					ocon.checkTired(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else {
					System.out.println("아이참, 이러지 마세요.");
					System.out.println("저랑 놀고 싶으신 거에요?");
				}

			} // 놀아주기

			else if (menu3 == 3) {// 낮잠자기
				System.out.println("잠자리가 편치않은 모양일까요?");
				System.out.println("잠이 안 오는 것 같으니 뭐라도 해주는게 좋을지도 모릅니다.");
				System.out.println("======어떻게 하시겠습니까?======");
				System.out.println("[1]따뜻하게 이불을 덮어준다.");
				System.out.println("[2]봉제인형을 옆에 둔다.");
				System.out.println("[3]잔잔한 음악을 틀어준다.");
				System.out.println("[4]종이상자 안에 고양이를 집어넣는다.");
				System.out.print(">> ");
				int nap = sc.nextInt();
				if (nap == 1) {
					String blanket = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⢀⠀⡀⡀⡀⡀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⢀⠂⠨⢀⠐⡐⡈⠄⠂⠄⠄⠄⡁⡂⢐⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠄⠠⠀⠄⠄⠂⠄⠡⢐⠐⡐⠨⢐⠠⠂⡂⠄⠅⠅⡡⠁⠅⡂⠔⢐⢐⢀⠂⠄⡀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⢐⠠⠐⠠⡁⠅⢊⠨⠈⢌⠨⢐⠐⠨⢐⠐⠄⠅⡂⠡⠨⢐⠠⠡⠡⢐⠨⠐⡀⠢⢈⠂⠔⡀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⢀⢐⢐⠨⢀⠂⢅⢁⠂⠅⡂⠌⠌⠔⡨⠠⡡⢑⠐⠨⠐⠡⠠⠡⢁⠢⠨⠠⡁⡂⡂⠅⡂⡑⠄⢅⢁⠂⢅⠠⠀⠀⠀\n"
							+ "⠀⠀⠀⢀⢀⢀⢠⢖⣶⡣⡟⡯⡿⡸⡢⡳⣥⡂⢅⠡⢑⠠⡑⠄⢅⠊⢌⠨⢈⠌⠨⢐⠨⡈⡂⡊⠔⡈⡂⡊⠄⠕⡐⠄⠅⡂⠌⢄⠀⠀\n"
							+ "⢐⠊⠈⠠⠀⡀⠡⡯⣺⡽⣕⢕⢟⣽⡪⡣⡣⡻⡕⣆⡂⡂⡂⠅⢅⢊⠔⡈⡢⠨⠨⢂⠅⡂⡊⠄⠕⡐⢌⢐⠅⠅⡂⠅⡂⠢⢑⠠⢁⠀\n"
							+ "⠀⢅⠀⠅⠌⠄⣇⢯⢎⢟⢾⡜⡎⣎⢯⡻⡜⡎⡮⡲⡱⡢⡂⠅⢅⠢⠨⡐⡐⢅⢑⠡⢂⢊⢐⠅⡑⢌⢐⢐⠌⡐⡐⢐⠨⢈⢤⢌⣆⠀\n"
							+ "⠀⠀⠑⢄⠌⡮⣎⢗⡝⡜⡕⡝⡧⡣⡣⡝⡝⣜⢜⡜⣎⢇⢏⢮⣐⠨⠨⡐⢌⢐⠄⠕⡐⠔⠡⠨⡐⠔⡨⢐⠨⢐⢠⣡⡾⣝⡮⣳⣝⠂\n"
							+ "⠀⠀⠄⡢⢑⣵⣳⢧⢧⡳⡱⡣⡳⡹⡸⡸⡜⣜⢜⢜⡜⣜⢵⣟⣟⡎⣆⢆⡢⡐⠨⢐⠨⢈⠪⠨⢐⢁⢂⠡⣨⡲⣯⡳⣝⣕⢯⣻⢞⠀\n"
							+ "⠀⠀⠁⠂⠁⢺⡪⣇⢧⢳⢱⢕⢕⢧⢫⡪⡎⣎⢎⠣⡱⡕⣗⢵⣻⣺⣪⡳⣝⢮⡫⣆⠌⡐⠨⢐⢐⢄⣦⡳⣕⢵⢳⣻⢼⡪⡗⠝⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠈⠞⣗⢯⢳⢱⢕⢝⢜⢜⢜⡜⡜⡜⢜⢼⣚⢮⠳⠕⠓⠓⠙⠊⠓⠙⠓⠗⠔⢕⠮⢮⡫⡾⡕⡗⡽⠕⠏⠋⠁⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠉⠃⠋⠊⠑⠁⠀⠀⠀⠘⠕⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
					System.out.println("고양이한테 이불을 덮어줍니다.");
					System.out.println(blanket);
					System.out.println("좋은 꿈이라도 꾼 걸까요?");
					System.out.println("꼬리를 살랑살랑 흔드는 모습이 정말 귀엽습니다.");
					ccon.updateStressConn(member, -5);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					ccon.updateTiredConn(member, -1);
					ocon.checkTired(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else if (nap == 2) {
					String toy = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠴⢶⡆⠀⠀⣀⣀⣀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣤⠀⠀⠉⣽⠏⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⠀⠀⠀⠀⠀⠀⠼⠿⠶⠀⠀\n"
							+ "⠀⠀⠀⠀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡀⠀⠀⠀⠈⢉⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⡞⢁⣌⡉⠓⢦⣀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⢀⣤⠖⣛⣭⣭⣿⡆⠀⠀⠀⣼⣯⣴⠦⠀⠀⢼⠅⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⢸⠃⣿⠉⠻⣷⣄⠈⠳⠖⠛⠉⠉⠉⠁⠀⠀⢩⣭⣭⣛⣓⠶⣫⣴⣿⡟⠉⣿⣿⡇⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⢸⠀⣿⠀⢠⡿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣄⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠸⡇⢹⣰⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣧⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⣇⠈⠃⠀⠀⠀⠀⠠⠶⢶⣦⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣤⡤⢤⣤⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⡾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠸⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠉⠑⠂⢀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⣸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠚⠿⠿⠿⠿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⣄⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢳⡀⠀⠀⠀\n"
							+ "⠀⢸⠃⠀⠀⠀⠀⠀⠀⠙⠶⣤⣤⠞⠀⠀⣤⣤⣤⠀⠀⠙⢦⣤⡴⠞⠀⠀⠀⠀⠀⠀⠀⢷⠀⠀⠀⢀⡠⠀⠀⠀⠀⠀⠀⠀⢧⠀⠀⠀\n"
							+ "⠀⡾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣶⣶⣌⣻⡉⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡄⢠⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠘⡄⠀⠀\n"
							+ "⠸⣧⣤⡴⠚⠋⠉⠉⢹⣿⣶⣿⣿⣿⣿⣿⣿⣇⠙⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣤⣷⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢱⠀⠀\n"
							+ "⠀⢰⡏⠀⠀⠚⡖⠀⢈⣿⣿⣿⣿⣿⣿⣿⣿⣿⡷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠬⠇⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠄⠀⠘⡆⠀\n"
							+ "⠀⠸⡟⣒⡦⠶⠶⠶⠾⠿⢟⣛⣿⣿⡿⢿⣿⣿⣽⣶⠤⠴⠶⠶⠶⠶⠶⠶⠒⠚⠋⠁⠀⠀⢸⡆⠀⠀⠀⠀⠀⠀⠀⣠⠎⠀⠀⠀⡇⠀\n"
							+ "⠀⠀⢹⠃⠀⠀⠀⠀⠀⠀⠀⠉⠻⣿⠇⠀⡴⠋⠁⠀⠀⠀⠀⠀⠀⣠⠖⠛⠉⠉⠉⠉⠓⠒⠺⠷⠦⠤⠤⠤⠶⠒⠉⠀⠀⠀⠀⣸⠃⠀\n"
							+ "⠀⠀⢸⡀⠀⠀⠀⠀⠀⠀⠠⡀⢐⣼⡄⢸⣧⡆⢀⠀⠀⠀⠀⠀⡼⠁⠀⢀⣀⣄⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠋⠀⠀\n"
							+ "⠀⠀⠀⠛⠶⠤⠤⣤⣤⣤⠤⠷⠾⠛⠛⠋⠛⠷⠾⠤⠤⠤⠤⢴⣇⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⣀⣠⠴⠛⠁⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⢻⣿⣿⡷⠶⠖⠚⠛⠋⠉⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠻⠿⣿⣿⣿⣿⡾⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
					System.out.println("고양이한테 물고기 인형을 안겨줍니다.");
					System.out.println(toy);
					System.out.println("좋은 꿈이라도 꾼 걸까요?");
					System.out.println("꼬리를 살랑살랑 흔드는 모습이 정말 귀엽습니다.");
					ccon.updateStressConn(member, -5);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					ccon.updateTiredConn(member, -1);
					ocon.checkTired(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else if (nap == 3) {
					String music = "⠀⠀⢠⣤⣤⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⢸⣿⡟⣿⣿⣿⣿⣶⣤⣄⠀⢀⣀⣤⣤⣶⣶⣶⣿⣿⣿⣿⣶⣶⣶⣦⣤⣄⣀⠀⣀⣠⣴⣾⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠸⣿⡇⠚⠻⣿⣿⣿⣿⣿⣿⣿⣿⠿⠟⠛⠋⠉⠉⠉⠉⠉⠉⠉⠛⠛⠿⢿⣿⣿⣿⣿⣿⣿⣿⠿⠛⢻⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⣿⣷⠀⠀⢈⣽⣿⣿⣿⣿⡿⢦⣄⣀⣀⣰⣶⣶⣤⣠⣤⣀⣀⣀⣀⣠⡴⠟⣿⣿⣿⣿⣿⣟⠀⠀⣸⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⢸⣿⡄⣠⣿⣿⣟⣿⣿⡇⠀⠀⠈⠉⠋⠙⣿⠁⠁⠉⢩⣿⠏⠉⠋⠁⠀⠈⢹⣿⣟⡙⢿⣿⣧⣀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⢻⣿⣿⡟⠁⣾⣿⠿⠃⠀⠀⠀⠀⠀⠀⢻⡀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠘⢿⣷⡆⠀⠙⢿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⢀⣾⣿⣿⠀⣨⣭⠁⠀⢀⣀⣀⡀⠀⠀⠀⠈⠇⠀⠀⢸⡇⠀⠀⢀⣀⣤⣀⠀⠀⠉⢭⣥⡀⣼⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⢀⣾⣿⣿⣿⣯⣿⠏⠀⠀⠀⠀⠀⠈⠳⣄⠀⠀⠀⠀⠀⠈⠀⢀⠖⠉⠀⠀⠀⠀⠀⠀⠺⣿⣿⣿⣿⣿⡿⡄⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⢸⣧⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⣽⣿⣿⣿⣿⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⡴⢻⠈⣿⣿⣿⣿⣷⢠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⠀⣿⣿⣿⣿⣿⠀⡟⣶⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⢸⣿⣸⠀⣿⣿⣿⣿⣿⠀⠙⠻⢶⣤⣀⣠⡤⠀⠆⠀⠀⠀⠀⠀⠐⣦⠄⣤⣀⢠⡴⠾⠛⠁⢠⣿⣿⣿⣿⣿⢰⢱⣿⡇⠀⠀⠀⠀⠀⠀\n"
							+ "⢸⣿⣿⢠⣿⣿⣿⣿⣿⠀⣀⠀⠀⠀⠈⠀⠀⠀⠀⣀⠀⠤⠀⢀⠀⠀⠀⠀⠉⠀⠀⠀⢀⣤⢾⣿⣿⣿⣿⡿⢸⢸⢸⡇⠀⠀⠀⠀⠀⠀\n"
							+ "⢸⣿⣻⣿⣿⣿⣿⣿⣿⡀⣉⣙⣒⡶⠒⠀⠀⠀⠀⠑⢢⠀⡠⠚⠀⠀⠀⠠⠔⠒⢖⣛⣋⣁⢸⣿⣿⣿⣿⣇⠘⣻⣼⡇⠀⠀⠀⠀⠀⠀\n"
							+ "⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠠⠄⣐⠂⠀⠀⠀⠀⢉⡁⠀⠀⠀⠀⠐⢒⣀⠀⠽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠈⠀⠠⠀⠀⠀⠐⠈⠀⠈⠐⠀⠀⠀⠂⠠⠄⡀⠁⠺⢿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠙⠻⠿⡿⠿⣿⣴⣿⣷⣶⣅⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣵⣶⣿⣷⣽⡿⠿⠿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⠀⠀⢠⣾⠟⠉⠛⢿⣿⣿⣿⣿⣷⣶⣶⣦⣤⣤⣤⣤⣤⣶⣶⣶⣿⣿⣿⣿⣿⣿⠏⠉⢿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⢀⣼⠋⠁⢀⣠⣤⣶⡿⠿⠿⠿⠟⠛⠛⠛⠿⠿⣿⡿⠿⣿⣿⠿⠿⠿⠽⠿⠿⠿⣦⣤⡀⢹⣿⣿⣿⣿⣿⠿⠶⣦⣄⠀⠀⠀\n"
							+ "⠀⠀⠀⠀⣾⢁⡄⠾⢻⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢏⠁⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⡿⠻⡟⣿⣿⣿⣿⣶⣾⣿⣿⣧⡀⠀\n"
							+ "⣤⣤⣤⣴⣿⣿⡁⠀⢸⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⢠⣨⢠⠀⠀⠄⠀⠀⠀⠀⠀⠀⣿⠇⠀⢀⣿⣿⣿⣿⣿⣿⣿⣟⡙⣷⡤\n"
							+ "⠛⠛⠛⠿⠿⠿⠿⠿⠿⠿⠿⠶⣶⣤⣤⣤⣤⣤⣤⣤⣤⣼⣤⣾⣶⣾⣤⣤⣤⣠⣤⣤⣤⣤⣾⡿⠷⠿⠿⠿⠿⠿⠿⠿⠛⠛⠛⠛⠛⠃";
					System.out.println("잔잔한 음악을 틀어줍니다.");
					System.out.println(music);
					System.out.println("좋은 꿈이라도 꾼 걸까요?");
					System.out.println("꼬리를 살랑살랑 흔드는 모습이 정말 귀엽습니다.");
					ccon.updateStressConn(member, -5);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					ccon.updateTiredConn(member, -1);
					ocon.checkTired(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else if (nap == 4) {
					String box = "⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⡽\n"
							+ "⡿⡽⡽⡽⣞⡯⣞⣯⢯⡯⣯⢯⡯⣯⢯⡯⣯⢯⣟⡾⡽⣽⢽⣵⣻⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⣳⢯⢯⢟⡾⡽⣽⢽⡽⣽⢽⡽⣽⢽⢯\n"
							+ "⢽⢯⢿⢝⣗⡯⣟⡾⣽⢽⡽⣽⢽⡽⣽⢽⡽⣽⣺⢽⢽⣺⢽⣺⢾⢽⡽⣽⢽⡽⣽⢽⡽⣽⢽⡽⡯⣟⡽⡽⣽⢽⡽⡾⣽⢽⡽⣽⢽⣽\n"
							+ "⢯⢿⢽⣽⣳⢯⣗⡿⣽⢽⡽⣽⡽⠝⠉⠉⠈⡐⢄⠢⠢⡐⠔⢅⢍⢋⠯⢯⡯⣯⢯⡯⢫⢯⡯⣯⢯⡷⣻⡽⣞⡯⣯⢿⢽⡽⣽⢽⣽⣺\n"
							+ "⢯⢿⢽⣺⣞⣟⡾⣽⣳⢯⠟⠡⡐⠄⢌⠀⡀⠈⢂⠅⢕⠨⠨⡂⡢⢑⠌⡢⠪⡙⡏⢜⠸⢘⢯⣯⢯⡯⣷⣻⡽⣽⢽⣽⣫⡯⣯⣟⢾⣺\n"
							+ "⡿⡽⡯⣗⣷⣻⣺⢗⣯⠣⡑⢅⠪⡈⡢⢁⢂⠀⢀⠈⠂⠅⠕⡐⠌⢂⢑⠌⡌⡢⡈⠀⠀⠠⠀⠨⠹⣙⢕⠵⣹⢯⣟⣞⡾⣽⣳⢽⢯⣗\n"
							+ "⢯⢿⢽⣻⣺⣞⢽⠋⠰⡱⡨⠢⡑⡰⢐⠅⡢⠡⠀⠀⠱⡀⠀⠀⠀⠀⠠⡈⠆⣆⠢⠠⠂⠀⠄⠈⢌⠢⡫⡢⡯⣟⡾⣵⣻⣳⣫⢯⣻⣺\n"
							+ "⣟⡽⣯⣗⡗⡕⡝⡨⠠⡘⠸⢸⢰⢨⢂⢅⠢⡑⠀⠀⠄⡂⠀⠀⠄⠈⠀⠇⢕⢐⠑⠀⠀⠠⠀⠀⠡⢑⢜⢜⡮⡺⡪⡪⡚⣗⡯⣯⢷⣳\n"
							+ "⡾⣽⣳⡽⡱⡸⡘⡬⡊⢔⢐⠀⠈⠝⡺⣪⢎⢦⢢⢡⢜⡈⡀⢀⠠⠈⠈⠊⢣⢁⠀⡁⠅⠀⡈⠉⠀⠢⡑⣯⢪⢪⢪⠪⡊⣆⢽⢽⡽⣞\n"
							+ "⣟⣗⡷⣓⡜⠬⡪⡸⡸⡲⣡⠀⠀⠐⡨⡪⣗⢕⢕⢕⢕⢕⢝⢕⢇⢦⡀⠠⠀⣣⣂⢆⡅⡄⢔⢐⢅⣣⣺⢪⢪⢪⢢⣣⡷⡯⡿⣽⢽⣳\n"
							+ "⣞⣗⣯⣗⢿⡹⡕⣗⢗⡧⣗⠇⠀⢅⠊⡎⣳⣫⢪⢪⢪⠪⡪⡊⡎⡆⢏⢆⡠⢼⢪⡯⡯⣯⡫⢯⢳⢣⢣⡣⣗⡽⣝⣗⣯⢿⡽⣽⢽⣞\n"
							+ "⣳⣻⡺⣮⢿⠸⡸⠸⠜⡜⠎⠃⢐⠐⢅⢪⢺⣪⢮⣪⡪⡪⡪⡊⡆⡇⢇⢇⢇⢇⣗⡯⢯⡺⣝⣗⡵⡳⣝⣞⢵⢝⡮⣗⣯⢷⣻⡽⣽⣺\n"
							+ "⣗⡯⣟⣾⣻⡝⠄⢅⠕⡐⡑⠄⠠⠡⡑⡜⣕⡯⣣⢳⡹⡝⡵⡳⡵⢵⢥⢇⡧⣕⢗⡽⣕⡝⡮⣚⢮⡫⡮⡮⣞⡷⡯⣟⣞⣯⢷⣻⣳⢯\n"
							+ "⢷⣻⡽⣞⣞⣧⢣⢡⢂⠆⡊⡀⢄⠕⡜⡮⡾⣵⣱⡱⡱⡱⡱⡱⡱⡱⡱⡣⡫⡪⡣⡯⡲⣝⠮⣮⣳⢽⡽⡯⣯⢯⢿⢽⣺⣳⢟⡾⣝⣷\n"
							+ "⡽⡾⣽⣳⣻⢾⢽⡮⣞⣼⣜⣌⡦⣳⣽⢽⢯⣗⡯⣯⢿⢽⣖⣷⣣⢧⡵⣕⣜⣔⢕⢏⣧⢷⣻⣳⢯⡯⣯⣟⣽⢽⢯⣟⣗⣯⢿⢽⢽⣺\n"
							+ "⡯⣟⣗⣯⣞⣯⢯⡯⣟⣞⣞⡮⣟⡽⣮⢯⣟⡾⣽⢽⡽⡯⣾⣺⣞⣯⢯⡷⣽⣺⢽⣽⣺⣽⣳⢯⡯⣯⣗⡷⡯⡿⣽⣺⣵⢽⡽⣽⢽⡵\n"
							+ "⢯⣟⡾⣵⢗⣯⢯⢿⢽⣺⣳⣟⣗⡿⡽⣽⣺⡽⣽⢽⣽⣫⢷⣳⣻⣺⡽⣽⣳⢯⣻⣺⣞⣾⣺⡽⣽⣳⢗⡿⡽⡯⣷⣳⢯⡯⣟⡾⣽⢽\n"
							+ "⡽⡾⡽⣽⢽⣞⢿⢽⢯⢷⣳⣗⡷⣻⢽⣳⢯⢯⢯⣟⢾⣺⢯⢷⣻⣺⢽⣳⢯⣟⣞⣗⢷⣳⢗⣟⣗⡯⡿⣝⡯⣟⢷⢽⡽⣽⣳⢯⡯⣟";
					System.out.println("적당한 크기의 상자를 가져와 고양이를 집어넣습니다.");
					System.out.println(box);
					System.out.println("좋은 꿈이라도 꾼 걸까요?");
					System.out.println("꼬리를 살랑살랑 흔드는 모습이 정말 귀엽습니다.");
					ccon.updateStressConn(member, -5);
					ccon.updateExpConn(member, 10);
					ccon.checkLvlConn(member);
					ccon.updateTiredConn(member, -1);
					ocon.checkTired(member);
					member = mCon.joinMemberDB(member.getId());
					status(member);
				} else {
					System.out.println("고양이는 지금 장난을 치는 것보단 자고 싶어하는 것 같습니다.");
				}

			} // 낮잠자기

			else if (menu3 == 4) {
				System.out.println("메인홈으로 돌아갑니다.");
				break;
			}

			else {// 잘못 입력
				System.out.println("장난은 고양이한테 해주세요.");
				System.out.println("지금도 당신을 빤히 바라보고 있잖아요.");
			} // 잘못 입력
		} // while

	}// game
	
	public static void status(MemberVO member) {
		System.out.println(member.getName() + "의 현재 레벨은 " + member.getLvl() + ", 경험치는 " + member.getExp() + ", 피로도는 "
				+ member.getTired() + ", 스트레스 지수는 " + member.getStress() + "입니다.");
	}

}// Class Main