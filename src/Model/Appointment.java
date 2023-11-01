package src.Model;

import java.awt.*;

// function of Class: Appointment
/*
    Manages individual appointments, with methods to book and cancel.
*/

public class Appointment {
    private boolean paid = true;
    public boolean booked = false;
    private String customerName;

    public void book(String name) {
        customerName = name;
        booked = true;
    }

    public void cancel() {
        booked = false;
    }

    public void useCreditDelayPayment() {
        paid = false;
    }
    public void payCredit() {
        paid = true;
    }


    public void checkDate() {
        if (!booked) {
            System.out.println("Date Approved\n");
        } else {
            System.out.println("Date Not Available");
        }
    }

    public void checkTime(){
        if (!booked){
            System.out.println("Time Approved");
            System.out.println("...");
            System.out.println("Appointment Booked Into Calendar");
            System.out.println();
        } else {
            System.out.println("Time Not Available");
        }
    }

    public String toString () {
        return "Appointment: " + customerName + " " + booked + " " + booked + " " + paid;
    }
}