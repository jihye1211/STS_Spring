package com.example.project.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.project.model.dto.MemberVO;

// ���� Ŭ������ DAO bean���� ��Ͻ�Ŵ
// @Repository ��Ʈ���� ���� x �ſ� �߿�!
@Repository
public class MemberDAOImpl implements MemberDAO {
	// SqlSession ��ü�� ���������� �����Ͽ� ���Խ����ش�.
	// �������� ����(Dependency Injection, DI)
	// ������ ����
	// IoC(Inversion of Control, ������ ����)
	@Inject
	// Inject�ֳ����̼��� ������ sqlSession�� null����������
	// Inject�ֳ����̼��� ������ �ܺο��� ��ü�� ���Խ����ְ� �ȴ�.
	// try catch��, finally��, ��ü�� close�� �ʿ䰡 ��������.
	SqlSession sqlSession;

	@Override
	public List<MemberVO> memberList() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("member.memberList");
	}

	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		
		sqlSession.insert("member.insertMember",vo);
	}

	@Override
	public MemberVO viewMember(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.viewMember", userId);
		
	}

	@Override
	public void deleteMember(String userId) {
		// TODO Auto-generated method stub
		sqlSession.delete("member.deleteMember",userId);
	}

	@Override
	public void updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update("member.updateMember",vo);
	}
	
	public boolean checkPw(String userId, String userPw) {
		boolean result=false;
		Map<String, String> map=new HashMap<String, String>();
		map.put("userId",userId);
		map.put("userPw",userPw);
		int count=sqlSession.selectOne("member.checkPw", map);
		if(count==1) result=true;
		return result;
	}

}