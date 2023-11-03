package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Member;

@Mapper
public interface DataMappingInterface {
	@Select("select * from MEM")
	List<Member> selectAll();
}