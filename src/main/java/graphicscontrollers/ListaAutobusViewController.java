package graphicscontrollers;

import appcontrollers.AutobusController;
import exception.DAOException;
import javafx.scene.Node;
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

        autobuses = AutobusController.getAutobus();
        updateLists();
    }

    private void aggiungiAutobus(Autobus autobus) {
        this.autobuses.add(autobus);
        updateLists();
    }

    private void rimuoviAutobus(Autobus autobus) {
        this.autobuses.remove(autobus);
        updateLists();
    }

    public void updateLists() {

        try {

            List<Node> autobusNodes = new ArrayList<>();
            for (Autobus i : autobuses) {
                ListaAutobusElementView listaAutobusElementView = ViewFactory.createListaAutobusElementView(i);
                ListaAutobusElementViewController listaAutobusElementViewController = (ListaAutobusElementViewController) listaAutobusElementView.getGraphicsController();
                listaAutobusElementViewController.setOnDeleted(this::rimuoviAutobus);
                autobusNodes.add(listaAutobusElementView.getRoot());
            }

            getView().update(autobusNodes);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Error", e.getMessage(), Icon.APPICON);
        }
    }

    private void addButtonClicked() {
        AggiungiAutobusView aggiungiAutobusView = ViewNavigator.displayAggiungiAutobusView();
        AggiungiAutobusViewController aggiungiAutobusViewController = (AggiungiAutobusViewController) aggiungiAutobusView.getGraphicsController();
        aggiungiAutobusViewController.setOnSuccess(this::aggiungiAutobus);
    }
}
