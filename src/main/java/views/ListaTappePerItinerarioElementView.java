package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaTappePerItinerarioElementViewController;
import graphicscontrollers.ListaTappePerItinerarioViewController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import models.Itinerario;
import models.Tappa;
import utils.Utils;

import java.util.List;

public class ListaTappePerItinerarioElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private ImageView tappaIcon;
    @FXML
    private Label tappaLabel;

    private static final Page page = Page.LISTA_TAPPE_PER_ITINERARIO_ELEMENT;
    private final GraphicsController<ListaTappePerItinerarioElementView> graphicsController;

    public ListaTappePerItinerarioElementView(Tappa tappa) {
        this.graphicsController = new ListaTappePerItinerarioElementViewController(this, tappa);
        init();
    }

    public ImageView getTappaIcon() {
        return tappaIcon;
    }

    public Label getTappaLabel() {
        return tappaLabel;
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
    public GraphicsController<ListaTappePerItinerarioElementView> getGraphicsController() {
        return graphicsController;
    }
}
