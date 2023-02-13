package th.ac.rmutt.studentbecandidate;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import th.ac.rmutt.electionwithstudent.ElecWStudent;

@ApplicationScoped
public class StudentBCandidateService {

	@Inject
	EntityManager entityManager;

	public List<StudentBCandidate> get() {
		List<StudentBCandidate> list = entityManager.createQuery("from StudentBCandidate sc", StudentBCandidate.class).getResultList();
		return list;
	}
	
	public List<StudentBCandidate> getByCandidate(Integer Id) {
		List<StudentBCandidate> list = entityManager
				.createQuery("from StudentBCandidate sc where sc.candidate.candiId = :Id ", StudentBCandidate.class)
				.setParameter("Id", Id).getResultList();
		return list;
	}

	public List<StudentBCandidate> getByStudent(Integer Id) {
		List<StudentBCandidate> list = entityManager
				.createQuery("from StudentBCandidate sc where sc.student.studentId = :Id ", StudentBCandidate.class).setParameter("Id", Id)
				.getResultList();
		return list;
	}
	
	public Response create(StudentBCandidate stdBCandi) {
		if (stdBCandi.getScId() != null) {
			stdBCandi.setScId(null);
		}
		entityManager.persist(stdBCandi);
		return Response.status(Status.CREATED).entity(stdBCandi).build();
	}
}
