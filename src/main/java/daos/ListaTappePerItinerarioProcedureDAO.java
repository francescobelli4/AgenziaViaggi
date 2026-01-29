package daos;

import app.AppContext;
import exception.DAOException;
import models.Tappa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaTappePerItinerarioProcedureDAO implements GenericProcedureDAO<String, List<Tappa>> {

    @Override
    public List<Tappa> execute(String input) throws DAOException, SQLException {

        List<Tappa> tappe = new ArrayList<>();

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call ListaTappePerItinerario(?)}");

        cs.setString(1,input);

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            String nome = rs.getString("Tappa");
            String tipo = rs.getString("Tipo");

            tappe.add(new Tappa(nome, Tappa.Tipo.fromString(tipo)));
        }

        conn.commit();
        cs.close();

        return tappe;
    }
}
