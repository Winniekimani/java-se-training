package com.systechafrika.poswithinsertanddeletedata.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Logger;

import com.systechafrika.poswithinsertanddeletedata.Item;
import com.systechafrika.poswithinsertanddeletedata.logging.FileLogging;

public class DatabaseAccess {
    private static final Logger LOGGER = Logger.getLogger(DatabaseAccess.class.getName());
    private static final String DB_URL = "jdbc:mysql://localhost:3308/pos";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "javase";

    public static void main(String[] args) {
        Connection connection = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Initialize logger
            FileLogging.setupLogger();

            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create Statement from the connection
            Statement statement = connection.createStatement();

            // Perform database operations
            createTableIfNotExists(statement);

            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Insert item");
                System.out.println("2. Delete item");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        insertData(scanner, connection);
                        break;
                    case 2:
                        deleteData(scanner, connection);
                        break;
                    case 3:
                        // Close resources and exit
                        statement.close();
                        connection.close();
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }

        } catch (ClassNotFoundException e) {
            FileLogging.logError("JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            FileLogging.logError("Database connection error.");
            e.printStackTrace();
        } catch (IOException e) {
            FileLogging.logError("Failed to initialize logger.");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close(); // Close the database connection when done
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }

    private static void createTableIfNotExists(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS items (" +
                "item_code VARCHAR(255) NOT NULL," +
                "quantity INT NOT NULL," +
                "unit_price DECIMAL(10, 2) NOT NULL) ENGINE=INNODB;";
        statement.executeUpdate(createTableQuery);
    }

    private static void insertData(Scanner scanner, Connection connection) throws SQLException {
        System.out.print("Enter item code: ");
        String itemCode = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter unit price: ");
        double unitPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        // Create an Item object with the entered data
        Item item = new Item(itemCode, quantity, unitPrice);

        // Define the SQL query for insertion
        String insertQuery = "INSERT INTO items (item_code, quantity, unit_price) VALUES (?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // Set the values using the Item object
            preparedStatement.setString(1, item.getItemCode());
            preparedStatement.setInt(2, item.getQuantity());
            preparedStatement.setDouble(3, item.getUnitPrice());

            // Execute the insertion query
            int rowsInserted = preparedStatement.executeUpdate();
            FileLogging.logInfo(rowsInserted + " row(s) inserted.");
        } catch (SQLException e) {
            FileLogging.logError("Error while inserting data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void deleteData(Scanner scanner, Connection connection) throws SQLException {
        System.out.print("Enter item code to delete: ");
        String itemCodeToDelete = scanner.nextLine();

        // SQL query to delete data by item code
        String deleteQuery = "DELETE FROM items WHERE item_code = ?";

        // PreparedStatement to execute the delete query
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setString(1, itemCodeToDelete);

            // Execute the delete query
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                FileLogging.logInfo("Item with code " + itemCodeToDelete + " deleted from the database.");
            } else {
                FileLogging.logInfo("Item with code " + itemCodeToDelete + " not found in the database.");
            }
        } catch (SQLException e) {
            FileLogging.logError("Error while deleting data: " + e.getMessage());
        }
    }
}
