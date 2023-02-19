package th.ac.rmutt.electionwithstudent;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


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
	@Path("find_allbystudent/{Id}")
	public List<ElecWStudent> getAllByStudent(@PathParam("Id") Integer Id) {
		List<ElecWStudent> list = elecStuService.getAllByStudent(Id);
		return list;
	}
	
	@GET
	@Path("find_onvotebystudent/{Id}")
	public List<ElecWStudent> getOnVoteByStudent(@PathParam("Id") Integer Id) {
		List<ElecWStudent> list = elecStuService.getOnVoteByStudent(Id);
		return list;
	}
	
	@GET
	@Path("findbyelection/{Id}")
	public List<ElecWStudent> getByElection(@PathParam("Id") Integer Id) {
		List<ElecWStudent> list = elecStuService.getByElection(Id);
		return list;
	}
	
	@GET
	@Path("check_voted/{Id}")
	public List<ElecWStudent> checkVoted(@PathParam("Id") Integer Id) {
		List<ElecWStudent> list = elecStuService.notVoted(Id);
		return list;
	}
	
	@GET
	@Path("findByStdIdAndElecId/{studentId}/{elecId}")
	public List<ElecWStudent> getByStdIdAndElecId(@PathParam("studentId") Integer stdId,@PathParam("elecId") Integer elecId) {
		List<ElecWStudent> list = elecStuService.getByStdIdAndElecId(stdId,elecId);
		return list;
	}
	
	@POST
	@Transactional
	public Response create(ElecWStudent elecWstd) {
		Response entity = elecStuService.create(elecWstd);
		return entity;
	}
	
	@PUT
	@Path("vote/{id}")
	@Transactional
	public Response update(@PathParam("id")Integer id,ElecWStudent elecWStd) {
		Response entity = elecStuService.vote(id,elecWStd);
		return entity;
	}
}
