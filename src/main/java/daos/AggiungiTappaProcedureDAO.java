package daos;

import app.AppContext;
import dtos.TappaDTO;
import exception.DAOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class AggiungiTappaProcedureDAO implements GenericProcedureDAO<TappaDTO, Void> {

    @Override
    public Void execute(TappaDTO input) throws DAOException, SQLException {

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call NuovaTappa(?, ?)}");

        cs.setString(1, input.name());
        cs.setString(2, input.tipo());
        cs.executeQuery();

        return null;
    }
}
