package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ReportsViewController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import utils.Utils;

import java.util.List;

public class ReportsView implements View {

    @FXML
    private VBox root;
    @FXML
    private VBox reportsList;

    private static final Page page = Page.REPORT_VIAGGI;
    private final GraphicsController<ReportsView> graphicsController;

    public ReportsView() {
        this.graphicsController = new ReportsViewController(this);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    @Override
    public void close() {
        //Nothing to do...
    }

    public void update(List<Node> reports) {
        reportsList.getChildren().clear();
        reportsList.getChildren().addAll(reports);
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
    public GraphicsController<ReportsView> getGraphicsController() {
        return graphicsController;
    }
}
