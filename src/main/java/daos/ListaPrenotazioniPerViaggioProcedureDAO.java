package daos;

import app.AppContext;
import exception.DAOException;
import models.Cliente;
import models.Prenotazione;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaPrenotazioniPerViaggioProcedureDAO implements GenericProcedureDAO<String, List<Prenotazione>> {

    @Override
    public List<Prenotazione> execute(String input) throws DAOException, SQLException {

        Map<String, Prenotazione> prenotazioni = new HashMap<>();

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call ListaPrenotazioniPerViaggio(?)}");
        cs.setString(1, input);

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            String codicePrenotazione = rs.getString("CodicePrenotazione");

            Prenotazione p = prenotazioni.get(codicePrenotazione);

            if (p == null) {
                p = new Prenotazione(input, codicePrenotazione, new HashMap<>());
                prenotazioni.put(codicePrenotazione, p);
            }

            String cf = rs.getString("Cliente");
            String nome = rs.getString("Nome");
            String cognome = rs.getString("Cognome");
            String codDisdetta = rs.getString("CodiceDisdetta");

            Cliente c = new Cliente(cf, nome, cognome);
            p.getClienti().put(codDisdetta, c);
        }

        conn.commit();
        cs.close();

        return new ArrayList<>(prenotazioni.values());
    }
}
