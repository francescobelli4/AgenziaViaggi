package graphicscontrollers;

import appcontrollers.ItinerariesController;
import exception.DAOException;
import javafx.scene.Node;
import models.Itinerario;
import models.Role;
import models.User;
import views.Icon;
import views.ListaItinerariView;
import views.ViewFactory;
import views.ViewNavigator;

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
