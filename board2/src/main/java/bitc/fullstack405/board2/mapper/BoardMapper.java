package bitc.fullstack405.board2.mapper;

import bitc.fullstack405.board2.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

  public List<BoardDTO> selectBoardList() throws Exception;

  public BoardDTO selectBoardDetail(int boardIdx) throws Exception;

  public void updateHitCount(int boardIdx) throws Exception;
}
