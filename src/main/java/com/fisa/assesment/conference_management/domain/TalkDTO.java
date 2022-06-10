package com.fisa.assesment.conference_management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalkDTO {

    private String title;
    private String duration;

}
