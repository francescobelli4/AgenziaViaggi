package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaAlberghiViewController;
import graphicscontrollers.ListaItinerariViewController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import utils.Utils;

import java.util.List;

public class ListaAlberghiView implements View {

    @FXML
    private VBox root;
    @FXML
    private Button addButton;
    @FXML
    private VBox hotelsList;

    private static final Page page = Page.LISTA_ALBERGHI;
    private final GraphicsController<ListaAlberghiView> graphicsController;

    public ListaAlberghiView() {
        this.graphicsController = new ListaAlberghiViewController(this);
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

    public void update(List<Node> hotels) {
        hotelsList.getChildren().clear();
        hotelsList.getChildren().addAll(hotels);
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
    public GraphicsController<ListaAlberghiView> getGraphicsController() {
        return graphicsController;
    }
}
