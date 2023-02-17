package th.ac.rmutt.electionwithcandidate;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@ApplicationScoped
public class ElecWCandidateService {

	@Inject
	EntityManager entityManager;

	public List<ElecWCandidate> get() {
		List<ElecWCandidate> list = entityManager.createQuery("from ElecWCandidate e", ElecWCandidate.class).getResultList();
		return list;
	}
	
	public List<ElecWCandidate> getByCandidate(Integer Id) {
		List<ElecWCandidate> list = entityManager
				.createQuery("from ElecWCandidate ec where ec.candidate.candiId = :Id ", ElecWCandidate.class)
				.setParameter("Id", Id).getResultList();
		return list;
	}

	public List<ElecWCandidate> getByElection(Integer Id) {
		List<ElecWCandidate> list = entityManager
				.createQuery("from ElecWCandidate ec where ec.election.elecId = :Id ", ElecWCandidate.class).setParameter("Id", Id)
				.getResultList();
		return list;
	}
	
	public List<ElecWCandidate> getCandidateApprove(Integer Id) {
		List<ElecWCandidate> list = entityManager
				.createQuery("from ElecWCandidate ec where ec.election.elecId = :Id and ec.candidate.candiStatus = 1", ElecWCandidate.class).setParameter("Id", Id)
				.getResultList();
		return list;
	}
	
	public Response create(ElecWCandidate elecWCandi) {
		if (elecWCandi.getEcId() != null) {
			elecWCandi.setEcId(null);
		}
		entityManager.persist(elecWCandi);
		return Response.status(Status.CREATED).entity(elecWCandi).build();
	}

}
