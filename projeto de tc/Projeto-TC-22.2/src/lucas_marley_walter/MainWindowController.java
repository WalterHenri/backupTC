package lucas_marley_walter;


import javafx.fxml.FXML;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindowController{
    @FXML private Pane generalArea;
    @FXML private ImageView closeButton;

    
    private double x,y;

    public void init(Stage stage) {
        generalArea.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        generalArea.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });
    }
    
}
