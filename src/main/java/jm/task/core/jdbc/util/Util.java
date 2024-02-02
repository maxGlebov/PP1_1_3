package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    static private  final String URL = "jdbc:mysql://localhost:3306/mydbHyper";
    static private  final String USERNAME = "root";
    static private final String PASSWORD = "rootROOT";
    static public  Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    static public void closeConnection() {
    }


}
