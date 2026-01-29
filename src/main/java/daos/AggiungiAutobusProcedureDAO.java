package daos;

import app.AppContext;
import dtos.AlbergoDTO;
import dtos.AutobusDTO;
import exception.DAOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class AggiungiAutobusProcedureDAO implements GenericProcedureDAO<AutobusDTO, Void> {

    @Override
    public Void execute(AutobusDTO input) throws DAOException, SQLException {

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call NuovoAutobus(?, ?, ?)}");

        cs.setString(1, input.targa());
        cs.setInt(2, input.capienza());
        cs.setInt(3, input.costo());
        cs.executeQuery();

        conn.commit();
        cs.close();

        return null;
    }
}
