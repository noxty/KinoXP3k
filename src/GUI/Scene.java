package GUI;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;

/**
 * Created by Daniel on 26-02-2016.
 */
public class Scene extends Pane
{
    Scene()
    {
        setStyle("-fx-background-color: black");
        setPrefSize(1, 220);
        Insets in = new Insets(5,5,5,5);
        setPadding(in);
        setMaxWidth(20);
    }
}
