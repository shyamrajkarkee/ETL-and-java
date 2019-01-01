package DAo;
import java.util.*;

import java.sql.*;
import java.sql.Date;


public class DAO {
	public static void selectByUsername(String zip, int month, int year)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp?useSSL=false","root","root");
			PreparedStatement st = conn.prepareStatement("select cr.* , c.CUST_ZIP as Zip  from cdw_sapp_creditcard \r\n" + 
					"cr inner join cdw_sapp_customer c on cr.cust_ssn = c.ssn\r\n" + 
					"where c.CUST_ZIP = ?  and year = ? and month = ?\r\n" + 
					"order by cr.DAY desc  ");
			st.setString(1, zip);
			st.setInt(2, year);
			st.setInt(3, month);
		    ResultSet rs = st.executeQuery();
		    
		    
		    while(rs.next())
		    {   System.out.println("-----------------------------------------------------");
		    	System.out.println("Transaction ID: "+ rs.getInt(1));
		    	System.out.println("Day: " +rs.getInt(2));
		    	System.out.println("Month: "+rs.getInt(3));
		    	System.out.println("Year: "+rs.getInt(4));
		    	System.out.println("Credit Card Number: "+rs.getLong(5));
		    	System.out.println("Cust SSN Number: "+ rs.getInt(6));
		    	System.out.println("Branch Code: "+rs.getInt(7));
		    	System.out.println("Transaction Type: "+rs.getString(8));
		    	System.out.println("Transaction Value: "+ rs.getDouble(9));
		    	System.out.println("Zip: "+rs.getInt(10));
		    	System.out.println("-----------------------------------------------------");
		    	
		    }
	
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------------------------------");
		}
	
	public static void selectByUsername2( String transactionType, int totalTransaction, double transactionValue)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp?useSSL=false","root","root");
			PreparedStatement st = conn.prepareStatement("select  TRANSACTION_TYPE ,count(*) as \"Total Transaction\"\r\n" + 
					", sum(TRANSACTION_VALUE)  as \"Sum for Transaction Value\"\r\n" + 
					"from cdw_sapp_creditcard where TRANSACTION_TYPE = ?;\r\n" + 
					"");
			st.setString(1, transactionType);
			
		    ResultSet rs = st.executeQuery();

		  
		    
		    while(rs.next())
		    {   System.out.println("Transaction Type"+ "|"+"Total Transaction"+"|"+"Sum for Transaction");
		    	System.out.println(rs.getString(1)+"          "+rs.getInt(2)+"               "+ rs.getDouble(3) );
		    }
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
	System.out.print("--------------------------------------------------------------------------");
	
	}
	public static void selectByUsername3(String state,int countTransaction, double transactionValue)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp?useSSL=false","root","root");
			PreparedStatement st = conn.prepareStatement("select count(cr.TRANSACTION_VALUE), sum(cr.TRANSACTION_VALUE),b.BRANCH_STATE\r\n" + 
					" from cdw_sapp_creditcard cr \r\n" + 
					" inner join cdw_sapp_branch b on\r\n" + 
					" cr.BRANCH_CODE = b.BRANCH_CODE\r\n" + 
					" where b.BRANCH_STATE = ?");
			st.setString(1, state);
		
			
		    ResultSet rs = st.executeQuery();
		  
		    
		    while(rs.next())
		    {   System.out.println("Number of TRANSACTION VALUE" +"|| "+ "Sum of TRANSACTION VALUE" + "|| " + " State" );
		    	System.out.println(rs.getInt(1)+"                              "+rs.getDouble(2)+"                "+ rs.getString(3));
		    }
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public static void selectByUsername4(int ssn)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp?useSSL=false","root","root");
			PreparedStatement st = conn.prepareStatement("select * from cdw_sapp_customer\r\n" + 
					"where SSN = ?");
			st.setInt(1, ssn);
		
			
		    ResultSet rs = st.executeQuery();
		  		    
		    while(rs.next())
		    { 
		    	System.out.println("FirstName: " +rs.getString(1));
		    	System.out.println("MiddleName: "+rs.getString(2));
		    	System.out.println("LastName: "+rs.getString(3));
		    	System.out.println("SSN: "+rs.getString(4));
		    	System.out.println("CreditCard Number: "+rs.getString(5));
		    	System.out.println("Apt No: "+rs.getString(6));
		    	System.out.println("Street Name: "+rs.getString(7));
		    	System.out.println("Customer City: "+rs.getString(8));
		    	System.out.println("Customer State: "+rs.getString(9));
		    	System.out.println("Customer Country: "+rs.getString(10));
		    	System.out.println("Customer Zip: "+rs.getString(11));
		    	System.out.println("Customer Phone no: "+rs.getString(12));
		    	System.out.println("Customer Email: "+rs.getString(13));
		    	System.out.println("Last Updated: "+rs.getTimestamp(14)); 
		    }
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public static void selectByUsername5(int ssn,String Firstname,String Middlename,String Lastname,String Aptno )
	{
		StringBuilder sb = new StringBuilder();
		
		// KEY VALU PAIRS
		HashMap<String, String> map = new HashMap<String, String>();
		
		if (Firstname != null) {
			map.put("FIRST_NAME", Firstname);
		}
		if (Middlename != null) {
			map.put("MIDDLE_NAME", Middlename);
		}
		if(Lastname != null) {
			map.put("LAST_NAME", Lastname);
		}
		if (Aptno != null) {
			map.put("APT_NO", Aptno);
		}
		
		map.forEach((key, value) -> {
			sb.append(key + " = ");
			sb.append("'"+value+"'");
			sb.append(",");	
				
		});
		
		String query = sb.substring(0, sb.length() - 1);
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =  null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp?useSSL=false","root","root");
			
			PreparedStatement st3 = conn.prepareStatement("select FIRST_NAME, MIDDLE_NAME, LAST_NAME, SSN, APT_NO\r\n" + 
					" from cdw_sapp_customer where ssn = ?");
			
			st3.setInt(1, ssn);
			ResultSet rs2 = st3.executeQuery();
  		    
		    while(rs2.next())
		    
		    { System.out.println("---------------------------------------------------------------");
		    System.out.println("Update Success!!!!");
		    System.out.println("");
		    System.out.println("---------------------------------------------------------------");
		    System.out.print("");
		    System.out.println(" Before Updated");
		    System.out.println("---------------------------------------------------------------");
		    	System.out.println("FirstName: " +rs2.getString(1));
		    	System.out.println("MiddleName: "+rs2.getString(2));
		    	System.out.println("LastName: "+rs2.getString(3));
		    	System.out.println("SSN: "+rs2.getInt(4));
		    	System.out.println("Apt No: "+rs2.getString(5));
		    }
		  	
			PreparedStatement st = conn.prepareStatement("update cdw_sapp_customer\r\n" + 
					"set " + query +" where ssn = ?");
			st.setInt(1, ssn);	
			
		   int rs = st.executeUpdate();
		   
		 
			PreparedStatement st1 = conn.prepareStatement("select FIRST_NAME, MIDDLE_NAME, LAST_NAME, SSN, APT_NO\r\n" + 
					" from cdw_sapp_customer where ssn = ?");
			
			st1.setInt(1, ssn);
			ResultSet rs1 = st1.executeQuery();
  		    
		    while(rs1.next())
		    
		    {System.out.println("---------------------------------------------------------------");
		    System.out.print("");
		    System.out.println("Your Result After Updated");
		    System.out.println("---------------------------------------------------------------");
		    	System.out.println("FirstName: " +rs1.getString(1));
		    	System.out.println("MiddleName: "+rs1.getString(2));
		    	System.out.println("LastName: "+rs1.getString(3));
		    	System.out.println("SSN: "+rs1.getInt(4));
		    	System.out.println("Apt No: "+rs1.getString(5));
		    }
		  	
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void selectByUsername6(String creditCardNumber, int month, int year)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp?useSSL=false","root","root");
			PreparedStatement st = conn.prepareStatement("select CREDIT_CARD_NO, sum(TRANSACTION_VALUE), MONTH, YEAR \r\n" + 
					"from  cdw_sapp_creditcard\r\n" + 
					"where CREDIT_CARD_NO = ? and MONTH = ? and YEAR = ?;");
			st.setString(1, creditCardNumber);
			st.setInt(2, month);
			st.setInt(3, year);
		
			
		    ResultSet rs = st.executeQuery();
		  		    
		    while(rs.next())
		    { System.out.println("CreditCardNumber"+ "|"+ "Sum of Transaction"+ "|"+"Month"+ "|"+ "Year");
		    	System.out.println(rs.getString(1)+"      "+
		    			rs.getDouble(2)+"         "+
		    			rs.getInt(3)+"     "+
		    			rs.getInt(4));
		    			
		    }
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public static void selectByUsername7( int ssn, String from, String to  )
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp?useSSL=false","root","root");
			PreparedStatement st = conn.prepareStatement(" SELECT TRANSACTION_ID, CONCAT(MONTH,\"/\",DAY,\"/\",YEAR)Date,\r\n" + 
					"CREDIT_CARD_NO,CUST_SSN,BRANCH_CODE,TRANSACTION_TYPE,TRANSACTION_VALUE\r\n" + 
					"FROM cdw_sapp_creditcard\r\n" + 
					"WHERE CUST_SSN = ? AND str_to_date(CONCAT(MONTH,\"-\",DAY,\"-\",YEAR),\r\n" + 
					"'%m-%d-%Y') \r\n" + 
					"BETWEEN str_to_date(?,'%m-%d-%Y' )AND str_to_date(?,'%m-%d-%Y')\r\n" + 
					"ORDER BY YEAR ,MONTH,DAY DESC;");
			st.setInt(1, ssn);
			st.setString(2, from);
			st.setString(3, to);
			
			
		
			
		    ResultSet rs = st.executeQuery();
		  		    
		    while(rs.next())
		    { System.out.println("ID   "+"|"+"Date"+"     |"+"Credit Card Number"
		    + ""+" | "+"Customer SSN"+" | "
		    + "Branch Code"+" | "+" Transaction Type "+" | "+ "Transaction Value");
		    System.out.println("----------------------------------------------------"
		    		+ "-------------------------------------------------------------");
		    	System.out.println(rs.getInt(1)+"   "+rs.getString(2)
		    	+"  "+rs.getString(3)+"      "+rs.getInt(4)
		    	+"         "+rs.getInt(5)
		    	+"         "+rs.getString(6)
		    	+"         "+rs.getDouble(7));
		    	System.out.println("");
		    	 System.out.println("----------------------------------------------------"
				    		+ "-------------------------------------------------------------");    			
		    }
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
