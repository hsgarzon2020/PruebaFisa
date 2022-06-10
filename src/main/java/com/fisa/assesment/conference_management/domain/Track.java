package com.fisa.assesment.conference_management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Track {

    private int dayNo;
    private List<Session> sessions;

    public Track(int dayNo) {
        this.dayNo = dayNo;
        this.sessions = new ArrayList<>();
    }
}
