package th.ac.rmutt.student;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@ApplicationScoped
public class StudentService {

	@Inject
	EntityManager entityManager;

	public List<Student> get() {
		List<Student> list = entityManager.createQuery("from Student s", Student.class).getResultList();
		return list;
	}
	
	public Student getSingle(Integer id) {
		Student entity = entityManager.find(Student.class, id);

		if (entity == null) {
			throw new WebApplicationException("Student with id of " + id + " does not exist.", Status.NOT_FOUND);
		}
		return entity;
	}

	public Response create(Student student) {
		entityManager.persist(student);
		return Response.status(Status.CREATED).entity(student).build();
	}
	
	public Response login(Student student) {
		Student entity = entityManager.createQuery("FROM Student WHERE studentCode = :student_code and password = :password", Student.class)
                .setParameter("student_code", student.getStudentCode())
                .setParameter("password", student.getPassword())
                .getSingleResult();
		if(entity == null) {
			 throw new WebApplicationException("studentCode or password incorrect.",
	                    Status.NOT_FOUND);
		}
		return Response.ok(entity).build();
	}
}
