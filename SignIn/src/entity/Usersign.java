package entity;

public class Usersign {
	String userId;
	String userName;
	String userDeparent;
	String userAdress;
	String userTime;
	String userState;
	public Usersign(String userId, String userName, String userDeparent, String userAdress, String userTime, String userState) {
		this.userId = userId;
		this.userName = userName;
		this.userDeparent = userDeparent;
		this.userAdress = userAdress;
		this.userTime = userTime;
		this.userState = userState;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDeparent() {
		return userDeparent;
	}

	public void setUserDeparent(String userDeparent) {
		this.userDeparent = userDeparent;
	}

	public String getUserAdress() {
		return userAdress;
	}

	public void setUserAdress(String userAdress) {
		this.userAdress = userAdress;
	}

	public String getUserTime() {
		return userTime;
	}

	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public static void main(String[] args) {} 
	
}
