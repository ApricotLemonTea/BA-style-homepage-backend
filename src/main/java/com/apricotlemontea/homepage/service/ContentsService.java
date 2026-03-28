package com.apricotlemontea.homepage.service;

import com.apricotlemontea.homepage.dto.AnnouncementData;
import com.apricotlemontea.homepage.dto.PatchNoteData;
import com.apricotlemontea.homepage.mapper.ContentsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContentsService {
    private final ContentsMapper mapper;

    public ContentsService(ContentsMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional
    public AnnouncementData getAnnouncement() {
        AnnouncementData res = new AnnouncementData();

        res.setAnnouncementJa(mapper.getAnnouncementJa());
        res.setAnnouncementZh(mapper.getAnnouncementZh());
        res.setAnnouncementEn(mapper.getAnnouncementEn());

        return res;
    }

    @Transactional
    public PatchNoteData getPatchNote() {
        PatchNoteData res = new PatchNoteData();

        res.setPatchNoteJa(mapper.getPatchNoteJa());
        res.setPatchNoteZh(mapper.getPatchNoteZh());
        res.setPatchNoteEn(mapper.getPatchNoteEn());

        return res;
    }

}
