package bitc.fullstack405.board3.mapper;

import bitc.fullstack405.board3.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

  public List<BoardDTO> selectBoardList() throws Exception;

  BoardDTO selectBoardDetail(@Param("boardIdx") int boardIdx) throws Exception;

  void insertBoard(BoardDTO board) throws Exception;

  void updateBoard(BoardDTO board) throws Exception;

  void deleteBoard(@Param("boardIdx") int boardIdx) throws Exception;

  void updateHitCount(@Param("boardIdx") int boardIdx) throws Exception;
}
