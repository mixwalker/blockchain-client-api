package th.ac.rmutt.electionwithstudent;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import th.ac.rmutt.electionwithcandidate.ElecWCandidate;

@ApplicationScoped
public class ElecWStudentService {

	@Inject
	EntityManager entityManager;

	public List<ElecWStudent> get() {
		List<ElecWStudent> list = entityManager.createQuery("from ElecWStudent e", ElecWStudent.class).getResultList();
		return list;
	}
	
	public List<ElecWStudent> getByStudent(Integer Id) {
		List<ElecWStudent> list = entityManager
				.createQuery("from ElecWStudent es where es.student.studentId = :Id ", ElecWStudent.class)
				.setParameter("Id", Id).getResultList();
		return list;
	}

	public List<ElecWStudent> getByElection(Integer Id) {
		List<ElecWStudent> list = entityManager
				.createQuery("from ElecWStudent es where es.election.elecId = :Id ", ElecWStudent.class).setParameter("Id", Id)
				.getResultList();
		return list;
	}
	
	public Response create(ElecWStudent elecWStd) {
		if (elecWStd.getEsId() != null) {
			elecWStd.setEsId(null);
		}
		entityManager.persist(elecWStd);
		return Response.status(Status.CREATED).entity(elecWStd).build();
	}
}
