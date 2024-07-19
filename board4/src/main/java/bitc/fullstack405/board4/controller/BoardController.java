package bitc.fullstack405.board4.controller;

import bitc.fullstack405.board4.entity.JpaBoardEntity;
import bitc.fullstack405.board4.service.JpaBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jpa")
public class BoardController {

  @Autowired
  private JpaBoardService jpaBoardService;

  @GetMapping({"/", ""})
  public String index() {
    return "index";
  }

//  게시글 목록
  @GetMapping("/board")
  public ModelAndView selectBoardList() throws Exception {
    ModelAndView mv = new ModelAndView("board/jpaBoardList");

    List<JpaBoardEntity> boardList = jpaBoardService.selectBoardList();
    mv.addObject("boardList", boardList);

    return mv;
  }
  
//  게시글 상세
  @GetMapping("/board/{boardIdx}")
  public ModelAndView selectBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
    ModelAndView mv = new ModelAndView("board/jpaBoardDetail");

    JpaBoardEntity board = jpaBoardService.selectBoardDetail(boardIdx);
    mv.addObject("board", board);

    return mv;
  }
  
//  게시글 등록(view)
  @GetMapping("/board/write")
  public String insertBoard() throws Exception {
    return "board/jpaBoardWrite";
  }

//  게시글 등록 처리
  @PostMapping("/board/write")
  public String insertBoard(JpaBoardEntity board) throws Exception {
    jpaBoardService.saveBoard(board);
    return "redirect:/jpa/board";
  }
  
//  게시글 수정
  @PutMapping("/board/{boardIdx}")
  public String updateBoard(@PathVariable("boardIdx") int boardIdx, JpaBoardEntity board) throws Exception {
    jpaBoardService.saveBoard(board);
    return "redirect:/jpa/board";
  }
  
//  게시글 삭제
  @DeleteMapping("/board/{boardIdx}")
  public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
    jpaBoardService.deleteBoard(boardIdx);
    return "redirect:/jpa/board";
  }
}












