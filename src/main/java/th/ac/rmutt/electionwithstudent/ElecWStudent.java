package th.ac.rmutt.electionwithstudent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import th.ac.rmutt.election.Election;
import th.ac.rmutt.student.Student;


@Entity
@Table(name = "election_student")
public class ElecWStudent {

	@Id
	@SequenceGenerator(name = "esSequence", sequenceName = "es_id_seq", allocationSize = 1, initialValue = 15)
	@GeneratedValue(generator = "esSequence")
	@Column(name = "es_id")
	private Integer esId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "elec_id")
	private Election election;

	public Integer getEsId() {
		return esId;
	}

	public void setEsId(Integer esId) {
		this.esId = esId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}
	
	
}
