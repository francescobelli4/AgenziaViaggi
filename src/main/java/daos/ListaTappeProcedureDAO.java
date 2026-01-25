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

public class ListaTappeProcedureDAO implements GenericProcedureDAO<Void, List<Tappa>> {

    @Override
    public List<Tappa> execute(Void input) throws DAOException, SQLException {

        List<Tappa> tappe = new ArrayList<>();

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call ListaTappe()}");

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            String nome = rs.getString("Nome");
            String tipo = rs.getString("Tipo");

            tappe.add(new Tappa(nome, Tappa.Tipo.fromString(tipo)));
        }

        return tappe;
    }
}
