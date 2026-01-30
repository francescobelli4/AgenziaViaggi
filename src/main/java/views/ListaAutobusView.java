package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaAutobusViewController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import utils.Utils;

import java.util.List;

public class ListaAutobusView implements View {

    @FXML
    private VBox root;
    @FXML
    private Button addButton;
    @FXML
    private VBox autobusList;

    private static final Page page = Page.LISTA_AUTOBUS;
    private final GraphicsController<ListaAutobusView> graphicsController;

    public ListaAutobusView() {
        this.graphicsController = new ListaAutobusViewController(this);
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

    public void update(List<Node> autobus) {
        autobusList.getChildren().clear();
        autobusList.getChildren().addAll(autobus);
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
    public GraphicsController<ListaAutobusView> getGraphicsController() {
        return graphicsController;
    }
}
