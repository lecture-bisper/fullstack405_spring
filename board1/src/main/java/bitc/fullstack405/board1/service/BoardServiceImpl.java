package bitc.fullstack405.board1.service;

import bitc.fullstack405.board1.dto.BoardDTO;
import bitc.fullstack405.board1.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service : 스프링 프레임워크에 해당 파일이 서비스 파일임을 알려주는 어노테이션
@Service
// BoardService를 상속받아 구현하는 클래스
public class BoardServiceImpl implements BoardService {

//  데이터베이스를 사용하기 위한 Mapper 인터페이스 타입의 변수 선언
//  @Autowired 어노테이션을 사용하여 스프링 프레임워크가 자동으로 객체를 생성하고 관리함
  @Autowired
  private BoardMapper boardMapper;

//  BoardService 인터페이스에서 상속받아 구현한 메소드
  @Override
  public List<BoardDTO> selectBoardList() throws Exception {
//    BoardMapper에서 제공하는 selectBoardList() 메소드를 사용하여 데이터를 가져옴
    return boardMapper.selectBoardList();
  }

  @Override
  public void insertBoard(BoardDTO board) throws Exception {
//    데이터베이스에 데이터 추가를 위하여 mapper 에서 제공하는 insertBoard() 메소드 호출
    boardMapper.insertBoard(board);
  }

  @Override
  public BoardDTO selectBoardDetail(int boardIdx) throws Exception {
    return boardMapper.selectBoardDetail(boardIdx);
  }

  @Override
  public void updateBoard(BoardDTO board) throws Exception {
    boardMapper.updateBoard(board);
  }

  @Override
  public void deleteBoard(int boardIdx) throws Exception {
    boardMapper.deleteBoard(boardIdx);
  }
}












