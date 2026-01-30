package daos;

import app.AppContext;
import exception.DAOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaAutobusPerViaggioProcedureDAO implements GenericProcedureDAO<String, List<String>> {

    @Override
    public List<String> execute(String input) throws DAOException, SQLException {

        List<String> autobus = new ArrayList<>();

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call ListaAutobusPerViaggio(?)}");

        cs.setString(1, input);

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            String targa = rs.getString("Autobus");
            autobus.add(targa);
        }

        conn.commit();
        cs.close();

        return autobus;
    }
}
