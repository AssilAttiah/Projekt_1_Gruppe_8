package src.View;

import src.Controller.InputOutputProcess;

public class SubMenu {
    UserInputScanner userInputScanner = new UserInputScanner();
    InputOutputProcess ioProcess = new InputOutputProcess();
    int choice;


}

class createBookingSubMenu extends SubMenu {


    public createBookingSubMenu() {
        ioProcess.displayDateAvailableTimes(userInputScanner.getDateInput());
        ioProcess.processBooking(userInputScanner.getNameInput(), userInputScanner.getDateInput());
        System.out.println("Booking successful!");
    }

}

class manageBookingSubMenu extends SubMenu {
    // registerHolidays
    // cancelBooking
    // changeBooking
    // payLater     -  for creditPayment

    public manageBookingSubMenu () {
        System.out.println("Manage Booking");
        System.out.println("--------------------");
        System.out.println("1. Register Holidays");
        System.out.println("2. Cancel Booking");
        System.out.println("3. Change Booking");
        System.out.println("4. Pay Later");
        System.out.println("--------------------");
        System.out.println("Enter choice: ");

        choice = userInputScanner.getIntInput();
        switch (choice) {
            case 1:
                registerHolidays();
                break;
            case 2:
                cancelBooking();
                break;
            case 3:
                changeBooking();
                break;
            case 4:
                payLater();
                break;
            default:
                System.out.println("Invalid input");
        }
    }
}

class accessFinancialDataSubMenu extends SubMenu {

}

class addAdditionalItemsToCardAndPaySubMenu extends SubMenu {

}
