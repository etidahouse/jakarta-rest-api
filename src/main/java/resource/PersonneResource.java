package resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.PersonneBusiness;
import entities.Personne;

@Path("personnes")
public class PersonneResource {

	private PersonneBusiness personneBusiness = new PersonneBusiness();

	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public Response helloWorld() {
		return Response.ok("Hello World").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPersonnes() {
		return Response.ok(personneBusiness.getAllPersonnes()).build();
	}

	@GET
	@Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonne(@PathParam("name") String name) {
		return Response.ok(personneBusiness.get(name)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPersonne(Personne personne) {
		return Response.ok(personneBusiness.add(personne)).build();
	}

}
