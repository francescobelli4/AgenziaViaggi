package graphicscontrollers;

import appcontrollers.StopsController;
import exception.DAOException;
import javafx.scene.image.Image;
import models.Tappa;
import views.*;

import java.util.Objects;
import java.util.function.Consumer;

public class ListaTappeElementViewController extends GraphicsController<ListaTappeElementView> {

    Consumer<Tappa> onDeleted;
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

    public void setOnDeleted(Consumer<Tappa> onDeleted) {
        this.onDeleted = onDeleted;
    }

    private void deleteButtonClicked() {

        try {
            StopsController.eliminaTappa(tappa);
            if (onDeleted != null) onDeleted.accept(tappa);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }

    public Tappa getTappa() {
        return tappa;
    }
}
