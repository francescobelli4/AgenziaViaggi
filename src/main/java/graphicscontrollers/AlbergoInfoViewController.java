package graphicscontrollers;

import javafx.scene.layout.StackPane;
import models.Albergo;
import views.AlbergoInfoView;
import views.ViewNavigator;

public class AlbergoInfoViewController extends GraphicsController<AlbergoInfoView> {

    private final Albergo albergo;

    public AlbergoInfoViewController(AlbergoInfoView view, Albergo albergo) {
        super(view);
        this.albergo = albergo;
        loaded();
    }

    @Override
    public void loaded() {
        getView().getRoot().setOnMouseClicked(_ -> rootClicked());

        getView().getNomeTA().setText(albergo.getNome());
        getView().getCittaTA().setText(albergo.getCitta());
        getView().getIndirizzoTA().setText(albergo.getIndirizzo());
        getView().getCostoTA().setText(albergo.getCosto()+" €");
        getView().getCapienzaTA().setText(albergo.getCapienza() + "");
        getView().getReferenteTA().setText(String.format("(%s) %s %s", albergo.getReferente().getCF(), albergo.getReferente().getNome(), albergo.getReferente().getCognome()));
        getView().getEmailTA().setText(albergo.getEmail());
        getView().getTelefonoTA().setText(albergo.getTelefono());
        getView().getFaxTA().setText(albergo.getFax());
    }

    private void rootClicked() {
        ((StackPane)ViewNavigator.getActiveView().getRoot()).getChildren().remove(getView().getRoot());
    }
}
