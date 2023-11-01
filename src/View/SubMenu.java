package src.View;

import src.Controller.InputOutputProcess;

import java.time.LocalDate;

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
                System.out.println("Register Holidays");
                System.out.println("--------------------");
                System.out.println("How many holiday days do you want to register?");
                int nrOfHolidays = userInputScanner.getIntInput();
                for (int i = 0; i < nrOfHolidays; i++) {
                    System.out.println("Enter date: ");
                    LocalDate dateInput = userInputScanner.getDateInput();
                    ioProcess.registerHoliday(dateInput);
                    System.out.println("Holiday "+ dateInput.toString() +" registered!");
                }


                break;
            case 2:
                ioProcess.cancelBooking();
                break;
            case 3:
                ioProcess.changeBooking();
                break;
            case 4:
                ioProcess.payLater();
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
