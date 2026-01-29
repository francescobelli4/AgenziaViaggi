package views;

import graphicscontrollers.AggiungiAutobusViewController;
import graphicscontrollers.GraphicsController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import utils.Utils;

public class AggiungiAutobusView implements View {

    @FXML
    private StackPane root;
    @FXML
    private TextField targaTF;
    @FXML
    private TextField costoTF;
    @FXML
    private TextField capienzaTF;
    @FXML
    private Button aggiungiButton;


    private static final Page page = Page.AGGIUNGI_AUTOBUS;
    private final GraphicsController<AggiungiAutobusView> graphicsController;

    public AggiungiAutobusView() {
        this.graphicsController = new AggiungiAutobusViewController(this);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
        targaTF.setTextFormatter(Utils.getTextFormatter(8, true));
        capienzaTF.setTextFormatter(Utils.getTextFormatter(64, true));
        costoTF.setTextFormatter(Utils.getTextFormatter(64, true));
    }

    public Button getAggiungiButton() {
        return aggiungiButton;
    }

    public TextField getTargaTF() {
        return targaTF;
    }

    public TextField getCapienzaTF() {
        return capienzaTF;
    }

    public TextField getCostoTF() {
        return costoTF;
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
    public GraphicsController<AggiungiAutobusView> getGraphicsController() {
        return graphicsController;
    }
}
