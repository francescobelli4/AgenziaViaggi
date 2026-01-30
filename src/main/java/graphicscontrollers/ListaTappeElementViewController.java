package graphicscontrollers;

import appcontrollers.StopsController;
import exception.DAOException;
import javafx.scene.image.Image;
import models.Tappa;
import views.*;

import java.util.Objects;

public class ListaTappeElementViewController extends GraphicsController<ListaTappeElementView> {

    private final Tappa tappa;

    public ListaTappeElementViewController(ListaTappeElementView view, Tappa tappa) {
        super(view);
        this.tappa = tappa;

        loaded();
    }

    @Override
    public void loaded() {

        getView().getStopLabel().setText(tappa.getNome());

        Image image = switch (tappa.getTipo()) {
            case CITTA -> new Image(Objects.requireNonNull(getClass().getResource(Icon.CITY.getPath())).toExternalForm());
            case LUOGO -> new Image(Objects.requireNonNull(getClass().getResource(Icon.LOCATION.getPath())).toExternalForm());
        };

        getView().getIconImageView().setImage(image);

        getView().getDeleteButton().setOnMouseClicked(_ -> deleteButtonClicked());
    }

    private void deleteButtonClicked() {

        try {
            StopsController.eliminaTappa(tappa);

            ListaTappeView listaTappe = (ListaTappeView) ((HomeView)ViewNavigator.getActiveView()).getActiveView();
            ((ListaTappeViewController)listaTappe.getGraphicsController()).updateLists();
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }

    public Tappa getTappa() {
        return tappa;
    }
}
