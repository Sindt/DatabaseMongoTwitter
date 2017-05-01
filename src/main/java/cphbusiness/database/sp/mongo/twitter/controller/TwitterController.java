package cphbusiness.database.sp.mongo.twitter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.bson.Document;

import com.mongodb.client.MongoCursor;

import cphbusiness.database.sp.mongo.twitter.boundary.TwitterService;

@Stateless
public class TwitterController {

	private TwitterService service = new TwitterService();

	public TwitterController() {
	}

	public ResponseBuilder getCountAllUsers() {

		try {
			MongoCursor<String> users = service.getAllUsers();
			List<String> userList = new ArrayList();
			while (users.hasNext()) {
				userList.add(users.next());
			}
			return Response.status(Status.OK).entity(userList.size());
		} catch (Exception e) {
			return null;
		}
	}

	public ResponseBuilder getUsersWithMostLinks() {
		try {
			MongoCursor<Document> users = service.getUsersWithMostLinks();
			return Response.status(Status.OK).entity(users);
		} catch (Exception e) {
			return null;
		}
	}

	public ResponseBuilder getMentionedUsers() {
		try {
			MongoCursor<String> users = service.getAllUsers();
			return Response.status(Status.OK).entity(users);
		} catch (Exception e) {
			return null;
		}
	}

	public ResponseBuilder getActiveUsers() {
		try {
			MongoCursor<String> users = service.getAllUsers();
			return Response.status(Status.OK).entity(users);
		} catch (Exception e) {
			return null;
		}
	}

	public ResponseBuilder getNegativeUsers() {
		try {
			MongoCursor<String> users = service.getAllUsers();
			return Response.status(Status.OK).entity(users);
		} catch (Exception e) {
			return null;
		}
	}

	public ResponseBuilder getPositiveUsers() {
		try {
			MongoCursor<String> users = service.getAllUsers();
			return Response.status(Status.OK).entity(users);
		} catch (Exception e) {
			return null;
		}
	}

}
