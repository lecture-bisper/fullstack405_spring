package bitc.fullstack405.board1.service;

import bitc.fullstack405.board1.dto.BoardDTO;
import bitc.fullstack405.board1.dto.BoardFileDTO;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

// BoardService는 인터페이스이기 때문에 사용 방법만 제공
// 해당 인터페이스 파일을 구현하는 클래스가 반드시 필요함
public interface BoardService {

  public List<BoardDTO> selectBoardList() throws Exception;

//  기존의 t_board 타입의 데이터만 매개변수로 받음
//  public void insertBoard(BoardDTO board) throws Exception;
//  기존 데이터와 첨부파일을 모두 사용
  public void insertBoard(BoardDTO board, MultipartHttpServletRequest multipart) throws Exception;

  BoardDTO selectBoardDetail(int boardIdx) throws Exception;

  void updateBoard(BoardDTO board) throws Exception;

  void deleteBoard(int boardIdx) throws Exception;

  BoardFileDTO selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception;
}







