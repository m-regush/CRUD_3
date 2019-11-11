package DAO;

import util.PropertyRead;


public class UserDaoFactory {
    public static UserDAO getUserDao() {
        String daoType = PropertyRead.readProperty("dao");
        switch (daoType) {
            case "hibernate":
                return new UserHibernateDAO();
            case "jdbc":
                return new UserJdbcDAO();
            default:
                throw new IllegalArgumentException();
        }
    }
}
