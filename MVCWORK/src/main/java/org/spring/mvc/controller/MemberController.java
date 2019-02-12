package org.spring.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.spring.mvc.domain.MemberDTO;
import org.spring.mvc.domain.PageCriteria;
import org.spring.mvc.service.MemberEditService;
import org.spring.mvc.service.MemberJoinService;
import org.spring.mvc.service.MemberListService;
import org.spring.mvc.service.MemberLoginService;
import org.spring.mvc.service.MemberRemoveService;
import org.spring.mvc.service.PageSelectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Inject
	private MemberJoinService joinService;
	
	@Inject
	private MemberLoginService loginService;
	
	@Inject
	private MemberListService listSelect;
	
	@Inject
	private MemberRemoveService memberRemove;
	
	@Inject
	private MemberEditService memberEdit;
	
	@Inject
	private PageSelectService pageService;
	
	@RequestMapping("/JoinForm")
	public String regForm() {
		return "member/joinForm";
	}
	
	@RequestMapping(value="/Join", method=RequestMethod.POST)
	public String memberJoin(
			MultipartHttpServletRequest request,
			MemberDTO dto,
			Model model
			) {
		System.out.println(dto.toString());
		joinService.Insert(request ,dto);
		loginService.SelectMember(request, dto.getEmail(), dto.getPassword());
		return "redirect:/";
	}
	
	@RequestMapping("/Auth/myPage")
	public String myPage() {
		return "member/Auth/myPage";
	}
	
//	@RequestMapping("/Auth/memberList")
//	public String memberList(Model model) {
//		listSelect.memberListSelect(model);
//		
//		return "/member/Auth/memberList";
//	}
	
	@RequestMapping("/Auth/memberRemove") // 삭제 ajax 처리
	@ResponseBody
	public List<MemberDTO> memberRemove(String email, Model model, PageCriteria pcriteria) {
		System.out.println("컨트롤러에서 받은 이메일 : " + email);
		memberRemove.MemberRemove(email);
		List list=listSelect.memberListSelect();
		pcriteria.setAlldata(list.size());
		List returnlist=pageService.memberPageListSelect(pcriteria);
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("pcriteria", pcriteria);
		
		System.out.println(list);
		return returnlist;
	}
	
	@RequestMapping("/Auth/memberEdit") // 수정 ajax처리
	@ResponseBody
	public List<MemberDTO> memberEdit(MemberDTO dto, Model model, PageCriteria pcriteria) {
		System.out.println("수정하고 싶군요 : "+ dto.toString());
		
		memberEdit.MemberEdit(dto);
		
		List list=listSelect.memberListSelect();
		pcriteria.setAlldata(list.size());
		List returnlist=pageService.memberPageListSelect(pcriteria);
		
		System.out.println(list);
		return returnlist;
	}
	
	@RequestMapping("/Auth/memberList")
	public ModelAndView memberPageList(ModelAndView mav, PageCriteria pcriteria) {
		List list=listSelect.memberListSelect();
		pcriteria.setAlldata(list.size());
		
		pageService.memberPageListSelect(mav, pcriteria);
		
		mav.setViewName("/member/Auth/TempMemberList");
		return mav;
	}
}
