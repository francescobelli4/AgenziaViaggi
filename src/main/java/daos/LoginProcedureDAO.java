package daos;

import app.AppContext;
import dtos.LoginRequestDTO;
import exception.DAOException;
import models.Role;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class LoginProcedureDAO implements GenericProcedureDAO<LoginRequestDTO, Role> {

    @Override
    public Role execute(LoginRequestDTO input) throws DAOException, SQLException {

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call PerformLogin(?,?,?)}");

        cs.setString(1, input.username());
        cs.setString(2, input.password());
        cs.registerOutParameter(3, Types.VARCHAR);
        cs.executeQuery();
        String result = cs.getString(3);

        conn.commit();
        cs.close();

        return Role.fromString(result);
    }
}
