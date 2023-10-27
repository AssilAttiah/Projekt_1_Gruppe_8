package src.Model;

// function of Class: Appointment
/*
    Manages individual appointments, with methods to book and cancel.
*/
public class Appointment {
    private boolean booked = false;
    private boolean paid = true;
    private String customerName;

    Appointment (){}

    public void book(){
        booked = true;
    }

    public void cancel(){
        booked = false;
    }

    public void creditPayment(){
        paid = true;
    }
}
