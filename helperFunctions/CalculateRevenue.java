package helperFunctions;

import java.io.*;
import java.text.*;
import java.text.ParseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import helperFunctions.DbManager;

public class CalculateRevenue{


	public CalculateRevenue(){}
	
	public float calculate(){
	
		Connection conn = null;
		float revenue = 0;
	
		try {
			// connect to mySQL database
	    		conn = DbManager.getConnection(true);
		 
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT item_price, purchase_count FROM Items");
		float item_price = 0; 
		int purchase_count = 0; 
		float totalForItem = 0;		
			
		while(rs.next()){
		
			item_price = rs.getFloat("item_price");
			purchase_count = rs.getInt("purchase_count");
			
			totalForItem = item_price * purchase_count;
			revenue += totalForItem;
		
		}
		
		}catch (SQLException ex) {
		    System.out.println(ex);
		}
		
		return revenue;
	
	}
	
	public static void main(String agrs[]) {
      
		CalculateRevenue calculator = new CalculateRevenue();
		
		float revenue = calculator.calculate();
		
		System.out.println(revenue);
	
   	}

}
