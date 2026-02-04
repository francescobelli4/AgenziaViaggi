package graphicscontrollers;

import appcontrollers.AutobusController;
import exception.InvalidAutobusDataException;
import javafx.scene.layout.StackPane;
import models.Autobus;
import views.*;

import java.util.function.Consumer;

public class AggiungiAutobusViewController extends GraphicsController<AggiungiAutobusView> {

    private Consumer<Autobus> onSuccess;

    public AggiungiAutobusViewController(AggiungiAutobusView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {
        getView().getRoot().setOnMouseClicked(_ -> rootClicked());
        getView().getAggiungiButton().setOnMouseClicked(_ -> aggiungiButtonClicked());
    }

    public void setOnSuccess(Consumer<Autobus> onSuccess) {
        this.onSuccess = onSuccess;
    }

    private void rootClicked() {
        ViewNavigator.closeCurrentFloatingPage();
    }

    private void aggiungiButtonClicked() {

        int costo;
        int capienza;

        try {
            costo = Integer.parseInt(getView().getCostoTF().getText());
        } catch (NumberFormatException _) {
            ViewNavigator.displayNotification("Errore", "Costo non valido", Icon.APPICON);
            return;
        }

        try {
            capienza = Integer.parseInt(getView().getCapienzaTF().getText());
        } catch (NumberFormatException _) {
            ViewNavigator.displayNotification("Errore", "Capienza non valida", Icon.APPICON);
            return;
        }

        try {
            Autobus autobus = AutobusController.aggiungiAutobus(getView().getTargaTF().getText(), capienza, costo);

            if (onSuccess != null) onSuccess.accept(autobus);
            ViewNavigator.closeCurrentFloatingPage();
        } catch (InvalidAutobusDataException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }
}
