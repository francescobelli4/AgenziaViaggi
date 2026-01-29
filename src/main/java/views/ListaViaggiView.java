package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaAlberghiViewController;
import graphicscontrollers.ListaViaggiViewController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import utils.Utils;

import java.util.List;

public class ListaViaggiView implements View {

    @FXML
    private VBox root;
    @FXML
    private Button addButton;
    @FXML
    private VBox futureToursList;
    @FXML
    private VBox pastToursList;

    private static final Page page = Page.LISTA_VIAGGI;
    private final GraphicsController<ListaViaggiView> graphicsController;

    public ListaViaggiView() {
        this.graphicsController = new ListaViaggiViewController(this);
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

    public void setFutureTours(List<Node> tours) {
        futureToursList.getChildren().clear();
        futureToursList.getChildren().addAll(tours);
    }

    public void setPastTours(List<Node> tours) {
        pastToursList.getChildren().clear();
        pastToursList.getChildren().addAll(tours);
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
    public GraphicsController<ListaViaggiView> getGraphicsController() {
        return graphicsController;
    }
}
