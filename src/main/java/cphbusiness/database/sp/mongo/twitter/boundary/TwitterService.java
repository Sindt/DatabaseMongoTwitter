package cphbusiness.database.sp.mongo.twitter.boundary;

import java.util.Arrays;
import java.util.regex.Pattern;

import javax.ejb.Stateless;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import javax.inject.Named;

@Named
@Stateless
public class TwitterService {

	public TwitterService() {
	}

	private final MongoClient mongoClient = new MongoClient("localhost", 27017);
	private final MongoDatabase database = mongoClient.getDatabase("social_net");
	private final MongoCollection<Document> collection = database.getCollection("tweets");

	public MongoCursor<String> getAllUsers() {
		return collection.distinct("user", String.class).iterator();
	}

	public MongoCursor<Document> getUsersWithMostLinks() {
		return collection.aggregate(Arrays.asList(Aggregates.match(Filters.eq("text", Pattern.compile("@\\w+\\"))))).iterator();
	}

}
