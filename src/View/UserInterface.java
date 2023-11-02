package src.View;

// function of Interface Class:
/*
    Manage flow of information:

*/

import src.Model.Calendar;

public class UserInterface {


    UserInterface() {

    }

    public void startProgram(){
        System.out.println("Harry's Salon Electronic Booking System");
        Menu menu = new Menu();
        menu.displayMenu();
    }


    // calendar User Interface
    public void showCalGrid(){
        char[][] grid = new char[8][6];

            for (int i = 0; i < 8; i++) {
                for (int x = 0; x < 6; x++) {
                    grid[i][x] = '_';
                }
            }
            //CHOOSE WHICH ROW/COLUMN TO PUT X INSIDE!!!!
            int bookedRow = 2;
            int bookedColumn = 3;
            grid[bookedRow][bookedColumn] = 'X';

            System.out.println("  |TIME | MON | TUE | WED | THU | FRI | ");
            System.out.println("  |-----|-----|-----|-----|-----|-----| ");
            String[] times = {"10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};
            String[] days = {"MON", "TUE", "WED", "THU", "FRI"};
            for (int i = 0; i < 8; i++) {
                System.out.print("  |" + times[i] + "|");
                for (int x = 0; x < 5; x++) {
                    System.out.print("  " + grid[i][x] + "  |");
                }
                System.out.println();
            }
        }


}
