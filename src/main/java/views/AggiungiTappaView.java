package views;

import graphicscontrollers.AggiungiTappaViewController;
import graphicscontrollers.GraphicsController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import utils.Utils;

public class AggiungiTappaView implements View {

    @FXML
    private StackPane root;
    @FXML
    private TextField nomeTextField;
    @FXML
    private ToggleButton toggleCitta;
    @FXML
    private ToggleButton toggleLuogo;
    @FXML
    private Button aggiungiButton;

    private static final Page page = Page.AGGIUNGI_TAPPA;
    private final GraphicsController<AggiungiTappaView> graphicsController;

    public AggiungiTappaView() {
        this.graphicsController = new AggiungiTappaViewController(this);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
        nomeTextField.setTextFormatter(Utils.getTextFormatter(64, false));
    }

    @Override
    public void close() {
        //Nothing to do...
    }

    public Button getAggiungiButton() {
        return aggiungiButton;
    }

    public ToggleButton getToggleCitta() {
        return toggleCitta;
    }

    public ToggleButton getToggleLuogo() {
        return toggleLuogo;
    }

    public TextField getNomeTextField() {
        return nomeTextField;
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
    public GraphicsController<AggiungiTappaView> getGraphicsController() {
        return graphicsController;
    }
}
