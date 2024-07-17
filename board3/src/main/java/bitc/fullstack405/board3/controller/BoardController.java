package bitc.fullstack405.board3.controller;

import bitc.fullstack405.board3.dto.BoardDTO;
import bitc.fullstack405.board3.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {
//  RESTful 이란 : URL을 자원의 이름으로 구분하여 해당 자원의 정보를 주고 받는 방식
//  HTTP URI 를 통해서 자원을 명시하고, HTTP Method(GET, POST, PUT, DELETE)를 통해 자원에 대한 CRUD 명령을 적용하는 방식

//  URI : Uniform Resource Identifier 의 줄임말, 자원 식별자
//  URL : Uniform Resource Locator 의 줄임말, 자원의 위치
//  현재는 거의 같은 의미로 사용됨

//  RESTful 방식은 데이터를 전송하는 방법을 지정함
//  HttpMethod를 사용하여 GET(조회), POST(입력), PUT(수정), DELETE(삭제)로 구분하여 사용함

//  전체 URL 설정 방법
//  서버URL:포트번호/기본주소/추가주소/게시물번호

//  게시판 목록 : /board3/selectBoardList.do -> /board3  GET
//  게시글 작성 화면 : /board3/writeBoard.do -> /board3/write  GET
//  게시글 작성 처리 : /board3/insertBoard.do -> /board3/write  POST
//  게시글 상세 화면 : /board3/selectBoardDetail.do -> /board3/게시글번호  GET
//  게시글 수정 : /board3/updateBoard.do -> /board3/게시글번호  PUT
//  게시글 삭제 : /board3/deleteBoard.do -> /board3/게시글번호  DELETE

//  @RequestMapping 어노테이션 사용 시 URI를 value 속성을 사용하여 설정, method 속성을 추가하여 GET, POST, PUT, DELETE 를 사용하여 설정
//  @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 어노테이션을 사용하여 구분해도 상관없음

//  Spring Framework의 기본 설정은 GET, POST 방식만 인식함
//  설정 파일인 application.properties 에 spring.mvc.hiddenmethod.filter.enabled=true 가 추가되야 함

//  Spring Framework의 템플릿에서 GET, POST 방식만 인식하기 때문에 PUT, DELETE 를 인식하기 위해서 input type=hidden 을 추가하고, name=_method 속성을 사용하여 데이터 전송 방식(PUT, DELETE)을 지정해야 함

  @Autowired
  private BoardService boardService;

  @RequestMapping({"", "/"})
  public String index() {
    return "index";
  }

//  게시물 목록
  @RequestMapping(value = {"/board3"}, method = RequestMethod.GET)
  public ModelAndView selectBoardList() throws Exception {
    ModelAndView mv = new ModelAndView("board3/boardList");

    List<BoardDTO> boardList = boardService.selectBoardList();
    mv.addObject("boardList", boardList);

    return mv;
  }

//  게시물 상세
  @RequestMapping(value = "/board3/{boardIdx}", method = RequestMethod.GET)
  public ModelAndView selectBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
    ModelAndView mv = new ModelAndView("board3/boardDetail");

    BoardDTO board = boardService.selectBoardDetail(boardIdx);
    mv.addObject("board", board);

    return mv;
  }

//  @GetMapping : 클라이언트에서 데이터 전송 방식을 GET 으로 설정한 URL만 접속, @RequestMapping(method = RequestMethod.GET) 과 동일한 방식
//  게시물 등록 (view)
  @GetMapping("/board3/write")
  public String writeBoard() throws Exception {
    return "board3/boardWrite";
  }

//  URL이 동일하더라도 method 타입이 다르면 동일한 URL 을 사용할 수 있음
//  @PostMapping : 클라이언트에서 데이터 전송 방식을 POST 로 설정한 URL만 접속, @RequestMapping(method = RequestMethod.POST) 와 동일한 방식
//  게시물 등록 (내부처리)
  @PostMapping("/board3/write")
  public String writeBoard(BoardDTO board) throws Exception {
    boardService.insertBoard(board);

    return "redirect:/board3";
  }

//  @PutMapping : 클라이언트에서 데이터 전송 방식을 PUT으로 설정한 URL 만 접속, @RequestMapping(method = RequestMethod.PUT) 와 동일한 방식
//  게시물 수정
  @PutMapping("/board3/{boardIdx}")
  public String boardUpdate(BoardDTO board) throws Exception {
    boardService.updateBoard(board);

    return "redirect:/board3";
  }

//  @DeleteMapping : 클라이언트에서 데이터 전송 방식을 DELETE 로 설정한 URL 만 접속, @RequestMapping(method = RequestMethod.DELETE) 와 동일한 방식
//  @PathVariable : @RequestParam과 동일한 역할을 하는 어노테이션, REST 방식 사용 시 URI에 {} 로 지정해 놓은 리소스 값을 받아오는 어노테이션
//  게시물 삭제
  @DeleteMapping("/board3/{boardIdx}")
  public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
    boardService.deleteBoard(boardIdx);

    return "redirect:/board3";
  }
}












