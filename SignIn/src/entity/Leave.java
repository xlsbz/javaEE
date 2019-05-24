package entity;

public class Leave {
	String leaID;
	String leaDate;
	String leaTime;
	String leaState;
	int leaOrderNum;
	String admID;
	String wiID;
	
	public Leave(String leaID, String leaDate, String leaTime, String leaState, int leaOrderNum, String admID,
			String wiID) {
		this.leaID = leaID;
		this.leaDate = leaDate;
		this.leaTime = leaTime;
		this.leaState = leaState;
		this.leaOrderNum = leaOrderNum;
		this.admID = admID;
		this.wiID = wiID;
		
	}

	public String getLeaID() {
		return leaID;
	}

	public void setLeaID(String leaID) {
		this.leaID = leaID;
	}

	public String getLeaDate() {
		return leaDate;
	}

	public void setLeaDate(String leaDate) {
		this.leaDate = leaDate;
	}

	public String getLeaTime() {
		return leaTime;
	}

	public void setLeaTime(String leaTime) {
		this.leaTime = leaTime;
	}

	public String getLeaState() {
		return leaState;
	}

	public void setLeaState(String leaState) {
		this.leaState = leaState;
	}

	public int getLeaOrderNum() {
		return leaOrderNum;
	}

	public void setLeaOrderNum(int leaOrderNum) {
		this.leaOrderNum = leaOrderNum;
	}

	public String getAdmID() {
		return admID;
	}

	public void setAdmID(String admID) {
		this.admID = admID;
	}

	public String getWiID() {
		return wiID;
	}

	public void setWiID(String wiID) {
		this.wiID = wiID;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
