package graphicscontrollers;

import appcontrollers.HotelController;
import dtos.AlbergoDTO;
import exception.DAOException;
import exception.InvalidHotelDataException;
import javafx.scene.layout.StackPane;
import models.Albergo;
import views.*;

import java.util.function.Consumer;

public class AggiungiAlbergoViewController extends GraphicsController<AggiungiAlbergoView> {

    private Consumer<Albergo> onSuccess;

    public AggiungiAlbergoViewController(AggiungiAlbergoView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {
        getView().getRoot().setOnMouseClicked(_ -> rootClicked());
        getView().getAggiungiButton().setOnMouseClicked(_ -> aggiungiButtonClicked());
    }

    public void setOnSuccess(Consumer<Albergo> onSuccess) {
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
            Albergo albergo = HotelController.aggiungiAlbergo(new AlbergoDTO(
                    getView().getNomeTF().getText(),
                    getView().getCittaTF().getText(),
                    getView().getIndirizzoTF().getText(),
                    costo,
                    capienza,
                    getView().getEmailTF().getText(),
                    getView().getTelefonoTF().getText(),
                    getView().getFaxTF().getText(),
                    getView().getCfTF().getText(),
                    getView().getRefNomeTF().getText(),
                    getView().getCognomeTF().getText()
            ));

            if (onSuccess != null) onSuccess.accept(albergo);
            ViewNavigator.closeCurrentFloatingPage();
        } catch (InvalidHotelDataException | DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }
}
