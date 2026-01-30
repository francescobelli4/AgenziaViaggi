package graphicscontrollers;

import appcontrollers.HotelController;
import dtos.AlbergoDTO;
import exception.DAOException;
import exception.InvalidHotelDataException;
import javafx.scene.layout.StackPane;
import views.*;

public class AggiungiAlbergoViewController extends GraphicsController<AggiungiAlbergoView> {


    public AggiungiAlbergoViewController(AggiungiAlbergoView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {
        getView().getRoot().setOnMouseClicked(_ -> rootClicked());
        getView().getAggiungiButton().setOnMouseClicked(_ -> aggiungiButtonClicked());
    }

    private void rootClicked() {
        ((StackPane)ViewNavigator.getActiveView().getRoot()).getChildren().remove(getView().getRoot());
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
            HotelController.aggiungiAlbergo(new AlbergoDTO(
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

            ListaAlberghiView listaAlberghi = (ListaAlberghiView) ((HomeView)ViewNavigator.getActiveView()).getActiveView();
            ((ListaAlberghiViewController)listaAlberghi.getGraphicsController()).updateLists();
            rootClicked();
        } catch (InvalidHotelDataException | DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }
}
