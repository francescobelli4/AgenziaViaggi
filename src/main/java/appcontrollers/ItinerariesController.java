package appcontrollers;

import com.google.gson.Gson;
import daos.AggiungiItinerarioProcedureDAO;
import daos.EliminaItinerarioProcedureDAO;
import daos.ListaItinerariProcedureDAO;
import daos.ListaTappePerItinerarioProcedureDAO;
import dtos.ItinerarioDTO;
import exception.DAOException;
import exception.InvalidItineraryCostException;
import exception.InvalidItineraryNameException;
import models.Itinerario;
import models.Tappa;

import java.sql.SQLException;
import java.util.List;

public class ItinerariesController {

    public static List<Itinerario> getItinerari() throws DAOException {

        try {
           return new ListaItinerariProcedureDAO().execute(null);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Tappa> getTappePerItinerario(Itinerario itinerario) throws DAOException {

        try {
            return new ListaTappePerItinerarioProcedureDAO().execute(itinerario.getNome());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Tappa> getTappePerItinerario(String itinerario) throws DAOException {

        try {
            return new ListaTappePerItinerarioProcedureDAO().execute(itinerario);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static void aggiungiItinerario(String nome, int costo, List<Tappa> tappe) throws DAOException, InvalidItineraryNameException, InvalidItineraryCostException {

        if (nome.isBlank()) {
            throw new InvalidItineraryNameException();
        }

        if (costo <= 0) {
            throw new InvalidItineraryCostException();
        }

        try {
            new AggiungiItinerarioProcedureDAO().execute(new ItinerarioDTO(nome, costo, new Gson().toJson(tappe)));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static void eliminaItinerario(Itinerario itinerario) throws DAOException {

        try {
            new EliminaItinerarioProcedureDAO().execute(itinerario.getNome());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
