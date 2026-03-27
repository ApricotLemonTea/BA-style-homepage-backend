package com.apricotlemontea.homepage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;

@Mapper
public interface VisitsMapper {
    int countPageVisits(LocalDate date, String page);

    String getOneDayLobbyVisits(LocalDate date);

    String getSumLobbyVisits();
}
