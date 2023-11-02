package src.View;

// function of Interface Class:
/*
    Manage flow of information:

*/

import src.Controller.InputOutputProcess;
import src.Model.AppointmentDay;
import src.Model.Calendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    public void startProgram(){
        System.out.println("Harry's Salon Electronic Booking System");
        Menu menu = new Menu();
        menu.displayMenu();
    }

    public static class CalGrid {


        LocalDate firstDay;

        char[][] grid = new char[8][6];
        //CHOOSE WHICH ROW/COLUMN TO PUT X INSIDE!!!!


        public static String[] times = {"10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};
        public static String[] days = new String[5];


        ArrayList<AppointmentDay> daysObjects = new ArrayList<>(5);

        public CalGrid(ArrayList<AppointmentDay> daysObjects, LocalDate firstDay) {
            this.daysObjects = daysObjects;
            setDaysArray(firstDay);
            fillBookedGrid();
        }

        public void setDaysArray(LocalDate firstDay) {
            this.firstDay = firstDay;
            String[] weekDays = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
            for (int i = 0; i < 5; i++) {
                days[i] = weekDays[firstDay.getDayOfWeek().getValue() - 1];
                firstDay = firstDay.plusDays(1);
            }
        }
        public void updateCalGrid () {
            InputOutputProcess ioProcess = new InputOutputProcess();
            this.daysObjects = ioProcess.getCalDays(firstDay, 5);
            setDaysArray(firstDay);

            for (int i = 0; i < daysObjects.size(); i++) {
                for (int x = 0; x < 8; x++) {
                    if (daysObjects.get(i).getAppointmentArrNr(x).booked) {
                        grid[x][i] = 'X';
                    }
                }
            }
        }

        public void fillBookedGrid() {
            for (int i = 0; i < 8; i++) {
                for (int x = 0; x < 6; x++) {
                    grid[i][x] = '_';
                }
            }


        }

        // calendar User Interface
        public void showCalGrid() {


            for (int i = 0; i < 8; i++) {
                for (int x = 0; x < 6; x++) {
                    grid[i][x] = '_';
                }
            }

            //
            System.out.println("  |TIME | " + days[0] + " | " + days[1] + " | " + days[2] + " | " + days[3] + " | " + days[4] + " | ");
            System.out.println("  |-----|-----|-----|-----|-----|-----| ");

            for (int i = 0; i < 8; i++) {
                System.out.print("  |" + times[i] + "|");
                for (int x = 0; x < 5; x++) {
                    System.out.print("  " + grid[i][x] + "  |");
                }
                System.out.println();
            }

            System.out.println("  |-----|-----|-----|-----|-----|-----| ");
        }
    }
}

class testUI {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        UserInterface.CalGrid calGrid = new UserInterface.CalGrid(new Calendar().getDays(LocalDate.now(), 5), LocalDate.now());
        calGrid.showCalGrid();
    }
}
