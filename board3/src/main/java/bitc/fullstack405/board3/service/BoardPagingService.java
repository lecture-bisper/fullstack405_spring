package bitc.fullstack405.board3.service;

import bitc.fullstack405.board3.dto.BoardDTO;
import com.github.pagehelper.Page;

public interface BoardPagingService {
  Page<BoardDTO> selectBoardPageList(int pageNum) throws Exception;
}
