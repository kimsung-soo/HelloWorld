package com.yedam.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class RemoveBoardControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        String bno = req.getParameter("bno");

        BoardService svc = new BoardServiceImpl();
        svc.removeBoard(Integer.parseInt(bno));

        // 삭제 후 게시글 목록 페이지로 이동
        resp.sendRedirect("boardList.do");
    }
}
