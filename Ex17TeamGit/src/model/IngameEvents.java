package model;

import java.util.Random;

public class IngameEvents {
	public static void main(String[] args) {
		
	randomEvent();
		
	}
	
	public static void randomEvent() {
		Random ran = new Random();
		int stress=0; //일시적으로 추가한 stress 변수
		int num=0; //랜덤이벤트 발생할지 정하는 변수
		int num2=0; //랜덤이벤트가 발생했을시 준비된 랜덤 이벤트 시나리오중 하나를 랜덤으로 뽑는 변수
		num = ran.nextInt(1,11);
		if (num==1) {
			System.out.println("랜덤이벤트 발생!!");
			num2=ran.nextInt(1,7);
			if (num2==1) {
				System.out.println("오늘따라 고양이가 엄청 더러워 보이네요.");
				System.out.println("싫다고 발버둥 치는 고양이를 붙잡고 억지로 씻기니 깨끗해보입니다.");
				System.out.println("다만 상당히 기분이 나빠 보이는군요...");
				stress+=10;
				System.out.println("스트레스 : "+stress);
			}else if(num2==2) {
				System.out.println("물건깨기(스트레스 감소)");
				stress-=10;
				if(stress<0) {
					stress=0;
				}
				System.out.println("스트레스 : "+stress);
			}else if(num2==3) {
				System.out.println("애인만남(스트레스 감소)");
				stress-=10;
				if(stress<0) {
					stress=0;
				}
				System.out.println("스트레스 : "+stress);
			}else if(num2==4) {
				System.out.println("옆집 개와 싸움(스트레스 증가)");
				stress+=10;
				System.out.println("스트레스 : "+stress);
			}else if(num2==5) {
				System.out.println("다른 고양이와 영역 다툼(스트레스 증가)");
				stress+=10;
				System.out.println("스트레스 : "+stress);
			}else if(num2==6){
				System.out.println("눈이와서 창문 구경(스트레스 감소)");
				stress-=10;
				if(stress<0) {
					stress=0;
				}
				System.out.println("스트레스 : "+stress);
			}
		}
		
	}

}
