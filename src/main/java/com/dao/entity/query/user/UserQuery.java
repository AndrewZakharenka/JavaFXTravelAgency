package com.dao.entity.query.user;

public class UserQuery {
    public static final String GET_ALL_USERS_QUERY = "SELECT users.idUsers, users.Name, users.Surname, " +
            "users.Login, users.Password, roles.Name as RoleName\n" +
            "FROM travelagency.users JOIN travelagency.roles \n" +
            "ON users.IdRoles = roles.idRoles";

    public static final String UPDATE_USER_BY_ID = "UPDATE travelagency.users t " +
            "SET t.Name = ?, t.Surname = ?, t.Login = ?, t.Password = ? " +
            "WHERE t.idUsers = ?";

    public static final String GET_USER_BY_ID = "SELECT users.idUsers, users.Name, users.Surname, users.Login," +
            " users.Password, roles.Name as RoleName \n" +
            "FROM travelagency.users \n" +
            "JOIN travelagency.roles \n" +
            "ON (users.idUsers = ?) and (users.IdRoles = roles.idRoles)";

    public static final String GET_USER_BY_LOGIN = "SELECT users.idUsers, users.Name, users.Surname, users.Login," +
            " users.Password, roles.Name as RoleName \n" +
            "FROM travelagency.users \n" +
            "JOIN travelagency.roles \n" +
            "ON (users.Login = ?) and (users.IdRoles = roles.idRoles)";

    public static final String DELETE_USER_BY_ID = "DELETE FROM travelagency.users u " +
            "where u.idUsers = ?";

    public static final String INSERT_USER = "INSERT INTO travelagency.users " +
            "(Name, Surname, Login, Password, IdRoles) " +
            "values (?, ?, ?, ?, ?)";


}
