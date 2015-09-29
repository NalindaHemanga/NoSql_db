package my_abc_onlineBookStore;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;


public class Neo4jInputDataApi {
	public static GraphDatabaseFactory dbFactory= new GraphDatabaseFactory();
	public static GraphDatabaseService db_my = dbFactory.newEmbeddedDatabase("C:/neo4jDB1");
	
	public void createdb(Invoice invoice){
		int i;
		
		try (Transaction tx = db_my.beginTx()) {

			System.out.println(invoice.C_Name);
			Node CustomerNode = db_my.createNode(neo4jLabels.Cu_1);
			
			CustomerNode.setProperty("Name", invoice.C_Name);
			CustomerNode.setProperty("Code", invoice.C_Code);
			
			Node InvoiceNode = db_my.createNode(neo4jLabels.I_2);
			InvoiceNode.setProperty("id", invoice.I_ID);
			InvoiceNode.setProperty("date", invoice.I_Date);
			
			for(i=0;i<invoice.B_Code.length;i++){
				Node BookNode = db_my.createNode(neo4jLabels.B1);
				BookNode.setProperty("B.Code",invoice.B_Code[i]);
				BookNode.setProperty("B.Name",invoice.B_Name[i]);
				BookNode.setProperty("B.Cat.Code",invoice.B_Cat_Code[i]);
				BookNode.setProperty("B.Cat.Name",invoice.B_Cat_Name[i]);
				BookNode.setProperty("Price",invoice.Price[i]);
				
				
				Relationship relationship1 = InvoiceNode.createRelationshipTo(BookNode,neo4jRelationships.INVOICE_COLLECT_BOOK);
				relationship1.setProperty("Quantity",invoice.Quantity[i]);
				relationship1.setProperty("Amount",invoice.Amount[i]);
			
		}
			Relationship relationship2 = CustomerNode.createRelationshipTo(InvoiceNode,neo4jRelationships.SHOW_INVOICE);
			relationship2.setProperty("GrossTotal",invoice.G_Total);
			relationship2.setProperty("Discount",invoice.Discount);
			relationship2.setProperty("NetTotal",invoice.N_Total);
			
			tx.success();
			System.out.print("Sucessfully connected with neo4j");
		}
		
	}

}
