package com.apricotlemontea.homepage.controller;

import com.apricotlemontea.homepage.dto.AnnouncementData;
import com.apricotlemontea.homepage.dto.AnnouncementRecord;
import com.apricotlemontea.homepage.service.ContentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contents")
public class ContentsController {
    private final ContentsService service;

    public ContentsController(ContentsService service) {
        this.service = service;
    }

    @GetMapping("/announcement")
    public ResponseEntity<AnnouncementData> getAnnouncement() {
        AnnouncementData res = service.getAnnouncement();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}
