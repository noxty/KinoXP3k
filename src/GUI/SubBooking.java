package GUI;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;



public class SubBooking
{
    public static BorderPane subWindow()
    {
        // Root
        BorderPane pane = new BorderPane();

        //SubTopBar
        HBox top = new HBox();
        top.getStyleClass().add("Sub-bar");

        Button create = new Button("Create");
        create.setOnMouseClicked(e -> {
            pane.setCenter(AddBookingView.getView());
        });
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");

        top.getChildren().addAll(create, edit, delete);

        pane.setTop(top);


        return pane;
    }
}
