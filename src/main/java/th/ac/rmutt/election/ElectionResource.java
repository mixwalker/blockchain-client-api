package th.ac.rmutt.election;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;


@Path("election")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class ElectionResource {
	
	@Inject
	ElectionService elecService;

	@GET
	public List<Election> get() {
		List<Election> list = elecService.get();
		return list;
	}
	
	@GET
	@Path("regis_on")
	public List<Election> getRegisOn() {
		List<Election> list = elecService.getRegisOn();
		return list;
	}
	
	@GET
	@Path("on_vote")
	public List<Election> getOnVote() {
		List<Election> list = elecService.getOnVote();
		return list;
	}
	
	
	@GET
	@Path("{id}")
	public Election getSingle(@PathParam("id") Integer id) {
		Election entity = elecService.getSingle(id);
		return entity;
	}

	@POST
	@Transactional
	public Response create(Election elec) {
		Response entity = elecService.create(elec);
		return entity;
	}
	
	@PUT
	@Path("update_count")
	@Transactional
	public Response updateCount() {
		Response entity = elecService.updateCount();
		return entity;
	}
	
	@POST
	@Path("upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA + ";charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	public Response upload(@MultipartForm MultipartFormDataInput input) throws Exception {
		Response entity = elecService.upload(input);
		return entity;
	}

	@GET
	@Path("image/{fileName}")
	public Response readFile(@PathParam(value = "fileName") String fileName) throws Exception {
		Response entity = elecService.readFile(fileName);
		return entity;
	}
}
