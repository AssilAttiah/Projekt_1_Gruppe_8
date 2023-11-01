package src.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

// function of Class: Calendar
/*
    Access to the Calendar, which holds all the appointments for the month.
    functionalities:
        CRUD methods
        Check methods (isWeekend, isHoliday, isAvailable)
        Get and Set methods (getWeek, getMonth, getDay, addAppointmentDay, removeAppointmentDay, updateAppointmentDay, listAppointmentDays)
*/

public class Calendar {
    private final int MONTH_LENGTH = 31; // constant
    private final int WEEK_LENGTH = 7; // constant
    public ArrayList<AppointmentDay> month = new ArrayList<AppointmentDay>(31);
    protected ArrayList<AppointmentDay> currentWeek = new ArrayList<AppointmentDay>(7);

    // constructor:
    public Calendar() {
        fillCurrentWeek();
    }

    // methods:
    public AppointmentDay getDay (int dateNr) {
        return month.get(dateNr);
    }

    public void setDayAsHoliday (int dateNr) {
        month.get(dateNr).setWeekend(true);
    }

    public void checkDate(String name, int date) {

    }

    public void showDay(int dateNr) {
        System.out.println("Day: ");
        month.get(dateNr).readDay();
        System.out.println("Available Times: ");
        for (int i = 0; i < WEEK_LENGTH; i++) {
            int date = dateNr + i;
            System.out.println(month.get(date).availableTimes());
            int[] availableTimes = {1,2,4,5};

        }
    }



    public void showCalendar(){
        System.out.printf("");
    }

    private void fillCurrentWeek () {

        for (int i = 0; i < WEEK_LENGTH; i++) {

            currentWeek.add(month.get(i));
        }
    }





/*
        // methods:
        getWeek(int weekNumber)
        getMonth(int monthNumber)
        getDay(LocalDate date)

        updateAppointmentDay(AppointmentDay day)
        listAppointmentDays()
        isWeekend(LocalDate date)
        isHoliday(LocalDate date)
        isAvailable(LocalDate date, LocalTime time)
 */

}
