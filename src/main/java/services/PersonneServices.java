package resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.PersonneBusiness;
import entities.Personne;

@Path("personnes")
public class PersonneServices {

	@Inject
	private PersonneBusiness personneBusiness;

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
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonne(@PathParam("id") long id) {
		return Response.ok(personneBusiness.get(id)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPersonne(Personne personne) {
		personneBusiness.add(personne);
		return Response.noContent().build();
	}

	@DELETE
	@Path("{id}")
	public Response deletePersonne(@PathParam("id") long id) {
		personneBusiness.delete(id);
		return Response.noContent().build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePersonne(@PathParam("id") long id, Personne personne) {
		personneBusiness.update(personne);
		return Response.noContent().build();
	}
	
	@GET
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchPersonne(@QueryParam("name") String name) {
		return Response.ok(personneBusiness.search(name)).build();
	}
	
}
