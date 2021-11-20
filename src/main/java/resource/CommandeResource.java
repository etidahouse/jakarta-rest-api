package resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.CommandeBusiness;
import exceptions.technical.DAOException;

@Path("commandes")
public class CommandeResource {

	@Inject
	private CommandeBusiness commandeBusiness;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCommandes() throws DAOException {
		return Response.ok(commandeBusiness.getAll()).build();
	}

}
