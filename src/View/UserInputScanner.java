package src.View;

// function of Class: Calendar
/*
        Scanner class for user input.
        function:
        - standardize user input
        - error handling
        - input validation

*/

import java.time.LocalDate;
import java.util.Scanner;

public class UserInputScanner {
    Scanner scanner;

    public UserInputScanner() {
        this.scanner = newScannerErrorHandling();
    }

    private Scanner newScannerErrorHandling () {
        try {
            return new Scanner(System.in);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    // methods:
    // get name methods
    public String getCustomerName() {
        String customerName = getNameInput("customer first name");
        System.out.println("--------------------");
        return customerName;
    }
    public String getNameInput(String nameType) {
        System.out.println("Enter "+nameType+": ");
        try {
            return scanner.next();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    // get day input
    public String getDayInput() {
        String[] days = {"MON", "TUE", "WED", "THU", "FRI"};

        String dayInput = getStringInput();
        while (!checkDayInput(dayInput, days)) {
            System.out.println("Error: Invalid day input");
            System.out.println("Enter Day (MON/TUE/WED/THU/FRI)");
            dayInput = getStringInput();
        }
        return dayInput;
    }
    private boolean checkDayInput(String dayInput, String[] days) {
        for (String day : days) {
            if (dayInput.equals(day)) {
                return true;
            }
        }
        return false;
    }

    // get time input
    public Integer getTimeInput() {
        int[] times = {10, 11, 12, 13, 14, 15, 16, 17};

        int timeInput = getIntInput();
        while (!checkTimeInput(timeInput, times)) {
            System.out.println("Error: Invalid time input");
            System.out.println("Enter Time (10/11/12/13/14/15/16/17)");
            timeInput = getIntInput();
        }
        return timeInput;
    }
    private boolean checkTimeInput(int timeInput, int[] times) {
        for (int time : times) {
            if (timeInput==time) {
                return true;
            }
        }
        return false;
    }

    // get datatype input
    public int getIntInput() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return 0;
    }

    public String getStringInput() {
        try {
            return scanner.next();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public LocalDate getDateInput(){
        return nextDate();
    }

    private LocalDate nextDate() {
        System.out.println("Enter date in format yyyy-mm-dd: ");
        String dateInput = scanner.next();
        try {
            return LocalDate.parse(dateInput);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }


}

