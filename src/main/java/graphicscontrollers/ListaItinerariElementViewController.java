package graphicscontrollers;

import appcontrollers.ItinerariesController;
import exception.DAOException;
import models.Itinerario;
import views.*;

import java.util.function.Consumer;

public class ListaItinerariElementViewController extends GraphicsController<ListaItinerariElementView> {

    private Consumer<Itinerario> onDeleted;
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

    public void setOnDeleted(Consumer<Itinerario> onDeleted) {
        this.onDeleted = onDeleted;
    }

    private void elementClicked() {
        ViewNavigator.displayListaTappePerItinerarioView(itinerario);
    }

    private void deleteButtonClicked() {
        try {
            ItinerariesController.eliminaItinerario(itinerario);

            if (onDeleted != null) onDeleted.accept(itinerario);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }

    public Itinerario getItinerario() {
        return itinerario;
    }
}
