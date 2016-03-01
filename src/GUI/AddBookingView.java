package GUI;

import Classes.Customer;
import Classes.Seats;
import Data.DB;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class AddBookingView
{

    static int ScreeningID =0;



    public static VBox getView(int screeningID)
    {
        final int[] customerID = {0};

        VBox layout = new VBox();
        GridPane layoutGrid = new GridPane();
        int gaps = 10;

        layoutGrid.setHgap(gaps);
        layoutGrid.setVgap(gaps);

        // Buttons
        Button buttonAdd = new Button("Add Booking");

        HBox buttonBox = new HBox(gaps);
        buttonBox.getChildren().addAll(buttonAdd);

        // Tid, antal sæder, sal, sæde numre;

        //fetch kunde
        Label labelNumber = new Label("Phone number:");
        TextField phoneText = new TextField();
        Button buttonFetch = new Button("Fetch");
        Label labelError = new Label();

        //Larred
        Scene scene = new Scene();

        //Opret kunde
        Label labelFname = new Label("First name:");
        Label labelLname = new Label("Last name:");
        TextField fName = new TextField();
        TextField lName = new TextField();



        HBox fieldPickedSeats = new HBox();


        buttonFetch.setOnAction(event1 ->
        {

            List<Customer> customers = Customer.getCustomers("SELECT fName, lName, phoneNo, customerID FROM customer WHERE phoneNo = " + phoneText.getText());
            customerID[0] = customers.get(0).getCustomerID();

            if (customers.size() < 1) {
                labelError.setText("No customer found!");
            } else {
                for (Customer c : customers) {
                    fName.setText(c.getFirstName());
                    lName.setText(c.getLastName());
                    // vil du noget med phone#
                    // c.getPhone()
                }
            }
        });

        buttonAdd.setOnAction(event -> {
            //opret eller hent kunde "If not exsist insert into"
            //Tag kundeID Screening ID seat og row,
            Seats seat = new Seats();

            ShowScreeningsView ssv = ShowScreeningsView.getInstance();

            for(int i = 0; i < seat.getSize(); i++)
            {
                try
                {
                    DB db = DB.getInstance();

                    PreparedStatement prepStmt;

                    String sqlString = "INSERT INTO booking(screeningID, customerID, row, seat) VALUES(?, ?, ?, ?)";

                    prepStmt = db.getConnection().prepareStatement(sqlString);

                    prepStmt.setString(1, Integer.toString(screeningID));
                    prepStmt.setString(2, Integer.toString(customerID[0]));
                    prepStmt.setString(3, Integer.toString(seat.getSeat(i).getRow()));
                    prepStmt.setString(4, Integer.toString(seat.getSeat(i).getSeat()));

                    prepStmt.executeUpdate();

                    // getScreeningID(); -> movieID, theatreID, showtime.

                    //Får kunde information fra fetch og looper igennem for hvor mange sæder der er markeret
                    System.out.println(phoneText.getText() + " is the customers phonenumber");
                    System.out.println(fName.getText() + " is the first name of the customer");
                    System.out.println(lName.getText() + " is the last name of the customer");
                    System.out.println(seat.getSeat(i).getRow() + " is the row number");
                    System.out.println(seat.getSeat(i).getSeat() + " is the seat number");
                    System.out.println(screeningID);
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }

        });

        // theatreID store= 0 / lille= 1
        if(true)
        {
            fieldPickedSeats.getChildren().addAll(TheatreMap.bigTheatre());
        }
        else
        {
            fieldPickedSeats.getChildren().addAll(TheatreMap.smallTheatre());
        }

        layoutGrid.add(labelNumber, 0, 0);
        layoutGrid.add(buttonFetch, 2, 0);
        layoutGrid.add(phoneText, 1, 0);
        layoutGrid.add(labelError, 3,0);

        //Customer
        layoutGrid.add(labelFname,0,1);
        layoutGrid.add(fName,1,1);
        layoutGrid.add(labelLname,0,2);
        layoutGrid.add(lName,1,2);


        layoutGrid.add(scene, 0, 4);
        layoutGrid.add(fieldPickedSeats, 1, 4);
        layoutGrid.add(buttonBox, 1, 5);

        layout.getChildren().add(layoutGrid);
        return layout;
    }

    public void saveBooking(int id)
    {

    }

    public static int getScreeningID()
    {
        return ScreeningID;
    }

    public static void setScreeningID(int screeningID)
    {
        ScreeningID = screeningID;
    }
}
