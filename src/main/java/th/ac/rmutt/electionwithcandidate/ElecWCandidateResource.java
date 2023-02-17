package th.ac.rmutt.electionwithcandidate;

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


@Path("elec_candidate")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class ElecWCandidateResource {
	
	@Inject
	ElecWCandidateService elecCandiService;
	
	@GET
	public List<ElecWCandidate> get() {
		List<ElecWCandidate> list = elecCandiService.get();
		return list;
	}
	
	@GET
	@Path("findbycandidate/{Id}")
	public List<ElecWCandidate> getByStudent(@PathParam("Id") Integer Id) {
		List<ElecWCandidate> list = elecCandiService.getByCandidate(Id);
		return list;
	}
	
	@GET
	@Path("findbyelection/{Id}")
	public List<ElecWCandidate> getByElection(@PathParam("Id") Integer Id) {
		List<ElecWCandidate> list = elecCandiService.getByElection(Id);
		return list;
	}
	
	@GET
	@Path("findbyelectionwith_approve/{Id}")
	public List<ElecWCandidate> getByElectionWithApprove(@PathParam("Id") Integer Id) {
		List<ElecWCandidate> list = elecCandiService.getCandidateApprove(Id);
		return list;
	}
	
	@POST
	@Transactional
	public Response create(ElecWCandidate elecWCandi) {
		Response entity = elecCandiService.create(elecWCandi);
		return entity;
	}
}
