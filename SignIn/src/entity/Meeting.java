package entity;

public class Meeting {
	String mType;
	String mTime;
	String mAddress;
	String mState;
	String mName;
	String admId;
	public Meeting(String mType, String mTime, String mAddress, String mState, String mName, String admId) {
		this.mType = mType;
		this.mTime = mTime;
		this.mAddress = mAddress;
		this.mState = mState;
		this.mName = mName;
		this.admId = admId;
	}
	public String getmType() {
		return mType;
	}
	public void setmType(String mType) {
		this.mType = mType;
	}
	public String getmTime() {
		return mTime;
	}
	public void setmTime(String mTime) {
		this.mTime = mTime;
	}
	public String getmAddress() {
		return mAddress;
	}
	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}
	public String getmState() {
		return mState;
	}
	public void setmState(String mState) {
		this.mState = mState;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getAdmId() {
		return admId;
	}
	public void setAdmId(String admId) {
		this.admId = admId;
	}
	
	public static void main(String[] args) {} 
	
}
