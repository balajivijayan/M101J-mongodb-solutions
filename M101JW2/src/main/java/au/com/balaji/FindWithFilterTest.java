package au.com.balaji;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.or;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class FindWithFilterTest {

	public static void main(String[] args) {
		MongoClient client = new MongoClient();
		try {
			MongoDatabase db = client.getDatabase("test");
			MongoCollection<Document> collection = db.getCollection("filterTest");
			collection.drop();
			
			for (int i = 0; i < 10; i++) {
				collection.insertOne(new Document("x", i).append("y", i + 3));
			}
			
			//Bson filter = new Document("x", 5).append("y", new Document("$gte", 8));
			Bson filter = or(eq("x", 0), gt("y", 5));
			System.out.println(filter);
			
			
			System.out.println("Find all:");
			List<Document> all = collection.find().filter(filter).into(new ArrayList<Document>());
			for (Document document : all) {
				System.out.println(document);
			}
			
			System.out.println("Count:");
			System.out.println(collection.count(filter));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.close();
		}

	}

}
