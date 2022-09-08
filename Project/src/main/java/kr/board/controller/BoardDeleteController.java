package kr.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.dao.BoardMyBatisDAO;
import kr.dao.CommMyBatisDAO;

// 게시글 삭제 컨트롤러
public class BoardDeleteController implements Controller {

	@Override
	public String requestProcessor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardMyBatisDAO dao = new BoardMyBatisDAO();
		CommMyBatisDAO dao1 = new CommMyBatisDAO();
		int num = Integer.parseInt(request.getParameter("num")); // 게시글 번호 가져오기
		dao1.commDelete(num); // 댓글을 삭제하고 게시글을 삭제해야 무결성 제약조건을 위배하지 않는다 
		dao.boardDelete(num); // 게시글 삭제 dao
		return "redirect:/boardList.do";
	}

}
