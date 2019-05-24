package vo;

import java.util.Date;

/**
 * 发布招聘信息
 * @author Mr DU
 *
 */
public class CjobVo {
	private int jobid;
	private String cname;
	private String specialty;
	private String job;
	private String emolument;
	private Date ptime;
	private Date atime;
	private String other;
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getEmolument() {
		return emolument;
	}
	public void setEmolument(String emolument) {
		this.emolument = emolument;
	}
	public Date getPtime() {
		return ptime;
	}
	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}
	public Date getAtime() {
		return atime;
	}
	public void setAtime(Date atime) {
		this.atime = atime;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public CjobVo(String cname, String specialty, String job, String emolument, Date ptime, Date atime,
			String other) {
		super();
		this.cname = cname;
		this.specialty = specialty;
		this.job = job;
		this.emolument = emolument;
		this.ptime = ptime;
		this.atime = atime;
		this.other = other;
	}
	public CjobVo() {
		super();
	}
}
