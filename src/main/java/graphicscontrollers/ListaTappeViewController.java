package graphicscontrollers;

import appcontrollers.StopsController;
import exception.DAOException;
import javafx.scene.Node;
import models.Tappa;
import views.Icon;
import views.ListaTappeView;
import views.ViewFactory;
import views.ViewNavigator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        updateLists();
    }

    private void addTappaButtonClicked() {
        ViewNavigator.displayAggiungiTappaView();
    }

    public void updateLists() {
        try {
            tappe = StopsController.getTappe();

            Map<Node, Tappa.Tipo> nodes = new HashMap<>();

            for (Tappa t : tappe) {
                nodes.put(ViewFactory.createListaTappeElementView(t).getRoot(), t.getTipo());
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
