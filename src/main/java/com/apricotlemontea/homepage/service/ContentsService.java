package com.apricotlemontea.homepage.service;

import com.apricotlemontea.homepage.dto.AnnouncementData;
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

}
