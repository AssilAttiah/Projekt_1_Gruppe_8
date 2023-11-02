package src.View;


import src.Controller.InputOutputProcess;


public class Menu {
    UserInputScanner userInputScanner;
    UserInterface ui;

    String userName;

    public Menu() {
        this.userInputScanner = new UserInputScanner();
        userName = userInputScanner.getNameInput("user name");
    }

    public void displayMenu() {
        while (true) {
            System.out.println("1. Create Booking");
            System.out.println("2. Manage Booking");
            System.out.println("3. Access Financial Data");
            System.out.println("4. Add Additional Items To Card And Pay");
            System.out.println("5. Exit");
            int choice = userInputScanner.getIntInput();
            if (choice == 1) {
                System.out.println("Create Booking");

                createBookingSubMenu createBookingSubMenu = new createBookingSubMenu();
            } else if (choice == 2) {
                manageBookingSubMenu manageBookingSubMenu = new manageBookingSubMenu();
            } else if (choice == 3) {
                accessFinancialDataSubMenu accessFinancialDataSubMenu = new accessFinancialDataSubMenu();
            } else if (choice == 4) {
                addAdditionalItemsToCardAndPaySubMenu addAdditionalItemsToCardAndPaySubMenu = new addAdditionalItemsToCardAndPaySubMenu();
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid input");
            }
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


}


