package GUI;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Created by Hans on 24-02-2016.
 */
public class HomeView
{
    public static VBox getView() {
        VBox layout = new VBox();
        Text message = new Text("Velkommen til KinoXP3k");

        layout.getChildren().add(message);

        return layout;
    }
}
