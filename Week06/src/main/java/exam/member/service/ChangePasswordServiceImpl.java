package exam.member.service;

import exam.member.dao.MemberDao;
import exam.member.vo.MemberVo;

public class ChangePasswordServiceImpl implements ChangePasswordService {

	private MemberDao memberDao;
	public ChangePasswordServiceImpl(MemberDao memberDao) {
		// TODO Auto-generated constructor stub
		this.memberDao=memberDao;
	}
	@Override
	public void changePassword(String email, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
	MemberVo member=memberDao.selectByEmail(email);
	if(member == null) {
		System.out.println("그런 정보가 없습니다.");
	}
	member.changerPassword(oldPassword, newPassword);
	memberDao.update(member);
	}

}
