package com.apricotlemontea.homepage.mapper;

import com.apricotlemontea.homepage.entity.UserRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRecordMapper {

    int insert(UserRecord userRecord);
    
}
