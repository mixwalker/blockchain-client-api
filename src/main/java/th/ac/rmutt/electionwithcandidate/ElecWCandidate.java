package th.ac.rmutt.electionwithcandidate;

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
import th.ac.rmutt.election.Election;


@Entity
@Table(name = "election_candidate")
public class ElecWCandidate {

	@Id
	@SequenceGenerator(name = "ecSequence", sequenceName = "ec_id_seq", allocationSize = 1, initialValue = 15)
	@GeneratedValue(generator = "ecSequence")
	@Column(name = "ec_id")
	private Integer ecId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "elec_id")
	private Election election;

	public Integer getEcId() {
		return ecId;
	}

	public void setEcId(Integer ecId) {
		this.ecId = ecId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}
	
	
}
