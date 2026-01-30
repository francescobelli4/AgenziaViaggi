package graphicscontrollers;

import appcontrollers.ItinerariesController;
import exception.DAOException;
import models.Itinerario;
import views.*;

public class ListaItinerariElementViewController extends GraphicsController<ListaItinerariElementView> {

    private final Itinerario itinerario;

    public ListaItinerariElementViewController(ListaItinerariElementView view, Itinerario itinerario) {
        super(view);
        this.itinerario = itinerario;

        loaded();
    }

    @Override
    public void loaded() {
        getView().getItineraryLabel().setText(itinerario.getNome());
        getView().getCostoLabel().setText(String.format("€%d", itinerario.getCosto()));
        getView().getDeleteButton().setOnMouseClicked(_ -> deleteButtonClicked());
        getView().getRoot().setOnMouseClicked(_ -> elementClicked());
    }

    private void elementClicked() {
        ViewNavigator.displayListaTappePerItinerarioView(itinerario);
    }

    private void deleteButtonClicked() {
        try {
            ItinerariesController.eliminaItinerario(itinerario);

            ListaItinerariView listaItinerari = (ListaItinerariView) ((HomeView)ViewNavigator.getActiveView()).getActiveView();
            ((ListaItinerariViewController)listaItinerari.getGraphicsController()).updateLists();
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }

    public Itinerario getItinerario() {
        return itinerario;
    }
}
