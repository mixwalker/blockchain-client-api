package th.ac.rmutt.student;

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

@Path("student")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class StudentResource {
	@Inject
	StudentService studentService;

	@GET
	public List<Student> get() {
		List<Student> list = studentService.get();
		return list;
	}
	
	@GET
	@Path("{id}")
	public Student getSingle(@PathParam("id") Integer id) {
		Student entity = studentService.getSingle(id);
		return entity;
	}

	@POST
	@Transactional
	public Response create(Student student) {
		Response entity = studentService.create(student);
		return entity;
	}
	
	@POST
	@Transactional
	@Path("login")
	public Response login(Student student) {
		Response entity = studentService.login(student);
		return entity;
	}
}	
