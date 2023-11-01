package src.Controller;

// function of InputOutputProcess Class:
/*
    Manage flow of information:
        UI User input -> IO Process -> Model
        UI information <- IO Process <- Model
*/

import src.Model.Calendar;

import java.time.LocalDate;

public class InputOutputProcess {
    LocalDate now;
    int daysFromNow;
    int dateNr;
    public static Calendar calendar = new Calendar();
    IOProcessing io = new IOProcessing();

    public InputOutputProcess () {
        now = LocalDate.now();
    }

    // Methods:
    // 1. subMenu methods:
    public void registerHoliday(LocalDate date) {
        dateNr = io.getDateNr(date);
        calendar.getDay(dateNr).setDayAsHoliday();

    }

    public void cancelBooking() {

    }

    public void changeBooking(){

    }

    public void payLater(){


    }


    /*
    processBooking():           Handles the booking process by coordinating between the user input and the model.
    processCancellation():      Handles the cancellation of an appointment.
    displayAvailableTimes():    Fetches and displays available times from the model.
    displayDayDetails():        Fetches and displays details of a specific day.
    initiatePayment():          Handles the payment process.
    */


    // 2. additional Methods
    public void displayDateAvailableTimes(LocalDate date) {
        calendar.showDayAvailableTimes(io.getDateNr(date));
    }


    public void processBooking(String name, LocalDate date) {
        calendar.month.get(io.getDateNr(date));
    }


    // inner Class IOProcessing for InputOutputProcess:
    private class IOProcessing {

        private int getDateNr(LocalDate date) {
            return io.daysFromNow(date);
        }

        public int daysFromNow(LocalDate date) {
            return now.compareTo(date);
        }

        public void showDayAndDaysFollowing(LocalDate date) {

            for (int i = 0; i < 7; i++) {
                calendar.showDayAvailableTimes(getDateNr(date));
                date = date.plusDays(1);

            }

        }

    }

}
