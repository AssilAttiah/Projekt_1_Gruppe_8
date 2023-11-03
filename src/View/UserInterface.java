package src.View;


import src.Controller.Processor;
import src.Model.AppointmentDay;
import src.Model.Calendar;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserInterface {

    public void startProgram(){
        System.out.println("Harry's Salon Electronic Booking System");
        Menu menu = new Menu();
        menu.displayMenu();
    }

    public void showBookingConfirmation(String customerName, LocalDate dateInput, String timeInput) {
        System.out.println("Booked: " + customerName + " on " + dateInput.toString() + " at " + timeInput + "!\n");
    }

    public void showAppointmentNotAvailableMessage() {
        System.out.println("Appointment not available, please try again.");
    }

    public static class CalGrid {
        // instance variables
        private LocalDate firstDay;

        char[][] grid = new char[8][6];

        public static String[] times = {"10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};
        public static String[] days = new String[5];

        ArrayList<AppointmentDay> daysObjects = new ArrayList<>(5);

        Processor ioProcess;

        // constructor
        public CalGrid(ArrayList<AppointmentDay> daysObjects, LocalDate firstDay, Processor ioProcess) {
            this.ioProcess = ioProcess;
            this.daysObjects = daysObjects;
            initializeGrid();
            setDaysArray(firstDay);
            updateCalGrid();
        }

        // methods:
        private void initializeGrid() {
            for (int i = 0; i < 8; i++) {
                for (int x = 0; x < 6; x++) {
                    grid[i][x] = '_';
                }
            }
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

            this.daysObjects = ioProcess.getCalDays(firstDay, 5);
            setDaysArray(firstDay);

            for (int i = 0; i < daysObjects.size(); i++) {
                for (int x = 0; x < 8; x++) {
                    // if appointment is booked or cancelled, set time to X or C
                    if (daysObjects.get(i).getAppointmentArrNr(x).booked) {
                        grid[x][i] = 'X';
                    } else if (daysObjects.get(i).getAppointmentArrNr(x).cancelled) {
                        grid[x][i] = 'C';
                    } else {
                        grid[x][i] = '_'; // -> available
                    }
                }
                // if day = weekend or holiday, set all times to W or H
                if (daysObjects.get(i).getIsWeekend()) {
                    for (int x = 0; x < 8; x++) {
                        grid[x][i] = 'W';
                    }
                } else if (daysObjects.get(i).getIsHoliday()) {
                    for (int x = 0; x < 8; x++) {
                        grid[x][i] = 'H';
                    }
                }
            }
        }

        // main method to display calGrid
        public void showCalGrid() {
            // updates to show latest grid
            updateCalGrid();

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


        public LocalDate getDate(String dayInput) {
            // find date by checking dayInput against days array
            // return date
            LocalDate dateOfDayInput;
            int index = 0;
            for (String d: days) {
                if (d.equalsIgnoreCase(dayInput)) {
                    return dateOfDayInput = firstDay.plusDays(index);
                }
                index++;
            }
            return null;
        }

        public int getTime(int inputTime) {
            // find time by checking inputTime against times array
            // return time
            switch (inputTime) {
                case 10:
                    return 0;
                case 11:
                    return 1;
                case 12:
                    return 2;
                case 13:
                    return 3;
                case 14:
                    return 4;
                case 15:
                    return 5;
                case 16:
                    return 6;
                case 17:
                    return 7;
                default:
                    System.out.println("Error: Invalid time input");
            }
            return 0;
        }
    }

}


