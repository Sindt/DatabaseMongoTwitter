package cphbusiness.database.sp.mongo.twitter.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import cphbusiness.database.sp.mongo.twitter.controller.TwitterController;

@Stateless
@Path("twitter")
@Produces(MediaType.APPLICATION_JSON)
public class TwitterResource {

	@Context
	UriInfo uriInfo;

	@Inject
	private TwitterController controller;
	
	@GET
	@Path("count")
	public Response getCountAllUsers() {
		return controller.getCountAllUsers().build();
	}

	@GET
	@Path("links")
	public Response getLinksUsers() {
		return controller.getUsersWithMostLinks().build();
	}

	@GET
	@Path("mentioned")
	public Response getMentionedUsers() {
		return controller.getMentionedUsers().build();
	}

	@GET
	@Path("active")
	public Response getActiveUsers() {
		return controller.getActiveUsers().build();
	}

	@GET
	@Path("negative")
	public Response getNegativeUsers() {
		return controller.getNegativeUsers().build();
	}

	@GET
	@Path("positive")
	public Response getPositiveUsers() {
		return controller.getPositiveUsers().build();
	}

}
