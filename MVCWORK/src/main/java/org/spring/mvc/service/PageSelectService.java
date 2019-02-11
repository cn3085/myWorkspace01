package org.spring.mvc.service;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.spring.mvc.domain.MemberDTO;
import org.spring.mvc.domain.PageCriteria;
import org.spring.mvc.persistence.MemberDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@Service
public class PageSelectService {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MemberDAO dao;
	
	public void pagingVarSetting(PageCriteria pcriteria) {
		int Alldata = pcriteria.getAlldata(); //전체 데이터 개수
		int pageNow = pcriteria.getPageNow(); // 현재 페이지 어디지?
		int perPageNum = pcriteria.getPerPageNum(); // 한 페이지에 몇 개 보여줄 건지
		
		int pageStart = Alldata-((pageNow-1)*perPageNum); // 맨 위에 몇 번 게시글 보여줄 건지
		int pageEnd = pageStart<perPageNum?1:pageStart-perPageNum+1; // 보여지는 게시물 + 몇 개 보여줄건지
		int pageList = Alldata%perPageNum==0?Alldata/perPageNum:Alldata/perPageNum+1;//페이징 몇개?
		
		pcriteria.setPageStart(pageStart);
		pcriteria.setPageEnd(pageEnd);
		pcriteria.setPageList(pageList);
	}
	
	@Transactional
	public void memberPageListSelect(ModelAndView mav, PageCriteria pcriteria) {
		
		dao=sqlSessionTemplate.getMapper(MemberDAO.class);
		
		System.out.println("세팅 전"+pcriteria.toString());
		pagingVarSetting(pcriteria);
		System.out.println("세팅 후"+pcriteria.toString());
		
		List<MemberDTO> list = dao.memberPageListSelect(pcriteria);
		System.out.println("--------list 가져온 거--------------");
		System.out.println(list);
		mav.addObject("list", list);
		mav.addObject("pcriteria", pcriteria);
	}
	

}
