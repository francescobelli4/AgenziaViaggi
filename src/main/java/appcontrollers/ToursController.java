package appcontrollers;

import daos.*;
import dtos.AutobusDTO;
import dtos.ViaggioDTO;
import exception.DAOException;
import exception.InvalidAutobusDataException;
import exception.InvalidTourDataException;
import models.Autobus;
import models.Itinerario;
import models.Viaggio;
import views.Icon;
import views.ViewNavigator;

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
}
