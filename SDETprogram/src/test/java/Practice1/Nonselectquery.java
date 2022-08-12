package Practice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Nonselectquery {

	public static void main(String[] args) throws Throwable {
		Driver driverRef = new Driver();
	       DriverManager.registerDriver(driverRef);
	       
	       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
	       Statement stat = conn.createStatement();
	       
	       String query = "insert into institutions(first_name,last_name,address)values('raja','roy','india')";
	        int result = stat.executeUpdate(query);
	        if(result==1)
	        {
	        	System.out.println("user created");
	        }
	        else
	        {
	        	System.out.println("user not created");
	        }
	        conn.close();

	}

}
