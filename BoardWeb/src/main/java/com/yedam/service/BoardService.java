package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 업무단위의 처리.
 */
public interface BoardService {
	public List<BoardVO> boardList(int page);//목록조회
	public BoardVO getBoard(int bno);//단건조회
	public boolean registerBoard(BoardVO board);//등록가능
	public boolean modifyBoard(BoardVO board);//수정가능
	public boolean removeBoard(int boardNo); // 삭제 기능

}
