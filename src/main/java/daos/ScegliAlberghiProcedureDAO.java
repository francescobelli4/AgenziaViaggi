package daos;

import app.AppContext;
import dtos.ScegliAlberghiDTO;
import exception.DAOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ScegliAlberghiProcedureDAO implements GenericProcedureDAO<ScegliAlberghiDTO, Void> {

    @Override
    public Void execute(ScegliAlberghiDTO input) throws DAOException, SQLException {

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call ScegliAlberghi(?, ?)}");

        cs.setString(1, input.codiceViaggio());
        cs.setString(2, input.pernottamenti());
        cs.executeQuery();

        conn.commit();
        cs.close();

        return null;
    }
}
