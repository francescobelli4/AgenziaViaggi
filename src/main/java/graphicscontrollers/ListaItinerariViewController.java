package graphicscontrollers;

import appcontrollers.ItinerariesController;
import exception.DAOException;
import javafx.scene.Node;
import models.Itinerario;
import models.Role;
import models.User;
import views.*;

import java.util.ArrayList;
import java.util.List;

public class ListaItinerariViewController extends GraphicsController<ListaItinerariView> {

    private List<Itinerario> itinerari = new ArrayList<>();

    public ListaItinerariViewController(ListaItinerariView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {

        if (User.getInstance().getRole() == Role.BOOKING) {
            getView().getAddButton().setVisible(false);
            getView().getAddButton().setManaged(false);
        }

        itinerari = ItinerariesController.getItinerari();
        updateLists();

        getView().getAddButton().setOnMouseClicked(_ -> addButtonClicked());
    }

    private void rimuoviItinerario(Itinerario itinerario) {
        itinerari.remove(itinerario);
        updateLists();
    }

    private void aggiungiItinerario(Itinerario itinerario) {
        itinerari.add(itinerario);
        updateLists();
    }

    public void updateLists() {

        try {

            List<Node> itinerariNodes = new ArrayList<>();
            for (Itinerario i : itinerari) {
                ListaItinerariElementView listaItinerariElementView = ViewFactory.createListaItinerariElementView(i);
                ListaItinerariElementViewController listaItinerariElementViewController = (ListaItinerariElementViewController) listaItinerariElementView.getGraphicsController();
                listaItinerariElementViewController.setOnDeleted(this::rimuoviItinerario);
                itinerariNodes.add(listaItinerariElementView.getRoot());
            }

            getView().update(itinerariNodes);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Error", e.getMessage(), Icon.APPICON);
        }
    }

    private void addButtonClicked() {
        AggiungiItinerarioView aggiungiItinerarioView = ViewNavigator.displayAggiungiItinerarioView();
        AggiungiItinerarioViewController aggiungiItinerarioViewController = (AggiungiItinerarioViewController) aggiungiItinerarioView.getGraphicsController();
        aggiungiItinerarioViewController.setOnSuccess(this::aggiungiItinerario);
    }
}
