package com.systechafrika.pos.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.systechafrika.pos.logging.FileLogging;

public class DatabaseAccess {

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
            insertData(scanner, connection);
            retrieveData(statement);

            // Close resources
            statement.close();
            connection.close();

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

        String insertQuery = "INSERT INTO items (item_code, quantity, unit_price) VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, itemCode);
        preparedStatement.setInt(2, quantity);
        preparedStatement.setDouble(3, unitPrice);

        int rowsInserted = preparedStatement.executeUpdate();
        FileLogging.logInfo(rowsInserted + " row(s) inserted.");

        // Close the PreparedStatement
        preparedStatement.close();
    }

    private static void retrieveData(Statement statement) throws SQLException {
        String selectQuery = "SELECT * FROM items;";
        ResultSet resultSet = statement.executeQuery(selectQuery);

        while (resultSet.next()) {
            String itemCode = resultSet.getString("item_code");
            int quantity = resultSet.getInt("quantity");
            double unitPrice = resultSet.getDouble("unit_price");

            FileLogging.logInfo("Item Code: " + itemCode);
            FileLogging.logInfo("Quantity: " + quantity);
            FileLogging.logInfo("Unit Price: " + unitPrice);
            FileLogging.logInfo("------------------------");
        }
        // Close the ResultSet
        resultSet.close();
    }
}
