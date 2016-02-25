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

        Button btn1 = new Button("Create");
        btn1.setOnMouseClicked(e -> {
            pane.setCenter(AddBookingView.getView());
        });
        Button btn2 = new Button("Edit");
        Button btn3 = new Button("Delete");

        top.getChildren().addAll(btn1, btn2, btn3);

        pane.setTop(top);


        return pane;
    }
}
