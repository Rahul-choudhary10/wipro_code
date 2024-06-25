package day27;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class UserAuthentication1 {
	 private static final String JDBC_URL = "jdbc:mysql://localhost:3306/wipro_test";
	    private static final String JDBC_USER = "root";
	    private static final String JDBC_PASSWORD = "rps@2345";

	    public static void main(String[] args) {
	        // Create the User table
	        createUserTable();

	        // Insert a sample user
	        String userID = "test_user";
	        String password = "password123";
	        insertUser(userID, password);

	        // Authenticate user
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter User ID: ");
	        String inputUserID = scanner.nextLine();
	        System.out.print("Enter Password: ");
	        String inputPassword = scanner.nextLine();

	        if (authenticateUser(inputUserID, inputPassword)) {
	            System.out.println("User authenticated successfully.");
	        } else {
	            System.out.println("Invalid User ID or Password.");
	        }
	        
	        scanner.close();
	    }

	    private static void createUserTable() {
	        String createTableSQL = "CREATE TABLE IF NOT EXISTS User ("
	                + "userID VARCHAR(50) NOT NULL PRIMARY KEY, "
	                + "passwordHash VARCHAR(64) NOT NULL)";

	        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	             Statement statement = connection.createStatement()) {

	            statement.execute(createTableSQL);
	            System.out.println("User table created successfully.");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void insertUser(String userID, String password) {
	        String insertUserSQL = "INSERT INTO User (userID, passwordHash) VALUES (?, ?)";

	        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	             PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL)) {

	            String hashedPassword = hashPassword(password);
	            preparedStatement.setString(1, userID);
	            preparedStatement.setString(2, hashedPassword);

	            int rowsInserted = preparedStatement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("User inserted successfully.");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    private static boolean authenticateUser(String userID, String password) {
	        String selectUserSQL = "SELECT passwordHash FROM User WHERE userID = ?";

	        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	             PreparedStatement preparedStatement = connection.prepareStatement(selectUserSQL)) {

	            preparedStatement.setString(1, userID);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                String storedPasswordHash = resultSet.getString("passwordHash");
	                String inputPasswordHash = hashPassword(password);
	                return storedPasswordHash.equals(inputPasswordHash);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false;
	    }

	    private static String hashPassword(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            byte[] hash = md.digest(password.getBytes());
	            StringBuilder hexString = new StringBuilder();

	            for (byte b : hash) {
	                String hex = Integer.toHexString(0xff & b);
	                if (hex.length() == 1) {
	                    hexString.append('0');
	                }
	                hexString.append(hex);
	            }

	            return hexString.toString();

	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException("Error hashing password", e);
	        }
	    }
	}