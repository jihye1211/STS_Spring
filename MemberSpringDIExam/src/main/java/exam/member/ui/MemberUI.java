package exam.member.ui;

import java.util.Scanner;
import exam.member.ui.AlreadyExistingMemberException;
import exam.member.service.MemberListPrinterService;
import exam.member.service.MemberRegisterService;
import exam.member.vo.RegisterRequest;

public class MemberUI {
	
	MemberRegisterService memberRegisterService; //멤버등록
	// 이 변수명을 통해 모두 사용 가능함.
	MemberListPrinterService memberListPrinterService; //출력 서비스
	
	public MemberUI() {}
		public void setMemberRegisterService(MemberRegisterService memberRegisterService)
		{
			this.memberRegisterService=memberRegisterService;
		}
		// 이 코드를 통해 실제 관계를 맺게 됨.
	
	public void setMemberistPrinterService(MemberListPrinterService memberListPrinterService) {
		this.memberListPrinterService=memberListPrinterService;
	}
	
	
	public void showMenu() {
		Scanner scan = new Scanner(System.in);
		String command = "";

		while (true) {
			System.out.println("명령어를 입력하세요.");
			command = scan.nextLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료합니다.");
				break;
			} else if (command.toLowerCase().startsWith("new")) {
				processNewCommand(command.split(""));
				continue;
			} else if (command.toLowerCase().startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			} else if (command.equalsIgnoreCase("list")) {
				processListCommand();
				continue;
			}else if(command.toLowerCase().startsWith("change")) {
				processChangeCommand(command.split(""));
				continue;
				
			}
		}
	}

	private void processListCommand() {
		memberListPrinterService.printAll();
	}


	private void processNewCommand(String[] args) {
		if (args.length != 5) {
			System.out.println("입력된 정보가 틀립니다. 다시 넣어주세요.");
			return;
		}

		RegisterRequest req = new RegisterRequest();
		// 받은 정보는 req에서 저장하고 있음.
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 암호 확인이 일치하지 않습니다. \n");
			return;
		}
		
		try {
			memberRegisterService.regist(req);
			System.out.println("성공");
		}catch(AlreadyExistingMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.");
		}
	}
	
	private void processChangeCommand(String[] args) {
		if(args.length!=4)
		{
			return;
		}
		try {
			changePasswordService.chanagePassword(args[1], args[2], args[3]);
			System.out.println("암호를 변경했습니다.\n");
		} catch (MemberNotFoundException e) {
			System.out.println("존재핮 않는 이메일입니다.\n");
		} catch (IdPasswordNotMatchingException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다. \n");
		}
	}

}
