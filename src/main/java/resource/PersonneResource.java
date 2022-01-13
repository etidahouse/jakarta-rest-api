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
import exceptions.technical.DAOException;

@Path("personnes")
public class PersonneResource {

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
		try {
			return Response.ok(personneBusiness.getAllPersonnes()).build();
		} catch (DAOException e) {
			return Response.status(500, e.getMessage()).build();
		}
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonne(@PathParam("id") long id) {
		try {
			return Response.ok(personneBusiness.get(id)).build();
		} catch (DAOException e) {
			return Response.status(500, e.getMessage()).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPersonne(Personne personne) {
		try {
			return Response.ok(personneBusiness.add(personne)).build();
		} catch (DAOException e) {
			return Response.status(500, e.getMessage()).build();
		}
	}

	@DELETE
	@Path("{id}")
	public Response deletePersonne(@PathParam("id") long id) {
		System.out.println("HELOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + id);
		try {
			personneBusiness.delete(id);
		} catch (DAOException e) {
			return Response.status(500, e.getMessage()).build();
		}
		return Response.noContent().build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePersonne(@PathParam("id") long id, Personne personne) {
		personne.setId(id);
		try {
			return Response.ok(personneBusiness.update(personne)).build();
		} catch (DAOException e) {
			return Response.status(500, e.getMessage()).build();
		}
	}
	
	@GET
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchPersonne(@QueryParam("name") String name) {
		try {
			return Response.ok(personneBusiness.search(name)).build();
		} catch (DAOException e) {
			return Response.status(500, e.getMessage()).build();
		}
	}
	
}
