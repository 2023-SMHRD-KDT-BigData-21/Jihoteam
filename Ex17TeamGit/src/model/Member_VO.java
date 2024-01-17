package model;

public class Member_VO {

	private String id;
	private String pw;
	public int rank;
	public String type;
	public String name;
	public int lvl;
	public int tired;
	public int date;
	public int stress;
	public int exp;

	public Member_VO(String id, String type, String name) {
		this.id = id;
		this.type = type;
		this.name = name;
	}

	public Member_VO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getTired() {
		return tired;
	}

	public void setTired(int tired) {
		this.tired = tired;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getStress() {
		return stress;
	}

	public void setStress(int stress) {
		this.stress = stress;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

}
