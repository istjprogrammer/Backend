package com.konny.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konny.member.common.MemberPrinter;
import com.konny.member.model.MemberDto;
import com.konny.member.repository.MemberDao;
@Service("infoPrinter")
public class MemberInfoPrinter {
	private MemberDao memDao;
	private MemberPrinter printer;
	
	@Autowired public void setMemDao(MemberDao memDao) {this.memDao = memDao; }
	@Autowired public void setPrinter(MemberPrinter printer) {this.printer = printer; }
	
	public void printMemberInfo(String email) {
		MemberDto member = memDao.selectByEmail(email);
		
		if(member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		
		printer.print(member);
		System.out.println();
	}
}