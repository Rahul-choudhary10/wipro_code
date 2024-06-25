package day27;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQLConnectionTest {

	 public static void main(String[] args) {
	        // Database URL
	        String jdbcURL = "jdbc:mysql://localhost:3306/wipro_test"; // Replace with your database name
	        String username = "root"; // Replace with your MySQL username
	        String password = "rps@2345"; // Replace with your MySQL password

	        try {
	            // Load the MySQL JDBC driver (optional, can be skipped in newer versions of JDBC)
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establish a connection to the database
	            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

	            // Print out the connection object to confirm successful connection
	            System.out.println("Connection successful: " + connection);

	            // Close the connection (optional for this example, but good practice in real applications)
	            connection.close();

	        } catch (ClassNotFoundException e) {
	            System.out.println("MySQL JDBC Driver not found.");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Connection failed.");
	            e.printStackTrace();
	        }
	    }
}
