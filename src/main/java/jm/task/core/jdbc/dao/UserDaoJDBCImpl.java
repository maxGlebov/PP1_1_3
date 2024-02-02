package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }
     Connection connection = Util.getConnection();

    public void createUsersTable() {
        String sql = "CREATE TABLE users (id INT PRIMARY KEY AUTO_INCREMENT," +
                " name VARCHAR(45), lastName VARCHAR(45), age INT)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);

        } catch (SQLException e) {
        }


    }

    public void dropUsersTable() {
        String sql = "DROP TABLE users";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);

        } catch (SQLException e) {
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO users (name, lastName, age)" +
                     "VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = null;


        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age );
            preparedStatement.executeUpdate();
            System.out.printf("User с именем – %s %s добавлен в базу данных\n", name, lastName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<User> getAllUsers() {
        List<User> listUser = new ArrayList<>();
        String sql = "SELECT * FROM users;";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                listUser.add(user);
            }

        } catch (SQLException e) {
        }
        return listUser;
    }

    public void cleanUsersTable() {
        String sql = "DELETE  FROM users;";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);

        } catch (SQLException e) {
        }

    }
}
