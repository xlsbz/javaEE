package entity;

import java.sql.Date;

import javafx.scene.chart.PieChart.Data;

public class Apply {		
		 String applyId;
		 String applyName;
		 String applyTimestart;
		 String applyTimeend;
		 String applyType;
		 String applyState;
		 String applyInformation;
		 String applyAdress;
		 String applyWin;
		 String applyPhone;
		 String applyBeizhu;
		 String admId;
		//alt shift +s 选择批量创建set get 方法
		 public Apply(String applyId, String applyName, String applyTimestart, String applyTimeend, 
				 String applyType, String applyState, String applyInformation, String applyAdress,
				 String applyWin,String applyPhone,String applyBeizhu,String admId) {
			 this.applyId = applyId;
				this.applyName = applyName;
				this.applyTimestart = applyTimestart;
				this.applyTimeend = applyTimeend;
				this.applyType = applyType;
				this.applyState = applyState;
				this.applyInformation = applyInformation;
				this.applyAdress = applyAdress;
				this.applyWin = applyWin;
				this.applyPhone = applyPhone;
				this.applyBeizhu = applyBeizhu;
				this.admId = admId;
			}
		 
	
		public String getApplyId() {
			return applyId;
		}


		public void setApplyId(String applyId) {
			this.applyId = applyId;
		}


		public String getApplyName() {
			return applyName;
		}


		public void setApplyName(String applyName) {
			this.applyName = applyName;
		}


		public String getApplyTimestart() {
			return applyTimestart;
		}


		public void setApplyTimestart(String applyTimestart) {
			this.applyTimestart = applyTimestart;
		}


		public String getApplyTimeend() {
			return applyTimeend;
		}


		public void setApplyTimeend(String applyTimeend) {
			this.applyTimeend = applyTimeend;
		}


		public String getApplyType() {
			return applyType;
		}


		public void setApplyType(String applyType) {
			this.applyType = applyType;
		}


		public String getApplyState() {
			return applyState;
		}


		public void setApplyState(String applyState) {
			this.applyState = applyState;
		}


		public String getApplyInformation() {
			return applyInformation;
		}


		public void setApplyInformation(String applyInformation) {
			this.applyInformation = applyInformation;
		}


		public String getApplyAdress() {
			return applyAdress;
		}


		public void setApplyAdress(String applyAdress) {
			this.applyAdress = applyAdress;
		}


		public String getApplyWin() {
			return applyWin;
		}


		public void setApplyWin(String applyWin) {
			this.applyWin = applyWin;
		}


		public String getApplyPhone() {
			return applyPhone;
		}


		public void setApplyPhone(String applyPhone) {
			this.applyPhone = applyPhone;
		}


		public String getApplyBeizhu() {
			return applyBeizhu;
		}


		public void setApplyBeizhu(String applyBeizhu) {
			this.applyBeizhu = applyBeizhu;
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
