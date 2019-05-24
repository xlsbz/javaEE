package vo;
/**
 * 公司基本信息表对象
 * @author Mr DU
 *
 */
public class CompanyVo {
	private String cname;
	private String password;
	private String name;
	private String email;
	private String tel;
	private String manage;
	private String address;
	private String resume;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getManage() {
		return manage;
	}
	public void setManage(String manage) {
		this.manage = manage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public CompanyVo() {
		
	}
	public CompanyVo(String cname, String password, String name, String email, String tel, String manage,
			String address, String resume) {
		super();
		this.cname = cname;
		this.password = password;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.manage = manage;
		this.address = address;
		this.resume = resume;
	}
	
}
