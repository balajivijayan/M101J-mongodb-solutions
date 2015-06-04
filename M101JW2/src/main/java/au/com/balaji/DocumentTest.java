package au.com.balaji;

import java.util.Arrays;
import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;

public class DocumentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Document doc = new Document();

		doc.append("string", "Hello MongoDB")
				.append("int", 1)
				.append("long", 1L)
				.append("float", 2.0)
				.append("boolean", true)
				.append("Date", new Date())
				.append("object_id", new ObjectId())
				.append("null", null)
				.append("embeddedDoc",
						new Document().append("str",
								"I'm a document inside a document"))
				.append("list", Arrays.asList(1, 2, 3, 4));

		System.out.println(doc.toJson());

		System.out.println("Getting String from document "
				+ doc.getString("string"));
		System.out.println("Getting object id from document "
				+ doc.getObjectId("object_id"));
		System.out.println("Getting embedded doc from documetnt "
				+ doc.get("embeddedDoc"));
		System.out.println("Getting Arrays from document " + doc.get("list"));

	}
}
