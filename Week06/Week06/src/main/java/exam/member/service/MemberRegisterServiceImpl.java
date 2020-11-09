package exam.member.service;

import java.util.Date;

import exam.member.dao.MemberDao;
import exam.member.ui.AlreadyExistingMemberException;
import exam.member.vo.MemberVo;
import exam.member.vo.RegisterRequest;

public class MemberRegisterServiceImpl implements MemberRegisterService {

	private MemberDao memberDao;
	
	public MemberRegisterServiceImpl(MemberDao memberDao) {
		
		// TODO Auto-generated constructor stub
		this.memberDao=memberDao;
	}
	@Override
	public void regist(RegisterRequest req) {
		// TODO Auto-generated method stub
		 MemberVo member = memberDao.selectByEmail(req.getEmail());
		 
		 if(member !=null) {
			 throw new AlreadyExistingMemberException();
		 }
		
		 MemberVo newMember=new MemberVo(req.getEmail(), req.getPassword(),
				 req.getName(), new Date());
				 
		 memberDao.insert(newMember);
	}

}
