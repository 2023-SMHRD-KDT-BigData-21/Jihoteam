package controller;

import model.MemberVO;
import model.RankingDAO;

public class RankingController {
	public void showRanker(MemberVO member){
		RankingDAO rDao = new RankingDAO();
		MemberVO[] rankerArr = rDao.getRanker();
		System.out.println(String.format("     아이디 \t 랭킹 점수"));
		int num = 1;
		for (MemberVO ranker : rankerArr) {
			if(ranker!=null) {				
				System.out.println(String.format("%d. %s \t %d ", num, ranker.getId(), ranker.getRank()));
				num++;
			}
		}
		
		System.out.println(String.format("------------------------------"));
		String[] result = rDao.getRank(member.getId());
		System.out.println(String.format("%s. %s \t %s", result[0], member.getId(), result[1]));
	}
}
