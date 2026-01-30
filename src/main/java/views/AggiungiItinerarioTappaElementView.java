package views;

import graphicscontrollers.AggiungiItinerarioTappaElementViewController;
import graphicscontrollers.GraphicsController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import models.Tappa;
import utils.Utils;


public class AggiungiItinerarioTappaElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private Label tappaLabel;
    @FXML
    private ImageView tappaIcon;
    @FXML
    private CheckBox tappaCheckbox;

    private static final Page page = Page.AGGIUNGI_ITINERARIO_ELEMENT;
    private final GraphicsController<AggiungiItinerarioTappaElementView> graphicsController;

    public AggiungiItinerarioTappaElementView(Tappa tappa) {
        this.graphicsController = new AggiungiItinerarioTappaElementViewController(this, tappa);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    public CheckBox getTappaCheckbox() {
        return tappaCheckbox;
    }

    public ImageView getTappaIcon() {
        return tappaIcon;
    }

    public Label getTappaLabel() {
        return tappaLabel;
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
    public GraphicsController<AggiungiItinerarioTappaElementView> getGraphicsController() {
        return graphicsController;
    }
}
