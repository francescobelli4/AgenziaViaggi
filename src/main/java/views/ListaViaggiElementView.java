package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaTappeElementViewController;
import graphicscontrollers.ListaViaggiElementViewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import models.Tappa;
import models.Viaggio;
import utils.Utils;

public class ListaViaggiElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private Label codiceViaggioLabel;
    @FXML
    private Label itineraryLabel;
    @FXML
    private Label partenzaLabel;
    @FXML
    private Label ritornoLabel;
    @FXML
    private Button deleteButton;

    private static final Page page = Page.LISTA_VIAGGI_ELEMENT;
    private final GraphicsController<ListaViaggiElementView> graphicsController;

    public ListaViaggiElementView(Viaggio viaggio) {
        this.graphicsController = new ListaViaggiElementViewController(this, viaggio);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    public Label getItineraryLabel() {
        return itineraryLabel;
    }

    public Label getCodiceViaggioLabel() {
        return codiceViaggioLabel;
    }

    public Label getPartenzaLabel() {
        return partenzaLabel;
    }

    public Label getRitornoLabel() {
        return ritornoLabel;
    }

    public Button getDeleteButton() {
        return deleteButton;
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
    public GraphicsController<ListaViaggiElementView> getGraphicsController() {
        return graphicsController;
    }
}
