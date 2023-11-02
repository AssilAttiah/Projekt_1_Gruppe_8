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
                day.setDayOfWeek(today.getDayOfWeek().toString());
            } else {
                day = new AppointmentDay(today.plusDays(i), checkWeekend(today.plusDays(i)));
                day.setDayOfWeek(today.plusDays(i).getDayOfWeek().toString());
            }
            month.add(i, day);
        }
    }
    private boolean checkWeekend(LocalDate today) {
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }



    // methods:
    // getters
    public AppointmentDay getDay (int dateNr) {
        return month.get(dateNr);
    }
    public AppointmentDay getDate (LocalDate date) {
        return month.get(date.getDayOfMonth());
    }
    public ArrayList<AppointmentDay> getDays(LocalDate firstDay, int nrOfDays) {
        ArrayList<AppointmentDay> week = new ArrayList<>(nrOfDays);
        for (int i = 0; i < nrOfDays; i++) {
            week.add(i, getDate(firstDay.plusDays(i)));
        }
        return week;
    }

    // display
    public void displayWeek (LocalDate date) {
        for (int i = 0; i < 7; i++) {
            System.out.println("Day: " + date.plusDays(i)+", "+ date.getDayOfWeek());
            getDate(date.plusDays(i)).readDay();
            System.out.println("---------------------");
        }
    }
    public void displayDay (LocalDate date) {
        System.out.println("Day: " + date+", "+ date.getDayOfWeek());
        getDate(date).readDay();
        System.out.println("---------------------");
    }

}

class TestCalendar {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();

        calendar.displayWeek(LocalDate.now());
        calendar.displayDay(LocalDate.now());
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


