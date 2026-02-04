package daos;

import app.AppContext;
import exception.DAOException;
import models.Itinerario;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaItinerariProcedureDAO implements GenericProcedureDAO<Void, List<Itinerario>> {

    @Override
    public List<Itinerario> execute(Void input) throws DAOException, SQLException {

        List<Itinerario> itineraries = new ArrayList<>();

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call ListaItinerari()}");

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {

            String nome = rs.getString("Nome");
            int costo = rs.getInt("Costo");

            itineraries.add(new Itinerario(nome, costo));
        }

        conn.commit();
        cs.close();

        return itineraries;
    }
}
