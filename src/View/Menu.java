package src.View;

public class Menu {
    private UserInputScanner userInputScanner;

    public Menu() {
        this.userInputScanner = new UserInputScanner();
    }

    public void displayMenu() {
        System.out.println("1. View Appointments");
        System.out.println("2. Create Appointment");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        int choice = userInputScanner.getIntInput();

        switch (choice) {
            case 1:
                // View Appointments
                break;
            case 2:
                // Create Appointment
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

