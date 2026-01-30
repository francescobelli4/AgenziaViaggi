package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.InfoViaggioListaAlberghiPerCittaViewController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import models.Tappa;
import utils.Utils;

import java.util.List;

public class InfoViaggioListaAlberghiPerCittaView implements View {

    @FXML
    private StackPane root;
    @FXML
    private VBox listaAlberghi;

    private static final Page page = Page.INFO_VIAGGIO_LISTA_ALBERGHI_PER_CITTA;
    private final GraphicsController<InfoViaggioListaAlberghiPerCittaView> graphicsController;

    public InfoViaggioListaAlberghiPerCittaView(Tappa citta) {
        this.graphicsController = new InfoViaggioListaAlberghiPerCittaViewController(this, citta);
        init();
    }

    public void setHotels(List<Node> hotels) {
        listaAlberghi.getChildren().clear();
        listaAlberghi.getChildren().addAll(hotels);
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    public VBox getListaAlberghi() {
        return listaAlberghi;
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
    public GraphicsController<InfoViaggioListaAlberghiPerCittaView> getGraphicsController() {
        return graphicsController;
    }
}
