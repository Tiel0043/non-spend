package kr.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.dao.BoardMyBatisDAO;
import kr.entity.Board;

// 게시글 목록 컨트롤러
public class BoardListController implements Controller {

	@Override
	public String requestProcessor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardMyBatisDAO dao = new BoardMyBatisDAO();
		List<Board> list = dao.allList(); // join을 게시글 전체를 가져온다
		HttpSession session =request.getSession();
		session.setAttribute("list", list);

		return "boardList";
	}


}
