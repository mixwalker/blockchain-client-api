package th.ac.rmutt.candidate;

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

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.core.MediaType;

@Path("candidate")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class CandidateResource {

	@Inject
	CandidateService candidateService;

	@GET
	public List<Candidate> get() {	
		List<Candidate> list = candidateService.get();
		return list;
	}

	@GET
	@Path("{id}")
	public Candidate getSingle(@PathParam("id") Integer id) {
		Candidate entity = candidateService.getSingle(id);
		return entity;
	}

	@POST
	@Transactional
	public Response create(Candidate candidate) {
		Response entity = candidateService.create(candidate);
		return entity;
	}

	@POST
	@Path("upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA + ";charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	public Response upload(@MultipartForm MultipartFormDataInput input) throws Exception {
		Response entity = candidateService.upload(input);
		return entity;
	}

	@GET
	@Path("image/{fileName}")
	public Response readFile(@PathParam(value = "fileName") String fileName) throws Exception {
		Response entity = candidateService.readFile(fileName);
		return entity;
	}

}
