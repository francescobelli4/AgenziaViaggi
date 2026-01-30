package graphicscontrollers;

import models.Report;
import views.ReportsElementView;

public class ReportsElementViewController extends GraphicsController<ReportsElementView> {

    private final Report report;

    public ReportsElementViewController(ReportsElementView view, Report report) {
        super(view);
        this.report = report;

        loaded();
    }

    @Override
    public void loaded() {

        getView().getCodiceLabel().setText(report.getCodiceViaggio());
        getView().getItinerarioLabel().setText(report.getItinerario());
        getView().getEntrateLabel().setText("€ " + report.getEntrate());
        getView().getUsciteLabel().setText("€ " + report.getUscite());
        getView().getGuadagnoLabel().setText("€ " + report.getGuadagno());
    }
}
