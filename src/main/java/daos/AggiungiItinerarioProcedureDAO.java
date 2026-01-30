package daos;

import app.AppContext;
import dtos.ItinerarioDTO;
import exception.DAOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class AggiungiItinerarioProcedureDAO implements GenericProcedureDAO<ItinerarioDTO, Void> {

    @Override
    public Void execute(ItinerarioDTO input) throws DAOException, SQLException {

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call NuovoItinerario(?, ?, ?)}");

        cs.setString(1, input.name());
        cs.setInt(2, input.costo());
        cs.setString(3, input.tappe());
        cs.executeQuery();

        conn.commit();
        cs.close();

        return null;
    }
}
