package com.apricotlemontea.homepage.mapper;

import com.apricotlemontea.homepage.dto.VisitsData;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface VisitsMapper {
    int countPageVisits(LocalDate date, String page);

    String getOneDayLobbyVisits(LocalDate date);

    String getSumLobbyVisits();

    List<VisitsData> getVisitsDataList();
}
