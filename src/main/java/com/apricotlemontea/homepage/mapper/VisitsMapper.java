package com.apricotlemontea.homepage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;

@Mapper
public interface VisitsMapper {
    int countVisits(LocalDate date, String page);
}
