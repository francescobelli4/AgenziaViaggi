package graphicscontrollers;

import appcontrollers.ItinerariesController;
import appcontrollers.StopsController;
import exception.DAOException;
import javafx.scene.Node;
import models.Itinerario;
import models.Tappa;
import views.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaItinerariViewController extends GraphicsController<ListaItinerariView> {

    private List<Itinerario> itinerari = new ArrayList<>();

    public ListaItinerariViewController(ListaItinerariView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {

        getView().getAddButton().setOnMouseClicked(_ -> addButtonClicked());

        updateLists();
    }

    public void updateLists() {

        try {
            itinerari = ItinerariesController.getItinerari();

            List<Node> itinerariNodes = new ArrayList<>();
            for (Itinerario i : itinerari) {
                itinerariNodes.add(ViewFactory.createListaItinerariElementView(i).getRoot());
            }

            getView().update(itinerariNodes);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Error", e.getMessage(), Icon.APPICON);
        }
    }

    private void addButtonClicked() {
        ViewNavigator.displayAggiungiItinerarioView();
    }
}
