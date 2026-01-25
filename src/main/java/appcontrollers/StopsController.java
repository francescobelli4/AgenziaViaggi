package appcontrollers;

import daos.AggiungiTappaProcedureDAO;
import daos.EliminaTappaProcedureDAO;
import daos.ListaTappeProcedureDAO;
import dtos.TappaDTO;
import exception.DAOException;
import exception.InvalidStopNameException;
import models.Tappa;

import java.sql.SQLException;
import java.util.List;

public class StopsController {

    public static List<Tappa> getTappe() throws DAOException {

        List<Tappa> tappe;

        try {
            tappe = new ListaTappeProcedureDAO().execute(null);
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return tappe;
    }

    public static void aggiungiTappa(String nome, Tappa.Tipo tipo) throws DAOException, InvalidStopNameException {

        if (nome.isBlank()) {
            throw new InvalidStopNameException();
        }

        try {
            new AggiungiTappaProcedureDAO().execute(new TappaDTO(nome, tipo.getTipo()));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static void eliminaTappa(Tappa tappa) throws DAOException {

        try {
            new EliminaTappaProcedureDAO().execute(tappa.getNome());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
