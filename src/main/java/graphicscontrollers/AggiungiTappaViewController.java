package graphicscontrollers;

import appcontrollers.StopsController;
import exception.DAOException;
import exception.InvalidStopNameException;
import javafx.scene.layout.StackPane;
import models.Tappa;
import views.*;

import java.util.function.Consumer;

public class AggiungiTappaViewController extends GraphicsController<AggiungiTappaView> {

    private Consumer<Tappa> onSuccess;
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

    public void setOnSuccess(Consumer<Tappa> onSuccess) {
        this.onSuccess = onSuccess;
    }

    private void rootClicked() {
        ViewNavigator.closeCurrentFloatingPage();
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
            Tappa t = StopsController.aggiungiTappa(getView().getNomeTextField().getText(), tipo);

            if (onSuccess != null) onSuccess.accept(t);
            ViewNavigator.closeCurrentFloatingPage();
        } catch (InvalidStopNameException _) {
            ViewNavigator.displayNotification("Errore", "Nome non valido.", Icon.APPICON);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }
}
