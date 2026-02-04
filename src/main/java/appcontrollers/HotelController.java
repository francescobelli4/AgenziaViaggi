package appcontrollers;

import daos.AggiungiAlbergoProcedureDAO;
import daos.EliminaAlbergoProcedureDAO;
import daos.ListaAlberghiPerCittaProcedureDAO;
import daos.ListaAlberghiProcedureDAO;
import dtos.AlbergoDTO;
import exception.DAOException;
import exception.InvalidHotelDataException;
import models.Albergo;
import models.Tappa;

import java.sql.SQLException;
import java.util.List;

public class HotelController {

    public static List<Albergo> getAlberghi() throws DAOException {
        try {
            return new ListaAlberghiProcedureDAO().execute(null);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Albergo> getAlberghiPerCitta(Tappa citta) throws DAOException {
        try {
            return new ListaAlberghiPerCittaProcedureDAO().execute(citta.getNome());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static void eliminaAlbergo(Albergo albergo) throws DAOException {
        try {
            new EliminaAlbergoProcedureDAO().execute(new AlbergoDTO(albergo.getNome(), albergo.getCitta(), albergo.getIndirizzo()));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static Albergo aggiungiAlbergo(AlbergoDTO albergo) throws DAOException, InvalidHotelDataException {

        if (albergo.costo() <= 0) {
            throw new InvalidHotelDataException("Costo non valido.");
        }

        if (albergo.capacita() <= 0) {
            throw new InvalidHotelDataException("Capienza non valida.");
        }

        if (albergo.name().isBlank()) {
            throw new InvalidHotelDataException("Nome albergo non valido.");
        }

        if (albergo.citta().isBlank()) {
            throw new InvalidHotelDataException("Città albergo non valida.");
        }

        if (albergo.indirizzo().isBlank()) {
            throw new InvalidHotelDataException("Indirizzo albergo non valido.");
        }

        if (albergo.email().isBlank()) {
            throw new InvalidHotelDataException("Email albergo non valida.");
        }

        if (albergo.telefono().isBlank()) {
            throw new InvalidHotelDataException("Telefono albergo non valido.");
        }

        if (albergo.fax().isBlank()) {
            throw new InvalidHotelDataException("Fax albergo non valido.");
        }

        if (albergo.nomeReferente().isBlank()) {
            throw new InvalidHotelDataException("Nome referente non valido non valido.");
        }

        if (albergo.cognomeReferente().isBlank()) {
            throw new InvalidHotelDataException("Cognome referente non valido.");
        }

        if (albergo.CFReferente().isBlank()) {
            throw new InvalidHotelDataException("Codice fiscale referente non valido.");
        }

        try {
            return new AggiungiAlbergoProcedureDAO().execute(albergo);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

}
