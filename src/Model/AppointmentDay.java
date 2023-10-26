package src.Model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class AppointmentDay {
    private LocalDate date;
    private boolean weekend = false;
    private ArrayList<Appointment> appointments;

    // constructor:
    /*
        1. sets the date
        2. checks if the date is weekend
        3. creates an arraylist of appointments for the day
    */
    public AppointmentDay(LocalDate date) {
        this.date = date;
        this.weekend = isWeekend();
        this.appointments = new ArrayList<>(8);     // 8 hrs (appointments) in a day: 10-18.
    }

    // methods:

    // 1. get & set methods
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
    public boolean getIsWeekend() {
        return weekend;
    }
    public LocalDate getDate() {
        return date;
    }

    // 2. check methods:
    // check if the day is weekend:
    private boolean isWeekend() {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    // 3. service methods:
    // toString method:
    @Override
    public String toString() {
        return "AppointmentDay{" +
                "date=" + date +
                ", weekend=" + weekend +
                ", appointments=" + appointments +
                '}';
    }
}

