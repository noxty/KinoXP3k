package GUI;

import Controller.ScreeningController;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class SubScreening
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
            pane.setCenter(ScreeningView.getView());
        });
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");
        Button test = new Button("Tilføj Screening Test");
        test.setOnMouseClicked(e ->
                {
                    ScreeningController sc = ScreeningController.getInstance();
                    sc.testScreening();
                }
        );

        top.getChildren().addAll(create, edit, delete, test);

        pane.setTop(top);


        return pane;
    }
}
