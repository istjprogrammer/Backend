package com.konny.member.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.konny.member.model.MemberDto;

@Repository
public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public MemberDto selectByEmail(String email) {
		return null;
	}
	
	public Collection<MemberDto> selectAll(){
		return null;
	}
	
	public void insert(MemberDto member) {
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				String sql = "insert into member(id, email, password, name, " +
//						"registerDate) values(seq_id.nextVal,?,?,?,?)";
//				PreparedStatement stmt = con.prepareStatement(sql);
//				stmt.setString(1, member.getEmail());
//				stmt.setString(2, member.getPassword());
//				stmt.setString(3, member.getName());
//				stmt.setTimestamp(4, 
//						new Timestamp(member.getRegisterDate().getTime()));
//
//				return stmt;
//			}
//		});
		jdbcTemplate.update(
				(Connection con) -> {
				String sql = "insert into member(id, email, password, name, " +
						"registerDate) values(seq_id.nextVal,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, member.getEmail());
				stmt.setString(2, member.getPassword());
				stmt.setString(3, member.getName());
				stmt.setTimestamp(4, 
						new Timestamp(member.getRegisterDate().getTime()));
				return stmt;
		}
	);
	}
	
	public void update(MemberDto member) {
		
	}
}