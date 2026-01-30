package graphicscontrollers;

import appcontrollers.AutobusController;
import exception.InvalidAutobusDataException;
import javafx.scene.layout.StackPane;
import views.*;

public class AggiungiAutobusViewController extends GraphicsController<AggiungiAutobusView> {

    public AggiungiAutobusViewController(AggiungiAutobusView view) {
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
            AutobusController.aggiungiAutobus(getView().getTargaTF().getText(), capienza, costo);

            ListaAutobusView listaAutobus = (ListaAutobusView) ((HomeView)ViewNavigator.getActiveView()).getActiveView();
            ((ListaAutobusViewController)listaAutobus.getGraphicsController()).updateLists();
            rootClicked();
        } catch (InvalidAutobusDataException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }
}
