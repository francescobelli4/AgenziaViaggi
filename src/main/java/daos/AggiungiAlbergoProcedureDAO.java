package daos;

import app.AppContext;
import dtos.AlbergoDTO;
import exception.DAOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class AggiungiAlbergoProcedureDAO implements GenericProcedureDAO<AlbergoDTO, Void> {

    @Override
    public Void execute(AlbergoDTO input) throws DAOException, SQLException {

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
        cs.executeQuery();

        conn.commit();
        cs.close();

        return null;
    }
}
