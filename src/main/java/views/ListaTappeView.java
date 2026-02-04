package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaTappeViewController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import models.Tappa;
import utils.Utils;

import java.util.Map;

public class ListaTappeView implements View {

    @FXML
    private VBox root;
    @FXML
    private Button addTappaButton;
    @FXML
    private Button addCittaButton;
    @FXML
    private VBox placesList;
    @FXML
    private VBox citiesList;

    private static final Page page = Page.LISTA_TAPPE;
    private final GraphicsController<ListaTappeView> graphicsController;

    public ListaTappeView() {
        this.graphicsController = new ListaTappeViewController(this);
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

    private void addStop(Node tappa, Tappa.Tipo tipo) {
        if (tipo == Tappa.Tipo.CITTA) {
            citiesList.getChildren().add(tappa);
        } else {
            placesList.getChildren().add(tappa);
        }
    }

    public void update(Map<Node, Tappa.Tipo> stops) {
        placesList.getChildren().clear();
        citiesList.getChildren().clear();

        for (var entry : stops.entrySet()) {
            addStop(entry.getKey(), entry.getValue());
        }
    }

    public Button getAddCittaButton() {
        return addCittaButton;
    }

    public Button getAddTappaButton() {
        return addTappaButton;
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
    public GraphicsController<ListaTappeView> getGraphicsController() {
        return graphicsController;
    }
}
