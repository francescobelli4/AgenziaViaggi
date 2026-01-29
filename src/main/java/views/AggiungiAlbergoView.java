package views;

import graphicscontrollers.AggiungiAlbergoViewController;
import graphicscontrollers.AggiungiItinerarioViewController;
import graphicscontrollers.GraphicsController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import utils.Utils;

import java.util.List;

public class AggiungiAlbergoView implements View {

    @FXML
    private StackPane root;
    @FXML
    private TextField nomeTF;
    @FXML
    private TextField cittaTF;
    @FXML
    private TextField indirizzoTF;
    @FXML
    private TextField costoTF;
    @FXML
    private TextField capienzaTF;
    @FXML
    private TextField cfTF;
    @FXML
    private TextField refNomeTF;
    @FXML
    private TextField cognomeTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField telefonoTF;
    @FXML
    private TextField faxTF;
    @FXML
    private Button aggiungiButton;


    private static final Page page = Page.AGGIUNGI_ALBERGO;
    private final GraphicsController<AggiungiAlbergoView> graphicsController;

    public AggiungiAlbergoView() {
        this.graphicsController = new AggiungiAlbergoViewController(this);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
        nomeTF.setTextFormatter(Utils.getTextFormatter(64, true));
        indirizzoTF.setTextFormatter(Utils.getTextFormatter(64, true));
        cittaTF.setTextFormatter(Utils.getTextFormatter(64, true));
        capienzaTF.setTextFormatter(Utils.getTextFormatter(64, true));
        costoTF.setTextFormatter(Utils.getTextFormatter(64, true));
        emailTF.setTextFormatter(Utils.getTextFormatter(64, true));
        telefonoTF.setTextFormatter(Utils.getTextFormatter(14, true));
        faxTF.setTextFormatter(Utils.getTextFormatter(12, true));
        refNomeTF.setTextFormatter(Utils.getTextFormatter(64, true));
        cfTF.setTextFormatter(Utils.getTextFormatter(16, true));
        cognomeTF.setTextFormatter(Utils.getTextFormatter(64, true));
    }

    public Button getAggiungiButton() {
        return aggiungiButton;
    }

    public TextField getCapienzaTF() {
        return capienzaTF;
    }

    public TextField getCfTF() {
        return cfTF;
    }

    public TextField getCittaTF() {
        return cittaTF;
    }

    public TextField getCognomeTF() {
        return cognomeTF;
    }

    public TextField getCostoTF() {
        return costoTF;
    }

    public TextField getEmailTF() {
        return emailTF;
    }

    public TextField getFaxTF() {
        return faxTF;
    }

    public TextField getIndirizzoTF() {
        return indirizzoTF;
    }

    public TextField getNomeTF() {
        return nomeTF;
    }

    public TextField getRefNomeTF() {
        return refNomeTF;
    }

    public TextField getTelefonoTF() {
        return telefonoTF;
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
    public GraphicsController<AggiungiAlbergoView> getGraphicsController() {
        return graphicsController;
    }
}
