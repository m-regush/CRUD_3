package Service;

import DAO.UserDAO;
import DAO.UserDaoFactory;
import DAO.UserJdbcDAO;
import Model.User;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static UserService userService;

    private UserService() {

    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    private UserDaoFactory userDaoFactory = new UserDaoFactory();
    private UserDAO userDAO = userDaoFactory.getUserDao();

    public List<User> getAllUser() {
        try {
            if (!(userDAO.getAllUser().isEmpty())) {
                return userDAO.getAllUser();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public User getClientByName(String name) {
        try {
            return userDAO.getUserByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getClientById(Long id) throws SQLException {
        try {
            return userDAO.getUserById(id);
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public boolean addUser(User user) throws SQLException {
        if (userDAO.getUserByName(user.getName()) == null) {
            userDAO.addUser(user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(Long id) {
        return userDAO.deleteUser(id);
    }

    public boolean updateUser(User user) throws SQLException {
        if (userDAO.getUserById(user.getId()) != null) {
            userDAO.updateUser(user);
            return true;
        }
        return false;
    }
}
