package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO http://localhost:8080/BoardWeb/board.do?bno =22
		String bno =req.getParameter("bno");
		
		//글 상세조회
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.getBoard(Integer.parseInt(bno));
		//요청정보 저장
		req.setAttribute("board", board);	//attribute의 board 속석으로 저장.
		//요청재지정(페이지이동)
		req.getRequestDispatcher("WEB-INF/jsp/board.jsp").forward(req, resp);
	}
		
		

}
