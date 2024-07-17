package bitc.fullstack405.board3.mapper;

import bitc.fullstack405.board3.dto.BoardDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardPagingMapper {

  Page<BoardDTO> selectBoardPageList() throws Exception;
}
