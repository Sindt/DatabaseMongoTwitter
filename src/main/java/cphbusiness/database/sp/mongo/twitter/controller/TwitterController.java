package cphbusiness.database.sp.mongo.twitter.controller;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoCursor;

import cphbusiness.database.sp.mongo.twitter.boundary.TwitterService;

@Stateless
public class TwitterController {

	private TwitterService service = new TwitterService();

	private Gson gson = new Gson();

	public TwitterController() {
	}

	public ResponseBuilder getCountAllUsers() {

		try {
			int users = service.getAllUsers();
			String json = gson.toJson(users);

			return Response.status(Status.OK).entity("All User count = " + json);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage());
		}
	}

	public ResponseBuilder getActiveUsers() {
		try {
			ArrayList<String> users = service.getMostActiveUsers();
			String json = gson.toJson(users);

			return Response.status(Status.OK).entity("Most active user = " + json);
		} catch (Exception e) {
			return null;
		}
	}

	public ResponseBuilder getNegativeUsers() {
		try {
			ArrayList<String> users = service.getMostGrumpyUsers();
			String json = gson.toJson(users);
			return Response.status(Status.OK).entity("Most negative users = " + json);
		} catch (Exception e) {
			return null;
		}
	}

	public ResponseBuilder getPositiveUsers() {
		try {
			ArrayList<String> users = service.getMostPositiveUsers();
			String json = gson.toJson(users);
			return Response.status(Status.OK).entity("Most Positive users =" + json);
		} catch (Exception e) {
			return null;
		}
	}

}
