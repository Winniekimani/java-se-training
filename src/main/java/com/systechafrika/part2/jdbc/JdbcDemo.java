package com.systechafrika.part2.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo {
    public static void main(String[] args) {
        try {
            DataAccess mysql = new MysqlDataAccess();
            mysql.connect();
            ResultSet adminResultSet = mysql.executeQuery("SELECT * from tbl_admin");// here i replaced mhusikas table
                                                                                     // with a table i created in mysql
                                                                                     // for the code to run
            while (adminResultSet.next()) {
                int adminId = adminResultSet.getInt("id");
                String adminName = adminResultSet.getString("fullname");
                String adminPassword = adminResultSet.getString("password");
                System.out.println("ID: " + adminId + " Name: " + adminName + "Password:" + adminPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
