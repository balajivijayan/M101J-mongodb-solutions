package au.com.balaji;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnectionTest {

	public static void main(String[] args) {
		MongoClientOptions options = MongoClientOptions.builder()
				.connectionsPerHost(100).build();
		@SuppressWarnings("resource")
		MongoClient client = new MongoClient(new ServerAddress("localhost"),
				options);

		MongoDatabase db = client.getDatabase("test");

		System.out.println(db.getName());
		System.out.println(db.getCollection("test").count());

	}

}
