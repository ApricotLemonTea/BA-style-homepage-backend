package com.apricotlemontea.homepage.service;

import com.apricotlemontea.homepage.dto.AnnouncementData;
import com.apricotlemontea.homepage.dto.PatchNoteData;
import com.apricotlemontea.homepage.mapper.ContentsMapper;
import org.springframework.stereotype.Service;

@Service
public class ContentsService {
    private final ContentsMapper mapper;

    public ContentsService(ContentsMapper mapper) {
        this.mapper = mapper;
    }

    public AnnouncementData getAnnouncement() {
        AnnouncementData res = new AnnouncementData();

        res.setAnnouncementJa(mapper.getAnnouncementJa());
        res.setAnnouncementZh(mapper.getAnnouncementZh());
        res.setAnnouncementEn(mapper.getAnnouncementEn());

        return res;
    }

    public PatchNoteData getPatchNote() {
        PatchNoteData res = new PatchNoteData();

        res.setPatchNoteJa(mapper.getPatchNoteJa());
        res.setPatchNoteZh(mapper.getPatchNoteZh());
        res.setPatchNoteEn(mapper.getPatchNoteEn());

        return res;
    }

}
