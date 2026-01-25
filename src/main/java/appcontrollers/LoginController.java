package appcontrollers;

import daos.LoginProcedureDAO;
import dtos.LoginRequestDTO;
import exception.DAOException;
import exception.InvalidCredentialsException;
import models.Role;
import models.User;

import java.sql.SQLException;
import java.util.logging.Logger;

public class LoginController {

    private static final Logger LOGGER = Logger.getLogger("LoginController");

    private LoginController() {}

    public static void login(String username, String password) throws InvalidCredentialsException, DAOException {

        LoginRequestDTO loginRequest = new LoginRequestDTO(username, password);

        try {
            Role userRole = new LoginProcedureDAO().execute(loginRequest);

            if (userRole != null) {
                User.getInstance().setUsername(username);
                User.getInstance().setRole(userRole);
                User.getInstance().setLoggedIn();
            }

            if (userRole == null) {
                throw new InvalidCredentialsException();
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
