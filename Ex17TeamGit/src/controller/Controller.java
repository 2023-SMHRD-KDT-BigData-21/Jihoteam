package controller;

import java.util.ArrayList;
import java.util.Random;

import model.CatVO;
import model.DAO;
import model.MemberDAO;
import model.MemberVO;
import model.UpdateDAO;

public class Controller {
	DAO dao = new DAO();
	MemberDAO mdao = new MemberDAO();
	UpdateDAO udao = new UpdateDAO();

	// 랜덤이벤트 메소드
	public void randomEvent(MemberVO member) {
		MemberVO info = mdao.selectMem(member.getId());
		Random ran = new Random();
		int stress = info.getStress();
		String name = info.getName();
		int num = ran.nextInt(1, 3); // 랜덤이벤트 발생할지 정하는 변수
		if (num == 1) {
			System.out.println("랜덤이벤트 발생!!");
			int num2 = ran.nextInt(1, 7); // 랜덤이벤트가 발생했을시 준비된 랜덤 이벤트 시나리오중 하나를 랜덤으로 뽑는 변수
			if (num2 == 1) { // 목욕하기(스트레스 증가)
				System.out.println("오늘따라 " + name + "(이)가 엄청 더러워 보이네요.");
				System.out.println("싫다고 발버둥 치는 " + name + "(이)를 붙잡고 억지로 씻기니 깨끗해보입니다.");
				System.out.println("다만 상당히 기분이 나빠 보이는군요...");
				stress += 15;
				udao.updateStress(member, 15);
				System.out.println("목욕하기로 스트레스가 15 증가되어 현재 스트레스 지수는 " + stress + "입니다.");
			} else if (num2 == 2) { // 물건깨기(스트레스 감소)
				System.out.println("집사가 방을 비운동안 집사의 물건을 깨뜨린 " + name + "!!!");
				stress -= 10;
				udao.updateStress(member, -10);
				if (stress < 0) {
					stress = 0;
					udao.updateStress(member, 0);
				}
				System.out.println("물건깨기로 스트레스가 10 감소되어 현재 스트레스 지수는 " + stress + "입니다.");
			} else if (num2 == 3) { // 데이트(스트레스 감소)
				System.out.println("집사가 방을 비운동안 애묘 고양이와 데이트를 하고 온 " + name);
				stress -= 20;
				udao.updateStress(member, -20);
				if (stress < 0) {
					stress = 0;
					udao.updateStress(member, 0);
				}
				System.out.println("애묘 고양이와의 데이트로 스트레스가 20 감소되어 현재 스트레스 지수는 " + stress + "입니다.");
			} else if (num2 == 4) {
				System.out.println("집사가 방을 비운동안 옆집 고양이와 싸운 " + name);
				stress += 20;
				udao.updateStress(member, 20);
				System.out.println("옆집 고양이와의 싸움으로 스트레스가 20 증가하여 현재 스트레스 지수는 " + stress + "입니다.");
			} else if (num2 == 5) {
				System.out.println("추워서 집사의 이불 속에 들어간 " + name);
				stress -= 10;
				if (stress < 0) {
					stress = 0;
					udao.updateStress(member, 0);
				}
				if (stress < 0) stress = 0;
				System.out.println("포근하고 따뜻해!! 스트레스가 10 감소하여 현재 스트레스 지수는 " + stress + "입니다.");
			} else if (num2 == 6) {
				System.out.println("창문 밖에 눈이 오네요~~");
				System.out.println("눈이 오는 풍경을 구경하며 기분이 좋아진 " + name);
				stress -= 5;
				if (stress < 0) {
					stress = 0;
					udao.updateStress(member, 0);
				}
				if (stress < 0) stress = 0;
				System.out.println("눈 구경으로 스트레스가 5 감소하여 현재 스트레스 지수는 " + stress + "입니다.");
			}
		} // if
	} // randomEvent

	// 피로도 0인지 체크하는 메소드
	public void checkTired(MemberVO member) {
		if (member.getTired() == 1) { // 피로도가 0이면
			String tired = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣾⡿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⢿⣷⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⣴⣶⣶⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠹⠿⢿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⠿⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⢿⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣶⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⣴⣿⠛⠿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⢀⣼⡿⢋⡁⠙⢿⣦⠀⣀⣠⣤⣴⣶⣶⣿⣿⣿⣿⣿⣶⣶⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⢰⣿⢃⣾⣷⣆⢙⣿⣿⣿⣿⣿⣿⠿⣿⣿⡟⢱⣿⣷⣖⠘⣿⡿⠿⢿⣿⣿⠁⢸⣿⡏⢀⠸⣿⣿⣿⠛⣿⣿⣦⣄⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⣼⣿⠸⣿⠿⠋⢸⣿⣿⡇⣿⣿⣿⢀⣿⣿⡆⠈⠛⠻⠟⠉⢻⣿⠐⣾⣿⡿⠀⣾⣿⡟⠁⣶⣿⣿⡇⢠⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⣿⡿⠀⠀⠀⠀⠈⠿⠿⠃⢻⣿⡿⠀⠻⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠙⠋⠀⠀⠉⠋⠀⠀⠻⠿⠟⠀⣾⣿⣿⠇⣼⣿⣧⠀⠀⠀⠀\r\n"
					+ "⠀⢸⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠛⠉⢰⣿⣿⣿⣇⠀⠀⠀\r\n"
					+ "⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠿⠿⢹⣿⣀⠀⠀\r\n"
					+ "⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣧⡀\r\n"
					+ "⠰⣿⡇⠀⣶⣶⣤⣤⣶⡄⠀⠀⠀⠀⠀⢰⣶⣤⣤⣾⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⠘⣿⣧\r\n"
					+ "⠀⣿⣧⠀⠈⠛⠛⠛⠋⠀⢼⣿⣿⣿⠀⠈⠙⠛⠛⠋⠁⠀⠀⠀⣀⣠⣤⠀⠀⠀⣴⣾⣿⣿⣷⣦⣄⡀⠀⠀⠀⠀⢀⣴⣦⠀⠀⠀⢸⣿\r\n"
					+ "⢀⣽⣿⡆⠀⠀⠀⠀⠀⠀⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⣠⣴⣿⣿⠿⠿⠁⠀⢸⣿⠋⠀⠀⢉⣿⣿⣿⣿⣶⣾⣿⣿⣿⣿⣄⠀⢀⣿⡟\r\n"
					+ "⣾⡿⢿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⠟⠉⠀⠀⠀⠀⠀⠸⣿⣆⠀⢀⣼⣿⣿⠋⢹⣿⣿⣇⠀⢻⣿⣿⣀⣾⡿⠁\r\n"
					+ "⢿⣷⣤⣈⣻⣿⣷⣶⣤⣄⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣿⣿⣀⠀⠀⢀⣀⣠⣴⣶⣿⣿⣿⣿⣿⣿⠋⠀⢸⣿⣿⡟⣀⣸⣿⣿⣿⠟⠁⠀\r\n"
					+ "⠀⠙⠛⠿⠿⠟⠛⠛⠛⠻⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠻⠿⣿⣿⡿⠿⠟⠛⠛⠉⠉⠉⠛⠻⠿⢿⣿⣿⣿⣿⣿⠿⠿⠛⠉⠀⠀⠀⠀";
			System.out.println("피로도가 0이 되었습니다.");
			System.out.println("강제 취침을 시작합니다.");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(tired);
			System.out.println("충전중...");
			udao.updateDate(member, 1);
			udao.updateTired(member, 6);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("피로가 충전되어 개운한 " + member.getName());
			String getUp = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣾⡿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⣿⣷⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⣴⣶⣶⡆⢠⣿⣿⣷⠀⢸⣿⣿⡇⢰⣿⣿⣷⢸⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⣿⣿⣿⡇⢸⣿⣿⣿⠀⣾⣿⣿⡇⢸⣿⣿⣿⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⣿⣿⣿⡇⢸⣿⣿⣿⠀⢹⣿⣿⣇⢸⣿⣿⣿⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠹⠿⠿⠇⠈⠿⠿⠿⠀⠸⠿⠿⠇⠘⠿⠿⠿⢰⣿⠿⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⢿⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣶⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⣴⣿⠛⠿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⢀⣼⡿⢋⡁⠙⢿⣦⠀⣀⣠⣤⣴⣶⣶⣿⣿⣿⣿⣿⣶⣶⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⢰⣿⢃⣾⣷⣆⠙⣿⣿⣿⣿⣿⣿⠿⣿⣿⡏⢰⣿⡇⣖⠘⣿⡿⠿⢿⣻⣿⠁⢸⣿⡏⢀⠸⣿⣿⣿⠛⣿⣿⣦⣄⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⣼⡿⠸⣿⠿⠋⢸⣿⣿⡇⣿⣿⣿⢀⣿⣿⡆⠈⠙⠳⠟⠀⢻⣿⠀⣾⣿⡟⠀⣾⣿⡞⠁⣶⣿⣿⠇⢠⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⣿⡧⠀⠀⠀⠀⠀⠿⠿⠃⠻⣿⡿⠀⠛⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠙⠋⠀⠀⠉⠉⠀⠀⠻⠿⠋⠀⣾⣿⣿⠇⣸⣿⣧⠀⠀⠀⠀\r\n"
					+ "⠀⢸⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠛⠁⢰⣿⣿⣿⣇⠀⠀⠀\r\n"
					+ "⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠿⠟⢹⣿⣀⠀⠀\r\n"
					+ "⠀⣿⡇⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣧⠀\r\n"
					+ "⠰⣿⡇⠀⠀⠰⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⠈⣿⣧\r\n"
					+ "⠀⣿⣇⠀⠀⠀⠀⠀⠀⠀⢴⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⠀⠀⠀⣴⣾⣿⣿⣷⣦⣄⡀⠀⠀⠀⠀⢀⣴⣦⠀⠀⠀⢸⣿\r\n"
					+ "⢀⣽⣿⡆⠀⠀⠀⠀⠀⠀⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⣠⣴⣿⣿⠿⠿⠀⠀⢸⣿⠋⠀⠀⢉⣿⣿⣿⣿⣶⣾⣿⣿⣿⣿⣄⠀⢀⣿⡟\r\n"
					+ "⣾⡿⠻⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⠟⠉⠀⠀⠀⠀⠀⠸⣿⣆⠀⢀⣼⣿⣿⠁⢹⣿⣿⡇⠀⢹⣿⣿⣀⣾⡿⠁\r\n"
					+ "⢿⣷⣤⣈⣻⣿⣶⣶⣤⣄⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣿⣿⣀⠀⠀⢀⣀⣠⣴⣤⣾⣿⣿⣿⣿⣿⠃⠀⢸⣿⣿⡇⣀⣸⣿⣿⣿⠟⠁⠀\r\n"
					+ "⠀⠙⠛⠿⠿⠟⠛⠛⠛⠻⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠻⠿⣿⣿⡿⠿⠟⠛⠛⠉⠉⠉⠛⠻⠿⢿⣿⣿⣿⣿⣿⠿⠿⠛⠉⠀";
			System.out.println(getUp);
			System.out.println("피로도가 7로 충전되고, 고양이 키운지 +" + (member.getDate() + 1) + "일이 되었습니다!");
			System.out.println("이제 다시 게임을 시작해 보세요!");
		} //if
	} //checkTired

}