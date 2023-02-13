package th.ac.rmutt.studentbecandidate;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import th.ac.rmutt.electionwithstudent.ElecWStudent;


@Path("student_candidate")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class StudentBCandidateResource {
	
	@Inject
	StudentBCandidateService stCandiService;
	
	@GET
	public List<StudentBCandidate> get() {
		List<StudentBCandidate> list = stCandiService.get();
		return list;
	}
	
	@GET
	@Path("findbycandidate/{Id}")
	public List<StudentBCandidate> getByCandidate(@PathParam("Id") Integer Id) {
		List<StudentBCandidate> list = stCandiService.getByCandidate(Id);
		return list;
	}
	
	@GET
	@Path("findbystudent/{Id}")
	public List<StudentBCandidate> getByStudent(@PathParam("Id") Integer Id) {
		List<StudentBCandidate> list = stCandiService.getByStudent(Id);
		return list;
	}
	
	@POST
	@Transactional
	public Response create(StudentBCandidate stdBCandi) {
		Response entity = stCandiService.create(stdBCandi);
		return entity;
	}
}
