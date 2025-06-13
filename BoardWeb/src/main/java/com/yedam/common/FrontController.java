package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.*;

public class FrontController extends HttpServlet {
	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do", new BoardControl());
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/modifyBoard.do", new ModifyBoardControl());
		map.put("/removeBoard.do", new RemoveBoardControl());

		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());

		map.put("/memberList.do", new MemberListControl());
		map.put("/allProduct.do", new AllControl());

		map.put("/replyList.do", new ReplyListControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/getReply.do", new GetReplyControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String page = uri.substring(context.length());

		Control sub = map.get(page);
		if (sub != null) {
			sub.exec(req, resp);
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, "요청하신 페이지를 찾을 수 없습니다.");
		}
	}
}
