package graphicscontrollers;

import appcontrollers.HotelController;
import exception.DAOException;
import javafx.scene.Node;
import models.Albergo;
import views.*;

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

        alberghi = HotelController.getAlberghi();

        updateLists();
    }

    private void aggiungiAlbergo(Albergo albergo) {
        this.alberghi.add(albergo);
        updateLists();
    }

    private void rimuoviAlbergo(Albergo albergo) {
        this.alberghi.remove(albergo);
        updateLists();
    }

    public void updateLists() {

        try {
            List<Node> alberghiNodes = new ArrayList<>();
            for (Albergo i : alberghi) {
                ListaAlberghiElementView listaAlberghiElementView = ViewFactory.createListaAlberghiElementView(i);
                ListaAlberghiElementViewController listaAlberghiElementViewController = (ListaAlberghiElementViewController) listaAlberghiElementView.getGraphicsController();
                listaAlberghiElementViewController.setOnDeleted(this::rimuoviAlbergo);

                alberghiNodes.add(listaAlberghiElementView.getRoot());
            }

            getView().update(alberghiNodes);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Error", e.getMessage(), Icon.APPICON);
        }
    }

    private void addButtonClicked() {
        AggiungiAlbergoView aggiungiAlbergoView = ViewNavigator.displayAggiungiAlbergoView();
        AggiungiAlbergoViewController aggiungiAlbergoViewController = (AggiungiAlbergoViewController) aggiungiAlbergoView.getGraphicsController();
        aggiungiAlbergoViewController.setOnSuccess(this::aggiungiAlbergo);
    }
}
