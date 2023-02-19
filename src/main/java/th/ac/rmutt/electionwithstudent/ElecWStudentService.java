package th.ac.rmutt.electionwithstudent;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@ApplicationScoped
public class ElecWStudentService {

	@Inject
	EntityManager entityManager;

	public List<ElecWStudent> get() {
		List<ElecWStudent> list = entityManager.createQuery("from ElecWStudent e", ElecWStudent.class).getResultList();
		return list;
	}
	
	public List<ElecWStudent> getAllByStudent(Integer Id) {
		List<ElecWStudent> list = entityManager
				.createQuery("from ElecWStudent es where es.student.studentId = :Id", ElecWStudent.class)
				.setParameter("Id", Id).getResultList();
		return list;
	}
	
	public List<ElecWStudent> getOnVoteByStudent(Integer Id) {
		List<ElecWStudent> list = entityManager
				.createQuery("from ElecWStudent es where es.student.studentId = :Id and es.election.elecOnVote = true", ElecWStudent.class)
				.setParameter("Id", Id).getResultList();
		return list;
	}

	public List<ElecWStudent> getByElection(Integer Id) {
		List<ElecWStudent> list = entityManager
				.createQuery("from ElecWStudent es where es.election.elecId = :Id ", ElecWStudent.class).setParameter("Id", Id)
				.getResultList();
		return list;
	}
	
	public List<ElecWStudent> getByStdIdAndElecId(Integer studentId,Integer elecId) {
		List<ElecWStudent> list = entityManager
				.createQuery("from ElecWStudent es where es.election.elecId = :elecId and es.student.studentId = :studentId ", ElecWStudent.class)
				.setParameter("elecId", elecId).setParameter("studentId", studentId).getResultList();
		return list;
	}
	
	public List<ElecWStudent> notVoted(Integer Id) {
		List<ElecWStudent> entity = entityManager.createQuery("from ElecWStudent es where es.esId = :Id and es.Voted = false", ElecWStudent.class).setParameter("Id", Id)
				.getResultList();
		return entity;
	}
	
	public Response create(ElecWStudent elecWStd) {
		if (elecWStd.getEsId() != null) {
			elecWStd.setEsId(null);
		}
		elecWStd.setVoted(false);
		entityManager.persist(elecWStd);
		return Response.status(Status.CREATED).entity(elecWStd).build();
	}
	
	public Response vote(Integer Id,ElecWStudent elecWStd) {
		ElecWStudent entity = entityManager.find(ElecWStudent.class, Id);
		if (entity == null) {
			throw new WebApplicationException("ElecWStudent with id of " + Id + " does not exist.", Status.NOT_FOUND);
		}
		if(entity.getVoted() != false) {
			throw new WebApplicationException("your have voted",Status.BAD_REQUEST);
		}
		entity.setVoted(elecWStd.getVoted());
		return Response.ok(entity).build();
	}
}
