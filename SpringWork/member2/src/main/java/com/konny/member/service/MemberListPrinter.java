package com.konny.member.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konny.member.common.MemberPrinter;
import com.konny.member.model.MemberDto;
import com.konny.member.repository.MemberDao;
@Service("listPrinter")
public class MemberListPrinter {
	private MemberDao memDao;
	private MemberPrinter printer;
	
	@Autowired
	public void setMemDao(MemberDao memDao) {this.memDao = memDao; }
	@Autowired
	public void setPrinter(MemberPrinter printer) {this.printer = printer; }
	
	public void printAll() {
		Collection<MemberDto> members = memDao.selectAll();
		
		for(MemberDto m : members) {
			printer.print(m);
		}
		System.out.println();
	}
}