package cphbusiness.database.sp.mongo.twitter.boundary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.ejb.Stateless;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import javax.inject.Named;

@Stateless
public class TwitterService {

	public TwitterService() {
	}

	private final MongoClient mongoClient = new MongoClient("localhost", 27017);
	private final MongoDatabase database = mongoClient.getDatabase("social_net");
	private final MongoCollection<Document> collection = database.getCollection("tweets");

	public int getAllUsers() {
		int count;
		try (MongoCursor<Document> c = collection
				.aggregate((Arrays.asList(new BasicDBObject("$group",
						new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1))))))
				.iterator()) {
			count = 0;
			while (c.hasNext()) {
				count++;
				c.next();
			}
		}

		return count;
	}

	public ArrayList<String> getMostActiveUsers() {
		ArrayList<String> result = new ArrayList();
		try (MongoCursor<Document> c = collection
				.aggregate(
						(Arrays.asList(
								new BasicDBObject("$group",
										new BasicDBObject("_id", "$user").append("count",
												new BasicDBObject("$sum", 1))),
								new BasicDBObject("$sort", new BasicDBObject("count", -1)),
								new BasicDBObject("$limit", 10))))
				.iterator()) {

			while (c.hasNext()) {

				Document d = c.next();

				result.add(d.get("_id").toString());
			}
		}

		return result;
	}

	public ArrayList<String> getMostGrumpyUsers() {
		ArrayList<String> result = new ArrayList();
		try (MongoCursor<Document> c = collection
				.aggregate((Arrays.asList(new BasicDBObject("$match", new BasicDBObject("polarity", 0)),
						new BasicDBObject("$group",
								new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1))),
						new BasicDBObject("$sort", new BasicDBObject("count", -1)), new BasicDBObject("$limit", 5))))
				.iterator()) {

			while (c.hasNext()) {

				Document d = c.next();

				result.add(d.get("_id").toString());
			}
		}

		return result;
	}

	public ArrayList<String> getMostPositiveUsers() {
		ArrayList<String> result = new ArrayList();
		try (MongoCursor<Document> c = collection
				.aggregate((Arrays.asList(new BasicDBObject("$match", new BasicDBObject("polarity", 4)),
						new BasicDBObject("$group",
								new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1))),
						new BasicDBObject("$sort", new BasicDBObject("count", 1)), new BasicDBObject("$limit", 5))))
				.iterator()) {

			while (c.hasNext()) {

				Document d = c.next();

				result.add(d.get("_id").toString());
			}
		}

		return result;
	}
}
