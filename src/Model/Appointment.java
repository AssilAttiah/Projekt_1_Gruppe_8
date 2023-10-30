package src.Model;

import java.awt.*;

// function of Class: Appointment
/*
    Manages individual appointments, with methods to book and cancel.
*/
public class Appointment extends Menu {
    private boolean dbooked = false;
    private boolean paid = true;
    private boolean tbooked = false;
    private String customerName;

    public void book() {
        dbooked = true;
    }

    public void cancel() {
        tbooked = false;
    }

    public void creditPayment() {
        paid = true;
    }

    public void checkDate() {
        if (!dbooked) {
            System.out.println("Date Approved");
            System.out.println("...");
            System.out.println("Appointment Booked Into Calendar");
            System.out.println();
        } else {
            System.out.println("Date Not Available");
        }
    }
    public void checkTime(){
        if (!tbooked){
            System.out.println("Time Approved");
            System.out.println("...");
            System.out.println("Appointment Booked Into Calendar");
            System.out.println();
        } else {
            System.out.println("Time Not Available");
        }
    }
    }