package com.systechafrika.possystemupdate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.systechafrika.possystemupdate.Item;
import com.systechafrika.possystemupdate.Payment;
import com.systechafrika.possystemupdate.User;

public class DatabaseAccess {
    private Connection connection;
    private final String DB_URL = "jdbc:mysql://localhost:3308/pos";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "javase";

    public DatabaseAccess() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            createTablesIfNotExists();
        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTablesIfNotExists() {
        try {
            Statement statement = connection.createStatement();

            // Create items table if not exists
            String createItemsTable = "CREATE TABLE IF NOT EXISTS items (" +
                    "item_code VARCHAR(255) PRIMARY KEY," +
                    "quantity INT NOT NULL," +
                    "unit_price DECIMAL(10, 2) NOT NULL)";
            statement.executeUpdate(createItemsTable);

            // Create users table if not exists
            String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "username VARCHAR(255) NOT NULL," +
                    "password VARCHAR(255) NOT NULL)";
            statement.executeUpdate(createUsersTable);

            // Create payments table if not exists
            // Create payments table if not exists with additional columns
            String createPaymentsTable = "CREATE TABLE IF NOT EXISTS payments (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "total_amount DECIMAL(10, 2) NOT NULL," +
                    "amount_given DECIMAL(10, 2) NOT NULL," +
                    "change_amount DECIMAL(10, 2) NOT NULL)";
            statement.executeUpdate(createPaymentsTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean userExists(String username) {
        try {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getPassword(String username) {
        try {
            String query = "SELECT password FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean registerUser(String username) {
        try {
            if (userExists(username)) {
                System.out.println("User already exists.");
                return false;
            }
            String password = "Admin123"; // Set the password to "Admin123"
            String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("User registered successfully with password: " + password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("User registration failed.");
            return false;
        }
    }

    public void insertItem(Item item) {
        try {
            String insertQuery = "INSERT INTO items (item_code, quantity, unit_price) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, item.getItemCode());
            preparedStatement.setInt(2, item.getQuantity());
            preparedStatement.setDouble(3, item.getUnitPrice());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error while inserting data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteItem(String itemCode) {
        try {
            String deleteQuery = "DELETE FROM items WHERE item_code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, itemCode);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while deleting data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertPayment(Payment payment) {
        try {
            String insertQuery = "INSERT INTO payments (total_amount, amount_given, change_amount ) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setDouble(1, payment.getTotalAmount());
            preparedStatement.setDouble(2, payment.getAmountGiven());
            preparedStatement.setDouble(3, payment.getChangeAmount());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> retrieveUsers() {
        List<User> userList = new ArrayList<>();
        try {
            String query = "SELECT * FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(id, username, password);
                userList.add(user);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public List<Item> retrieveItemData() {
        List<Item> itemList = new ArrayList<>();
        try {
            String query = "SELECT * FROM items";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String itemCode = resultSet.getString("item_code");
                int quantity = resultSet.getInt("quantity");
                double unitPrice = resultSet.getDouble("unit_price");
                Item item = new Item(itemCode, quantity, unitPrice);
                itemList.add(item);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

}
