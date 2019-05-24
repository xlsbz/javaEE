package vo;
/**
 * javaBean  封装学生表的所有字段，实现get/set方法  对封装的学生对象取值
 * @author Mr DU
 *
 */

import java.util.Date;

public class StudentVo {
	private String sname;
	private String password;
	private String name;
	private int age;
	private String sex;
	private Date birthday;
	private String school;
	private String specialty;
	private String knowledge;
	private String email;
	private String resume;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public StudentVo() {
		
	}
	public StudentVo(String sname, String password, String name, int age, String sex, Date birthday, String school,
			String specialty, String knowledge, String email, String resume) {
		super();
		this.sname = sname;
		this.password = password;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.school = school;
		this.specialty = specialty;
		this.knowledge = knowledge;
		this.email = email;
		this.resume = resume;
	}
	
}
