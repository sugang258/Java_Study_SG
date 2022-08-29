package com.gang.start.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gang.start.board.impl.BoardDTO;
import com.gang.start.board.impl.BoardService;
import com.gang.start.board.impl.BoardFileDTO;
import com.gang.start.util.FileManager;
import com.gang.start.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManager fileManager;
	/*
	@Autowired
	private ServletContext servletContext;
	*/
	
	//글목록
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception{
		System.out.println(pager.getPage());
		/*
		Long startRow = 0L;
		Long lastRow =0L;
		Long perPage =10L; //한페이지에 출력할 목록의 갯수
		
		startRow = (page-1)*perPage+1;
		lastRow = page*perPage;
		
		System.out.println("StartRow" + startRow);
		System.out.println("lastRow" + lastRow);
		
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		
		Long totalCount = noticeDAO.getCount();
		System.out.println(totalCount);
		Long totalPage = totalCount/perPage;
		
		
		
		if(totalCount % perPage != 0) {
			totalPage++;
		}
		
		System.out.println( "page count : " + totalPage);
		
		Long perBlock=5L;
		Long totalBlock = totalPage/perBlock;
		
		if(totalPage % perBlock != 0) {
			totalBlock++;
		}
		
		Long curBlock = (totalPage /perBlock);
		
		if(curBlock % perBlock  != 0) {
			curBlock++;
		}
		
		Long startNum =(curBlock-1) * perBlock + 1; 
		
		Long lastNum = curBlock*perBlock;
		
		System.out.println(curBlock);
		*/
		
		Long totalCount = noticeDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
	    
		
		return noticeDAO.getList(pager);
		
		
	}
		
	//글상세보기
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception{
		return noticeDAO.getDetail(boardDTO);
	}
		
	//글쓰기
	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception{
		
		int result = noticeDAO.setAdd(boardDTO);
		
		String path = "resources/upload/notice";
		
		for(MultipartFile mf : files) {
		
			if(mf.isEmpty()) {
				continue;
			}
		String fileName = fileManager.saveFile(path, servletContext, mf);
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOriName(mf.getOriginalFilename());
		boardFileDTO.setNum(boardDTO.getNum());
		noticeDAO.setAddFile(boardFileDTO);
		}
	
		return result; //noticeDAO.setAdd(boardDTO);
	}
		
	//글수정
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setUpdate(boardDTO);
	}
		
	//글삭제
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setDelete(boardDTO);
	}
	
	

}
