package daoTrue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import daoInterface.StudentIn;
import vo.StudentVo;
/**
 * 真实实现类
 * 此类完成对数据库的访问与操作
 * @author Mr DU
 *
 */
public class StudentTu implements StudentIn{
	//声明数据库访问对象
	private Connection conn = null;
	private PreparedStatement prep = null;
	private ResultSet rs = null;
	public StudentTu(Connection conn) {
		//注意，这里并没有实现数据库连接，代理实现类将调用这个类的构造方法，传入数据库连接对象conn给这个类的this.conn才可以进行数据库操作
		this.conn = conn;
	}
	@Override
	public boolean insertStudent(StudentVo studentvo) throws Exception {
		boolean flag = false; 
		String sql = "INSERT INTO tb_student(sname,password,name,age,sex,birthday,school,specialty,knowledge,email,resume)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		prep = conn.prepareStatement(sql);
		this.prep.setString(1,studentvo.getSname());
		this.prep.setString(2,studentvo.getPassword());
		this.prep.setString(3,studentvo.getName());
		this.prep.setInt(4,studentvo.getAge());
		this.prep.setString(5,studentvo.getSex());
		this.prep.setDate(6,new Date(studentvo.getBirthday().getTime()));
		this.prep.setString(7,studentvo.getSchool());
		this.prep.setString(8,studentvo.getSpecialty());
		this.prep.setString(9,studentvo.getKnowledge());
		this.prep.setString(10,studentvo.getEmail());
		this.prep.setString(11,studentvo.getResume());
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		prep.close();
		return flag;
	}

	@Override
	public boolean loginStudent(String sname, String password) throws Exception {
		boolean flag = false;
		String sql = "select sname,name from tb_student where sname=? and password=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, sname);
		prep.setString(2, password);
		ResultSet rs = null;
		rs = prep.executeQuery();
		if(rs.next()) {
			flag = true;
		}
		prep.close();
		return flag;
	}
	@Override
	public boolean updateStudent(StudentVo studentvo,String name) throws Exception {
		boolean flag = false;
		String sql ="update tb_student set password=?,name=?,age=?,sex=?,birthday=?,school=?,specialty=?,knowledge=?,email=?,resume=? where sname=?";
		prep = conn.prepareStatement(sql);
		this.prep.setString(1,studentvo.getPassword());
		this.prep.setString(2,studentvo.getName());
		this.prep.setInt(3,studentvo.getAge());
		this.prep.setString(4,studentvo.getSex());
		this.prep.setDate(5,new Date(studentvo.getBirthday().getTime()));
		this.prep.setString(6,studentvo.getSchool());
		this.prep.setString(7,studentvo.getSpecialty());
		this.prep.setString(8,studentvo.getKnowledge());
		this.prep.setString(9,studentvo.getEmail());
		this.prep.setString(10,studentvo.getResume());
		prep.setString(11, name);
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		prep.close();
		return flag;
	}
	@Override
	public StudentVo queryStudent(String name) throws Exception {
		StudentVo vo = null;
		ResultSet rs = null;
		String sql = "select sname,password,name,age,sex,birthday,school,specialty,knowledge,email,resume from tb_student where sname=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1,name);
		rs = prep.executeQuery();
		if(rs.next()) {
			vo = new StudentVo();
			vo.setSname(rs.getString(1));
			vo.setPassword(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setAge(rs.getInt(4));
			vo.setSex(rs.getString(5));
			vo.setBirthday(rs.getDate(6));
			vo.setSchool(rs.getString(7));
			vo.setSpecialty(rs.getString(8));
			vo.setKnowledge(rs.getString(9));
			vo.setEmail(rs.getString(10));
			vo.setResume(rs.getString(11));
		}
		prep.close();
		return vo;
	}

}
