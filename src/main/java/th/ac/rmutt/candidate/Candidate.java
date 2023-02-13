package th.ac.rmutt.candidate;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "candidate")
public class Candidate {

	@Id
	@SequenceGenerator(name = "candiSequence", sequenceName = "candi_id_seq", allocationSize = 1, initialValue = 15)
	@GeneratedValue(generator = "candiSequence")
	@Column(name = "candidate_id")
	private Integer candiId;
	@Column(length = 3, unique = false, name = "candi_no")
	private String candiNo;
	@Column(length = 100, unique = false, name = "candi_party")
	private String candiParty;
	@Column(length = 100, unique = false, name = "candi_image")
	private String candiImage;
	@Column(length = 1, unique = false, name = "candi_status")
	private String candiStatus;
	@Column(unique = false, name = "candi_regisdate")
	private Date regisDate;
	
	@OneToMany(
			fetch = FetchType.EAGER,
			mappedBy = "candidate",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<CandidateExp> candiExpList;
	
	
	public Integer getCandiId() {
		return candiId;
	}
	public void setCandiId(Integer candiId) {
		this.candiId = candiId;
	}
	
	public String getCandiNo() {
		return candiNo;
	}
	public void setCandiNo(String candiNo) {
		this.candiNo = candiNo;
	}
	
	public String getCandiParty() {
		return candiParty;
	}
	public void setCandiParty(String candiParty) {
		this.candiParty = candiParty;
	}
	public String getCandiImage() {
		return candiImage;
	}
	public void setCandiImage(String candiImage) {
		this.candiImage = candiImage;
	}
	public Date getRegisDate() {
		return regisDate;
	}
	public void setRegisDate(Date regisDate) {
		this.regisDate = regisDate;
	}
	public List<CandidateExp> getCandiExpList() {
		return candiExpList;
	}
	public void setCandiExpList(List<CandidateExp> candiExpList) {
		this.candiExpList = candiExpList;
	}
	public String getCandiStatus() {
		return candiStatus;
	}
	public void setCandiStatus(String candiStatus) {
		this.candiStatus = candiStatus;
	}
	
	
	
	
	
}
