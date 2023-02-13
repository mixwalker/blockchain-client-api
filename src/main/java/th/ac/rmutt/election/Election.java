package th.ac.rmutt.election;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "election")
public class Election {

	@Id
	@SequenceGenerator(name = "elecSequence", sequenceName = "elec_id_seq", allocationSize = 1, initialValue = 15)
	@GeneratedValue(generator = "elecSequence")
	@Column(name = "elec_id")
	private Integer elecId;
	
	@Column(length = 255, unique = false, name = "elec_name")
	private String elecName;
	@Column(length = 255, unique = false, name = "elec_detail")
	private String elecDetail;
	@Column(unique = false, name = "elec_startdate")
	private Date elecStartdate;
	@Column(unique = false, name = "elec_enddate")
	private Date elecEnddate;
	@Column(unique = false, name = "elec_status")
	private Integer elecStatus;
	@Column(length = 3, unique = false, name = "elec_countcandi")
	private Integer countCandi;
	@Column(unique = false, name = "elec_register")
	private Boolean elecRegister;
	
	
	
	public Integer getElecId() {
		return elecId;
	}
	public void setElecId(Integer elecId) {
		this.elecId = elecId;
	}
	public String getElecName() {
		return elecName;
	}
	public void setElecName(String elecName) {
		this.elecName = elecName;
	}
	public String getElecDetail() {
		return elecDetail;
	}
	public void setElecDetail(String elecDetail) {
		this.elecDetail = elecDetail;
	}
	public Date getElecStartdate() {
		return elecStartdate;
	}
	public void setElecStartdate(Date elecStartdate) {
		this.elecStartdate = elecStartdate;
	}
	public Date getElecEnddate() {
		return elecEnddate;
	}
	public void setElecEnddate(Date elecEnddate) {
		this.elecEnddate = elecEnddate;
	}
	public Integer getElecStatus() {
		return elecStatus;
	}
	
	public void setElecStatus(Integer elecStatus) {
		this.elecStatus = elecStatus;
	}
	public Integer getCountCandi() {
		return countCandi;
	}
	public void setCountCandi(Integer countCandi) {
		this.countCandi = countCandi;
	}
	public Boolean getElecRegister() {
		return elecRegister;
	}
	public void setElecRegister(Boolean elecRegister) {
		this.elecRegister = elecRegister;
	}
	
	
}
