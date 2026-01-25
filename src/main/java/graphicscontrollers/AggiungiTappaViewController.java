package graphicscontrollers;

import appcontrollers.StopsController;
import exception.DAOException;
import exception.InvalidStopNameException;
import javafx.scene.layout.StackPane;
import models.Tappa;
import views.*;

public class AggiungiTappaViewController extends GraphicsController<AggiungiTappaView> {

    private Tappa.Tipo tipo = Tappa.Tipo.CITTA;

    public AggiungiTappaViewController(AggiungiTappaView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {
        getView().getRoot().setOnMouseClicked(_ -> rootClicked());

        getView().getToggleCitta().setOnMouseClicked(_ -> cityButtonClicked());
        getView().getToggleLuogo().setOnMouseClicked(_ -> placeButtonClicked());

        getView().getAggiungiButton().setOnMouseClicked(_ -> aggiungiButtonClicked());
    }

    private void rootClicked() {
        ((StackPane)ViewNavigator.getActiveView().getRoot()).getChildren().remove(getView().getRoot());
    }

    private void cityButtonClicked() {
        getView().getToggleCitta().setSelected(true);
        getView().getToggleLuogo().setSelected(false);
        tipo = Tappa.Tipo.CITTA;
    }

    private void placeButtonClicked() {
        getView().getToggleLuogo().setSelected(true);
        getView().getToggleCitta().setSelected(false);
        tipo = Tappa.Tipo.LUOGO;
    }

    private void aggiungiButtonClicked() {

        try {
            StopsController.aggiungiTappa(getView().getNomeTextField().getText(), tipo);
            ListaTappeView listaTappe = (ListaTappeView) ((HomeView)ViewNavigator.getActiveView()).getActiveView();
            ((ListaTappeViewController)listaTappe.getGraphicsController()).updateLists();
            rootClicked();
        } catch (InvalidStopNameException _) {
            ViewNavigator.displayNotification("Errore", "Nome non valido.", Icon.APPICON);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }
}
