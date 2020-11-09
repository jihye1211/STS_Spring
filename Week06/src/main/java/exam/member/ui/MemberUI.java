package exam.member.ui;

import java.util.Scanner;

import exam.member.service.ChangePasswordService;
import exam.member.service.MemberDeleteService;
import exam.member.service.MemberListPrinterService;
import exam.member.service.MemberRegisterService;
import exam.member.vo.RegisterRequest;

public class MemberUI {
	
	MemberRegisterService memberRegisterService;
	MemberListPrinterService memberListPrinterService;
	ChangePasswordService changePasswordService;
	MemberDeleteService memberDeleteService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService)
	{
		this.memberRegisterService=memberRegisterService;
	}
	public void setMemberListPrinterService(MemberListPrinterService memberListPrinterService) {
		this.memberListPrinterService=memberListPrinterService;
	}
	
	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService=changePasswordService;
	}
	public void setMemberDeleteService(MemberDeleteService memberDeleteService) {
		this.memberDeleteService=memberDeleteService;
	}
	
	public void showMenu() {
		Scanner scan=new Scanner(System.in);
		String command="";
		
		while(true) {
			System.out.println("명령어를 입력하세요.");
			command=scan.nextLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료합니다.");
				break;
			}
			else if(command.toLowerCase().startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			}
			else if(command.toLowerCase().startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			else if(command.equalsIgnoreCase("list")) {
				processListCommand();
				continue;
			}
			else if(command.toLowerCase().startsWith("delete ")) {
				processDeleteCommand(command.split(" "));
				continue;
			}
		}
	}
	

	private void processDeleteCommand(String[] args) {
		// TODO Auto-generated method stub
		memberDeleteService.delete(args[1]);
	}
	private void processListCommand() {
		memberListPrinterService.printAll();
	}
	
	private void processChangeCommand(String[] args) {
		if(args.length !=4) {
			System.out.println("입력된 정보가 틀립니다. 다시 넣어주세요.");
			return;
		}
		changePasswordService.changePassword(args[1], args[2], args[3]);
		System.out.println("암호를 변경했습니다.");
		
	}
	
	private void processNewCommand(String[] args) {
		if(args.length !=5) {
			System.out.println("입력된 정보가 틀립니다. 다시 넣어주세요.");
			return;
		}
		
		RegisterRequest req=new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);
		
		
		
		try {
			memberRegisterService.regist(req);
		}catch(AlreadyExistingMemberException e) {
			System.out.println("이미 존재하는 이메일입니다. ");
		}
	}

}
