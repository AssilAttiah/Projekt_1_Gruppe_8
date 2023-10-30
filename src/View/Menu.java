package src.View;


import src.Model.Appointment;
import src.Model.Calendar;


public class Menu extends Appointment {
    private UserInputScanner userInputScanner; // object instantiation

    public Menu() {
        this.userInputScanner = new UserInputScanner();
    }

    public void viewApp() {
        while (true){
            System.out.println("Delete");
            int choice = userInputScanner.getIntInput();
        }
    }

    public void createApp() {
        while (true){
            System.out.println("Which date would you like to pick?");
            double dchoice= userInputScanner.getDoubleInput();
            checkDate();

            System.out.println("Which time would you like to pick?");
            double tchoice= userInputScanner.getDoubleInput();
            checkTime();
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

