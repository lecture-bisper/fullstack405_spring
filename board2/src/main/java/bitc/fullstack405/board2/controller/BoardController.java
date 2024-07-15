package bitc.fullstack405.board2.controller;

import bitc.fullstack405.board2.dto.BoardDTO;
import bitc.fullstack405.board2.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/board2")
public class BoardController {

  @Autowired
  private BoardService boardService;

  @RequestMapping("/")
  public String index() {
    return "index";
  }

//  게시물 전체 목록 조회 (모든 사용자가 이용 가능)
  @RequestMapping("/boardList.do")
  public ModelAndView boardList() throws Exception {
    ModelAndView mv = new ModelAndView("board2/boardList");

    List<BoardDTO> boardList = boardService.selectBoardList();
    mv.addObject("boardList", boardList);

    return mv;
  }

//  1. 컨트롤러에서 세션 정보를 사용하여 로그인 여부 확인
////  게시글 상세 보기 (회원만 이용 가능, 비회원은 로그인 페이지로 이동)
////  HttpServletRequest : JSP의 내장 객체인 request 와 동일한 객체
//  @RequestMapping("/boardDetail.do")
//  public ModelAndView boardDetail(@RequestParam("boardIdx") int boardIdx, HttpServletRequest req) throws Exception {
////    HttpSession : 세션 객체 클래스, JSP의 session 내장 객체와 같은 객체
////    request 에 저장된 세션 정보를 가져옴
//    HttpSession session = req.getSession();
//    ModelAndView mv = new ModelAndView();
//
////    세션에 저장된 정보가 있는지 확인
//    if (session.getAttribute("userId") == null) {
////      세션 정보가 없으면 비 로그인 상태, 로그인 페이지로 리다이렉트
//      mv.setViewName("redirect:/board2/login/login.do");
//    }
//    else {
////      세션 정보가 있으면 로그인 상태, 게시글 상세보기 View 페이지를 설정
//      mv.setViewName("board2/boardDetail");
////      DB에서 데이터를 가져오기
//      BoardDTO board = boardService.selectBoardDetail(boardIdx);
////      ModelAndView 객체에 저장
//      mv.addObject("board", board);
//    }
//
//    return mv;
//  }

//  2. 세션 정보를 html 에서 자바스크립트를 사용하여 처리하는 방식
  //  게시글 상세 보기 (회원만 이용 가능)
  @RequestMapping("/boardDetail.do")
  public ModelAndView boardDetail(@RequestParam("boardIdx") int boardIdx) throws Exception {
    ModelAndView mv = new ModelAndView("board2/boardDetail");

    BoardDTO board = boardService.selectBoardDetail(boardIdx);
    mv.addObject("board", board);

    return mv;
  }
}












