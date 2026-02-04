package daos;

import app.AppContext;
import dtos.ViaggioDTO;
import exception.DAOException;
import models.Tappa;
import models.Viaggio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AggiungiViaggioProcedureDAO implements GenericProcedureDAO<ViaggioDTO, Viaggio> {

    @Override
    public Viaggio execute(ViaggioDTO input) throws DAOException, SQLException {

        Viaggio viaggio = null;

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call NuovoViaggio(?, ?, ?)}");

        cs.setString(1, input.itinerario());
        cs.setObject(2, input.partenza());
        cs.setObject(3, input.ritorno());

        boolean resultSetFound = cs.execute();

        while (!resultSetFound && cs.getUpdateCount() != -1) {
            resultSetFound = cs.getMoreResults();
        }

        if (resultSetFound) {
            try (ResultSet rs = cs.getResultSet()) {
                if (rs.next()) {
                    String codice = rs.getString("Codice");
                    String itinerario = rs.getString("Itinerario");
                    LocalDate partenza = rs.getObject("Partenza", LocalDate.class);
                    LocalDate ritorno = rs.getObject("Ritorno", LocalDate.class);

                    viaggio = new Viaggio(codice, itinerario, partenza, ritorno);
                }
            }
        }

        conn.commit();
        cs.close();

        return viaggio;
    }
}
