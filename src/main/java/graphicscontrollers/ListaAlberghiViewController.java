package graphicscontrollers;

import appcontrollers.HotelController;
import exception.DAOException;
import javafx.scene.Node;
import models.Albergo;
import views.Icon;
import views.ListaAlberghiView;
import views.ViewFactory;
import views.ViewNavigator;

import java.util.ArrayList;
import java.util.List;

public class ListaAlberghiViewController extends GraphicsController<ListaAlberghiView> {

    private List<Albergo> alberghi = new ArrayList<>();

    public ListaAlberghiViewController(ListaAlberghiView view) {
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
            alberghi = HotelController.getAlberghi();

            List<Node> alberghiNodes = new ArrayList<>();
            for (Albergo i : alberghi) {
                alberghiNodes.add(ViewFactory.createListaAlberghiElementView(i).getRoot());
            }

            getView().update(alberghiNodes);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Error", e.getMessage(), Icon.APPICON);
        }
    }

    private void addButtonClicked() {
        ViewNavigator.displayAggiungiAlbergoView();
    }
}
