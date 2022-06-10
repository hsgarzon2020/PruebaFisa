package com.fisa.assesment.conference_management.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data
public class Session {

    private List<Event> events;
    private Calendar startTime;
    private int remainingTime;
    private Calendar endTime;

    public Session(Calendar startTime, int remainingTime) {
        this.events = new ArrayList<>();
        this.startTime = startTime;
        this.remainingTime = remainingTime;
    }

    public Boolean fitsInSessionTime(Talk talk){
        return remainingTime >= talk.getDuration();
    }

    public void addTalkOrEvent(Event event) {
        this.events.add(event);
        this.remainingTime -= event.getDuration();
    }

}
