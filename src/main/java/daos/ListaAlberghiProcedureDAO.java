package daos;

import app.AppContext;
import exception.DAOException;
import models.Albergo;
import models.Referente;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaAlberghiProcedureDAO implements GenericProcedureDAO<Void, List<Albergo>> {

    @Override
    public List<Albergo> execute(Void input) throws DAOException, SQLException {

        List<Albergo> alberghi = new ArrayList<>();

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call ListaAlberghi()}");

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            String nome = rs.getString("NomeAlbergo");
            String indirizzo = rs.getString("Indirizzo");
            String citta = rs.getString("Città");
            int costo = rs.getInt("Costo");
            int capienza = rs.getInt("Capienza");
            String CFReferente = rs.getString("CFReferente");
            String nomeReferente = rs.getString("NomeReferente");
            String cognomeReferente = rs.getString("CognomeReferente");
            String email = rs.getString("Email");
            String telefono = rs.getString("Telefono");
            String fax = rs.getString("Fax");

            alberghi.add(new Albergo(nome, indirizzo, citta, costo, capienza, new Referente(CFReferente, nomeReferente, cognomeReferente), email, telefono, fax));
        }

        conn.commit();
        cs.close();


        return alberghi;
    }
}
