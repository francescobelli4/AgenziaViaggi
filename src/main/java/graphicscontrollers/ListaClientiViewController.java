package graphicscontrollers;

import appcontrollers.CustomersController;
import appcontrollers.ItinerariesController;
import exception.DAOException;
import javafx.scene.Node;
import models.Cliente;
import models.Itinerario;
import views.Icon;
import views.ListaClientiView;
import views.ViewFactory;
import views.ViewNavigator;

import java.util.ArrayList;
import java.util.List;

public class ListaClientiViewController extends GraphicsController<ListaClientiView> {

    private List<Cliente> clienti = new ArrayList<>();

    public ListaClientiViewController(ListaClientiView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {
        updateLists();
    }

    public void updateLists() {

        try {
            clienti = CustomersController.getCustomers();

            List<Node> customersNodes = new ArrayList<>();
            for (Cliente i : clienti) {
                customersNodes.add(ViewFactory.createListaClientiElementView(i).getRoot());
            }

            getView().update(customersNodes);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Error", e.getMessage(), Icon.APPICON);
        }
    }
}
