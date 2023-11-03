package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Member;

@Repository
public class MemDao {
	@Autowired
	private DataMappingInterface dataInterface;
	
	public List<Member> getDataAll(){
		List<Member> list = dataInterface.selectAll();
		return list;
	}
}