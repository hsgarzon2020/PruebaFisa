package com.fisa.assesment.conference_management.management;

import com.fisa.assesment.conference_management.domain.TalkDTO;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class ManagementFieldSetMapper implements FieldSetMapper<TalkDTO> {

    @Override
    public TalkDTO mapFieldSet(FieldSet fieldSet) throws BindException {
        TalkDTO talk = new TalkDTO();
        talk.setTitle(fieldSet.readString("title"));
        talk.setDuration(fieldSet.readString("duration"));
        return talk;
    }
}
