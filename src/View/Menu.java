package src.View;


import src.Controller.InputOutputProcess;
import src.Model.Appointment;
import src.Model.Calendar;

import java.time.LocalDate;
import java.util.Date;


public class Menu extends Appointment {
    private UserInputScanner userInputScanner; // object instantiation
    InputOutputProcess ioProcess = new InputOutputProcess();
    String name;

    public Menu() {
        this.userInputScanner = new UserInputScanner();
        name = userInputScanner.getNameInput();
    }

    UserInterface calGrid=new UserInterface();

    public void viewApp() {
        while (true){
            calGrid.showCalGrid();
            System.out.println("Delete");
            int choice = userInputScanner.getIntInput();
        }
    }

    public void createApp() {
        while (true){
            System.out.println("Which date would you like to pick?");
            LocalDate dateChoice = userInputScanner.getDateInput();
            ioProcess.checkDate(name, dateChoice);

            System.out.println("Which time would you like to pick?");
            double tchoice= userInputScanner.getDoubleInput();
            ioProcess.checkTime(name, dateChoice,tchoice);
                break;
        }
    }

    public void displayMenu() {
        while (true) {
            System.out.println("1. View Appointments");
            System.out.println("2. Create Appointment");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = userInputScanner.getIntInput();

            switch (choice) {
                case 1:
                    viewApp();
                    break;
                case 2:
                    createApp();
                    break;
                case 3:
                    // Exit
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    displayMenu();
                    break;
            }
        }
    }
}
