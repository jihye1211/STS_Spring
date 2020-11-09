package exam.member.service;

import java.util.Date;

import exam.member.dao.MemberDao;
import exam.member.ui.AlreadyExistingMemberException;
import exam.member.vo.MemberVo;
import exam.member.vo.RegisterRequest;

public class MemberRegisterServiceImpl implements MemberRegisterService {

	private MemberDao memberDao;
	
	
	// 중요한 이부분이 생략되어서 오류가 났음.
	public MemberRegisterServiceImpl(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	
	public void regist(RegisterRequest req) {
		MemberVo member=memberDao.selectByEmail(req.getEmail());
		
		if(member!=null) {
			throw new AlreadyExistingMemberException();
		}
		MemberVo newMember=new MemberVo(req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}
}
