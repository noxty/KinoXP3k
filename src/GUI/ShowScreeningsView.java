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
import javafx.scene.layout.Pane;


import java.util.List;

/**
 * Created by Claes Gottlieb on 29/02/16.
 */
public class ShowScreeningsView
{
    private static ShowScreeningsView Instance = new ShowScreeningsView();
    public static ShowScreeningsView getInstance()
    {
        return Instance;
    }

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

        ObservableList<Screening> screenings = Screening.getScreening("SELECT screeningID, title, theatre.theatreName, showtime, screening.movieID, screening.theatreID " +
                                                                        "FROM screening " +
                                                                        "JOIN movie ON screening.movieID = movie.movieID " +
                                                                        "JOIN theatre ON screening.theatreID = theatre.theatreID " +
                                                                        "WHERE screening.movieID = " + i);

        // TableView "tableBookings"
        tableViewScreening = new TableView();
        tableViewScreening.setEditable(true);

        // TableColumns (tc)
        tcScreeningID = new TableColumn("Screening ID");
        tcScreeningID.setCellValueFactory(new PropertyValueFactory<Screening, Integer>("screeningID"));

        tcMovieID = new TableColumn("Movie Title");
        tcMovieID.setCellValueFactory(new PropertyValueFactory<Screening, String>("title"));

        tcTheatreID = new TableColumn("Theatre");
        tcTheatreID.setCellValueFactory(new PropertyValueFactory<Screening, String>("theatreName"));

        tcShowtime = new TableColumn("Date/Time");
        tcShowtime.setCellValueFactory(new PropertyValueFactory<Screening, String>("showtime"));

        tableViewScreening.getColumns().addAll(tcScreeningID, tcMovieID, tcTheatreID, tcShowtime);

        tableViewScreening.setItems(screenings);
        pane.setCenter(tableViewScreening);
        tableViewScreening.setOnMouseClicked(e ->
                {
                    Screening s = (Screening) tableViewScreening.getSelectionModel().getSelectedItem();

                    pane.setCenter(AddBookingView.getView(s.getScreeningID()));

                    System.out.println(s.getScreeningID());
                }
        );
        return pane;
    }
}
