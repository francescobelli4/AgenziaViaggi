package daos;

import app.AppContext;
import dtos.ItinerarioDTO;
import exception.DAOException;
import models.Itinerario;
import models.Tappa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AggiungiItinerarioProcedureDAO implements GenericProcedureDAO<ItinerarioDTO, Itinerario> {

    @Override
    public Itinerario execute(ItinerarioDTO input) throws DAOException, SQLException {

        Itinerario i = null;

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call NuovoItinerario(?, ?, ?)}");

        cs.setString(1, input.name());
        cs.setInt(2, input.costo());
        cs.setString(3, input.tappe());

        boolean resultSetFound = cs.execute();

        while (!resultSetFound && cs.getUpdateCount() != -1) {
            resultSetFound = cs.getMoreResults();
        }

        if (resultSetFound) {
            try (ResultSet rs = cs.getResultSet()) {
                if (rs.next()) {
                    String nome = rs.getString("Nome");
                    int costo = rs.getInt("Costo");

                    i = new Itinerario(nome, costo);
                }
            }
        }

        conn.commit();
        cs.close();

        return i;
    }
}
