package daos;

import app.AppContext;
import dtos.AlbergoDTO;
import exception.DAOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class EliminaAlbergoProcedureDAO implements GenericProcedureDAO<AlbergoDTO, Void> {

    @Override
    public Void execute(AlbergoDTO input) throws DAOException, SQLException {

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call EliminaAlbergo(?, ? , ?)}");

        cs.setString(1, input.name());
        cs.setString(2, input.citta());
        cs.setString(3, input.indirizzo());
        cs.executeQuery();

        conn.commit();
        cs.close();

        return null;
    }
}
