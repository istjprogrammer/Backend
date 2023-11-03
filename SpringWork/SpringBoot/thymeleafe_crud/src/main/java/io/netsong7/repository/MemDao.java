package io.netsong7.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.netsong7.domain.Member;

@Repository
public class MemDao {
	@Autowired
	private DataMappingInterface dataInterface;
	
	public List<Member> getDataAll(){
		List<Member> list = dataInterface.selectAll();
		return list;
	}
	
	public boolean insertData(Member mem) {
		int result = dataInterface.insertData(mem);
		if(result > 0)
				return true;
		else
				return false;
	}
}