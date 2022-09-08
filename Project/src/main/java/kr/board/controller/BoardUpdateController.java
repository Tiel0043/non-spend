package kr.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.dao.BoardMyBatisDAO;
import kr.entity.Board;

// 게시글 수정 처리 컨트롤러
public class BoardUpdateController implements Controller {

	@Override
	public String requestProcessor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardMyBatisDAO dao = new BoardMyBatisDAO();
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num")); // 게시글 순번
		String title = request.getParameter("title"); // 게시글 제목
		String content = request.getParameter("content"); // 게시글 내용
		Board vo = new Board();
		vo.setComm_seq(num);
		vo.setComm_title(title);
		vo.setComm_content(content);
		dao.boardUpdate(vo); // 위 값을 가져와서 update문 처리
		System.out.println();
		return "redirect:/boardView.do?num="+num;
	}

}
