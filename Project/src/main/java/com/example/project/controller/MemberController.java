package com.example.project.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project.model.dto.MemberVO;
import com.example.project.service.MemberService;

//URL 요청 정보가 들어오면
//Model 클래스를 이용해서
//memberList 정보를 가져온 후 
//Member_list.jsp 뷰를 생성

@Controller // 현재의 클래스를 controller bean에 등록시킴
public class MemberController {
	// MemberService 객체를 스프링에서 생성하여 주입시킴
	@Inject
	MemberService memberService;
	
	// 01. 회원 목록
	// url pattern mapping
	@RequestMapping("member/list.do")
	public String memberList(Model model){
		//controller -> service -> dao 요청
		List<MemberVO> list=memberService.memberList();
		model.addAttribute("list",list); // 이 이름과 뷰 화면(list) item값이 같아야함.
		return "member/member_list";
	}
	
	// 02. 회원 삽입
	@RequestMapping("member/insert.do")
	public String memberInsert(@ModelAttribute MemberVO vo) {
		memberService.insertMember(vo);
		return "redirect:/member/list.do";
	}
	
	//03. 회원 입력 폼
	@RequestMapping("member/write.do")
	public String memberWrite() {
		return "member/member_write";
	}
	
	//04. 회원 상세 보기
	@RequestMapping("member/view.do")
	public String memberView(String userId, Model model) {
		model.addAttribute("dto", memberService.viewMember(userId));
		return "member/member_view";
	}
	
	//05. 회원 정보 수정하기
	// 14주차 부분에 설명
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
			   model.addAttribute("message","비밀번호불일치");
			   return "member/member_view";
		   }
	   }
	//06. 회원 정보 삭제하기
	// 14주차 부분에 설명
	 @RequestMapping("member/delete.do")
	 public String memberDelete(@ModelAttribute MemberVO vo, Model model) {
			   boolean result=memberService.checkPw(vo.getUserId(), vo.getUserPw());
			   if(result) {
				   memberService.deleteMember(vo.getUserId());
				   return "redirect:/member/list.do";
			   }else {
				   model.addAttribute("message","비번 불일치");
				 
				   model.addAttribute("dto",memberService.viewMember(vo.getUserId()));
				   return "member/member_view"; 
			   }
	 }
}
