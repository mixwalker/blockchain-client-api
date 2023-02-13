package th.ac.rmutt.studentbecandidate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import th.ac.rmutt.candidate.Candidate;
import th.ac.rmutt.student.Student;

@Entity
@Table(name = "student_candidate")
public class StudentBCandidate {

	@Id
	@SequenceGenerator(name = "scSequence", sequenceName = "sc_id_seq", allocationSize = 1, initialValue = 15)
	@GeneratedValue(generator = "scSequence")
	@Column(name = "sc_id")
	private Integer scId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	private Student student;

	public Integer getScId() {
		return scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
