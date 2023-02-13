package th.ac.rmutt.candidate;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.io.OutputStream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.core.HttpHeaders;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@ApplicationScoped
public class CandidateService {
	
	@Inject
	EntityManager entityManager;

	public List<Candidate> get() {
		List<Candidate> list = entityManager.createQuery("from Candidate c", Candidate.class).getResultList();
		return list;
	}
	
	public Candidate getSingle(Integer id) {
		Candidate entity = entityManager.find(Candidate.class, id);

		if (entity == null) {
			throw new WebApplicationException("Candidate with id of " + id + " does not exist.", Status.NOT_FOUND);
		}
		return entity;
	}

	public Response create(Candidate candidate) {
		if(candidate.getCandiId() != null) {
			candidate.setCandiId(null);
		}
		for(CandidateExp candiExp:candidate.getCandiExpList()) {
			createCandiExp(candiExp,candidate);
		}
		entityManager.persist(candidate);
		return Response.status(Status.CREATED).entity(candidate).build();
	}
	
	private CandidateExp createCandiExp (CandidateExp candiExp,Candidate candidate) {
		if(candiExp.getCanExpId() != null) {
			candiExp.setCanExpId(null);
		}
		candiExp.setCandidate(candidate);
		candiExp.setPosition(candiExp.getPosition());
		candiExp.setYears(candiExp.getYears());
		entityManager.persist(candiExp);
		return candiExp;
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
            return Response.ok(stream)
                    .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                    .build();
        }
        return Response.noContent().build();
    }
	
}
