package com.apricotlemontea.homepage.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRecord {

    private Long id;
    private String username;
    private String content;
    private LocalDateTime createdAt;

}
