package graphicscontrollers;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import models.Albergo;
import models.Tappa;
import views.Icon;
import views.InfoViaggioListaAlberghiPerCittaView;
import views.InfoViaggioTappaElementView;
import views.ViewNavigator;

import java.util.Objects;


public class InfoViaggioTappaElementViewController extends GraphicsController<InfoViaggioTappaElementView> implements InfoViaggioListaAlberghiPerCittaViewController.Listener {

    private Tappa tappa;
    private Albergo selectedHotel;

    public InfoViaggioTappaElementViewController(InfoViaggioTappaElementView view, Tappa tappa) {
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

        if (tappa.getTipo() == Tappa.Tipo.CITTA) {
            getView().getRoot().getStyleClass().add("citta");
            getView().getRoot().setOnMouseClicked(this::elementClicked);
        }
    }

    private void elementClicked(MouseEvent e) {
        e.consume();
        InfoViaggioListaAlberghiPerCittaView dialog = ViewNavigator.displayInfoViaggioListaAlberghiPerCittaView(tappa);
        ((InfoViaggioListaAlberghiPerCittaViewController) dialog.getGraphicsController()).setListener(this);
    }

    @Override
    public void hotelSelected(Albergo albergo) {
        selectedHotel = albergo;
        getView().getStopLabel().setText(tappa.getNome() + " - " + albergo.getNome());
    }

    public Albergo getSelectedHotel() {
        return selectedHotel;
    }
}
