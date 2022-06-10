package com.fisa.assesment.conference_management.domain;

import com.fisa.assesment.conference_management.util.ConferenceConstants;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
public class Event extends Talk {

    private Calendar startTime;

    public Event(String title, Calendar startHour, int duration) {
        this.setTitle(title);
        this.startTime = startHour;
        this.setDuration(duration);
    }

    public Event(String title, Calendar startHour) {
        this.setTitle(title);
        this.startTime = startHour;
        this.setDuration(0);
    }

    @Override
    public String toString() {
        // different formats 12H hh - 24H HH - AM/PM text ´a´ at the end
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mma");

        if (getDuration() == 5)
            return sdf.format(getStartTime().getTime()) + " " + getTitle() + " " + ConferenceConstants.LIGHTNING_TIME + "min";
        else
            return sdf.format(getStartTime().getTime()) + " " + getTitle() + " " + (getDuration() == 0 ? "" : getDuration() + "min");
    }


}
