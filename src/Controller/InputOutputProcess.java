package src.Controller;

// function of InputOutputProcess Class:
/*
    Manage flow of information:
        UI User input -> IO Process -> Model
        UI information <- IO Process <- Model
*/

import src.Model.Appointment;
import src.Model.Calendar;
import src.View.UserInputScanner;

import java.time.LocalDate;

public class InputOutputProcess {
    LocalDate now;
    int daysFromNow;
    int dateNr;
    LocalDate date;
    int time;
    LocalDate newDate;
    int newTime;
    static boolean isFound;
    String customerName;

    public static Calendar calendar = new Calendar();
    IOProcessing io = new IOProcessing();
    UserInputScanner userInputScanner = new UserInputScanner();

    public InputOutputProcess () {
        now = LocalDate.now();
        
    }

    // Methods:
    // 1. subMenu methods:
    public void createBooking (String customerName) {
        io.getDateTime();
        io.processBooking(customerName, date, time);
    }
    
    public void registerHoliday(LocalDate date) {
        dateNr = io.getDateNr(date);
        calendar.getDay(dateNr).setDayAsHoliday();
    }

    public void cancelBooking(String customerName) {

        io.getDateTime();

        boolean isCancelled = false;

        while (!isCancelled) {
            // if-loop to 1) check if the appointment is booked and 2) check if the customerName matches the appointment:
            if (io.getAppointment(date, time).booked && io.getAppointment(date, time).customerName.equals(customerName)) {
                io.getAppointment(date, time).cancel();
                isCancelled = true;
            } else {
                System.out.println("Appointment not found.");
                System.out.println("--------------------");
                io.getDateTime();
            }
        }
    }

    public void changeBooking(String customerName) {
        io.findAppointmentWhileLoop();
        cancelBooking(customerName);
        io.newAppointment();
    }

    public void payLater(String customerName){
        io.findAppointmentWhileLoop();
        io.getAppointment(date, time).useCreditDelayPayment();
        io.getAppointment(date, time).setCustomerName(customerName);

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



    // inner Class IOProcessing for InputOutputProcess:
    // methods: appointment methods, process methods, date methods, display methods
    private class IOProcessing {
        // Methods:
        // 1. appointment methods:

        private void

        private void findAppointmentWhileLoop() {
            System.out.println("Lets find your appointment!");
            getDateTime();
            isFound = false;
            while (!isFound) {
                if (io.getAppointment(date, time).booked) {

                    isFound = true;
                    System.out.println("Appointment found!");
                } else {
                    System.out.println("Appointment not found.");
                    System.out.println("--------------------");
                    getDateTime();
                }
            }
        }

        private Appointment getAppointment(LocalDate date, int time) {
            return calendar.getDay(getDateNr(date)).getAppointment(time);
        }

        private void newAppointment () {
            getNewDateTime();

        }



        // 2. process methods:
        public void processBooking(String customerName, LocalDate date, int time) {
            calendar.month.get(getDateNr(date)).getAppointment(time).book(customerName);
        }

        // 3. date methods:
        private void getDateTime() {
            System.out.println("Enter date: ");
            date = userInputScanner.getDateInput();
            System.out.println("Enter time: ");
            time = userInputScanner.getIntInput();
        }
        private void getNewDateTime() {
            System.out.println("Enter new date: ");
            newDate = userInputScanner.getDateInput();
            System.out.println("Enter new time: ");
            newTime = userInputScanner.getIntInput();
        }

        private int getDateNr(LocalDate date) {
            return io.daysFromNow(date);
        }

        public int daysFromNow(LocalDate date) {
            return now.compareTo(date);
        }

        // 4. display methods:
        public void showDayAndDaysFollowing(LocalDate date) {

            for (int i = 0; i < 7; i++) {
                calendar.showDayAvailableTimes(getDateNr(date));
                date = date.plusDays(1);

            }

        }

    }

}
