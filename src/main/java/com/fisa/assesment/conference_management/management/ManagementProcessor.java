package com.fisa.assesment.conference_management.management;

import com.fisa.assesment.conference_management.util.ConferenceConstants;
import com.fisa.assesment.conference_management.domain.Talk;
import com.fisa.assesment.conference_management.domain.TalkDTO;
import org.springframework.batch.item.ItemProcessor;

public class ManagementProcessor implements ItemProcessor<TalkDTO, Talk> {


    @Override
    public Talk process(TalkDTO talkDTO) throws Exception {

        String name = talkDTO.getTitle();
        String time = talkDTO.getDuration();
        int durationMin = 0;


            if (time.equals(ConferenceConstants.LIGHTNING))
                durationMin = ConferenceConstants.LIGHTNING_TIME;
            else {
                try {
                    String[] minutes = time.split("min");
                    durationMin = Integer.parseInt(minutes[0]);
                } catch (NumberFormatException ne) {
                    System.err.println("Error parsing nmber of minutes");
                    throw ne;
                }
            }
            return new Talk(name, durationMin);
        }
    }