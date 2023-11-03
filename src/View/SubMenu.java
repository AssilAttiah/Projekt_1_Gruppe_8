package src.View;

import src.Controller.*;

import java.time.LocalDate;

public class SubMenu {
    UserInputScanner userInputScanner = new UserInputScanner();
    Processor ioProcess = new Processor();
    int choice;
    String customerName;
}

class createBookingSubMenu extends SubMenu {

    public createBookingSubMenu() {
        System.out.println("Create Booking");
        System.out.println("--------------------");
        customerName = userInputScanner.getCustomerName();
        LocalDate date = userInputScanner.getDateInput();
        System.out.println();
        ioProcess.showCalGridInfo();
        ioProcess.showCalGrid(date);
        ioProcess.createCalGridBooking(date, customerName);
        ioProcess.showCalGrid(date);

        System.out.println("\nBooking successful!");
    }
}

class manageBookingSubMenu extends SubMenu {

    public manageBookingSubMenu () {
        System.out.println("Manage Booking");
        System.out.println("--------------------");

        // options:
        System.out.println("1. Register Holidays");
        System.out.println("2. Cancel Booking -- currently unavailable");
        System.out.println("3. Change Booking -- currently unavailable");
        System.out.println("4. Pay Later -- currently unavailable");
        System.out.println("--------------------");
        // choice:
        System.out.println("Enter choice: ");
        choice = userInputScanner.getIntInput();
        // customerName:
        if (choice != 1) {
            customerName = userInputScanner.getCustomerName();
        }
        System.out.println();

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
