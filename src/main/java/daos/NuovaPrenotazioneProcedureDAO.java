package daos;

import app.AppContext;
import dtos.PrenotazioneDTO;
import exception.DAOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class NuovaPrenotazioneProcedureDAO implements GenericProcedureDAO<PrenotazioneDTO, Void> {

    @Override
    public Void execute(PrenotazioneDTO input) throws DAOException, SQLException {

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call NuovaPrenotazione(?, ?)}");

        cs.setString(1, input.codiceViaggio());
        cs.setString(2, input.clienti());
        cs.executeQuery();

        conn.commit();
        cs.close();

        return null;
    }
}
