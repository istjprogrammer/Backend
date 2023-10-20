package com.konny.member.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.konny.member.model.MemberDto;

@Repository
public class MemberDao {
	private Map<String, MemberDto> map = new HashMap<String, MemberDto>();
	private static long nextId = 0;
	// 한사람의 이메일을 조회하는 메서드
	public MemberDto selectByEmail(String email) {
		return map.get(email);
	}
	
	// 모두를 조회하는 메서드
	public Collection<MemberDto> selectAll() {
		return map.values();
	}
	
	// 데이터 입력
	public void insert(MemberDto member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
		System.out.println("test:" + map);
	}
	
	
	// 데이터 업데이트
	public void update(MemberDto member) {
		map.put(member.getEmail(), member);
	}
}
