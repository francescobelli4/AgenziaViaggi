package appcontrollers;

import com.google.gson.Gson;
import daos.*;
import dtos.ScegliAlberghiDTO;
import dtos.ScegliAutobusDTO;
import dtos.ViaggioDTO;
import exception.DAOException;
import exception.InvalidTourDataException;
import models.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ToursController {

    public static List<Viaggio> getTours() throws DAOException {
        try {
            return new ListaViaggiProcedureDAO().execute(null);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static void aggiungiViaggio(Itinerario itinerario, LocalDate partenza, LocalDate ritorno) throws DAOException, InvalidTourDataException {

        if (ChronoUnit.DAYS.between(LocalDate.now(), partenza) <= 0) {
            throw new InvalidTourDataException("Hai inserito una data di partenza non valida.");
        }

        if (ChronoUnit.DAYS.between(partenza, ritorno) <= 0) {
            throw new InvalidTourDataException("Hai inserito date non valide.");
        }

        if (ChronoUnit.DAYS.between(partenza, ritorno) > 7) {
            throw new InvalidTourDataException("Un viaggio può durare al massimo una settimana.");
        }

        try {
            new AggiungiViaggioProcedureDAO().execute(new ViaggioDTO(itinerario.getNome(), partenza, ritorno));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static void eliminaViaggio(Viaggio viaggio) throws DAOException {

        try {
            new EliminaViaggioProcedureDAO().execute(viaggio.getCodice());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Prenotazione> getPrenotazioniPerViaggio(Viaggio viaggio) {
        try {
            return new ListaPrenotazioniPerViaggioProcedureDAO().execute(viaggio.getCodice());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<String> getAutobusPerViaggio(Viaggio viaggio) {
        try {
            return new ListaAutobusPerViaggioProcedureDAO().execute(viaggio.getCodice());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Pernottamento> getPernottamentiPerViaggio(Viaggio viaggio) throws DAOException {
        try {
            return new ListaPernottamentiPerViaggioProcedureDAO().execute(viaggio.getCodice());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static void scegliLogisticaViaggio(Viaggio viaggio, List<Pernottamento> pernottamenti, List<Autobus> autobus) throws DAOException {
        try {
            ScegliAlberghiDTO dto = new ScegliAlberghiDTO(viaggio.getCodice(), new Gson().toJson(pernottamenti));
            ScegliAutobusDTO autobusDTO = new ScegliAutobusDTO(viaggio.getCodice(), new Gson().toJson(autobus));
            new ScegliAlberghiProcedureDAO().execute(dto);
            new ScegliAutobusProcedureDAO().execute(autobusDTO);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Report> generateReports() {
        try {
            return new GeneraReportProcedureDAO().execute(null);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
