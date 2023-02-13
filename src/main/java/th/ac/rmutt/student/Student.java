package th.ac.rmutt.student;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@SequenceGenerator(name = "stuSequence", sequenceName = "stu_id_seq", allocationSize = 1, initialValue = 15)
	@GeneratedValue(generator = "stuSequence")
	@Column(name = "student_id")
	private Integer studentId;
	@Column(length = 15, unique = false, name = "student_code")
	private String studentCode;
	@Column(length = 45, unique = false, name = "password")
	private String password;
	@Column(length = 15, unique = false, name = "student_prefix")
	private String prefix;
	@Column(length = 255, unique = false, name = "firstname")
	private String firstName;
	@Column(length = 255, unique = false, name = "lastname")
	private String lastName;
	@Column(length = 255, unique = false, name = "birthday")
	private Date birthday;
	@Column(length = 255, unique = false, name = "nation")
	private String nationality;
	@Column(length = 255, unique = false, name = "reli")
	private String religion;
	@Column(length = 255, unique = false, name = "email")
	private String email;
	@Column(length = 255, unique = false, name = "phone_no")
	private String phoneNo;
	@Column(length = 125, unique = false, name = "student_regisyear")
	private String studentRegisYear;
	@Column(length = 125, unique = false, name = "student_faculty")
	private String studentFaculty;
	@Column(length = 125, unique = false, name = "student_major")
	private String studentMajor;
	@Column(length = 5, unique = false, name = "student_gpa")
	private Float studentGpa;
	@Column(length = 1, unique = false, name = "student_classyear")
	private String studentClassyear;
	@Column(length = 255, unique = false, name = "role")
	private String role;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "add_id")
	private StudentAddress studentAddress;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getStudentRegisYear() {
		return studentRegisYear;
	}

	public void setStudentRegisYear(String studentRegisYear) {
		this.studentRegisYear = studentRegisYear;
	}

	public String getStudentFaculty() {
		return studentFaculty;
	}

	public void setStudentFaculty(String studentFaculty) {
		this.studentFaculty = studentFaculty;
	}

	public String getStudentMajor() {
		return studentMajor;
	}

	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}

	public Float getStudentGpa() {
		return studentGpa;
	}

	public void setStudentGpa(Float studentGpa) {
		this.studentGpa = studentGpa;
	}

	public String getStudentClassyear() {
		return studentClassyear;
	}

	public void setStudentClassyear(String studentClassyear) {
		this.studentClassyear = studentClassyear;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public StudentAddress getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(StudentAddress studentAddress) {
		this.studentAddress = studentAddress;
	}

	
	

}
