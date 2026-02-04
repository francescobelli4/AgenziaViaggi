package daos;

import app.AppContext;
import dtos.TappaDTO;
import exception.DAOException;
import models.Autobus;
import models.Tappa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AggiungiTappaProcedureDAO implements GenericProcedureDAO<TappaDTO, Tappa> {

    @Override
    public Tappa execute(TappaDTO input) throws DAOException, SQLException {

        Tappa tappa = null;

        Connection conn = AppContext.getActiveConnection();

        CallableStatement cs = conn.prepareCall("{call NuovaTappa(?, ?)}");

        cs.setString(1, input.name());
        cs.setString(2, input.tipo());

        /**
         * This procedure executes an INSERT and then a SELECT. The right function is cs.execute().
         * It returns a boolean value that represents if a valid ResultSet is found.
         * If a valid ResultSet is not found, we want to continue "scrolling" the statement's output
         * using cs.getMoreResults().
         * At the beginning, resultSetFound should be "false" because it will find a counter for the rows
         * that were updated by the INSERT. Then it should find the valid ResultSet.
         */
        boolean resultSetFound = cs.execute();

        while (!resultSetFound && cs.getUpdateCount() != -1) {
            resultSetFound = cs.getMoreResults();
        }

        if (resultSetFound) {
            try (ResultSet rs = cs.getResultSet()) {
                if (rs.next()) {
                    String nome = rs.getString("Nome");
                    String tipo = rs.getString("Tipo");

                    tappa = new Tappa(nome, Tappa.Tipo.fromString(tipo));
                }
            }
        }

        conn.commit();
        cs.close();
        return tappa;
    }
}
