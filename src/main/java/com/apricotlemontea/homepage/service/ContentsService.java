package com.apricotlemontea.homepage.service;

import com.apricotlemontea.homepage.dto.AnnouncementData;
import com.apricotlemontea.homepage.dto.MissionData;
import com.apricotlemontea.homepage.dto.MissionRecord;
import com.apricotlemontea.homepage.dto.PatchNoteData;
import com.apricotlemontea.homepage.mapper.ContentsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

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

    @Transactional
    public MissionData getMission() {
        MissionData res = new MissionData();

        res.setMissionJa(mapper.getMissionJa());
        res.setMissionZh(mapper.getMissionZh());
        res.setMissionEn(mapper.getMissionEn());

        List<MissionRecord> todoListJa = res.getMissionJa().stream()
                .filter(m -> m.getTimes() < m.getMaxTimes())
                .sorted(Comparator.comparing(
                        MissionRecord::getCompleteDate,
                        Comparator.nullsLast(String::compareTo)
                ))
                .toList();
        List<MissionRecord> todoListZh = res.getMissionZh().stream()
                .filter(m -> m.getTimes() < m.getMaxTimes())
                .sorted(Comparator.comparing(
                        MissionRecord::getCompleteDate,
                        Comparator.nullsLast(String::compareTo)
                ))
                .toList();
        List<MissionRecord> todoListEn = res.getMissionEn().stream()
                .filter(m -> m.getTimes() < m.getMaxTimes())
                .sorted(Comparator.comparing(
                        MissionRecord::getCompleteDate,
                        Comparator.nullsLast(String::compareTo)
                ))
                .toList();

        res.setTodoListJa(todoListJa);
        res.setTodoListZh(todoListZh);
        res.setTodoListEn(todoListEn);

        return res;
    }

}
