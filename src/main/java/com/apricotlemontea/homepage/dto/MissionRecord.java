package com.apricotlemontea.homepage.dto;

import lombok.Data;

@Data
public class MissionRecord {
    String tagIndex;
    String title;
    Double times;
    Double maxTimes;
    String completeDate;
    String detailUrl;
}
