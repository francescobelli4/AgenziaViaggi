package daos;

import app.AppContext;
import exception.DAOException;
import models.Viaggio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListaViaggiProcedureDAO implements GenericProcedureDAO<Void, List<Viaggio>> {

    @Override
    public List<Viaggio> execute(Void input) throws DAOException, SQLException {

        List<Viaggio> viaggi = new ArrayList<>();

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call ListaViaggi()}");

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            String codice = rs.getString("Codice");
            String itinerario = rs.getString("Itinerario");
            LocalDate partenza = rs.getObject("Partenza", LocalDate.class);
            LocalDate ritorno = rs.getObject("Ritorno", LocalDate.class);

            viaggi.add(new Viaggio(codice, itinerario, partenza, ritorno));
        }

        conn.commit();
        cs.close();

        return viaggi;
    }
}
