package my_abc_onlineBookStore;

import com.mongodb.MongoClient;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;


public class MongoDbInvoiceInputApi {
	public void createdb(Invoice invoice){
		int i;
		try{ 
			// To connect to mongodb server
				MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
				DB db = mongoClient.getDB( "ABC_BookShop" );
				DBCollection collection = db.getCollection("Invoices");
				BasicDBObject document = new BasicDBObject();
				document.put("Name", invoice.C_Name);
				document.put("Code", invoice.C_Code);
				document.put("invoice_id", invoice.I_ID);
				document.put("date", invoice.I_Date);
				for(i=0;i<invoice.B_Code.length;i++){
					document.put("Book"+(i+1)+"-> B_Code",invoice.B_Code[i]);
					document.put("Book"+(i+1)+"-> B_Name",invoice.B_Name[i]);
					document.put("Book"+(i+1)+"-> B_Cat_Code",invoice.B_Cat_Code[i]);
					document.put("Book"+(i+1)+"-> B_Cat_Name",invoice.B_Cat_Name[i]);
					document.put("Book"+(i+1)+"-> Price",invoice.Price[i]);
					document.put("Book"+(i+1)+"-> Quantity",invoice.Quantity[i]);
					document.put("Book"+(i+1)+"-> Amount",invoice.Amount[i]);
				}

				collection.insert(document);

				DBCursor cursorDoc = collection.find();
				while (cursorDoc.hasNext()) {
					System.out.println(cursorDoc.next());
				}
				//collection.remove(new BasicDBObject());  //to remove collection
				
			}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			}
	}

}
