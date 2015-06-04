package au.com.balaji;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class FindTest {

	public static void main(String[] args) {
		MongoClient client = null;
		MongoCursor<Document> cursor = null;
		
		try {
			client = new MongoClient();
			MongoDatabase db = client.getDatabase("test");
			MongoCollection<Document> collection = db.getCollection("findTest");
			collection.drop();
			
			//insert 10 documents
			for (int i = 0; i < 10; i++) {
				collection.insertOne(new Document("x", i));
			}
			System.out.println("Find One:");
			System.out.println(collection.find().first());
			
			System.out.println("Find all wiht into:");
			List<Document> all = collection.find().into(new ArrayList<Document>());
			for ( Document document : all) {
				System.out.println(document);
			}
			
			System.out.println("Find all with iteration:");
			cursor = collection.find().iterator();
			
			while(cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			
			System.out.println("Count:");
			System.out.println(collection.count());
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.close();
			cursor.close();
		}
		
	}

}
