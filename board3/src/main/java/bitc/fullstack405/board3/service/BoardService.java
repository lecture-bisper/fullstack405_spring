package bitc.fullstack405.board3.service;

import bitc.fullstack405.board3.dto.BoardDTO;

import java.util.List;

public interface BoardService {

  public List<BoardDTO> selectBoardList() throws Exception;

  BoardDTO selectBoardDetail(int boardIdx) throws Exception;

  void insertBoard(BoardDTO board) throws Exception;

  void updateBoard(BoardDTO board) throws Exception;

  void deleteBoard(int boardIdx) throws Exception;
}









