package daos;

import app.AppContext;
import exception.DAOException;
import models.Cliente;
import models.Referente;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaClientiProcedureDAO implements GenericProcedureDAO<Void, List<Cliente>> {

    @Override
    public List<Cliente> execute(Void input) throws DAOException, SQLException {

        List<Cliente> clienti = new ArrayList<>();

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call ListaClienti()}");

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            String cf = rs.getString("CF");
            String nome = rs.getString("Nome");
            String cognome = rs.getString("Cognome");

            clienti.add(new Cliente(cf, nome, cognome));
        }

        conn.commit();
        cs.close();

        return clienti;
    }
}
