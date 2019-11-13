package DAO;

import Model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {

    private Connection connection;

    public UserJdbcDAO() {
        connection = DBHelper.getInstance().getConnection();
    }

    public List<User> getAllUser() throws SQLException {
        List<User> allUsers = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("select * from users");
            ResultSet result = stmt.getResultSet();
            while (result.next()) {
                allUsers.add(new User(result.getLong("id"), result.getString("name"),
                        result.getString("password"), result.getString("role"),
                        result.getString("job"), result.getLong("salary")));
            }
        }
        return allUsers;
    }

    public void addUser(User user) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("INSERT INTO users (name, password, role, job, salary) " +
                    "VALUES ('" + user.getName() + "', '" + user.getPassword() + "', '"+ user.getRole()+ "', '"
                    + user.getJob() + "'," + user.getSalary() + ")");

        }
    }

    public boolean deleteUser(Long id) {
        int delete = 0;
        try (Statement stmt = connection.createStatement()) {
            delete = stmt.executeUpdate("DELETE FROM users WHERE id= '" + id + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (delete > 0) {
            return true;
        }
        return false;
    }


    public void updateUser(User user) {
        String query = "update users set name = ?, password = ?, role = ?, job = ?, salary = ? where id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setString(4, user.getJob());
            stmt.setLong(5, user.getSalary());
            stmt.setLong(6, user.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByName(String name) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            ResultSet result = stmt.executeQuery("SELECT * FROM users WHERE name= '" + name + "'");
            if (result.next()) {
                return new User(result.getLong("id"), name, result.getString("password"),
                        result.getString("role"), result.getString("job"),
                        result.getLong("salary"));
            }
        }
        return null;
    }

    public User getUserById(Long id) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            ResultSet result = stmt.executeQuery("select * from users where id= " + id);
            if (result.next()) {
                return new User(id, result.getString("name"), result.getString("password"),
                        result.getString("role"), result.getString("job"),
                        result.getLong("salary"));
            }
        }
        return null;
    }

}
