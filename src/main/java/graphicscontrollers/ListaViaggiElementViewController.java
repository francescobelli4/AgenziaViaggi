package graphicscontrollers;

import appcontrollers.AutobusController;
import appcontrollers.ToursController;
import exception.DAOException;
import models.Autobus;
import models.Viaggio;
import views.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ListaViaggiElementViewController extends GraphicsController<ListaViaggiElementView> {

    private final Viaggio viaggio;

    public ListaViaggiElementViewController(ListaViaggiElementView view, Viaggio viaggio) {
        super(view);
        this.viaggio = viaggio;

        loaded();
    }

    @Override
    public void loaded() {

        if (ChronoUnit.DAYS.between(LocalDate.now(), viaggio.getPartenza()) <= 0) {
            getView().getDeleteButton().setManaged(false);
            getView().getDeleteButton().setVisible(false);
        }

        getView().getCodiceViaggioLabel().setText(viaggio.getCodice());
        getView().getItineraryLabel().setText(viaggio.getItinerario());
        getView().getPartenzaLabel().setText(String.format("Partenza: %s", viaggio.getPartenza().toString()));
        getView().getRitornoLabel().setText(String.format("Ritorno: %s", viaggio.getRitorno().toString()));

        getView().getDeleteButton().setOnMouseClicked(_ -> deleteButtonClicked());
    }

    private void deleteButtonClicked() {
        try {
            ToursController.eliminaViaggio(viaggio);

            ListaViaggiView listaViaggi = (ListaViaggiView) ((HomeView)ViewNavigator.getActiveView()).getActiveView();
            ((ListaViaggiViewController)listaViaggi.getGraphicsController()).updateLists();
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }

    public Viaggio getViaggio() {
        return viaggio;
    }
}
