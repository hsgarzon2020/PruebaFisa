package com.fisa.assesment.conference_management.management;

import com.fisa.assesment.conference_management.util.ConferenceConstants;
import com.fisa.assesment.conference_management.util.Util;
import com.fisa.assesment.conference_management.domain.*;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@Component
public class ManagementWriter implements ItemWriter<Talk> {

    private Conference conference = new Conference();

    @Override
    public void write(List<? extends Talk> list) throws Exception {
        List<Talk> talks = new ArrayList<>();
        for (Talk talk: list) {
            talks.add(talk);
        }
        scheduleTalks(talks);
        printTalks(conference);
    }


    public void scheduleTalks(List<Talk> talks) {
        int dayCount = 0;

        // Sort talks descending
        talks.sort(new Util());

        // Execute the schedule for all tasks
        while (!talks.isEmpty()) {

            // create sessions for each section of the track (day)
            Session morningSession = new Session(ConferenceConstants.SESSION_MORNING_START,
                    ConferenceConstants.MORNING_SESSION_TIME);
            assignTalksToSession(morningSession, talks);

            Session lunch = new Session(ConferenceConstants.SESSION_LUNCH_START, ConferenceConstants.LUNCH_TIME);
            lunch.addTalkOrEvent(new Lunch());

            Session afternoonSession = new Session(ConferenceConstants.SESSION_AFTERNOON_START,
                    ConferenceConstants.AFTERNOON_SESSION_TIME);
            assignTalksToSession(afternoonSession, talks);

            Session networking = new Session(afternoonSession.getEndTime(),
                    ConferenceConstants.NETWORKING_SESSION_TIME);
            networking.addTalkOrEvent(new Networking(afternoonSession.getEndTime()));

            // create Track for each day and assign sessions (morning and afternoon)
            Track track = new Track(++dayCount);
            List<Session> sessions = new ArrayList<>();
            sessions.add(morningSession);
            sessions.add(lunch);
            sessions.add(afternoonSession);
            sessions.add(networking);
            track.setSessions(sessions);
            // finally add a track to conference schedule
            conference.addTrack(track);
        }

    }

    public void assignTalksToSession(Session session, List<Talk> talks) {
        Calendar currentStartTime = session.getStartTime();
        for (Iterator<Talk> talksIterator = talks.iterator(); talksIterator.hasNext();) {
            Talk talk = talksIterator.next();
            if (Boolean.TRUE.equals(session.fitsInSessionTime(talk))) {
                // add talk event to the session at the currentStartTime calculated.
                session.addTalkOrEvent(new Event(talk.getTitle(), currentStartTime, talk.getDuration()));
                // calculate the next start time based on the current start time and current talk duration.
                currentStartTime = Util.nextTalkTime(currentStartTime, talk);
                // remove the talk from the list. This means that the talk has been scheduled in the conference.
                talksIterator.remove();
                session.setEndTime(currentStartTime);
            }
        }
    }

    public void printTalks(Conference conference) {
        for (Track track : conference.getTracks()) {
            System.out.println("Track " + track.getDayNo() + ":");
            for(Session session : track.getSessions()) {
                for (Event talkEvent : session.getEvents()) {
                    System.out.println(talkEvent.toString());
                }
            }
        }
    }



}
