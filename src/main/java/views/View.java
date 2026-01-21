package views;

import graphicscontrollers.GraphicsController;
import javafx.scene.Parent;

public interface View {

    void init();
    void close();
    Parent getRoot();
    Page getPage();

    GraphicsController<? extends View> getGraphicsController();
}
