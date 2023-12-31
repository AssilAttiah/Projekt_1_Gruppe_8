package src.Model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// function of Class: Appointment
/*
    Manages appointments for a specific day
    generally methods handle: CRUD, get and set (Creae-Read-Update-Delete).
*/

public class AppointmentDay {
    // instance variables
    private LocalDate date;
    private String dayOfWeek;
    private boolean weekend = false;
    private boolean holiday = false;

    // 8 hrs (appointments) in a day: 10-18.
    private ArrayList<Appointment> appointments = new ArrayList<>(8);

    public AppointmentDay(LocalDate date, boolean weekend) {
        this.date = date;
        this.weekend = weekend;
        this.appointments = initializeDay(8);     // 8 hrs (appointments) in a day: 10-18.
    }

    private ArrayList<Appointment> initializeDay(int nrOfAppointments) {
        for (int i = 0; i < nrOfAppointments; i++) {
            appointments.add(i, new Appointment());
        }
        return appointments;
    }

    // methods:
    // 1. CRUD Methods:
    public void createBooking(int time, String name) {
        appointments.get(time).book(name);
    }
    public void readDay() {
        int i = 0;
        for (Appointment appointment : appointments) {
            String[] hrs = {"10:00", "11:00", "12:00", "13:00", "14:00", "15:00","16:00", "17:00"};
            System.out.println(hrs[i]+": "+ appointment.toString());
            i++;
        }
    }

    // getters:
    public boolean getIsWeekend() {
        return weekend;
    }
    public boolean getIsHoliday() {
        return holiday;
    }

    // get day/date
    public LocalDate getDate() {
        return date;
    }
    public ArrayList<Appointment> getDay() {
        return appointments;
    }
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    // get appointment/avaliable times
    public Appointment getAppointment(int time) {
        return appointments.get(convertTimeToArrElement(time));
    }
    private int convertTimeToArrElement(int time) {
        for (int t = 10; t < 18; t++) {
            if (t == time) {
                return t - 10;
            }
        }
        return 0;
    }

    public Appointment getAppointmentArrNr(int arrNr) {return appointments.get(arrNr);}
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
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public void setDayAsHoliday() {
        for (Appointment appointment : appointments) {
            appointment.holiday = true;
        }
        holiday = true;
    }
    public void setDayAsWeekend() {
        for (Appointment appointment : appointments) {
            appointment.weekend = true;
        }
        weekend = true;
    }

}

