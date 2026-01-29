package daos;

import app.AppContext;
import dtos.AlbergoDTO;
import dtos.ViaggioDTO;
import exception.DAOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class AggiungiViaggioProcedureDAO implements GenericProcedureDAO<ViaggioDTO, Void> {

    @Override
    public Void execute(ViaggioDTO input) throws DAOException, SQLException {

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call NuovoViaggio(?, ?, ?)}");

        cs.setString(1, input.itinerario());
        cs.setObject(2, input.partenza());
        cs.setObject(3, input.ritorno());

        cs.executeQuery();

        conn.commit();
        cs.close();

        return null;
    }
}
