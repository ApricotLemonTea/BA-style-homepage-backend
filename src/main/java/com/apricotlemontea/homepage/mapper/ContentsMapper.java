package com.apricotlemontea.homepage.mapper;

import com.apricotlemontea.homepage.dto.AnnouncementRecord;
import com.apricotlemontea.homepage.dto.PatchNoteRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentsMapper {

    List<AnnouncementRecord> getAnnouncementJa();
    List<AnnouncementRecord> getAnnouncementZh();
    List<AnnouncementRecord> getAnnouncementEn();

    List<PatchNoteRecord> getPatchNoteJa();
    List<PatchNoteRecord> getPatchNoteZh();
    List<PatchNoteRecord> getPatchNoteEn();

}
