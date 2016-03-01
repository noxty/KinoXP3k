package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class SubMovies
{
    public static BorderPane subWindow()
    {
        // Root
        BorderPane pane = new BorderPane();

        //SubTopBar
        HBox top = new HBox();
        top.getStyleClass().add("Sub-bar");

        Button create = new Button("Create");
        create.setStyle("-fx-background-color: pink;-fx-box-shadow:10px 10px 10px 10px");
        create.setOnMouseClicked(e -> {
            pane.setCenter(AddMovieView.getView());
        });
        Button edit = new Button("Edit");
        edit.setStyle("-fx-background-color: pink;-fx-box-shadow:10px 10px 10px 10px");

        Button delete = new Button("Delete");
        delete.setStyle("-fx-background-color: pink;-fx-box-shadow:10px 10px 10px 10px");


        top.getChildren().addAll(create, edit, delete);

        pane.setTop(top);
        top.setSpacing(10);
        top.setPadding(new Insets(10, 10, 10, 10));


        return pane;
    }
}
