package bitc.fullstack405.board2.service;

import bitc.fullstack405.board2.dto.BoardDTO;
import bitc.fullstack405.board2.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardMapper boardMapper;

  @Override
  public List<BoardDTO> selectBoardList() throws Exception {
    return boardMapper.selectBoardList();
  }

  @Override
  public BoardDTO selectBoardDetail(int boardIdx) throws Exception {
    boardMapper.updateHitCount(boardIdx);
    return boardMapper.selectBoardDetail(boardIdx);
  }
}












