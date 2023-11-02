package src.View;

// function of Class: Calendar
/*
        Scanner for Menu class
        It will be responsible for capturing user input based on the options presented.
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

    public String getCustomerName() {
        System.out.println("Enter customer name: ");
        String customerName = getNameInput("customer name");
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

    public double getDoubleInput(){
        try {
            return scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return 0;
    }

    public LocalDate getDateInput(){

        return nextDate();
    }

    private LocalDate nextDate() {
        System.out.println("Enter date in format dd-mm-yyyy: ");
        try {
            return LocalDate.parse(scanner.next());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }
    // Add more methods for different types of inputs
}

