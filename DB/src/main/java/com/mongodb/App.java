package com.mongodb;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.ValidationOptions;
import com.mongodb.client.result.DeleteResult;





public class App {
		//Add item if not yet in database
		public static boolean addItem(MongoClient mongoClient, String name, double price, int units) {
			// TODO Auto-generated method stub
			MongoCollection<Document>collection=mongoClient.getDatabase("Materials").getCollection("materials");
			Document item= new Document("name", name);
            item.append("price", price);
            item.append("units", units);
        	Document current =collection.find(eq("name", item.get("name"))).first();

            try{ 
            	if(current==null) {
                    collection.insertOne(item);
            	}else {
            		System.out.println("Document " + current.get("name")+ " already exists with id "+ current.get("_id"));
            		return false;
            	}
            }catch(MongoWriteException e){
            	e.printStackTrace();
                System.out.println("Some error while inserting document");
                return false;
            }
            System.out.println("Document inserted with value of _id: " + item.get("_id"));
            return true;

		};
		//Retrieves all items matching name
		public static void retrieveAllItemsWithName(MongoClient mongoClient, String name) {
            MongoCollection < Document > collection = mongoClient.getDatabase("Materials").getCollection("materials");
            BasicDBObject searchQuery= new BasicDBObject();
            searchQuery.put("name", name);
            MongoCursor<Document>cursor=collection.find(searchQuery).iterator();
            while(cursor.hasNext()) {
            	System.out.println(cursor.next());
            }
			
		};
		//Retrieves single document given id
		public static void retrieveSingleItem(MongoClient mongoClient,String id ) {
            MongoCollection < Document > collection = mongoClient.getDatabase("Materials").getCollection("materials");
            Document document = collection.find(eq("_id", new ObjectId(id))).first();
			System.out.println(document.toJson());
					 

		};
		
		//Deletes single document given id
		public static boolean deleteItem(MongoClient mongoClient, String id) {
			 MongoCollection < Document > collection = mongoClient.getDatabase("Materials").getCollection("materials");
			 Document document = collection.find(eq("_id", new ObjectId(id))).first();
			 collection.deleteOne(eq("_id", new ObjectId(id)));
			 try {
				 if(document==null) {
					 System.out.println("Document does not exist" );
					 return false;

				 }else {
					 System.out.println("Deleting "+ document.get("name") + " with ID of " +document.get("_id") );
					 
				 }
			 }catch(MongoWriteException e){
				 e.printStackTrace();
	                System.out.println("Some error while inserting document");
	                return false;
				 
			 }
			 System.out.println("Document deleted successfully");
	            return true;
			
		}
		
		//Updates item given id, newName, newPrice, and newUnits
		public static boolean UpdateItem(MongoClient mongoClient, String id, String newName, double newPrice, int newUnits) {
			MongoDatabase db = mongoClient.getDatabase("Materials");
            MongoCollection < Document > collection = mongoClient.getDatabase("Materials").getCollection("materials");
			BasicDBObject query = new BasicDBObject();
			query.put("_id", new ObjectId(id)); // (1)
			 Document document = collection.find(query).first();


			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("name", newName); // (2)
			newDocument.put("price", newPrice); // (2)
			newDocument.put("price", newUnits); // (2)

			BasicDBObject updateObject = new BasicDBObject();
			updateObject.put("$set", newDocument); // (3)

			
			
			try {
				 if(document==null) {
					 System.out.println("Document does not exist" );
					 return false;

				 }else {
					 
					db.getCollection("materials").updateOne(query, updateObject); // (4)
					 System.out.println("Updating "+ document.get("name") + " with ID of " +document.get("_id") );
					 
				 }
			 }catch(MongoWriteException e){
				 e.printStackTrace();
	                System.out.println("Some error while updating document");
	                return false;
				 
			 }
			 System.out.println("Document updated successfully");
	            return true;
			
		}

	//Drives main program after connecting to Mongo Atlas in the cloud
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger.getLogger("org.mongobd.driver").setLevel(Level.WARNING);
		String connectionString= "mongodb+srv://jag:Golden@javafinalproject.lo0sy.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
		MongoClient mongoClient = MongoClients.create(connectionString);
		addItem(mongoClient, "Double X brackets",0.20, 10);
//		retrieveSingleItem(mongoClient,"60f597aa38f2f86659502d58");
//		UpdateItem(mongoClient,"60f5983bfb92701f03e9329f","Cross-Tilt head flip screws",0.10, 30);
//		retrieveSingleItem(mongoClient,"60f5983bfb92701f03e9329f");
//		retrieveAllItemsWithName(mongoClient, "L brackets");
//		deleteItem(mongoClient, "60f599e485e517138154f40f"); 

			
		}
	}
