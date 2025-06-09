package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); //한글처리.
		//요청방식에 따라 Get요청이면 화면Open.
		//     		   post요청이면 저장.
		
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardService svc = new BoardServiceImpl();
		
		if(req.getMethod().equals("GET")) {
			//요청재지정(페이지이동)	  modifyBoard.do?bno=23
			BoardVO board = svc.getBoard(Integer.parseInt(bno));
			req.setAttribute("board", board);
			req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);
			
		}else if (req.getMethod().equals("POST")) {
			BoardVO board = new BoardVO();
			board.setBoardNo(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);
			svc.modifyBoard(board); 
			
			 resp.sendRedirect("boardList.do");
		}

	}

}
