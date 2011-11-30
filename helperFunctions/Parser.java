package helperFunctions;

import java.io.*;
import java.text.*;
import java.text.ParseException;
import helperFunctions.CalculateRevenue;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Parser{

	public Parser(){}
	
	// parse the given file and create an sql load file with the recieved information
	public void parseFile(String itemFile){
		String s; 
		String[] splitList = new String[6];
		
		try{
		 FileWriter itemStream = new FileWriter("Items.csv", true);
        	 BufferedWriter writer = new BufferedWriter(itemStream);
		FileReader reader = new FileReader(itemFile); 
		BufferedReader br = new BufferedReader(reader); 
		int count = 0;
		double itemPrice = 0;
		int purchaseCount = 0;
		double totalRevenue = 0;
	
	
		while((s = br.readLine()) != null) { 
			
			String insert = "";
			if( count == 0){// to skip the header line
			  count++;	
			  continue;
			  }
			
			splitList = s.split("\t");
			
			for( int i = 0; i < 6; i++){
			
				if( i != 5)
				insert += splitList[i] + ">>";
				
				if( i == 5)
				insert += splitList[i];
				
				if( i == 2)
				itemPrice = Double.parseDouble(splitList[i]);
				
				if( i == 3)
				purchaseCount = Integer.parseInt(splitList[i]);
				
			}
			totalRevenue += (itemPrice * purchaseCount);
			
			try{
				//System.out.println(insert);
        			writer.write(insert + "\n");
        		}catch (Exception e){//Catch exception if any
        		  System.err.println("Error: " + e.getMessage());
			}
			count++;
		}
		
		System.out.println("Total Revenue: " + totalRevenue);
		
		writer.close();	
		} catch (IOException e){//Catch exception if any
        		  System.err.println("Error: " + e.getMessage());
		}
		
	
	}
	
	public static void main(String args[]) {
      	
	try{
		Parser parse = new Parser();
		
   		parse.parseFile(args[0]);
   		
	}
	catch ( Exception e){
	System.out.println(e);
	}
	
    }

}
