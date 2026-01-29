package graphicscontrollers;

import appcontrollers.AutobusController;
import appcontrollers.HotelController;
import exception.DAOException;
import javafx.scene.Node;
import models.Albergo;
import models.Autobus;
import views.*;

import java.util.ArrayList;
import java.util.List;

public class ListaAutobusViewController extends GraphicsController<ListaAutobusView> {

    private List<Autobus> autobuses = new ArrayList<>();

    public ListaAutobusViewController(ListaAutobusView view) {
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
            autobuses = AutobusController.getAutobus();

            List<Node> autobusNodes = new ArrayList<>();
            for (Autobus i : autobuses) {
                autobusNodes.add(ViewFactory.createListaAutobusElementView(i).getRoot());
            }

            getView().update(autobusNodes);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Error", e.getMessage(), Icon.APPICON);
        }
    }

    private void addButtonClicked() {
        ViewNavigator.displayAggiungiAutobusView();
    }
}
