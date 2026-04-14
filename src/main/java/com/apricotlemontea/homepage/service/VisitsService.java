package com.apricotlemontea.homepage.service;

import com.apricotlemontea.homepage.dto.PageVisitsData;
import com.apricotlemontea.homepage.mapper.VisitsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class VisitsService {
    private final VisitsMapper mapper;

    public VisitsService(VisitsMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional
    public Integer countPageVisits(String page) {
        LocalDate today = LocalDate.now();

        return mapper.countPageVisits(today, page);
    }

    @Transactional
    public PageVisitsData getPageVisitsData() {
        LocalDate today = LocalDate.now();
        String todayLobbyVisits = mapper.getOneDayLobbyVisits(today);

        String sumLobbyVisits = mapper.getSumLobbyVisits();

        PageVisitsData res = new PageVisitsData();
        res.setTodayLobbyVisits(todayLobbyVisits == null ? "0" : todayLobbyVisits);
        res.setSumLobbyVisits(sumLobbyVisits == null ? "0" : sumLobbyVisits);

        return res;
    }
}
