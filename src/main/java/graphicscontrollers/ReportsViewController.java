package graphicscontrollers;

import appcontrollers.ToursController;
import exception.DAOException;
import javafx.scene.Node;
import models.Report;
import views.Icon;
import views.ReportsView;
import views.ViewFactory;
import views.ViewNavigator;

import java.util.ArrayList;
import java.util.List;

public class ReportsViewController extends GraphicsController<ReportsView> {

    public ReportsViewController(ReportsView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {
        updateLists();
    }

    public void updateLists() {
        try {
            List<Node> reports = new ArrayList<>();

            for (Report t : ToursController.generateReports()) {
                reports.add(ViewFactory.createReportsElementView(t).getRoot());
            }

            getView().update(reports);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Error", e.getMessage(), Icon.APPICON);
        }
    }
}
