package com.apricotlemontea.homepage.controller;

import com.apricotlemontea.homepage.consts.Consts;
import com.apricotlemontea.homepage.dto.PageVisitsData;
import com.apricotlemontea.homepage.service.VisitsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/visits")
public class VisitsController {
    private final VisitsService service;

    public VisitsController(VisitsService service) {
        this.service = service;
    }

    @PostMapping("/countPageVisits")
    public ResponseEntity<Map<String, Object>> countPageVisits(@RequestParam String page, @RequestHeader(required = false) String isApricotLemonTea) {
        Map<String, Object> res = new HashMap<>();

        // 页面名不正确
        if (!Consts.PAGE_LIST.contains(page)) {
            res.put("msg", "invalid page name");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }

        // 不记录我自己的访问
        if ("true".equals(isApricotLemonTea)) {
            res.put("msg", "ApricotLemonTea");
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }

        Integer result = service.countPageVisits(page);
        res.put("msg", result);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/getPageVisitsData")
    public ResponseEntity<PageVisitsData> getPageVisitsData() {
        PageVisitsData res = service.getPageVisitsData();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}
