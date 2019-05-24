package entity;



public class SignIn {		
		 String signId;
		 String signNumber;
		 String signAdress;
		 String signTime;
		 String signBeizhu;
		 String admId;

		//alt shift +s 选择批量创建set get 方法
		 public SignIn(String signId, String signNumber, String signAdress, String signTime,String signBeizhu,String admId) {
			 this.signId = signId;
				this.signNumber = signNumber;
				this.signAdress = signAdress;
				this.signTime = signTime;
				this.signBeizhu = signBeizhu;
				this.admId = admId;
			}
		 
	
	

		public String getSignId() {
			return signId;
		}




		public void setSignId(String signId) {
			this.signId = signId;
		}




		public String getSignNumber() {
			return signNumber;
		}




		public void setSignNumber(String signNumber) {
			this.signNumber = signNumber;
		}




		public String getSignAdress() {
			return signAdress;
		}




		public void setSignAdress(String signAdress) {
			this.signAdress = signAdress;
		}




		public String getSignTime() {
			return signTime;
		}




		public void setSignTime(String signTime) {
			this.signTime = signTime;
		}




		public String getSignBeizhu() {
			return signBeizhu;
		}




		public void setSignBeizhu(String signBeizhu) {
			this.signBeizhu = signBeizhu;
		}




		public String getAdmId() {
			return admId;
		}




		public void setAdmId(String admId) {
			this.admId = admId;
		}




		public static void main(String[] args) {
		// TODO Auto-generated method stub

		}

	
}
