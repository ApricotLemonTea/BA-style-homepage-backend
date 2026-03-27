package com.apricotlemontea.homepage.service;

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
}
