package graphicscontrollers;

import appcontrollers.ItinerariesController;
import appcontrollers.StopsController;
import exception.InvalidItineraryCostException;
import exception.InvalidItineraryNameException;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import models.Tappa;
import views.*;

import java.util.*;

public class AggiungiItinerarioViewController extends GraphicsController<AggiungiItinerarioView> {

    private final List<AggiungiItinerarioTappaElementView> tappeViews = new ArrayList<>();

    public AggiungiItinerarioViewController(AggiungiItinerarioView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {
        getView().getRoot().setOnMouseClicked(_ -> rootClicked());
        getView().getAggiungiButton().setOnMouseClicked(_ -> aggiungiButtonClicked());

        List<Node> tappe = new ArrayList<>();
        for (Tappa t : StopsController.getTappe()) {
            tappeViews.add(ViewFactory.createAggiungiItinerarioTappaElementView(t));
            tappe.add(tappeViews.getLast().getRoot());
        }
        getView().setElements(tappe);
    }

    private void rootClicked() {
        ((StackPane)ViewNavigator.getActiveView().getRoot()).getChildren().remove(getView().getRoot());
    }


    private void aggiungiButtonClicked() {

        int costo;

        try {
            costo = Integer.parseInt(getView().getCostoTextField().getText());
        } catch (NumberFormatException _) {
            ViewNavigator.displayNotification("Errore", "Costo non valido", Icon.APPICON);
            return;
        }

        Map<Integer, Tappa> tappeSortedTree = new TreeMap<>();

        for (AggiungiItinerarioTappaElementView v : tappeViews) {

            if (v.getTappaCheckbox().isSelected()) {

                int ordine;

                try {
                    ordine = Integer.parseInt(v.getOrdineTF().getText());
                } catch (NumberFormatException _) {
                    ViewNavigator.displayNotification("Errore", "Una delle tappe ha un numero di ordine non valido. (da 0 a N)", Icon.APPICON);
                    return;
                }

                if (ordine < 0 || tappeSortedTree.containsKey(ordine)) {
                    ViewNavigator.displayNotification("Errore", "Una delle tappe ha un numero di ordine non valido. (da 0 a N)", Icon.APPICON);
                    return;
                }

                AggiungiItinerarioTappaElementViewController controller = (AggiungiItinerarioTappaElementViewController) v.getGraphicsController();
                tappeSortedTree.put(ordine, controller.getTappa());
            }
        }

        try {
            ItinerariesController.aggiungiItinerario(getView().getNomeTextField().getText(), costo, new ArrayList<>(tappeSortedTree.values()));

            ListaItinerariView listaItinerari = (ListaItinerariView) ((HomeView)ViewNavigator.getActiveView()).getActiveView();
            ((ListaItinerariViewController)listaItinerari.getGraphicsController()).updateLists();
            rootClicked();
        } catch (InvalidItineraryNameException _) {
            ViewNavigator.displayNotification("Errore", "Nome itinerario non valido.", Icon.APPICON);
        } catch (InvalidItineraryCostException _) {
            ViewNavigator.displayNotification("Errore", "Costo itinerario non valido.", Icon.APPICON);
        }
    }
}
