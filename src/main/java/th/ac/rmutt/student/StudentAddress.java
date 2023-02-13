package th.ac.rmutt.student;

import javax.persistence.Column;
import javax.persistence.Entity;	
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "students_address")
public class StudentAddress {
	
	@Id
	@SequenceGenerator(name = "stuAddSequence", sequenceName = "stuAdd_id_seq", allocationSize = 1, initialValue = 15)
	@GeneratedValue(generator = "stuAddSequence")
	@Column(name = "add_id")
	private Integer addId;
	@Column(length = 10, unique = false, name = "add_houseno")
	private String addHouse;
	@Column(length = 100, unique = false, name = "add_village")
	private String addVillage;
	@Column(length = 100, unique = false, name = "add_street")
	private String addStreet;
	@Column(length = 100, unique = false, name = "add_subdis")
	private String addSubDis;
	@Column(length = 100, unique = false, name = "add_district")
	private String addDistrict;
	@Column(length = 100, unique = false, name = "add_province")
	private String addProvince;
	@Column(length = 100, unique = false, name = "add_postcode")
	private String addPostCode;
	@Column(length = 100, unique = false, name = "add_oriprovince")
	private String addOriprovince;
	
	public Integer getStudentAddId() {
		return addId;
	}
	public void setStudentAddId(Integer studentAddId) {
		this.addId = studentAddId;
	}
	public String getAddHouse() {
		return addHouse;
	}
	public void setAddHouse(String addHouse) {
		this.addHouse = addHouse;
	}
	public String getAddVillage() {
		return addVillage;
	}
	public void setAddVillage(String addVillage) {
		this.addVillage = addVillage;
	}
	public String getAddStreet() {
		return addStreet;
	}
	public void setAddStreet(String addStreet) {
		this.addStreet = addStreet;
	}
	public String getAddSubDis() {
		return addSubDis;
	}
	public void setAddSubDis(String addSubDis) {
		this.addSubDis = addSubDis;
	}
	public String getAddDistrict() {
		return addDistrict;
	}
	public void setAddDistrict(String addDistrict) {
		this.addDistrict = addDistrict;
	}
	public String getAddProvince() {
		return addProvince;
	}
	public void setAddProvince(String addProvince) {
		this.addProvince = addProvince;
	}
	public String getAddPostCode() {
		return addPostCode;
	}
	public void setAddPostCode(String addPostCode) {
		this.addPostCode = addPostCode;
	}
	public String getAddOriprovince() {
		return addOriprovince;
	}
	public void setAddOriprovince(String addOriprovince) {
		this.addOriprovince = addOriprovince;
	}
	
}

