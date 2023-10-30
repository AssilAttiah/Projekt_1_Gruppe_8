package src.View;

// function of Class: Calendar
/*
        Scanner for Menu class
        It will be responsible for capturing user input based on the options presented.
*/

import java.util.Scanner;

public class UserInputScanner {
    private Scanner scanner;

    public UserInputScanner() {
        this.scanner = new Scanner(System.in);
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

    // Add more methods for different types of inputs
}

