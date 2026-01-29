package graphicscontrollers;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import models.Itinerario;
import models.Tappa;
import views.Icon;
import views.ListaTappePerItinerarioElementView;
import views.ListaTappePerItinerarioView;
import views.ViewNavigator;

import java.util.Objects;

public class ListaTappePerItinerarioElementViewController extends GraphicsController<ListaTappePerItinerarioElementView> {

    private final Tappa tappa;

    public ListaTappePerItinerarioElementViewController(ListaTappePerItinerarioElementView view, Tappa tappa) {
        super(view);
        this.tappa = tappa;
        loaded();
    }

    @Override
    public void loaded() {
        getView().getTappaLabel().setText(tappa.getNome());

        Image image = switch (tappa.getTipo()) {
            case CITTA -> new Image(Objects.requireNonNull(getClass().getResource(Icon.CITY.getPath())).toExternalForm());
            case LUOGO -> new Image(Objects.requireNonNull(getClass().getResource(Icon.LOCATION.getPath())).toExternalForm());
        };

        getView().getTappaIcon().setImage(image);
    }


    public Tappa getTappa() {
        return tappa;
    }
}
