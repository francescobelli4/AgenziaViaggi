package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaClientiViewController;
import graphicscontrollers.ListaItinerariViewController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import utils.Utils;

import java.util.List;

public class ListaClientiView implements View {

    @FXML
    private VBox root;
    @FXML
    private VBox customersList;

    private static final Page page = Page.LISTA_CLIENTI;
    private final GraphicsController<ListaClientiView> graphicsController;

    public ListaClientiView() {
        this.graphicsController = new ListaClientiViewController(this);
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

    public void update(List<Node> customers) {
        customersList.getChildren().clear();
        customersList.getChildren().addAll(customers);
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
    public GraphicsController<ListaClientiView> getGraphicsController() {
        return graphicsController;
    }
}
