package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaItinerariViewController;
import graphicscontrollers.ListaTappeViewController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import models.Tappa;
import utils.Utils;

import java.util.List;
import java.util.Map;

public class ListaItinerariView implements View {

    @FXML
    private VBox root;
    @FXML
    private Button addButton;
    @FXML
    private VBox itinerariesList;

    private static final Page page = Page.LISTA_ITINERARI;
    private final GraphicsController<ListaItinerariView> graphicsController;

    public ListaItinerariView() {
        this.graphicsController = new ListaItinerariViewController(this);
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
        itinerariesList.getChildren().clear();
        itinerariesList.getChildren().addAll(itineraries);
    }

    public Button getAddButton() {
        return addButton;
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
    public GraphicsController<ListaItinerariView> getGraphicsController() {
        return graphicsController;
    }
}
