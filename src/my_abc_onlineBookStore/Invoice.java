package my_abc_onlineBookStore;

public class Invoice {
	String C_Code,C_Name,I_Date,G_Total,Discount,N_Total,I_ID;
	String []B_Code,B_Name,B_Cat_Code,B_Cat_Name,Quantity,Price,Amount;
	
	Invoice(String C_Code,String C_Name,String I_Date,String G_Total,String Discount,
			String N_Total,String I_ID,String []B_Code,String []B_Name,String []B_Cat_Code,
			String []B_Cat_Name,String [] Quantity,String [] Price,String [] Amount){
		
			this.C_Code=C_Code;
			this.C_Name=C_Name;
			this.I_Date=I_Date;
			this.G_Total=G_Total;
			this.Discount =Discount;
			this.N_Total = N_Total;
			this.I_ID = I_ID;
			this.B_Code = B_Code;
			this.B_Name = B_Name;
			this.B_Cat_Name =B_Cat_Name;
			this.B_Cat_Code = B_Cat_Code;
			this.Quantity = Quantity;
			this.Amount =Amount;
			this.Price = Price;
	}

}
