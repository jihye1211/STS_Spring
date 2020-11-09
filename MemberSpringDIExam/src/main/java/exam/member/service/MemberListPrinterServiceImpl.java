package exam.member.service;

import java.util.Collection;

import exam.member.dao.MemberDao;
import exam.member.vo.MemberVo;

public class MemberListPrinterServiceImpl implements MemberListPrinterService{
	private MemberDao memberDao;
	private MemberPrinterService memberPrinter;
	public MemberListPrinterServiceImpl (MemberDao memberDao, MemberPrinterService Printer, MemberPrinterService memberPrinter) {
		this.memberDao=memberDao;
		this.memberPrinter=memberPrinter;
	}
	public void printAll() {
		Collection<MemberVo> members = memberDao.selectAll();
		for(MemberVo member:members) {
			memberPrinter.print(member);
		}
	}
}
