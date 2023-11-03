package src.Model;

import java.awt.*;

// function of Class: Appointment
/*
    Manages individual appointments, with methods:
    - book
    - cancel
    - useCreditDelayPayment
    - payCredit
    - setCustomerName
*/

public class Appointment {
    public boolean holiday;
    public boolean booked = false;
    public boolean weekend;
    public boolean cancelled = false;

    private boolean paid = true;
    public String customerName;

    // methods:
    public void book(String name) {
        customerName = name;
        booked = true;
    }
    public void cancel() {
        booked = false;
        cancelled = true;
    }

    public void useCreditDelayPayment() {
        paid = false;
    }
    public void payCredit() {
        paid = true;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }
    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    @Override
    public String toString () {
        if (!booked) {
            return "No Appointment";
        } else {
            String customerName = this.customerName == null ? "No Customer name" : this.customerName;
            String booked = "Booked";
            String paid = this.paid ? "Paid" : "Not Paid";

            return customerName + ", " + booked + ", " + paid;
        }
    }
}