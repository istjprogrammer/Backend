package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SampleMapper {
    @Select("SELECT count(*) FROM Users;")
    Integer getUserCount();

    @Insert("INSERT INTO USERS (id, createDate, userId, userName)" +
            "VALUES (#{id}, now(), #{userId}, #{userName})")
    Integer saveUser(@Param("id") String id, @Param("userId") String userId, @Param("userName") String userName);
}
