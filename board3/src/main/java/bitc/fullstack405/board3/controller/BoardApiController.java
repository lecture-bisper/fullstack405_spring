package bitc.fullstack405.board3.controller;

import bitc.fullstack405.board3.dto.BoardDTO;
import bitc.fullstack405.board3.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//  @RestController : @Controller + @ResponseBody 어노테이션이 하나로 합쳐진 어노테이션
//  @Controller 의 기능인 스프링 프레임워크에 해당 클래스가 Controller 임을 알려주고 클라이언트에서 접속하는 URL과 메소드를 연결하는 기능과 @ResponseBody 의 기능인 클라이언트에게 View 없이 데이터만 전달하는 기능이 합쳐진 어노테이션임
//  @Controller 어노테이션과 @ResponseBody 어노테이션을 따로 입력하여 사용하여도 같은 효과를 가짐
//  ajax 통신 시 rest api 방식으로 데이터를 전송하는 컨트롤러를 따로 만들어서 사용하면 편리함
//  리액트 사용 시 프론트엔드 부분과 백엔드 부분이 완전히 분리되어 있기 때문에 데이터를 주고 받기 위해서 ajax 통신이 필요함

//  RESTful API : REST 방식과 동일한 형태로 HTTP 프로토콜을 사용하지만, 클라이언트로 전달하는 데이터가 View를 제외한 순수 데이터만 전달하는 방식
//  예전에는 클라이언트가 컴퓨터 밖에 없었기 때문에 웹 브라우저 혹은 전용 프로그램이 클라이언트의 기능을 모두 담당했음
//  서버의 기능의 웹 서버의 기능만 주로 사용되었기 때문에 클라이언트로 전달하는 데이터가 View 와 Model 데이터 모두 필요한 형태였음
//  현재는 클라이언트가 다양한 디바이스로 동작하기 때문에 View 부분이 반드시 웹 브라우저일 필요가 아니기 때문에 데이터만 전달하는 방식으로 변경되었음

@RestController
@RequestMapping("/board3/api")
public class BoardApiController {

  @Autowired
  private BoardService boardService;
  
  // 게시판 목록 가져오기 API
  @RequestMapping(value = "/board", method = RequestMethod.GET)
  public Object selectBoardList() throws Exception {
    List<BoardDTO> boardList = boardService.selectBoardList();

    return boardList;
  }


//  게시판 글 상세 정보 가져오기 API
  @GetMapping("/board/{boardIdx}")
  public Object selectBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
    BoardDTO board = boardService.selectBoardDetail(boardIdx);

    return board;
  }

//  @RequestBody : 클라이언트에서 서버로 전달하는 데이터를 http 프로토콜의 body 부분에 데이터를 저장하여 서버로 전달하는 방식
//  @RequestParam은 서버 주소(URL)에 데이터를 포함하여 전달하는 방식
//  게시판 글 등록 API
  @PostMapping("/board/write")
  public void insertBoard(@RequestBody BoardDTO board) throws Exception {
    boardService.insertBoard(board);
  }


//  게시판 글 수정 API
  @PutMapping("/board/{boardIdx}")
  public void updateBoard(@PathVariable("boardIdx") int boardIdx, @RequestBody BoardDTO board) throws Exception {
    board.setBoardIdx(boardIdx);
    boardService.updateBoard(board);
  }

//  게시판 글 삭제 API
  @DeleteMapping("/board/{boardIdx}")
  public void deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
    boardService.deleteBoard(boardIdx);
  }
}












