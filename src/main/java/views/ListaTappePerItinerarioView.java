package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaTappePerItinerarioViewController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import models.Itinerario;
import utils.Utils;

import java.util.List;

public class ListaTappePerItinerarioView implements View {

    @FXML
    private StackPane root;
    @FXML
    private VBox tappeContainer;

    private static final Page page = Page.LISTA_TAPPE_PER_ITINERARIO;
    private final GraphicsController<ListaTappePerItinerarioView> graphicsController;

    public ListaTappePerItinerarioView(Itinerario itinerario) {
        this.graphicsController = new ListaTappePerItinerarioViewController(this, itinerario);
        init();
    }

    public void setElements(List<Node> tappe) {
        tappeContainer.getChildren().clear();
        tappeContainer.getChildren().addAll(tappe);
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    @Override
    public void close() {
        //Nothing to do...
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
    public GraphicsController<ListaTappePerItinerarioView> getGraphicsController() {
        return graphicsController;
    }
}
