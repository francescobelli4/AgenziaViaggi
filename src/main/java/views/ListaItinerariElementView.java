package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaItinerariElementViewController;
import graphicscontrollers.ListaTappeElementViewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import models.Itinerario;
import models.Tappa;
import utils.Utils;

public class ListaItinerariElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private Label itineraryLabel;
    @FXML
    private Label costoLabel;
    @FXML
    private Button deleteButton;

    private static final Page page = Page.LISTA_ITINERARI_ELEMENT;
    private final GraphicsController<ListaItinerariElementView> graphicsController;

    public ListaItinerariElementView(Itinerario itinerario) {
        this.graphicsController = new ListaItinerariElementViewController(this, itinerario);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Label getItineraryLabel() {
        return itineraryLabel;
    }

    public Label getCostoLabel() {
        return costoLabel;
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
    public GraphicsController<ListaItinerariElementView> getGraphicsController() {
        return graphicsController;
    }
}
