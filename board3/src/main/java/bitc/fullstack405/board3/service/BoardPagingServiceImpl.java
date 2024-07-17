package bitc.fullstack405.board3.service;

import bitc.fullstack405.board3.dto.BoardDTO;
import bitc.fullstack405.board3.mapper.BoardPagingMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardPagingServiceImpl implements BoardPagingService {

  @Autowired
  private BoardPagingMapper boardPagingMapper;

//  Page : PageHelper 에서 제공하는 데이터 타입, ArrayList 와 비슷한 데이터 타입
  @Override
  public Page<BoardDTO> selectBoardPageList(int pageNum) throws Exception {
//    첫번째 매개변수 : 현재 페이지 번호 입력
//    두번째 매개변수 : 현재 페이지에 출력할 게시물 수를 설정
//    PageHelper 라이브러리가 mapper 를 사용하여 전체 데이터를 불러온 후 자동으로 제어함
//    mapper의 sql문에 limit로 개수 제한을 할 필요가 없음
    PageHelper.startPage(pageNum, 3);
    return boardPagingMapper.selectBoardPageList();
  }
}












