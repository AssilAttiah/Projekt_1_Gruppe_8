package src.Model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// function of Class: Appointment
/*
    Manages appointments for a specific day, checks if the day is a weekend, and holds an ArrayList of appointments.
*/

public class AppointmentDay {
    private LocalDate date;
    private boolean weekend = false;
    private boolean holiday = false;
    private ArrayList<Appointment> appointments;


    // constructor:
    /*
        1. sets the date
        2. checks if the date is weekend
        3. creates an arraylist of appointments for the day
    */


    public AppointmentDay() {
        date = LocalDate.now();
        this.weekend = isWeekend();
        this.appointments = new ArrayList<>(8);     // 8 hrs (appointments) in a day: 10-18.
    }

    // methods:




    // 1. CRUD Methods:
   public void createBooking(int time, String name) {
        appointments.get(time).book(name);
    }

    public void readDay() {
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }


    public void updateDay() { // update method for updating appointments when a appointment in the day changes state


    }
    public void clearDay() { // delete method for clearing appointments of the day
        for (Appointment appointment : appointments) {
            appointment.cancel();
        }
    }

    // getters:
    public boolean getIsWeekend() {
        return weekend;
    }
    public boolean getIsHoliday() {
        return holiday;
    }

    public ArrayList<Appointment> getDay() {
        return appointments;
    }
    public LocalDate getDate() {
        return date;
    }

    public List<Integer> getAvailableTimes() {
        List<Integer> availableTimeSlots = new ArrayList<>();
        for (int i = 0; i < appointments.size(); i++) {
            if (!appointments.get(i).booked) {
                availableTimeSlots.add(i);
            }
        } // for-loop
        return availableTimeSlots;
    }

    // setters:
    public void setDayAsHoliday() {
        holiday = true;
    }

    // 2. boolean methods: for Weekend and Holiday
    private boolean isWeekend() {       // check if the day is weekend
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

