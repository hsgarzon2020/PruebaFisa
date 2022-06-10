package com.fisa.assesment.conference_management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Conference {

    private List<Track> tracks;

    public Conference() { this.tracks = new ArrayList<>(); }

    public void addTrack(Track track) {
        this.tracks.add(track);
    }

}
