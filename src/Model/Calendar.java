package src.Model;

import java.util.ArrayList;

// function of Class: Calendar
/*
    Manage a month of AppointmentDays
*/

public class Calendar {
    private final int MONTH_LENGTH = 31; // constant
    private final int WEEK_LENGTH = 7; // constant
    private ArrayList<AppointmentDay> month = new ArrayList<AppointmentDay>(31);
    private ArrayList<AppointmentDay> currentWeek = new ArrayList<>(7);

    private void fillCurrentWeek () {
        for (int i = 0; i < WEEK_LENGTH; i++) {
            currentWeek.add(month.get(i));
        }
    }

    public Calendar() {

    }


}
