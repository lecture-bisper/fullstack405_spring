package bitc.fullstack405.board2.service;

import bitc.fullstack405.board2.dto.BoardDTO;

import java.util.List;

public interface BoardService {

  public List<BoardDTO> selectBoardList() throws Exception;

  public BoardDTO selectBoardDetail(int boardIdx) throws Exception;
}
