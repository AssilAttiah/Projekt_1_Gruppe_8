package src.Model;

public class Appointment {
    private boolean booked = false;
    private String customerName;

    Appointment (){}

    public void book(){
        booked = true;
    }

    public void cancel(){
        booked = false;
    }
}
