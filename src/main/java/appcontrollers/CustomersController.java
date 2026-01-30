package appcontrollers;

import daos.DisdiciPrenotazioneProcedureDAO;
import daos.ListaClientiProcedureDAO;
import daos.NuovaPrenotazioneProcedureDAO;
import dtos.PrenotazioneDTO;
import exception.DAOException;
import models.Cliente;

import java.sql.SQLException;
import java.util.List;

public class CustomersController {

    public static List<Cliente> getCustomers() throws DAOException {
        try {
            return new ListaClientiProcedureDAO().execute(null);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static void aggiungiPrenotazione(PrenotazioneDTO prenotazione) throws DAOException {
        try {
            new NuovaPrenotazioneProcedureDAO().execute(prenotazione);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static void disdiciPrenotazione(String codiceDisdetta) throws DAOException {
        try {
            new DisdiciPrenotazioneProcedureDAO().execute(codiceDisdetta);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
