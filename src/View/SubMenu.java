package src.View;

import src.Controller.*;

import java.time.LocalDate;

public class SubMenu {
    UserInputScanner userInputScanner = new UserInputScanner();

    InputOutputProcess ioProcess = new InputOutputProcess();

    int choice;
    String customerName;


}

class createBookingSubMenu extends SubMenu {


    public createBookingSubMenu() {
        System.out.println("Create Booking");
        System.out.println("--------------------");
        customerName = userInputScanner.getCustomerName();
        LocalDate date = userInputScanner.getDateInput();
        ioProcess.showCalGrid(date);
        ioProcess.createCalGridBooking();

        ioProcess.showCalGrid(date);
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
        // customerName:
        customerName = userInputScanner.getCustomerName();
        // options:
        System.out.println("1. Register Holidays");
        System.out.println("2. Cancel Booking");
        System.out.println("3. Change Booking");
        System.out.println("4. Pay Later");
        System.out.println("--------------------");
        // choice:
        System.out.println("Enter choice: ");
        choice = userInputScanner.getIntInput();

        // menu:
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
                System.out.println("Cancel Booking");
                System.out.println("--------------------");
                ioProcess.cancelBooking(customerName);
                System.out.println("Appointment successfully found.");
                System.out.println("--------------------");
                System.out.println("Appointment cancelled.");
                break;
            case 3:
                System.out.println("Change Booking");
                System.out.println("--------------------");
                ioProcess.changeBooking(customerName);
                System.out.println("--------------------");
                System.out.println("Booking successfully changed!");
                break;
            case 4:
                System.out.println("Pay Later");
                System.out.println("--------------------");
                ioProcess.payLater(customerName);
                System.out.println("--------------------");
                System.out.println("Payment successfully processed!");
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
