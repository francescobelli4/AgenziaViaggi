package daos;

import app.AppContext;
import dtos.AlbergoDTO;
import exception.DAOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class EliminaViaggioProcedureDAO implements GenericProcedureDAO<String, Void> {

    @Override
    public Void execute(String input) throws DAOException, SQLException {

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call EliminaViaggio(?)}");

        cs.setString(1, input);
        cs.executeQuery();

        conn.commit();
        cs.close();

        return null;
    }
}
