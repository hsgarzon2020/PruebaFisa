package com.fisa.assesment.conference_management.util;

import com.fisa.assesment.conference_management.domain.Talk;

import java.util.Calendar;
import java.util.Comparator;

public class Util implements Comparator<Talk> {

    public static Calendar setCallTime(int hour, int min) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, min);
        return c;
    }

    public static Calendar nextTalkTime(Calendar currentTime, Talk talk) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, currentTime.get(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, currentTime.get(Calendar.MINUTE));
        c.add(Calendar.MINUTE, talk.getDuration());
        return c;
    }

    @Override
    public int compare(Talk talkA, Talk talkB) {
        if (talkA.getDuration() < talkB.getDuration()) {
            return 1;
        } else {
            return -1;
        }
    }

}
