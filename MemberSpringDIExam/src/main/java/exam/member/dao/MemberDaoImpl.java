package exam.member.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import exam.member.vo.MemberVo;

public class MemberDaoImpl implements MemberDao{
	
	private static long nextId=0;
	private Map<String, MemberVo> map = new HashMap<String, MemberVo>();
	
	public MemberVo selectByEmail(String email) {
		return map.get(email);
	}
	
	public void insert(MemberVo member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	public void update(MemberVo member) {
		map.put(member.getEmail(), member);
	}
	
	public Collection<MemberVo> selectAll() {
		return map.values();
	}
}
