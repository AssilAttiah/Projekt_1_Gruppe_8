package src.View;


public class Menu {
    UserInputScanner userInputScanner;
    UserInterface ui;
    int choice;
    String userName;

    public Menu() {
        this.userInputScanner = new UserInputScanner();
        userName = userInputScanner.getNameInput("user name");

    }

    public void displayMenu() {
        System.out.println("\nWelcome " + userName + "!");
        System.out.println("--------------------");
        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Create Booking");
            System.out.println("2. Manage Booking");
            System.out.println("3. Access Financial Data -- Feature not available yet");
            System.out.println("4. Add Additional Items To Card And Pay -- Feature not available yet");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int choice = userInputScanner.getIntInput();
            System.out.println("--------------------\n");


            switch (choice) {
                case 1:
                    createBookingSubMenu createBooking = new createBookingSubMenu();
                    break;
                case 2:
                    manageBookingSubMenu manageBooking = new manageBookingSubMenu();
                    break;
                case 3:
                    accessFinancialDataSubMenu accessFinancialData = new accessFinancialDataSubMenu();
                    break;
                case 4:
                    addAdditionalItemsToCardAndPaySubMenu addAdditionalItems = new addAdditionalItemsToCardAndPaySubMenu();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid Input, Try Again");
            }
        }
    }
}

class testMenu {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}



    // methods for menu options (Use cases):
    /*
        1. createBooking
        2. manageBooking
        3. accessFinancialData
        4. addAdditionalItemsToCardAndPay
        5. exit

     */




    /*
    public void viewApp() {
        while (true){
            ui.showCalGrid();
            System.out.println("Delete");
            int choice = userInputScanner.getIntInput();
        }
    }

     */

 /*   public void createApp() {
        while (true){
            System.out.println("Which date would you like to pick?");
            LocalDate dateChoice = userInputScanner.getDateInput();
            ioProcess.checkDate(userName, dateChoice);

            System.out.println("Which time would you like to pick?");
            double tchoice= userInputScanner.getDoubleInput();
            ioProcess.checkTime(userName, dateChoice,tchoice);
                break;
        }
    }

  */





