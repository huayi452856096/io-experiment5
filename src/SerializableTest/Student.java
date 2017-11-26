package SerializableTest;
import java.io.Serializable;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3819953521039206020L;
	private String studentID;
	private String name;
	private String sex;
	
	public String getID() {
		return studentID;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	
	public void setID(String studentID) {
		this.studentID = studentID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
