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
    LocalDate now;
    int daysFromNow;
    public static Calendar calendar = new Calendar();
    IOProcessing io = new IOProcessing();


    public InputOutputProcess () {
        now = LocalDate.now();
    }

    // Methods:

    /*
    processBooking():           Handles the booking process by coordinating between the user input and the model.
    processCancellation():      Handles the cancellation of an appointment.
    displayAvailableTimes():    Fetches and displays available times from the model.
    displayDayDetails():        Fetches and displays details of a specific day.
    initiatePayment():          Handles the payment process.
    */



    public void displayAvailableTimes(LocalDate date) {
        calendar.showDay(io.getDateNr(date));
    }

    //    Fetches and displays available times from the model.

    public void processBooking(String name, LocalDate date) {
        calendar.month.get(io.getDateNr(date));
    }


    private class IOProcessing {

        private int getDateNr(LocalDate date) {
            return io.daysFromNow(date);
        }

        public int daysFromNow(LocalDate date) {
            return now.compareTo(date);
        }

        public void showDayAndDaysFollowing(LocalDate date) {

            for (int i = 0; i < 7; i++) {
                calendar.showDay(getDateNr(date));
                date = date.plusDays(1);

            }

        }

    }
}
