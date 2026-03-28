package com.apricotlemontea.homepage.dto;

import lombok.Data;

import java.util.List;

@Data
public class AnnouncementData {
    List<AnnouncementRecord> AnnouncementJa;
    List<AnnouncementRecord> AnnouncementZh;
    List<AnnouncementRecord> AnnouncementEn;
}
