package com.example.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.project.model.dao.MemberDAOImpl;
import com.example.project.model.dto.MemberVO;

// 현재 클래스를 스프링에서 관리하는 service bean으로 등록
// @Service 꼭 넣어줘야함. 중요!
@Service
public class MemberServiceImpl implements MemberService {
    //MemberDAOImpl 객체를  스프링에서 생성하여 주입
	//service단에서는 dao를 인젝트시킴
	@Inject
	MemberDAOImpl memberDao;

	@Override
	public List<MemberVO> memberList() {
		// TODO Auto-generated method stub
		return memberDao.memberList();
	}

	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDao.insertMember(vo);
		
	}

	@Override
	public MemberVO viewMember(String userId) {
		// TODO Auto-generated method stub
		return memberDao.viewMember(userId);
	}

	@Override
	public void deleteMember(String userId) {
		// TODO Auto-generated method stub
		memberDao.deleteMember(userId);
	}

	@Override
	public void updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDao.updateMember(vo);
	}
	public boolean checkPw(String userId, String userPw) {
		return memberDao.checkPw(userId,userPw);
	}
	
	
	
}
