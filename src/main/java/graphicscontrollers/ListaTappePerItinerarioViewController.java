package graphicscontrollers;

import appcontrollers.ItinerariesController;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import models.Itinerario;
import models.Tappa;
import views.ListaTappePerItinerarioView;
import views.ViewFactory;
import views.ViewNavigator;

import java.util.ArrayList;
import java.util.List;

public class ListaTappePerItinerarioViewController extends GraphicsController<ListaTappePerItinerarioView> {

    private final Itinerario itinerario;

    public ListaTappePerItinerarioViewController(ListaTappePerItinerarioView view, Itinerario itinerario) {
        super(view);
        this.itinerario = itinerario;
        loaded();
    }

    @Override
    public void loaded() {
        getView().getRoot().setOnMouseClicked(_ -> rootClicked());

        List<Node> tappe = new ArrayList<>();

        for (Tappa t : ItinerariesController.getTappePerItinerario(itinerario)) {
            tappe.add(ViewFactory.createListaTappePerItinerarioElementView(t).getRoot());
        }

        getView().setElements(tappe);
    }

    private void rootClicked() {
        ((StackPane)ViewNavigator.getActiveView().getRoot()).getChildren().remove(getView().getRoot());
    }

    public Itinerario getItinerario() {
        return itinerario;
    }
}
