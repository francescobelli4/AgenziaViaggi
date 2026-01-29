package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaAutobusElementViewController;
import graphicscontrollers.ListaClientiElementViewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import models.Autobus;
import models.Cliente;
import utils.Utils;

public class ListaClientiElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private Label cfLabel;
    @FXML
    private Label nomeLabel;
    @FXML
    private Label cognomeLabel;

    private static final Page page = Page.LISTA_CLIENTI_ELEMENT;
    private final GraphicsController<ListaClientiElementView> graphicsController;

    public ListaClientiElementView(Cliente cliente) {
        this.graphicsController = new ListaClientiElementViewController(this, cliente);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    public Label getCfLabel() {
        return cfLabel;
    }

    public Label getCognomeLabel() {
        return cognomeLabel;
    }

    public Label getNomeLabel() {
        return nomeLabel;
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
    public GraphicsController<ListaClientiElementView> getGraphicsController() {
        return graphicsController;
    }
}
