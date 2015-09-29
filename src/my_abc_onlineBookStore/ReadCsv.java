package my_abc_onlineBookStore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsv  {
	
  public static void main(String[] args) {
	
	
	ReadCsv obj = new ReadCsv();
	obj.run();

  }

  public void run() {

	String csvFile = "C:/Users/Pushpika/Desktop/invo.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	String C_Code,C_Name,I_Date,G_Total,Discount,N_Total,I_ID;
	
	String []Array_name ={"C.Code","C.Name","I.Date","B.Code","B.name","B.Cat.Code","B.Cat.Name","Quantity","Price","Amount","G.Total","Discount","N.total","I.ID"};
	try {

		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {

		        // use comma as separator
			String[] country = line.split(cvsSplitBy);

			System.out.println("Invoice Details [ "+ Array_name[0]+" = "+ country[0]+ " , "+ Array_name[1]+ " = "+ country[1]+ " , "+ Array_name[3]+ " = "+ country[3]+
					" , "+ Array_name[4]+ " = "+ country[4]+ " , "+ Array_name[5]+ " = "+ country[5]+ " , "+ Array_name[6]+  " = "+ country[6]+ 
					" , "+ Array_name[7]+ " = "+ country[7]+ " , "+ Array_name[8]+ " = "+ country[8]+ " , "+ Array_name[9]+  " = "+ country[9]+ 
					" , "+ Array_name[10]+" = "+country[10]+ " , "+ Array_name[11]+" = "+ country[11]+ " , "+ Array_name[12]+" = "+ country[12]+ " , "+ Array_name[13]+" = "+ country[13]+ 
					"]");
			//count : signs
			C_Code = country[0];
			C_Name = country[1];
			I_Date = country[2];
			G_Total = country[10];
			Discount = country[11];
			N_Total = country[12];
			I_ID = country[13];
			String[] B_Code =country[3].split(":");
			String[] B_Name =country[4].split(":");
			String[] B_Cat_Code =country[5].split(":");
			String[] B_Cat_Name =country[6].split(":");
			String[] Quantity =country[7].split(":");
			String[] Price =country[8].split(":");
			String[] Amount =country[9].split(":");
			//System.out.println(B_Code[0]);
			Invoice inv = new Invoice(C_Code,C_Name,I_Date,G_Total,Discount,N_Total,I_ID,
					B_Code,B_Name,B_Cat_Code,B_Cat_Name,Quantity,Price,Amount);
			//call neo4j api to create db
			Neo4jInputDataApi neo4jApi = new Neo4jInputDataApi();
			neo4jApi.createdb(inv);
			
			//call mongodb api to create db
			MongoDbInvoiceInputApi mongoin = new MongoDbInvoiceInputApi();
			mongoin.createdb(inv);
		}
		

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	System.out.println("Done");
  }

}

