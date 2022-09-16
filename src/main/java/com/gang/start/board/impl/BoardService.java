package com.gang.start.board.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionContext;

import org.springframework.web.multipart.MultipartFile;

import com.gang.start.util.Pager;

public interface BoardService {
	
	//글목록
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//글조회
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	//글쓰기
	public int setAdd(BoardDTO boardDTO,MultipartFile [] files, ServletContext servletContext) throws Exception;
	
	//글수정
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception;
	
	//글삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;

	//fileDelete
	public int setFileDelete(BoardFileDTO boardFileDTO, ServletContext servletContext) throws Exception;
	
}
