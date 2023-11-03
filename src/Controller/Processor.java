package src.Controller;

// function of Processor Class:
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

public class Processor {
    // instance variables:
    LocalDate now;
    int daysFromNow;
    int dateNr;
    LocalDate date;
    int time;
    LocalDate newDate;
    int newTime;
    static boolean isFound;
    String customerName;

    // objects for integrations with View and Model:
    public static Calendar calendar = new Calendar();
    IOProcessing io = new IOProcessing();
    UserInputScanner userInputScanner = new UserInputScanner();
    UserInterface ui = new UserInterface();
    UserInterface.CalGrid calGrid;

    // constructor:
    public Processor() {
        this.now = LocalDate.now();
    }

    // Methods:

    // 1. subMenu methods:
    public void createBooking (String customerName) {
        io.getDateTime();
        io.processBooking(customerName, date, time);
    }
    public void createCalGridBooking (LocalDate date, String customerName) {

        String[] times = UserInterface.CalGrid.times;
        String[] days = UserInterface.CalGrid.days;

        System.out.println("\nEnter Day (MON/TUE/WED/THU/FRI)");
        String inputDay = userInputScanner.getDayInput();

        System.out.println("\nEnter Time (10/11/12/13/14/15/16/17)");
        int inputTime = userInputScanner.getTimeInput();

        LocalDate dateInput = calGrid.getDate(inputDay);
        int timeInput = calGrid.getTime(inputTime);


        if (!calendar.isAvailable(dateInput, timeInput)) {
            System.out.println("Appointment not available.");
            System.out.println("Try again.");
            createCalGridBooking(date, customerName);
        } else {
            io.processBooking(customerName, dateInput, timeInput);
            System.out.println("Booked: "+ customerName + " on " + dateInput.toString() + " at " + times[timeInput] + "!\n");
        }

    }

    public void registerHoliday(LocalDate date) {
        calendar.getDate(date).setDayAsHoliday();
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

    // 2. display methods:
    public void showCalGrid(LocalDate firstDate){

        calGrid = new UserInterface.CalGrid(calendar.getDays(firstDate, 5), firstDate);

        calGrid.showCalGrid();
    }

    // 3. get methods:
    public ArrayList<AppointmentDay> getCalDays (LocalDate date, int nrOfDays) {
        return calendar.getDays(date, nrOfDays);
    }

    public void showCalGridInfo() {
        System.out.println("Info: - = available, X = booked, H = holiday, W = weekend\n");
    }

    // inner Class IOProcessing for InputOutputProcess:
    /*
        Function:
        - logic for handling methods of InputOutputProcess
        -> executing from controller <- -> Model

        Manage flow of information:
            UI User input -> IO Process -> Model
            UI information <- IO Process <- Model
     */
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
            return calendar.getDate(date).getAppointment(time);
        }

        private void newAppointment () {
            getNewDateTime();

        }

        // 2. process methods:
        public void processBooking(String customerName, LocalDate date, int time) {
            calendar.getDate(date).getAppointment(time).book(customerName);
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

    }
}
