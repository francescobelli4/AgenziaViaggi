package graphicscontrollers;

import appcontrollers.StopsController;
import exception.DAOException;
import javafx.scene.Node;
import models.Tappa;
import views.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static views.ViewNavigator.displayAggiungiTappaView;

public class ListaTappeViewController extends GraphicsController<ListaTappeView> {

    private List<Tappa> tappe;

    public ListaTappeViewController(ListaTappeView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {

        getView().getAddCittaButton().setOnMouseClicked(_ -> addTappaButtonClicked());
        getView().getAddTappaButton().setOnMouseClicked(_ -> addTappaButtonClicked());

        tappe = StopsController.getTappe();
        updateLists();
    }

    private void addTappaButtonClicked() {
        AggiungiTappaView aggiungiTappaView = ViewNavigator.displayAggiungiTappaView();
        AggiungiTappaViewController aggiungiTappaViewController = (AggiungiTappaViewController) aggiungiTappaView.getGraphicsController();
        aggiungiTappaViewController.setOnSuccess(this::aggiungiTappa);
    }

    private void aggiungiTappa(Tappa tappa) {
        tappe.add(tappa);
        updateLists();
    }

    private void rimuoviTappa(Tappa tappa) {
        tappe.remove(tappa);
        updateLists();
    }

    public void updateLists() {
        try {
            Map<Node, Tappa.Tipo> nodes = new HashMap<>();

            for (Tappa t : tappe) {
                ListaTappeElementView listaTappeElementView = ViewFactory.createListaTappeElementView(t);
                ListaTappeElementViewController listaTappeElementViewController = (ListaTappeElementViewController) listaTappeElementView.getGraphicsController();
                listaTappeElementViewController.setOnDeleted(this::rimuoviTappa);

                nodes.put(listaTappeElementView.getRoot(), t.getTipo());
            }

            getView().update(nodes);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Error", e.getMessage(), Icon.APPICON);
        }
    }

    public List<Tappa> getTappe() {
        return tappe;
    }
}
