package daos;

import app.AppContext;
import dtos.ScegliAutobusDTO;
import exception.DAOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ScegliAutobusProcedureDAO implements GenericProcedureDAO<ScegliAutobusDTO, Void> {

    @Override
    public Void execute(ScegliAutobusDTO input) throws DAOException, SQLException {

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call ScegliAutobus(?, ?)}");

        cs.setString(1, input.codiceViaggio());
        cs.setString(2, input.autobus());
        cs.executeQuery();

        conn.commit();
        cs.close();

        return null;
    }
}
