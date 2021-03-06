package exam.member.service;

import exam.member.dao.MemberDao;
import exam.member.vo.MemberVo;

public class MemberDeleteServiceImpl implements MemberDeleteService{

	private MemberDao memberDao;
	public MemberDeleteServiceImpl(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub
		MemberVo member=memberDao.selectByEmail(email);
		if(member == null) {
			System.out.println("그런 정보가 없습니다.");
		}
		memberDao.delete(member);
	}

}
