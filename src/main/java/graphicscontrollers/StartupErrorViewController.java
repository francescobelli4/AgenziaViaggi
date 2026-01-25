package graphicscontrollers;

import views.StartupErrorView;

public class StartupErrorViewController extends GraphicsController<StartupErrorView> {


    public StartupErrorViewController(StartupErrorView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {
        getView().getExitButton().setOnMouseClicked(_ -> exitButtonClicked());
    }

    private void exitButtonClicked() {
        // This logic shouldn't be in the graphics controller, but I will put it here anyway to be clear :D
        System.exit(-1);
    }
}
