package com.konny.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.konny.member.model.RegisterRequest;
import com.konny.member.service.ChangePasswordService;
import com.konny.member.service.MemberInfoPrinter;
import com.konny.member.service.MemberListPrinter;
import com.konny.member.service.MemberRegisterService;

public class App {
	private static ApplicationContext ctx;
	
    public static void main( String[] args ) throws IOException{
    	ctx = new ClassPathXmlApplicationContext("config/application_context_config.xml");
    	
        BufferedReader br = 
        		new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
        	System.out.println("명령어를 입력하세요 : ");
        	String command = br.readLine();
        	
        	if(command.equalsIgnoreCase("exit")) {
        		System.out.println("프로그램을 종료합니다.");
        		break;
        	}
        	
        	if(command.startsWith("new ")) {
        		newCommand(command.split(" "));
        		continue;
        	}        	
        	else if(command.startsWith("change ")) {
        		changeCommand(command.split(" "));
        		continue;
        	}
        	else if(command.equals("list")) {
        		listCommand();
        		continue;
        	}
        	else if(command.startsWith("info ")) {
        		infoCommand(command.split(" "));
        		continue;
        	}
        	
        	printHelp();
        }
    }
    
    private static void newCommand(String cmd[]) {
    	if(cmd.length != 5) {
			printHelp();
			return;
		}
		
		RegisterRequest req = new RegisterRequest();
		req.setEmail(cmd[1]);
		req.setName(cmd[2]);
		req.setPassword(cmd[3]);
		req.setConfirmPassword(cmd[4]);
		
		MemberRegisterService regSvc = 
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		
		if(!req.isPasswordEqualToconfirmPassword()) {
			System.out.println("암호와 확인이 맞지 않습니다.\n");
			return;
		}
		else {
			regSvc.regist(req);
			System.out.println("잘 등록되었습니다.\n");
		}
    }
    
    private static void changeCommand(String cmd[]) {
    	if(cmd.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService changePwdSvc = 
				ctx.getBean("memberPwdSvc", ChangePasswordService.class);
		
		changePwdSvc.changePassword(cmd[1], cmd[2], cmd[3]);
		System.out.println("암호를 변경했습니다.");
    }
    
    private static void printHelp() {
    	System.out.println();
    	System.out.println("잘못된 명령어 입니다.");
    	System.out.println("new 이메일 이름 암호 암호확인");
    	System.out.println("change 이메일 현재암호 바꿀암호");
    	System.out.println("info 이메일");
    	System.out.println();
    }
    
    private static void infoCommand(String cmd[]) {
    	if(cmd.length != 2) {
			printHelp();
			return;
		}
    	
    	MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
    	infoPrinter.printMemberInfo(cmd[1]);
    }
    
    private static void listCommand() {
    	MemberListPrinter listPrinter = 
    			ctx.getBean("listPrinter", MemberListPrinter.class);
    	listPrinter.printAll();
    }
}
