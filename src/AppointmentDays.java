package src;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class AppointmentDays {
    private LocalDate date;
    private boolean weekend;
    private Arraylist <Appointment> appointments;

    public AppointmentDays(LocalDate date) {
        this.date = date;
        this.weekend = isWeekend();
        this.appointments = new Arraylist <Appointment>();
    }

    public boolean isWeekend() {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
}

