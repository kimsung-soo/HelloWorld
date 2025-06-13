package com.yedam.control;

import java.io.IOException;

import javax.servlet.http.*;

import com.yedam.common.Control;
import com.yedam.service.*;

public class RemoveReplyControl implements Control {
    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String rno = req.getParameter("rno");

        // JSON 응답을 위한 설정
        resp.setContentType("application/json;charset=UTF-8");

        // DB 처리
        ReplyService svc = new ReplyServiceImpl();
        if (svc.removeReply(Integer.parseInt(rno))) {
        	resp.getWriter().print("{\"retCode\":\"Success\"}");
        } else {
            resp.getWriter().print("{\"retCode\":\"Fail\"}");
        }
    }
}
