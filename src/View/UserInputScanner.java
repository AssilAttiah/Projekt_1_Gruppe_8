package src.View;

// function of Class: Calendar
/*
        Scanner for Menu class
        It will be responsible for capturing user input based on the options presented.
*/

import java.time.LocalDate;
import java.util.Scanner;

public class UserInputScanner {
    private Scanner scanner;

    public UserInputScanner() {
        this.scanner = new Scanner(System.in);
    }

    public String getNameInput() {
        System.out.println("Enter name: ");
        return scanner.next();
    }

    public int getIntInput() {
        return scanner.nextInt();
    }

    public String getStringInput() {
        return scanner.next();
    }

    public double getDoubleInput(){
        return scanner.nextDouble();
    }

    public LocalDate getDateInput(){ //
        return nextDate();
    }

    private LocalDate nextDate() {
        System.out.println("Enter date in format dd-mm-yyyy: ");
        return LocalDate.parse(scanner.next());
    }
    // Add more methods for different types of inputs
}

