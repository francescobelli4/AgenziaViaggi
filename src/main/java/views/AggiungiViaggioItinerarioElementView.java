package views;

import graphicscontrollers.AggiungiViaggioItinerarioElementViewController;
import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaAutobusViewController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Itinerario;
import utils.Utils;

import java.util.List;

public class AggiungiViaggioItinerarioElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private Label itineraryLabel;

    private static final Page page = Page.AGGIUNGI_VIAGGIO_ITINERARIO_ELEMENT;
    private final GraphicsController<AggiungiViaggioItinerarioElementView> graphicsController;

    public AggiungiViaggioItinerarioElementView(Itinerario itinerario) {
        this.graphicsController = new AggiungiViaggioItinerarioElementViewController(this, itinerario);
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

    public Label getItineraryLabel() {
        return itineraryLabel;
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
    public GraphicsController<AggiungiViaggioItinerarioElementView> getGraphicsController() {
        return graphicsController;
    }
}
