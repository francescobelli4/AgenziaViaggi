package graphicscontrollers;

import appcontrollers.CustomersController;
import exception.DAOException;
import javafx.scene.layout.StackPane;
import views.DisdiciPrenotazioneView;
import views.Icon;
import views.ViewNavigator;

public class DisdiciPrenotazioneViewController extends GraphicsController<DisdiciPrenotazioneView> {

    public DisdiciPrenotazioneViewController(DisdiciPrenotazioneView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {
        getView().getRoot().setOnMouseClicked(_ -> rootClicked());
        getView().getDisdiciButton().setOnMouseClicked(_ -> disdiciButtonClicked());
    }

    private void rootClicked() {
        //((StackPane)ViewNavigator.getActiveView().getRoot()).getChildren().remove(getView().getRoot());
        ViewNavigator.closeCurrentFloatingPage();
    }

    private void disdiciButtonClicked() {

        try {
            CustomersController.disdiciPrenotazione(getView().getCodiceTF().getText());
            rootClicked();
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }
}
