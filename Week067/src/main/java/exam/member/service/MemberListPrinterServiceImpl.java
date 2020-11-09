package exam.member.service;

import java.util.Collection;

import exam.member.dao.MemberDao;
import exam.member.vo.MemberVo;

public class MemberListPrinterServiceImpl implements MemberListPrinterService {

	private MemberDao memberDao;
	
	public MemberListPrinterServiceImpl(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	
	@Override
	public void printAll() {
		// TODO Auto-generated method stub
		Collection<MemberVo> members=memberDao.selectAll();
		for(MemberVo member:members) {
			print(member);
		}
			
	}
	
	public void print(MemberVo member) {
		System.out.printf("회원정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",member.getId(),
				member.getEmail(),member.getName(),member.getRegisterDate());
		
	}
}
