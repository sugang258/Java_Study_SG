package com.gang.start.members;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gang.start.account.BankAccountDAO;
import com.gang.start.account.BankAccountDTO;
import com.gang.start.util.FileManager;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private FileManager fileManager; 
	/*
	@Autowired
	private ServletContext servletContext;
	*/
	/*
	@Autowired
	private BankAccountDAO bankAccountDAO;
	*/
	

	//bankMembers 회원가입
		public int setJoin(BankMembersDTO bankMembersDTO,MultipartFile photo, ServletContext servletContext) throws Exception{
			
			
			int result = bankMembersDAO.setJoin(bankMembersDTO);
			
			String path = "resources/upload/member";
			
			String fileName = fileManager.saveFile(path, servletContext, photo);
			
			if(!photo.isEmpty()) {
			
			MemberFileDTO memberFileDTO =new MemberFileDTO();
			memberFileDTO.setFileName(fileName);
			memberFileDTO.setOriName(photo.getOriginalFilename());
			memberFileDTO.setUserName(bankMembersDTO.getUserName());
			bankMembersDAO.setAddFile(memberFileDTO);
			}
			//1. HDD에 파일을 저장
			//	파일 저장시에 경로는 Tomcat 기준이 아니라 OS의 기준으로 설정
			
			//2. 저장된 파일정보를 DB에 저장
			/*
			String realPath = servletContext.getRealPath("resources/upload/member");
			System.out.println("RealPath : "+realPath );
			
			File file = new File(realPath);
			*/
			
			//file 첨부가 없을 때 구분
			
			/*
			if(photo.getSize() != 0) {
				
			}
			*/
			
		/*
			if(!photo.isEmpty()) {
				
				
				if(!file.exists()) {
					file.mkdirs();
		
				}
				
				String fileName = UUID.randomUUID().toString();
				
				Calendar ca = Calendar.getInstance();
				Long time = ca.getTimeInMillis();
				
				fileName = fileName + "_" + photo.getOriginalFilename();
				
				//5. HDD에 파일 저장
				//어느 폴더에 어떤 이름으로 저장할 FILE 객체 생성
				file = new File(file, fileName);
				
				
				// 1)MultipartFile 클래스의 transferTo 메서드 사용
				photo.transferTo(file);
		        System.out.println(photo.getOriginalFilename());
		        // 2)FileCopyUtils 클래스의 copy 메서드 사용
				
				
				//2. 저장될 file정보를 db에 저장
				MemberFileDTO memberFileDTO =new MemberFileDTO();
				memberFileDTO.setFileName(fileName);
				memberFileDTO.setOriName(photo.getOriginalFilename());
				memberFileDTO.setUserName(bankMembersDTO.getUserName());
				
				bankMembersDAO.setAddFile(memberFileDTO);
				
				System.out.println(fileName);
				
				
			}
		*/
			
			return result;
			
		}
		
		//검색어를 입력해서 id를 찾기
		public List<BankMembersDTO> getSearchByID(String search) throws Exception{
			
			return bankMembersDAO.getSearchByID(search);
			
		}
			
		public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
			
			return bankMembersDAO.getLogin(bankMembersDTO);
		}
		/*
		public Map<String, Object> myPage(BankMembersDTO bankMembersDTO) throws Exception {
			Map<String, Object> map = new HashMap<String, Object>();
			List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
			bankMembersDTO = bankMembersDAO.myPage(bankMembersDTO);
			map.put("list", ar);
			map.put("dto", bankMembersDTO);
			
			return map;
			
			
		}
		*/
		
		public BankMembersDTO myPage(BankMembersDTO bankMembersDTO) throws Exception {
	
			return bankMembersDAO.myPage(bankMembersDTO);
		}
}
