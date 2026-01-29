package daos;

import app.AppContext;
import exception.DAOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class EliminaTappaProcedureDAO implements GenericProcedureDAO<String, Void> {

    @Override
    public Void execute(String input) throws DAOException, SQLException {

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call EliminaTappa(?)}");

        cs.setString(1, input);
        cs.executeQuery();

        conn.commit();
        cs.close();

        return null;
    }
}
