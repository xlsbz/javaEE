package entity;

public class User {
	String wiID;
	String admID;
	String wiName;
	String wiSex;
	String wiGrade;
	String wiPsd;
	String wiAddress;
	String wiPhone;
	String wiBorthday;

	public User(String wiID, String admID, String wiName, String wiSex, String wiGrade, String wiPsd, String wiAddress,
			String wiPhone, String wiBorthday) {
		this.wiID = wiID;
		this.admID = admID;
		this.wiName = wiName;
		this.wiSex = wiSex;
		this.wiGrade = wiGrade;
		this.wiPsd = wiPsd;
		this.wiAddress = wiAddress;
		this.wiPhone = wiPhone;
		this.wiBorthday = wiBorthday;
	}

	public String getWiID() {
		return wiID;
	}

	public void setWiID(String wiID) {
		this.wiID = wiID;
	}

	public String getAdmID() {
		return admID;
	}

	public void setAdmID(String admID) {
		this.admID = admID;
	}

	public String getWiName() {
		return wiName;
	}

	public void setWiName(String wiName) {
		this.wiName = wiName;
	}

	public String getWiSex() {
		return wiSex;
	}

	public void setWiSex(String wiSex) {
		this.wiSex = wiSex;
	}

	public String getWiGrade() {
		return wiGrade;
	}

	public void setWiGrade(String wiGrade) {
		this.wiGrade = wiGrade;
	}

	public String getWiPsd() {
		return wiPsd;
	}

	public void setWiPsd(String wiPsd) {
		this.wiPsd = wiPsd;
	}

	public String getWiAddress() {
		return wiAddress;
	}

	public void setWiAddress(String wiAddress) {
		this.wiAddress = wiAddress;
	}

	public String getWiPhone() {
		return wiPhone;
	}

	public void setWiPhone(String wiPhone) {
		this.wiPhone = wiPhone;
	}

	public String getWiBorthday() {
		return wiBorthday;
	}

	public void setWiBorthday(String wiBorthday) {
		this.wiBorthday = wiBorthday;
	}
	public static void main(String[] args) {
		
	}

}
