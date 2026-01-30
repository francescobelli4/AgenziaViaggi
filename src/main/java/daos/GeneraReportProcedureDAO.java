package daos;

import app.AppContext;
import exception.DAOException;
import models.Report;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneraReportProcedureDAO implements GenericProcedureDAO<Void, List<Report>> {

    @Override
    public List<Report> execute(Void input) throws DAOException, SQLException {

        List<Report> reports = new ArrayList<>();

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call GeneraReport()}");

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {

            String codiceViaggio = rs.getString("CodiceViaggio");
            String itinerario = rs.getString("NomeItinerario");
            int entrate = rs.getInt("Entrate");
            int uscite = rs.getInt("Uscite");
            int guadagno = rs.getInt("Guadagno");

            reports.add(new Report(codiceViaggio, itinerario, entrate, uscite, guadagno));
        }

        conn.commit();
        cs.close();

        return reports;
    }
}
