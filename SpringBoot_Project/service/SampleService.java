package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.SampleMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그를 자동으로 만들어주는 기능
@Service
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
		
	public void sample() {
		log.info("sample count : {} ", sampleMapper.getUserCount());
	}
	
	public void saveUsers(String id, String userId, String userName) {
		sampleMapper.saveUser(id, userId, userName);
    }
}
