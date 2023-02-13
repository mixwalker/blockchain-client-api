package th.ac.rmutt.electionwithstudent;

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

import th.ac.rmutt.electionwithcandidate.ElecWCandidate;



@Path("elec_student")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class ElecWStudentResource {
	
	@Inject
	ElecWStudentService elecStuService;
	
	@GET
	public List<ElecWStudent> get() {
		List<ElecWStudent> list = elecStuService.get();
		return list;
	}
	
	@GET
	@Path("findbystudent/{Id}")
	public List<ElecWStudent> getByStudent(@PathParam("Id") Integer Id) {
		List<ElecWStudent> list = elecStuService.getByStudent(Id);
		return list;
	}
	
	@GET
	@Path("findbyelection/{Id}")
	public List<ElecWStudent> getByElection(@PathParam("Id") Integer Id) {
		List<ElecWStudent> list = elecStuService.getByElection(Id);
		return list;
	}
	
	@POST
	@Transactional
	public Response create(ElecWStudent elecWstd) {
		Response entity = elecStuService.create(elecWstd);
		return entity;
	}
}
