import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import exam.member.dao.MemberDao;
import exam.member.dao.MemberDaoImpl;
import exam.member.service.ChangePasswordService;
import exam.member.service.ChangePasswordServiceImpl;
import exam.member.service.MemberDeleteService;
import exam.member.service.MemberDeleteServiceImpl;
import exam.member.service.MemberListPrinterService;
import exam.member.service.MemberListPrinterServiceImpl;
import exam.member.service.MemberRegisterService;
import exam.member.service.MemberRegisterServiceImpl;
import exam.member.ui.MemberUI;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*MemberDao memberDao=new MemberDaoImpl();
		MemberRegisterService memberRegisterService = new
				MemberRegisterServiceImpl(memberDao);
				
		MemberUI memberUI=new MemberUI();
		memberUI.setMemberRegisterService(memberRegisterService);
		
		MemberListPrinterService memberListPrinterService=new MemberListPrinterServiceImpl(memberDao);
		memberUI.setMemberListPrinterService(memberListPrinterService);
		
		ChangePasswordService changePasswordService=new ChangePasswordServiceImpl(memberDao);
		memberUI.setChangePasswordService(changePasswordService);		
		
		MemberDeleteService memberDeleteService=new MemberDeleteServiceImpl(memberDao);
		memberUI.setMemberDeleteService(memberDeleteService);
		
		memberUI.showMenu();*/
		ApplicationContext ctx=new GenericXmlApplicationContext("beans.xml");
		MemberUI memberUI=(MemberUI)ctx.getBean("memberUI");
		memberUI.showMenu();
	}

}
