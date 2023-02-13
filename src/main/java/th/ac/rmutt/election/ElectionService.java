package th.ac.rmutt.election;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import th.ac.rmutt.electionwithcandidate.ElecWCandidate;


@ApplicationScoped
public class ElectionService {
	
	@Inject
	EntityManager entityManager;

	public List<Election> get() {
		List<Election> list = entityManager.createQuery("from Election e", Election.class).getResultList();
		return list;
	}
	
	public List<Election> getRegisOn() {
		List<Election> list = entityManager.createQuery("from Election e where e.elecRegister = true", Election.class).getResultList();
		return list;
	}
	
	public Election getSingle(Integer id) {
		Election entity = entityManager.find(Election.class, id);
		if (entity == null) {
			throw new WebApplicationException("Election with id of " + id + " does not exist.", Status.NOT_FOUND);
		}
		return entity;
	}


	public Response create(Election election) {
		entityManager.persist(election);
		return Response.status(Status.CREATED).entity(election).build();
	}
	
	public Response updateCount() {
		List<Election> list = entityManager.createQuery("from Election e", Election.class).getResultList();
		for(Election ls:list) {
			int Id = ls.getElecId();
			List<ElecWCandidate> ecList = entityManager
					.createQuery("from ElecWCandidate es where es.election.elecId = :Id ", ElecWCandidate.class).setParameter("Id", Id)
					.getResultList();
			ls.setCountCandi(ecList.size());
		}
		return Response.ok(list).build();
	}
	
	

	}
