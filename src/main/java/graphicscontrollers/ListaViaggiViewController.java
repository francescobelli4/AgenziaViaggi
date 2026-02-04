package graphicscontrollers;

import appcontrollers.ToursController;
import exception.DAOException;
import javafx.scene.Node;
import models.Role;
import models.User;
import models.Viaggio;
import views.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ListaViaggiViewController extends GraphicsController<ListaViaggiView> {

    private List<Viaggio> viaggi = new ArrayList<>();

    public ListaViaggiViewController(ListaViaggiView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {

        if (User.getInstance().getRole() == Role.BOOKING) {
            getView().getAddButton().setVisible(false);
            getView().getAddButton().setManaged(false);
        }

        viaggi = ToursController.getTours();
        updateLists();

        getView().getAddButton().setOnMouseClicked(_ -> addButtonClicked());
    }

    private void aggiungiViaggio(Viaggio viaggio) {
        this.viaggi.add(viaggio);
        updateLists();
    }

    public void updateLists() {

        try {

            List<Node> pastToursNodes = new ArrayList<>();
            List<Node> futureToursNodes = new ArrayList<>();
            for (Viaggio i : viaggi) {

                if (ChronoUnit.DAYS.between(LocalDate.now(), i.getPartenza()) <= 0) {
                    pastToursNodes.add(ViewFactory.createListaViaggiElementView(i).getRoot());
                } else {
                    futureToursNodes.add(ViewFactory.createListaViaggiElementView(i).getRoot());
                }
            }

            getView().setPastTours(pastToursNodes);
            getView().setFutureTours(futureToursNodes);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Error", e.getMessage(), Icon.APPICON);
        }
    }

    private void addButtonClicked() {
        AggiungiViaggioView aggiungiViaggioView = ViewNavigator.displayAggiungiViaggioView();
        AggiungiViaggioViewController aggiungiViaggioViewController = (AggiungiViaggioViewController) aggiungiViaggioView.getGraphicsController();
        aggiungiViaggioViewController.setOnSuccess(this::aggiungiViaggio);
    }
}
