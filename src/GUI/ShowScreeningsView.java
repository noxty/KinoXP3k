package GUI;

import Classes.Booking;
import Classes.Screening;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;


import java.util.List;

/**
 * Created by Claes Gottlieb on 29/02/16.
 */
public class ShowScreeningsView
{
    // TableView Instance
    static TableView tableViewScreening;

    // TableColumns Instances
    static TableColumn tcScreeningID, tcMovieID, tcTheatreID, tcShowtime;

    // Button Instance
    static Button buttonFind;

    //Observablelist
    static ObservableList<Booking> observableListBooking;


    // Following method assembles the tableView for bookings
    // The body contains functions for searching through- and deleting bookings

    public static BorderPane getView(int i)
    {
        BorderPane pane = new BorderPane();

        ObservableList<Screening> screenings = Screening.getScreening("SELECT screeningID, movieID, TheatreID, showtime FROM screening WHERE movieID = " + i);

        // TableView "tableBookings"
        tableViewScreening = new TableView();
        tableViewScreening.setEditable(true);

        // TableColumns (tc)
        tcScreeningID = new TableColumn("Screening ID");
        tcScreeningID.setCellValueFactory(new PropertyValueFactory<Screening, Integer>("screeningID"));

        tcMovieID = new TableColumn("Movie ID");
        tcMovieID.setCellValueFactory(new PropertyValueFactory<Screening, Integer>("movieID"));

        tcTheatreID = new TableColumn("Theatre ID");
        tcTheatreID.setCellValueFactory(new PropertyValueFactory<Screening, Integer>("TheatreID"));

        tcShowtime = new TableColumn("Date/Time");
        tcShowtime.setCellValueFactory(new PropertyValueFactory<Screening, String>("showtime"));

        tableViewScreening.getColumns().addAll(tcScreeningID, tcMovieID, tcTheatreID, tcShowtime);

        tableViewScreening.setItems(screenings);
        pane.setCenter(tableViewScreening);

        return pane;
    }
}