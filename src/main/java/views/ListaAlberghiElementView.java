package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaAlberghiElementViewController;
import graphicscontrollers.ListaItinerariElementViewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import models.Albergo;
import models.Itinerario;
import utils.Utils;

public class ListaAlberghiElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private Label hotelLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Button deleteButton;

    private static final Page page = Page.LISTA_ALBERGHI_ELEMENT;
    private final GraphicsController<ListaAlberghiElementView> graphicsController;

    public ListaAlberghiElementView(Albergo albergo) {
        this.graphicsController = new ListaAlberghiElementViewController(this, albergo);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Label getCityLabel() {
        return cityLabel;
    }

    public Label getHotelLabel() {
        return hotelLabel;
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
    public GraphicsController<ListaAlberghiElementView> getGraphicsController() {
        return graphicsController;
    }
}
