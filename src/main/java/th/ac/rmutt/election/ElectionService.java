package th.ac.rmutt.election;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

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
	
//	public List<Election> getOnVote() {
//		List<Election> list = entityManager.createQuery("from Election e where e.elecOnVote = true", Election.class).getResultList();
//		return list;
//	}
	
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
					.createQuery("from ElecWCandidate ec where ec.election.elecId = :Id and ec.candidate.candiStatus = 1", ElecWCandidate.class).setParameter("Id", Id)
					.getResultList();
			ls.setCountCandi(ecList.size());
		}
		return Response.ok(list).build();
	}
	
	public Response upload(@MultipartForm MultipartFormDataInput input) throws Exception {
		final Map<String, List<InputPart>> multipart = input.getFormDataMap();
		final String fileName = input.getFormDataPart("fileName", String.class, null);
		final List<InputPart> files = multipart.get("files");
		for (final InputPart inputPart : files) {
			final java.nio.file.Path tempFile = inputPart.getBody(File.class, null).toPath();
			final java.nio.file.Path file = Paths.get("src/main/assets/images/" + fileName);
			if (Files.exists(file)) {
				Files.delete(file);
			}
			Files.copy(tempFile, file);
		}
		return Response.ok().build();
	}

	public Response readFile(@PathParam(value = "fileName") String fileName) throws Exception {
		final java.nio.file.Path file = Paths.get("src/main/assets/images/" + fileName);
		if (Files.exists(file)) {
			final StreamingOutput stream = (OutputStream output) -> Files.copy(file, output);
			return Response.ok(stream).header(HttpHeaders.CONTENT_TYPE, "image/jpeg").build();
		}
		return Response.noContent().build();
	}

	}


