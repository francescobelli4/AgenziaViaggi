package views;

import graphicscontrollers.AggiungiAutobusViewController;
import graphicscontrollers.AggiungiViaggioItinerarioElementViewController;
import graphicscontrollers.AggiungiViaggioViewController;
import graphicscontrollers.GraphicsController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import models.Itinerario;
import utils.Utils;

import java.util.List;

public class AggiungiViaggioView implements View {

    @FXML
    private StackPane root;
    @FXML
    private VBox itinerariesContainer;
    @FXML
    private Button aggiungiButton;
    @FXML
    private DatePicker partenzaDatePicker;
    @FXML
    private DatePicker ritornoDatePicker;

    private static final Page page = Page.AGGIUNGI_VIAGGIO;
    private final GraphicsController<AggiungiViaggioView> graphicsController;

    public AggiungiViaggioView() {
        this.graphicsController = new AggiungiViaggioViewController(this);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    @Override
    public void close() {
        //Nothing to do...
    }

    public void update(List<Node> itineraries) {
        itinerariesContainer.getChildren().clear();
        itinerariesContainer.getChildren().addAll(itineraries);
    }

    public Button getAggiungiButton() {
        return aggiungiButton;
    }

    public DatePicker getPartenzaDatePicker() {
        return partenzaDatePicker;
    }

    public DatePicker getRitornoDatePicker() {
        return ritornoDatePicker;
    }

    public VBox getItinerariesContainer() {
        return itinerariesContainer;
    }

    @Override
    public Parent getRoot() {
        return root;
    }

    @Override
    public Page getPage() {
        return page;
    }

    @Override
    public GraphicsController<AggiungiViaggioView> getGraphicsController() {
        return graphicsController;
    }
}
