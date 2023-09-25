package com.systechafrika.pos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseAccess {

    private static final String DB_URL = "jdbc:mysql://localhost:3308/pos";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "javase";

    public static void main(String[] args) {
        Connection connection = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create Statement from the connection
            Statement statement = connection.createStatement();

            // Perform any database ..
            createTableIfNotExists(statement);
            insertData(scanner, connection);
            retrieveData(statement);

            // Close resources
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection error.");
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
        String createTableQuery = "CREATE TABLE IF NOT EXISTS products (" +
                "product_id INT AUTO_INCREMENT PRIMARY KEY," +
                "product_name VARCHAR(255) NOT NULL," +
                "price DECIMAL(10, 2) NOT NULL," +
                "description TEXT," +
                "category VARCHAR(50)) ENGINE=INNODB;";
        statement.executeUpdate(createTableQuery);
    }

    private static void insertData(Scanner scanner, Connection connection) throws SQLException {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        scanner.nextLine(); // Consume newline
        System.out.print("Enter product description: ");
        String description = scanner.nextLine();

        System.out.print("Enter product category: ");
        String category = scanner.nextLine();

        String insertQuery = "INSERT INTO products (product_name, price, description, category) VALUES (?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, productName);
        preparedStatement.setDouble(2, price);
        preparedStatement.setString(3, description);
        preparedStatement.setString(4, category);

        int rowsInserted = preparedStatement.executeUpdate();
        System.out.println(rowsInserted + " row(s) inserted.");

        // Close the PreparedStatement
        preparedStatement.close();
    }

    private static void retrieveData(Statement statement) throws SQLException {
        String selectQuery = "SELECT * FROM products;";
        ResultSet resultSet = statement.executeQuery(selectQuery);

        while (resultSet.next()) {
            int productId = resultSet.getInt("product_id");
            String productName = resultSet.getString("product_name");
            double price = resultSet.getDouble("price");
            String description = resultSet.getString("description");
            String category = resultSet.getString("category");

            System.out.println("Product ID: " + productId);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Description: " + description);
            System.out.println("Category: " + category);
            System.out.println("------------------------");
        }
        // Close the ResultSet
        resultSet.close();
    }
}
