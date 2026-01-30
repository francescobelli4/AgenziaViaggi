package views;

import graphicscontrollers.AggiungiItinerarioViewController;
import graphicscontrollers.GraphicsController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import utils.Utils;

import java.util.List;

public class AggiungiItinerarioView implements View {

    @FXML
    private StackPane root;
    @FXML
    private TextField nomeTextField;
    @FXML
    private TextField costoTextField;
    @FXML
    private Button aggiungiButton;
    @FXML
    private VBox tappeContainer;

    private static final Page page = Page.AGGIUNGI_ITINERARIO;
    private final GraphicsController<AggiungiItinerarioView> graphicsController;

    public AggiungiItinerarioView() {
        this.graphicsController = new AggiungiItinerarioViewController(this);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
        nomeTextField.setTextFormatter(Utils.getTextFormatter(64, false));
    }

    @Override
    public void close() {
        //Nothing to do...
    }

    public void setElements(List<Node> tappe) {
        tappeContainer.getChildren().clear();
        tappeContainer.getChildren().addAll(tappe);
    }

    public Button getAggiungiButton() {
        return aggiungiButton;
    }

    public TextField getNomeTextField() {
        return nomeTextField;
    }

    public TextField getCostoTextField() {
        return costoTextField;
    }

    public VBox getTappeContainer() {
        return tappeContainer;
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
    public GraphicsController<AggiungiItinerarioView> getGraphicsController() {
        return graphicsController;
    }
}
