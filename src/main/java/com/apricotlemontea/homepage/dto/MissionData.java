package com.apricotlemontea.homepage.dto;

import lombok.Data;

import java.util.List;

@Data
public class MissionData {
    List<MissionRecord> missionJa;
    List<MissionRecord> missionZh;
    List<MissionRecord> missionEn;
}
