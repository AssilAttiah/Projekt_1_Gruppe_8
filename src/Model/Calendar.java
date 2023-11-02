package src.Model;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
    AppointmentDay day;
    LocalDate date;
    LocalDate today = LocalDate.now();

    // constructor:
    public Calendar() {
        initializeMonth();
    }

    private void initializeMonth() {

        int MONTH_LENGTH = 31;
        this.month = new ArrayList<>(MONTH_LENGTH);
        for (int i = 0; i < MONTH_LENGTH; i++) {
            if (i == 0) {
                day = new AppointmentDay(today, checkWeekend(today));
            } else {
                day = new AppointmentDay(today.plusDays(i), checkWeekend(today.plusDays(i)));
            }
            month.add(i, day);
        }
    }

    private boolean checkWeekend(LocalDate today) {
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    // fill state of day relative to place in month

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


    //   private final int WEEK_LENGTH = 7; // constant
    //   protected ArrayList<AppointmentDay> currentWeek = new ArrayList<AppointmentDay>(7);
    // fillCurrentWeek();
     /*   private void fillCurrentWeek () {

        for (int i = 0; i < WEEK_LENGTH; i++) {

            currentWeek.add(month.get(i));
        }
    }

  */

/*
    private boolean isWeekend() {       // check if the day is weekend
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
*/


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
