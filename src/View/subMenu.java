package src.View;

import src.Controller.InputOutputProcess;

public class subMenu {
    UserInputScanner userInputScanner = new UserInputScanner();
    InputOutputProcess ioProcess = new InputOutputProcess();
    int choice;


}

class createBookingSubMenu extends subMenu {


    public createBookingSubMenu() {
        ioProcess.displayDateAvailableTimes(userInputScanner.getDateInput());
        ioProcess.processBooking(userInputScanner.getNameInput(), userInputScanner.getDateInput());
        System.out.println("Booking successful!");
    }

}

class manageBookingSubMenu extends subMenu {

}

class accessFinancialDataSubMenu extends subMenu {

}

class addAdditionalItemsToCardAndPaySubMenu extends subMenu {

}
