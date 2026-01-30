package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaAutobusElementViewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import models.Autobus;
import utils.Utils;

public class ListaAutobusElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private Label targaLabel;
    @FXML
    private Label costoLabel;
    @FXML
    private Label capienzaLabel;
    @FXML
    private Button deleteButton;

    private static final Page page = Page.LISTA_AUTOBUS_ELEMENT;
    private final GraphicsController<ListaAutobusElementView> graphicsController;

    public ListaAutobusElementView(Autobus autobus) {
        this.graphicsController = new ListaAutobusElementViewController(this, autobus);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Label getCostoLabel() {
        return costoLabel;
    }

    public Label getCapienzaLabel() {
        return capienzaLabel;
    }

    public Label getTargaLabel() {
        return targaLabel;
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
    public GraphicsController<ListaAutobusElementView> getGraphicsController() {
        return graphicsController;
    }
}
