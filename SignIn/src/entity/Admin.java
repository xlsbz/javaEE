package entity;

public class Admin {
	String admId;
	int admNumber;
	String admPsd;
	String admState;
	String admPower;
	String admPhone;

	public String getAdmId() {
		return admId;
	}

	public void setAdmId(String admId) {
		this.admId = admId;
	}

	public int getAdmNumber() {
		return admNumber;
	}

	public void setAdmNumber(int admNumber) {
		this.admNumber = admNumber;
	}

	public String getAdmPsd() {
		return admPsd;
	}

	public void setAdmPsd(String admPsd) {
		this.admPsd = admPsd;
	}

	public String getAdmState() {
		return admState;
	}

	public void setAdmState(String admState) {
		this.admState = admState;
	}

	public String getAdmPower() {
		return admPower;
	}

	public void setAdmPower(String admPower) {
		this.admPower = admPower;
	}

	public String getAdmPhone() {
		return admPhone;
	}

	public void setAdmPhone(String admPhone) {
		this.admPhone = admPhone;
	}

	public Admin(String admId, int admNumber, String admPsd, String admState, String admPower, String admPhone) {
		super();
		this.admId = admId;
		this.admNumber = admNumber;
		this.admPsd = admPsd;
		this.admState = admState;
		this.admPower = admPower;
		this.admPhone = admPhone;

	}

}
