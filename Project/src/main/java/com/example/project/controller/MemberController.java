package com.example.project.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project.model.dto.MemberVO;
import com.example.project.service.MemberService;

//URL ��û ������ ������
//Model Ŭ������ �̿��ؼ�
//memberList ������ ������ �� 
//Member_list.jsp �並 ����

@Controller // ������ Ŭ������ controller bean�� ��Ͻ�Ŵ
public class MemberController {
	// MemberService ��ü�� ���������� �����Ͽ� ���Խ�Ŵ
	@Inject
	MemberService memberService;
	
	// 01. ȸ�� ���
	// url pattern mapping
	@RequestMapping("member/list.do")
	public String memberList(Model model){
		//controller -> service -> dao ��û
		List<MemberVO> list=memberService.memberList();
		model.addAttribute("list",list); // �� �̸��� �� ȭ��(list) item���� ���ƾ���.
		return "member/member_list";
	}
	
	// 02. ȸ�� ����
	@RequestMapping("member/insert.do")
	public String memberInsert(@ModelAttribute MemberVO vo) {
		memberService.insertMember(vo);
		return "redirect:/member/list.do";
	}
	
	//03. ȸ�� �Է� ��
	@RequestMapping("member/write.do")
	public String memberWrite() {
		return "member/member_write";
	}
	
	//04. ȸ�� �� ����
	@RequestMapping("member/view.do")
	public String memberView(String userId, Model model) {
		model.addAttribute("dto", memberService.viewMember(userId));
		return "member/member_view";
	}
	
	//05. ȸ�� ���� �����ϱ�
	// 14���� �κп� ����
	 @RequestMapping("member/update.do")
	   public String memberUpdate(@ModelAttribute MemberVO vo, Model model)
	   {
		   boolean result=memberService.checkPw(vo.getUserId(), vo.getUserPw());
		   if(result) {
			   memberService.updateMember(vo);
			   return "redirect:/member/list.do";
		   }
		   else {
			   model.addAttribute("dto",vo);
			   model.addAttribute("message","��й�ȣ����ġ");
			   return "member/member_view";
		   }
	   }
	//06. ȸ�� ���� �����ϱ�
	// 14���� �κп� ����
	 @RequestMapping("member/delete.do")
	 public String memberDelete(@ModelAttribute MemberVO vo, Model model) {
			   boolean result=memberService.checkPw(vo.getUserId(), vo.getUserPw());
			   if(result) {
				   memberService.deleteMember(vo.getUserId());
				   return "redirect:/member/list.do";
			   }else {
				   model.addAttribute("message","��� ����ġ");
				 
				   model.addAttribute("dto",memberService.viewMember(vo.getUserId()));
				   return "member/member_view"; 
			   }
	 }
}
