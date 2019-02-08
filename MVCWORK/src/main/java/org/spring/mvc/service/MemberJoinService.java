package org.spring.mvc.service;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.spring.mvc.domain.MemberDTO;
import org.spring.mvc.persistence.MemberDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class MemberJoinService {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	private MemberDAO dao;
	
	@Transactional
	public int Insert(MultipartHttpServletRequest request, MemberDTO dto) {
		dao = sqlSessionTemplate.getMapper(MemberDAO.class);
		String uri = "/upload";
		String dir = request.getSession().getServletContext().getRealPath(uri);
		MultipartFile file = request.getFile("picture");
		String fileName = file.getOriginalFilename();
		System.out.println("파일이름 : " + fileName);
		dto.setPhoto(fileName);
		System.out.println("파일 경로 + 이름 : "+dto.getPhoto());
		
		if(!file.isEmpty()) {
			try {
				file.transferTo(new File(dir,fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return dao.memberInsert(dto);
		
	}
}
