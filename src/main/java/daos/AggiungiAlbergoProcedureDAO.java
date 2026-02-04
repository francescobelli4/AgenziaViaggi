package daos;

import app.AppContext;
import dtos.AlbergoDTO;
import exception.DAOException;
import models.Albergo;
import models.Referente;
import models.Tappa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AggiungiAlbergoProcedureDAO implements GenericProcedureDAO<AlbergoDTO, Albergo> {

    @Override
    public Albergo execute(AlbergoDTO input) throws DAOException, SQLException {

        Albergo albergo = null;

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call NuovoAlbergo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

        cs.setString(1, input.name());
        cs.setString(2, input.indirizzo());
        cs.setString(3, input.citta());
        cs.setInt(4, input.costo());
        cs.setInt(5, input.capacita());
        cs.setString(6, input.CFReferente());
        cs.setString(7, input.nomeReferente());
        cs.setString(8, input.cognomeReferente());
        cs.setString(9, input.email());
        cs.setString(10, input.telefono());
        cs.setString(11, input.fax());

        boolean resultSetFound = cs.execute();

        while (!resultSetFound && cs.getUpdateCount() != -1) {
            resultSetFound = cs.getMoreResults();
        }

        if (resultSetFound) {
            try (ResultSet rs = cs.getResultSet()) {
                if (rs.next()) {
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

                    albergo = new Albergo(nome, indirizzo, citta, costo, capienza, new Referente(CFReferente, nomeReferente, cognomeReferente), email, telefono, fax);
                }
            }
        }

        conn.commit();
        cs.close();

        return albergo;
    }
}
