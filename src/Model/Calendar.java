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
    // instance variables:
    public ArrayList<AppointmentDay> month;
    AppointmentDay day;
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

    // methods:
    // check method
    private boolean checkWeekend(LocalDate today) {
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    // getters
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

    public boolean isAvailable(LocalDate date, int time) {
        if (getDate(date).getAppointmentArrNr(time).booked) {
            return false;
        } else if (getDate(date).getAppointmentArrNr(time).cancelled) {
            return false;
        } else if (getDate(date).getAppointmentArrNr(time).holiday) {
            return false;
        } else if (getDate(date).getAppointmentArrNr(time).weekend) {
            return false;
        } else
        return true;
    }
}