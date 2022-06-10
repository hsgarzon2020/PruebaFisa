package com.fisa.assesment.conference_management.util;


import java.util.Calendar;

public class ConferenceConstants {


    // Input Talks File
    public static final String TALKS_FILE = "talks.csv";
    public static final String LIGHTNING = "lightning";

    // Minutes for each session
    public static final int MORNING_SESSION_TIME = 180;
    public static final int AFTERNOON_SESSION_TIME = 240;

    // Minutes for each fixed event
    public static final int LUNCH_TIME = 60;
    public static final int LIGHTNING_TIME = 5;
    public static final int NETWORKING_SESSION_TIME = 60;

    // Fixed Start Hours for Sessions
    public static final Calendar SESSION_MORNING_START = Util.setCallTime(9,0);
    public static final Calendar SESSION_LUNCH_START = Util.setCallTime(12,0);
    public static final Calendar SESSION_AFTERNOON_START = Util.setCallTime(13,0);
    public static final Calendar SESSION_NETWORKING_START = Util.setCallTime(17,0);

}
