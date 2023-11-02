package src.Controller;

// function of InputOutputProcess Class:
/*
    Manage flow of information:
        UI User input -> IO Process -> Model
        UI information <- IO Process <- Model
*/

import src.Model.Appointment;
import src.Model.AppointmentDay;
import src.Model.Calendar;
import src.View.UserInputScanner;
import src.View.UserInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
    UserInterface ui = new UserInterface();
    UserInterface.CalGrid calGrid;

    public InputOutputProcess () {
        this.now = LocalDate.now();
    }

    public void showCalGrid(LocalDate firstDate){

        calGrid = new UserInterface.CalGrid(calendar.getDays(firstDate, 5), firstDate);

        calGrid.showCalGrid();
    }


    // Methods:
    // 1. subMenu methods:
    public void createBooking (String customerName) {
        io.getDateTime();
        io.processBooking(customerName, date, time);
    }
    public void createCalGridBooking () {

        String[] times = UserInterface.CalGrid.times;
        String[] days = UserInterface.CalGrid.days;
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("Enter Day (MON/TUE/WED/THU/FRI)");
        String inputDay = scan.nextLine();
        System.out.println();

        System.out.println("Enter Time (10/11/12/13/14/15/16/17)");
        int inputTime = scan.nextInt();
        scan.nextLine();

        String inputTimeStr = times[inputTime - 10];
        // Integer.toString(inputTime) + ":00";

        int dayIndex = 0;
        int timeIndex = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i].equalsIgnoreCase(inputDay)) {
                dayIndex = i;
                break;
            }
        }
        for (int i = 0; i < times.length; i++) {
            if (times[i].equals(inputTimeStr)) {
                timeIndex = i;
                break;
            }
        }

        calendar.getDay(dayIndex).getAppointment(timeIndex).book(customerName);
        System.out.println("Booking successful!");
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


    }


    public ArrayList<AppointmentDay> getCalDays (LocalDate date, int nrOfDays) {
        return calendar.getDays(date, nrOfDays);
    }
    /*
    processBooking():           Handles the booking process by coordinating between the user input and the model.
    processCancellation():      Handles the cancellation of an appointment.
    displayAvailableTimes():    Fetches and displays available times from the model.
    displayDayDetails():        Fetches and displays details of a specific day.
    initiatePayment():          Handles the payment process.
    */

    // 2. additional Methods
    // showCal method




    // inner Class IOProcessing for InputOutputProcess:
    // methods: appointment methods, process methods, date methods, display methods
    private class IOProcessing {
        // Methods:
        // 1. appointment methods:

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


    }

}
