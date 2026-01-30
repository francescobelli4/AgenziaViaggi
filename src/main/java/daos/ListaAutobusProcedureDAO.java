package daos;

import app.AppContext;
import exception.DAOException;
import models.Autobus;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaAutobusProcedureDAO implements GenericProcedureDAO<Void, List<Autobus>> {

    @Override
    public List<Autobus> execute(Void input) throws DAOException, SQLException {

        List<Autobus> autobus = new ArrayList<>();

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call ListaAutobus()}");

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            String targa = rs.getString("Targa");
            int costo = rs.getInt("Costo");
            int capienza = rs.getInt("Capienza");

            autobus.add(new Autobus(targa, costo, capienza));
        }

        conn.commit();
        cs.close();

        return autobus;
    }
}
