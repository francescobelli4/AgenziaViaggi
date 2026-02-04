package appcontrollers;

import daos.AggiungiAutobusProcedureDAO;
import daos.EliminaAutobusProcedureDAO;
import daos.ListaAutobusProcedureDAO;
import dtos.AutobusDTO;
import exception.DAOException;
import exception.InvalidAutobusDataException;
import models.Autobus;

import java.sql.SQLException;
import java.util.List;

public class AutobusController {

    public static List<Autobus> getAutobus() throws DAOException {

        List<Autobus> autobus;

        try {
            autobus = new ListaAutobusProcedureDAO().execute(null);
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return autobus;
    }

    public static Autobus aggiungiAutobus(String targa, int capienza, int costo) throws DAOException, InvalidAutobusDataException {

        if (targa.isBlank()) {
            throw new InvalidAutobusDataException("Targa non valida");
        }

        if (capienza <= 0) {
            throw new InvalidAutobusDataException("Capienza non valida");
        }

        if (costo < 0) {
            throw new InvalidAutobusDataException("Costo non valido");
        }

        try {
            return new AggiungiAutobusProcedureDAO().execute(new AutobusDTO(targa, capienza, costo));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static void eliminaAutobus(Autobus autobus) throws DAOException {

        try {
            new EliminaAutobusProcedureDAO().execute(autobus.getTarga());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
