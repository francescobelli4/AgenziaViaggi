package graphicscontrollers;

import javafx.scene.image.Image;
import models.Tappa;
import views.AggiungiItinerarioTappaElementView;
import views.Icon;

import java.util.Objects;

public class AggiungiItinerarioTappaElementViewController extends GraphicsController<AggiungiItinerarioTappaElementView> {

    private final Tappa tappa;

    public AggiungiItinerarioTappaElementViewController(AggiungiItinerarioTappaElementView view, Tappa tappa) {
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
