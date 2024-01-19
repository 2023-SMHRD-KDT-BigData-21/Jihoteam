package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.CatController;
import controller.MemberController;
import controller.MusicController;
import controller.RankingController;
import javazoom.jl.player.MP3Player;
import controller.Controller;
import model.CatVO;
import model.MemberVO;
import model.MusicVO;

public class Main_final {
	   static Scanner sc = new Scanner(System.in);//
	   static MemberController mCon = new MemberController();//
	   static CatController ccon = new CatController();
	   static Controller ocon = new Controller();
	   static MusicController mucon = new MusicController();
	   static MP3Player mp3 = new MP3Player();
	   static ArrayList<MusicVO> musicList = mucon.musicList();

	   public static void main(String[] args) {
	      ArrayList<CatVO> typeList = new ArrayList<CatVO>();
	      while (true) {// 초기화면
	         // 입력
	         String title = " ______      __                              __       __                                              ___                                                     \n"
	               + "/\\__  _\\    /\\ \\                            /\\ \\__   /\\ \\                                            /\\_ \\                                                    \n"
	               + "\\/_/\\ \\/    \\ \\/      ___ ___               \\ \\ ,_\\  \\ \\ \\___       __                ___     ___    \\//\\ \\     __  __                 ___     ___       __   \n"
	               + "   \\ \\ \\     \\/     /' __` __`\\              \\ \\ \\/   \\ \\  _ `\\   /'__`\\             / __`\\ /' _ `\\    \\ \\ \\   /\\ \\/\\ \\               / __`\\ /' _ `\\   /'__`\\ \n"
	               + "    \\_\\ \\__         /\\ \\/\\ \\/\\ \\              \\ \\ \\_   \\ \\ \\ \\ \\ /\\  __/            /\\ \\L\\ \\/\\ \\/\\ \\    \\_\\ \\_ \\ \\ \\_\\ \\             /\\ \\L\\ \\/\\ \\/\\ \\ /\\  __/ \n"
	               + "    /\\_____\\        \\ \\_\\ \\_\\ \\_\\              \\ \\__\\   \\ \\_\\ \\_\\\\ \\____\\           \\ \\____/\\ \\_\\ \\_\\   /\\____\\ \\/`____ \\            \\ \\____/\\ \\_\\ \\_\\\\ \\____\\\n"
	               + "    \\/_____/         \\/_/\\/_/\\/_/               \\/__/    \\/_/\\/_/ \\/____/            \\/___/  \\/_/\\/_/   \\/____/  `/___/> \\            \\/___/  \\/_/\\/_/ \\/____/\n"
	               + "                                                                                                                    /\\___/                                    \n"
	               + "                                                                                                                    \\/__/                                     \n"
	               + "                     __       __                           __                                                         __       __     \n"
	               + "              __    /\\ \\__   /\\ \\                         /\\ \\__                                                     /\\ \\__   /\\ \\    \n"
	               + " __  __  __  /\\_\\   \\ \\ ,_\\  \\ \\ \\___      ___    __  __  \\ \\ ,_\\                __                  ___      __     \\ \\ ,_\\  \\ \\ \\   \n"
	               + "/\\ \\/\\ \\/\\ \\ \\/\\ \\   \\ \\ \\/   \\ \\  _ `\\   / __`\\ /\\ \\/\\ \\  \\ \\ \\/              /'__`\\               /'___\\  /'__`\\    \\ \\ \\/   \\ \\ \\  \n"
	               + "\\ \\ \\_/ \\_/ \\ \\ \\ \\   \\ \\ \\_   \\ \\ \\ \\ \\ /\\ \\L\\ \\\\ \\ \\_\\ \\  \\ \\ \\_            /\\ \\L\\.\\_            /\\ \\__/ /\\ \\L\\.\\_   \\ \\ \\_   \\ \\_\\ \n"
	               + " \\ \\___x___/'  \\ \\_\\   \\ \\__\\   \\ \\_\\ \\_\\\\ \\____/ \\ \\____/   \\ \\__\\           \\ \\__/.\\_\\           \\ \\____\\\\ \\__/.\\_\\   \\ \\__\\   \\/\\_\\\n"
	               + "  \\/__//__/     \\/_/    \\/__/    \\/_/\\/_/ \\/___/   \\/___/     \\/__/            \\/__/\\/_/            \\/____/ \\/__/\\/_/    \\/__/    \\/_/\n"
	               + "                                                                                                                                      ";
	         if(mp3.isPlaying()) {
                 mp3.stop();
              }
              mp3.play(musicList.get(8).getPath());
	         slowPrint(1, title);
	         System.out.println();
	         slowPrint(50, "[1]회원가입 [2]로그인 [3]종료 >> ");
	         int menu1 = sc.nextInt();
	         if (menu1 == 1) {// 회원가입
	            doJoin();
	         } // 회원가입
	         else if (menu1 == 2) {// 로그인
	            String id = doLogin();
	            MemberVO member = mCon.joinMemberDB(id);
	            if (id == null) {// 일치하는 아이디가 없으면
	               slowPrint(50,"저런, ID나 PW를 틀리신 걸까요?");
	               System.out.println();
	               slowPrint(50,"고양이는 당신을 환영하지 않는 것 같습니다.");
	               System.out.println();
	            } else if (id != null) { // 일치하는 아이디가 있으면
	               slowPrint(50,id + "님, 환영합니다.");
	               System.out.println();
	               if (member.name == null) {// 고양이 정보가 없으면
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
	                  slowPrint(50,"""
	                        고양이 상점 주인 :
	                  "어서 와! 고양이를 고르러 왔지?"
	                  "여기 이 귀염둥이들 좀 보라고!"
	                        """);
	                  System.out.println();
	                  ccon.typeConn();
	                  slowPrint(50,"1)페르시안 2)샴 3)메인 쿤 4)스코티시 폴드 5)러시안 블루");
	                  System.out.println();
	                  typeList = ccon.typeConn();
	                  for (CatVO cat : typeList) {
	                     slowPrint(10,cat.getInfo());
	                     slowPrint(10,cat.getInfo2());
	                     System.out.println();
	                     System.out.println();
	                  }
	                  slowPrint(50,"고양이 종류 선택 >> ");
	                  int cat = sc.nextInt();
	                  slowPrint(50,"고양이 이름을 입력해주세요 >> ");
	                  String name = sc.next();
	                  ccon.enrollCatConn(member, cat, name);
	                  mainPage(member);
	               } else {// 고양이 정보가 있으면
	                  mainPage(member);
	               }
	            } // 로그인
	         }
	         else if (menu1 == 3) {// 종료
	            slowPrint(50,"안녕히 가십시오.");
	            System.out.println();
	            break;
	         } // 종료

	         else {// 메뉴 잘못 입력
	            slowPrint(50,"메뉴를 다시 선택해 주세요.");
	            System.out.println();
	         } // 메뉴 잘못 입력
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

	   public static void mainPage(MemberVO member) {
	      while (true) {// 메인 홈페이지
	         slowPrint(50,"무엇을 하시겠습니까?");
	         System.out.println();
	         slowPrint(50,"[1]게임하기 [2]랭킹확인 [3]게임종료 [4]탈퇴하기 >> ");
	         int menu2 = sc.nextInt();

	         if (menu2 == 1) {// 게임하기
	            game(member);
	         } // 게임하기

	         else if (menu2 == 2) {// 랭킹확인
	            ranking(member);
	         } // 랭킹확인

	         else if (menu2 == 3) {// 종료
	            System.out.println("로그아웃 합니다.");
	            break;
	         } // 종료

	         else if (menu2 == 4) {// 탈퇴
	            doDelete(member);
	            break;
	         } // 탈퇴
	         else {// 잘못 입력
	            System.out.println("잘못 입력하셨습니다.");
	         } // 잘못 입력
	      } // 메인 홈페이지}
	   }// mainPage

	   public static void game(MemberVO member) {
	      while (true) {
	         System.out.println();
	         ocon.randomEvent(member);
	         slowPrint(50,"무엇을 하시겠습니까?");
	         System.out.println();
	         slowPrint(50,"[1]먹이주기 [2]놀아주기 [3]낮잠자기 [4]종료 >> ");
	         int menu3 = sc.nextInt();

	         if (menu3 == 1) {// 밥주기
	            slowPrint(50,"어떤걸 주시겠습니까?");
	            System.out.println();
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
	               if(mp3.isPlaying()) {
	                     mp3.stop();
	                  }
	                  mp3.play(musicList.get(4).getPath());
	                  
	               slowPrint(50,"사료를 주었습니다.");
	               System.out.println();

	               System.out.println(catFood);
	               slowPrint(50,"만족스러운 식사였나봅니다.");
	               System.out.println();
	               slowPrint(50,"고양이가 가르릉 거리는군요.");
	               System.out.println();
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
	               if(mp3.isPlaying()) {
	                     mp3.stop();
	                  }
	                  mp3.play(musicList.get(4).getPath());
	               slowPrint(50,"츄르를 주었습니다.");
	               System.out.println();
	               System.out.println(turu);
	               slowPrint(50,"만족스러운 식사였나봅니다.");
	               System.out.println();
	               slowPrint(50,"고양이가 가르릉 거리는군요.");
	               ccon.updateStressConn(member, -5);
	               ccon.updateExpConn(member, 10);
	               ccon.checkLvlConn(member);
	               ccon.updateTiredConn(member, -1);
	               ocon.checkTired(member);
	               member = mCon.joinMemberDB(member.getId());
	               status(member);
	            } else if (food == 3) {
	               slowPrint(50,"캔참치");
	               System.out.println();
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
	               if(mp3.isPlaying()) {
	                     mp3.stop();
	                  }
	                  mp3.play(musicList.get(4).getPath());
	               slowPrint(50,"캔참치를 주었습니다.");
	               System.out.println();
	               System.out.println(can);
	               slowPrint(50,"만족스러운 식사였나봅니다.");
	               System.out.println();
	               slowPrint(50,"고양이가 가르릉 거리는군요.");
	               System.out.println();
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
	               if(mp3.isPlaying()) {
	                     mp3.stop();
	                  }
	                  mp3.play(musicList.get(4).getPath());
	               slowPrint(50,"닭고기를 주었습니다.");
	               System.out.println(chicken);
	               slowPrint(50,"만족스러운 식사였나봅니다.");
	               System.out.println();
	               slowPrint(50,"고양이가 가르릉 거리는군요.");
	               System.out.println();
	               ccon.updateStressConn(member, -5);
	               ccon.updateExpConn(member, 10);
	               ccon.checkLvlConn(member);
	               ccon.updateTiredConn(member, -1);
	               ocon.checkTired(member);
	               member = mCon.joinMemberDB(member.getId());
	               status(member);
	            } else {
	               slowPrint(50,"줄 수 있는 먹이가 없습니다. . .");
	               System.out.println();
	            }
	         } // 밥주기

	         else if (menu3 == 2) {// 놀아주기
	            slowPrint(50,"======뭐하고 놀까요?======");
	            System.out.println();
	            slowPrint(50,"[1]레이저 포인트 [2]캣 타워 [3]낚시대 [4]숨바꼭질 >> ");
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
	               if(mp3.isPlaying()) {
	                     mp3.stop();
	                  }
	                  mp3.play(musicList.get(0).getPath());

	               slowPrint(50,"고양이가 레이저에 흥미를 보이나 봅니다.");
	               System.out.println();

	               System.out.println(laser);
	               slowPrint(50,"세상에, 정말 즐거웠나보군요.");
	               System.out.println();
	               slowPrint(50,"저 털 헝클어진 것 좀 보세요.");
	               System.out.println();
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
	               if(mp3.isPlaying()) {
	                     mp3.stop();
	                  }
	                  mp3.play(musicList.get(1).getPath());

	               slowPrint(50,"고양이를 캣 타워에 올려둡니다.");
	               System.out.println();

	               System.out.println(tower);
	               slowPrint(50,"세상에, 정말 즐거웠나보군요.");
	               System.out.println();
	               slowPrint(50,"저 털 헝클어진 것 좀 보세요.");
	               System.out.println();
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
	               if(mp3.isPlaying()) {
	                     mp3.stop();
	                  }
	                  mp3.play(musicList.get(2).getPath());

	               slowPrint(50,"낚싯대를 고양이 앞에 흔들어 댑니다.");
	               System.out.println();

	               System.out.println(fishing);
	               slowPrint(50,"세상에, 정말 즐거웠나보군요.");
	               System.out.println();
	               slowPrint(50,"저 털 헝클어진 것 좀 보세요.");
	               System.out.println();
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
	               if(mp3.isPlaying()) {
	                     mp3.stop();
	                  }
	                  mp3.play(musicList.get(3).getPath());

	               slowPrint(50,"간식거리를 흔들어 주의를 끈 다음, 재빨리 다른 곳에 숨습니다.");
	               System.out.println();

	               System.out.println(hideAndSeek);
	               slowPrint(50,"세상에, 정말 즐거웠나보군요.");
	               System.out.println();
	               slowPrint(50,"저 털 헝클어진 것 좀 보세요.");
	               System.out.println();
	               ccon.updateStressConn(member, -5);
	               ccon.updateExpConn(member, 10);
	               ccon.checkLvlConn(member);
	               ccon.updateTiredConn(member, -1);
	               ocon.checkTired(member);
	               member = mCon.joinMemberDB(member.getId());
	               status(member);
	            } else {
	               slowPrint(50,"아이참, 이러지 마세요.");
	               System.out.println();
	               slowPrint(50,"저랑 놀고 싶으신 거에요?");
	               System.out.println();
	            }

	         } // 놀아주기

	         else if (menu3 == 3) {// 낮잠자기
	            slowPrint(50,"""
	                  잠자리가 편치않은 모양일까요?
	            잠이 안 오는 것 같으니 뭐라도 해주는게 좋을지도 모릅니다.
	            ======어떻게 하시겠습니까?======
	            [1]따뜻하게 이불을 덮어준다.
	            [2]봉제인형을 옆에 둔다.
	            [3]잔잔한 음악을 틀어준다.
	            [4]종이상자 안에 고양이를 집어넣는다.
	                  """);
	            System.out.println();
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
	               if(mp3.isPlaying()) {
	                     mp3.stop();
	                  }
	                  mp3.play(musicList.get(5).getPath());

	               slowPrint(50,"고양이한테 이불을 덮어줍니다.");
	               System.out.println();

	               System.out.println(blanket);
	               slowPrint(50,"좋은 꿈이라도 꾼 걸까요?");
	               System.out.println();
	               slowPrint(50,"꼬리를 살랑살랑 흔드는 모습이 정말 귀엽습니다.");
	               System.out.println();
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
	               if(mp3.isPlaying()) {
	                     mp3.stop();
	                  }
	                  mp3.play(musicList.get(5).getPath());

	               slowPrint(50,"고양이한테 물고기 인형을 안겨줍니다.");
	               System.out.println();

	               System.out.println(toy);
	               slowPrint(50,"좋은 꿈이라도 꾼 걸까요?");
	               System.out.println();
	               slowPrint(50,"꼬리를 살랑살랑 흔드는 모습이 정말 귀엽습니다.");
	               System.out.println();
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
	               if(mp3.isPlaying()) {
	                     mp3.stop();
	                  }
	                  mp3.play(musicList.get(5).getPath());

	               slowPrint(50,"잔잔한 음악을 틀어줍니다.");
	               System.out.println();

	               System.out.println(music);
	               slowPrint(50,"좋은 꿈이라도 꾼 걸까요?");
	               System.out.println();
	               slowPrint(50,"꼬리를 살랑살랑 흔드는 모습이 정말 귀엽습니다.");
	               System.out.println();
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
	               if(mp3.isPlaying()) {
	                     mp3.stop();
	                  }
	                  mp3.play(musicList.get(5).getPath());

	               slowPrint(50,"적당한 크기의 상자를 가져와 고양이를 집어넣습니다.");
	               System.out.println();

	               System.out.println(box);
	               slowPrint(50,"좋은 꿈이라도 꾼 걸까요?");
	               System.out.println();
	               slowPrint(50,"꼬리를 살랑살랑 흔드는 모습이 정말 귀엽습니다.");
	               System.out.println();
	               ccon.updateStressConn(member, -5);
	               ccon.updateExpConn(member, 10);
	               ccon.checkLvlConn(member);
	               ccon.updateTiredConn(member, -1);
	               ocon.checkTired(member);
	               member = mCon.joinMemberDB(member.getId());
	               status(member);
	            } else {
	               slowPrint(50,"고양이는 지금 장난을 치는 것보단 자고 싶어하는 것 같습니다.");
	            }

	         } // 낮잠자기

	         else if (menu3 == 4) {
	            slowPrint(50,"메인홈으로 돌아갑니다.");
	            System.out.println();
	            break;
	         }

	         else {// 잘못 입력
	            slowPrint(50,"장난은 고양이한테 해주세요.");
	            System.out.println();
	            slowPrint(50,"지금도 당신을 빤히 바라보고 있잖아요.");
	            System.out.println();
	         } // 잘못 입력
	      } // while

	   }// game

	   public static void ranking(MemberVO member) {
	      RankingController rCon = new RankingController();
	      rCon.showRanker(member);
	   }
	   
	   public static void status(MemberVO member) {
	      slowPrint(50, member.getName() + "의 현재 레벨은 " + member.getLvl() + ", 경험치는 " + member.getExp() + ", 피로도는 "
	            + member.getTired() + ", 스트레스 지수는 " + member.getStress() + "입니다.");
	   }
	   public static void slowPrint(long millisPerChar, String message) {
	         for (int i = 0; i < message.length(); i++) {
	            System.out.print(message.charAt(i));

	            try {
	               Thread.sleep(millisPerChar);
	            } catch (InterruptedException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	}// Class Main