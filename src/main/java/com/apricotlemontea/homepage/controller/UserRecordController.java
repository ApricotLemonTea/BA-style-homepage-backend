package com.apricotlemontea.homepage.controller;

import com.apricotlemontea.homepage.dto.CreateUserRecordRequest;
import com.apricotlemontea.homepage.service.UserRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user-records")
public class UserRecordController {

    private final UserRecordService userRecordService;

    public UserRecordController(UserRecordService userRecordService) {
        this.userRecordService = userRecordService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody CreateUserRecordRequest request) {
        if (!StringUtils.hasText(request.getUsername()) || !StringUtils.hasText(request.getContent())) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", "username and content must not be blank");
            return ResponseEntity.badRequest().body(error);
        }

        Long id = userRecordService.create(request);
        Map<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("message", "created");
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
