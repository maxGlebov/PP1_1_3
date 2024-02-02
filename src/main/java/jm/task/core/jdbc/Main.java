package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.util.List;

public class  Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Egor", "Simonov", (byte)23);
        userService.saveUser("Oleg", "Olegov", (byte)26);
        userService.saveUser("Maxim", "ivanov", (byte)32);
        userService.saveUser("Stas", "Sidorov", (byte)40);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();









    }
}
