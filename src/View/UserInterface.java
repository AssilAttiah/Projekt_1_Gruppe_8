package src.View;

// function of Interface Class:
/*
    Manage flow of information:

*/

public class UserInterface {
    Menu menu;

    UserInterface() {
        menu = new Menu();
    }

    public void startProgram(){
        System.out.println("Harry's Salon Electronic Booking System");
        menu.checkDate();
        menu.displayMenu();
    }




}
