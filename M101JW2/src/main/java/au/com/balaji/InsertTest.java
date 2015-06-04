package au.com.balaji;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertTest {

	public static void main(String[] args) {
		MongoClient client = null;
		try {
			client = new MongoClient();
			MongoDatabase db = client.getDatabase("test");
			MongoCollection<Document> coll = db.getCollection("insertTest");
			coll.drop();

			Document smith = new Document().append("name", "Smith")
					.append("age", 30).append("profession", "hacker");
			Document jones = new Document().append("name", "Jones")
					.append("age", 28).append("profession", "developer");
			System.out.println(smith);
			System.out.println(jones);
			coll.insertMany(Arrays.asList(smith, jones));
			// Object ID is added by the driver after insert.
			System.out.println(smith);
			System.out.println(jones);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.close();
		}

	}

}
