package th.ac.rmutt.candidate;

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
@Table(name = "candidate_exp")
public class CandidateExp {

	@Id
	@SequenceGenerator(name = "cexpAddSequence", sequenceName = "cexpAdd_id_seq", allocationSize = 1, initialValue = 15)
	@GeneratedValue(generator = "cexpAddSequence")
	@Column(name = "canexp_id")
	private Integer canExpId;
	@Column(length = 100, unique = false, name = "position")
	private String position;
	@Column(length = 100, unique = false, name = "years")
	private String years;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Integer getCanExpId() {
		return canExpId;
	}

	public void setCanExpId(Integer canExpId) {
		this.canExpId = canExpId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

}
