package model;

public class CatVO {
	public String type;
	public String info;
	public String info2;

	public CatVO(String type, String info, String info2) {
		this.type = type;
		this.info = info;
		this.info2 = info2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
