package bitc.fullstack405.board1.service;

import bitc.fullstack405.board1.dto.BoardDTO;

import java.util.List;

// BoardService는 인터페이스이기 때문에 사용 방법만 제공
// 해당 인터페이스 파일을 구현하는 클래스가 반드시 필요함
public interface BoardService {

  public List<BoardDTO> selectBoardList() throws Exception;

  public void insertBoard(BoardDTO board) throws Exception;

  BoardDTO selectBoardDetail(int boardIdx) throws Exception;

  void updateBoard(BoardDTO board) throws Exception;

  void deleteBoard(int boardIdx) throws Exception;
}







