package io.netsong7.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import io.netsong7.domain.Member;

@Mapper
public interface DataMappingInterface {
	@Select("select * from mem")
	List<Member> selectAll();
	
	@Insert("insert into mem values(#{num}, #{name}, #{addr})")
	int insertData(Member mem);
	
	@Select("select * from mem where num=#{num}")
	Member selectOne(String num);

	@Update("update mem set name=#{name}, addr=#{addr} where num-#{num}")
	int updateData(Member mem);
	
	@Delete("delete from mem where num=#{num]")
	int deleteData(String num);
}