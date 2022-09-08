package kr.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.dao.BoardMyBatisDAO;
import kr.entity.Board;

// 게시글 수정폼으로 이동하는 컨트롤러
public class BoardUpdateFormController implements Controller {

	@Override
	public String requestProcessor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardMyBatisDAO dao = new BoardMyBatisDAO();
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		Board vo = dao.boardView(num); // 해당 게시글의 데이터를 가져와 수정에 뿌려준다
		request.setAttribute("vo", vo); 
		return "boardUpdate";
	}

}
