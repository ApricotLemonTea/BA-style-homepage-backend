package com.apricotlemontea.homepage.controller;

import com.apricotlemontea.homepage.consts.Consts;
import com.apricotlemontea.homepage.service.VisitsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/visits")
public class VisitsController {
    private final VisitsService service;

    public VisitsController(VisitsService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> countVisits(@RequestParam String page) {
        Map<String, Object> res = new HashMap<>();

        if (!Consts.PAGE_LIST.contains(page)) {
            res.put("msg", "invalid page name");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }

        Integer result = service.countVisits(page);
        res.put("msg", result);
        return ResponseEntity.status(HttpStatus.OK).body(res);

    }
}
