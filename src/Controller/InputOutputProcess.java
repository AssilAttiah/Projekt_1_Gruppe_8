package src.Controller;

// function of InputOutputProcess Class:
/*
    Manage flow of information:
        UI User input -> IO Process -> Model
        UI information <- IO Process <- Model
*/

import src.Model.Calendar;
import src.View.UserInputScanner;

import java.time.LocalDate;

public class InputOutputProcess {

    public static Calendar calendar = new Calendar();

    // Methods:

    /*
    processBooking():           Handles the booking process by coordinating between the user input and the model.
    processCancellation():      Handles the cancellation of an appointment.
    displayAvailableTimes():    Fetches and displays available times from the model.
    displayDayDetails():        Fetches and displays details of a specific day.
    initiatePayment():          Handles the payment process.
    */


    public void processBooking(String name, LocalDate date) {
        calendar.getDate(date);
    }

    public void checkDate(String name, LocalDate date) {
        calendar.checkDate(name, date);
    }

    public void checkTime(String name, LocalDate date, double time) {
        calendar.checkTime(name, date, time);
    }


}
