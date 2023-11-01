package src.Model;

import java.util.ArrayList;

// function of Class: Calendar
/*
    Access to the Calendar, which holds all the appointments for the month.
    functionalities:
        CRUD methods
        Check methods (isWeekend, isHoliday, isAvailable)
        Get and Set methods (getWeek, getMonth, getDay, addAppointmentDay, removeAppointmentDay, updateAppointmentDay, listAppointmentDays)
*/

public class Calendar {
    public ArrayList<AppointmentDay> month ;

    //   private final int WEEK_LENGTH = 7; // constant
    //   protected ArrayList<AppointmentDay> currentWeek = new ArrayList<AppointmentDay>(7);
    // fillCurrentWeek();
     /*   private void fillCurrentWeek () {

        for (int i = 0; i < WEEK_LENGTH; i++) {

            currentWeek.add(month.get(i));
        }
    }

  */

    // constructor:
    public Calendar() {
        initializeMonth();
    }

    private void initializeMonth() {
        int MONTH_LENGTH = 31;
        this.month = new ArrayList<>(MONTH_LENGTH);
        for (int i = 0; i < MONTH_LENGTH; i++) {
            month.add(i, new AppointmentDay());
        }
    }

    // methods:
    public AppointmentDay getDay (int dateNr) {
        return month.get(dateNr);
    }


    public void showDayAvailableTimes(int dateNr) {
        System.out.println("Day: ");
        month.get(dateNr).readDay();
        System.out.println("Available Times: ");
        for (int i = 0; i < 7; i++) {
            int date = dateNr + i;
            System.out.println(month.get(date).getAvailableTimes());

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
