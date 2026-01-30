package daos;

import app.AppContext;
import exception.DAOException;
import models.Albergo;
import models.Pernottamento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaPernottamentiPerViaggioProcedureDAO implements GenericProcedureDAO<String, List<Pernottamento>> {

    @Override
    public List<Pernottamento> execute(String input) throws DAOException, SQLException {

        List<Pernottamento> pernottamenti = new ArrayList<>();

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call ListaPernottamentiPerViaggio(?)}");

        cs.setString(1, input);

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            String nomeAlbergo = rs.getString("NomeAlbergo");
            String cittaAlbergo = rs.getString("CittàAlbergo");
            String indirizzoAlbergo = rs.getString("IndirizzoAlbergo");
            int ordine = rs.getInt("Ordine");

            pernottamenti.add(new Pernottamento(new Albergo(nomeAlbergo, indirizzoAlbergo, cittaAlbergo), ordine));
        }

        conn.commit();
        cs.close();

        return pernottamenti;
    }
}
