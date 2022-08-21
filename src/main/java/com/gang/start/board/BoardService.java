package com.gang.start.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.gang.start.members.BankMembersDTO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardDTO> getList() throws Exception {
		//boardDAO.updateViews();
		return boardDAO.getList();
		
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		boardDAO.updateViews(boardDTO.getNum());
		return boardDAO.getDetail(boardDTO);
	}
	
	public int delete(BoardDTO boardDTO) throws Exception {	
		return boardDAO.delete(boardDTO);
	}
	

	
	public int update(BoardDTO boardDTO) throws Exception {
		return boardDAO.update(boardDTO);
	}
	
	
	
	public int add(BoardDTO boardDTO) throws Exception {
		
		return boardDAO.add(boardDTO);
	}
	
	
	public int updateViews(int num) throws Exception {
		return boardDAO.updateViews(num);
	}
	

}
