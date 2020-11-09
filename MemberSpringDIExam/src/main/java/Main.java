import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import exam.member.dao.MemberDao;
import exam.member.dao.MemberDaoImpl;
import exam.member.service.MemberListPrinterService;
import exam.member.service.MemberListPrinterServiceImpl;
import exam.member.service.MemberPrinterService;
import exam.member.service.MemberPrinterServiceImpl;
import exam.member.service.MemberRegisterService;
import exam.member.service.MemberRegisterServiceImpl;
import exam.member.ui.MemberUI;

public class Main {
	public static void main(String[] args) {
		
		MemberDao memberDao=new  MemberDaoImpl();
		MemberRegisterService memberRegisterService = new
				MemberRegisterServiceImpl(memberDao);
		MemberUI memberUI = new MemberUI();
		memberUI.setMemberRegisterService(memberRegisterService);
		
		MemberPrinterService memberListPrinterService=
				new MemberPrinterServiceImpl();
		MemberListPrinterService memberListPrinterService=
				new MemberListPrinterServiceImpl(memberDao, MemberPrinterService)
					
		memberUI.setMemberListPrinterService(memberListPrinterService);
		
		ChangePasswordService changePasswordService =
				new ChangePasswordServiceImpl(memberDao);
		memberUI.setChangePasswordService(changePasswordService);
		
		memberUI.showMenu();
		
		ApplicationContext ctx=new GenericXmlApplicationContext("member.xml");
		MemberUI memberUI = ctx.getBean("memberUI", MemberUI.class);
		
		memberUI.showMenu();
	}
}