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
				.createQuery("from ElecWCandidate es where es.candidate.candiId = :Id ", ElecWCandidate.class)
				.setParameter("Id", Id).getResultList();
		return list;
	}

	public List<ElecWCandidate> getByElection(Integer Id) {
		List<ElecWCandidate> list = entityManager
				.createQuery("from ElecWCandidate es where es.election.elecId = :Id ", ElecWCandidate.class).setParameter("Id", Id)
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
