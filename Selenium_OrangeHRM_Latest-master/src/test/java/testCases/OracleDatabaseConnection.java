package testCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class OracleDatabaseConnection {
	
	
	@Test
	public static void DBConnection() throws ClassNotFoundException, SQLException
	{ 
		//driver connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//connection to Database
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		System.out.println("Connection loaded");
		
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("select * from EMPLOYEE1");
		
		//moves the cursor to last row
		rs.last();
		//after moving the cursor to last row then getting the last row number
        int numResults = rs.getRow();
		System.out.println("Total Rows are " + numResults);
		
		while(rs.next())
		{
			String empname=rs.getString("EMP_NAME");
			System.out.println(empname);
			if(empname.equals("Geeta")){
				System.out.println("Employee " + empname + "Found");
				break;
			}
		}
	}

}
