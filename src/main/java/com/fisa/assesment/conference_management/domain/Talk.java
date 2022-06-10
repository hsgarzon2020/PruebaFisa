package com.fisa.assesment.conference_management.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Talk {

    private String title;
    private int duration;

}
