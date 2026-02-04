package graphicscontrollers;

import appcontrollers.ItinerariesController;
import appcontrollers.ToursController;
import exception.DAOException;
import exception.InvalidTourDataException;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import models.Itinerario;
import models.Viaggio;
import views.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AggiungiViaggioViewController extends GraphicsController<AggiungiViaggioView> implements AggiungiViaggioItinerarioElementViewController.Listener {

    private Consumer<Viaggio> onSuccess;
    private Itinerario selectedItinerary;

    public AggiungiViaggioViewController(AggiungiViaggioView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {
        getView().getRoot().setOnMouseClicked(_ -> rootClicked());
        getView().getAggiungiButton().setOnMouseClicked(_ -> aggiungiButtonClicked());

        updateLists();
    }

    public void setOnSuccess(Consumer<Viaggio> onSuccess) {
        this.onSuccess = onSuccess;
    }

    private void aggiungiButtonClicked() {

        if (getView().getPartenzaDatePicker().getValue() == null || getView().getRitornoDatePicker().getValue() == null) {
            ViewNavigator.displayNotification("Errore", "Non hai inserito date valide.", Icon.APPICON);
            return;
        }

        if (selectedItinerary == null) {
            ViewNavigator.displayNotification("Errore", "Non hai scelto un itinerario.", Icon.APPICON);
            return;
        }

        try {
            Viaggio viaggio = ToursController.aggiungiViaggio(selectedItinerary, getView().getPartenzaDatePicker().getValue(), getView().getRitornoDatePicker().getValue());

            if (onSuccess != null) onSuccess.accept(viaggio);
            ViewNavigator.closeCurrentFloatingPage();
        } catch (InvalidTourDataException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }

    public void updateLists() {

        try {
            List<Itinerario> itinerari = ItinerariesController.getItinerari();

            List<Node> itinerariNodes = new ArrayList<>();
            for (Itinerario i : itinerari) {
                AggiungiViaggioItinerarioElementView view = ViewFactory.createAggiungiViaggioItinerarioElementView(i);
                ((AggiungiViaggioItinerarioElementViewController)view.getGraphicsController()).setListener(this);
                itinerariNodes.add(view.getRoot());
            }

            getView().update(itinerariNodes);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Error", e.getMessage(), Icon.APPICON);
        }
    }

    private void rootClicked() {
        ViewNavigator.closeCurrentFloatingPage();
    }

    @Override
    public void selected(Itinerario itinerario, Node node) {
        selectedItinerary = itinerario;

        getView().getItinerariesContainer().getChildren().forEach(n -> n.getStyleClass().remove("selected"));
        node.getStyleClass().add("selected");
    }
}
