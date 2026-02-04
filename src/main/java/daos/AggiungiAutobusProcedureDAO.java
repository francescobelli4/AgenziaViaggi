package daos;

import app.AppContext;
import dtos.AutobusDTO;
import exception.DAOException;
import models.Autobus;
import models.Tappa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AggiungiAutobusProcedureDAO implements GenericProcedureDAO<AutobusDTO, Autobus> {

    @Override
    public Autobus execute(AutobusDTO input) throws DAOException, SQLException {

        Autobus autobus = null;

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call NuovoAutobus(?, ?, ?)}");

        cs.setString(1, input.targa());
        cs.setInt(2, input.capienza());
        cs.setInt(3, input.costo());

        boolean resultSetFound = cs.execute();

        while (!resultSetFound && cs.getUpdateCount() != -1) {
            resultSetFound = cs.getMoreResults();
        }

        if (resultSetFound) {
            try (ResultSet rs = cs.getResultSet()) {
                if (rs.next()) {
                    String targa = rs.getString("Targa");
                    int costo = rs.getInt("Costo");
                    int capienza = rs.getInt("Capienza");

                    autobus = new Autobus(targa, costo, capienza);
                }
            }
        }

        conn.commit();
        cs.close();

        return autobus;
    }
}
