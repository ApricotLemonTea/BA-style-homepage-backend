package com.apricotlemontea.homepage.service;

import com.apricotlemontea.homepage.dto.CreateUserRecordRequest;
import com.apricotlemontea.homepage.entity.UserRecord;
import com.apricotlemontea.homepage.mapper.UserRecordMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRecordService {

    private final UserRecordMapper userRecordMapper;

    public UserRecordService(UserRecordMapper userRecordMapper) {
        this.userRecordMapper = userRecordMapper;
    }

    @Transactional
    public Long create(CreateUserRecordRequest request) {
        UserRecord record = new UserRecord();
        record.setUsername(request.getUsername());
        record.setContent(request.getContent());

        int affectedRows = userRecordMapper.insert(record);
        if (affectedRows != 1) {
            throw new IllegalStateException("Insert user_record failed.");
        }
        return record.getId();
    }
}
