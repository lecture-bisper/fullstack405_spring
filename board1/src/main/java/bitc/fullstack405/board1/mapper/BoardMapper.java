package bitc.fullstack405.board1.mapper;

import bitc.fullstack405.board1.dto.BoardDTO;
import bitc.fullstack405.board1.dto.BoardFileDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 데이터베이스와 연동되어 있는 인터페이스
// JSP의 DAO 클래스의 기능을 수행
// @Mapper : mybatis의 Mapper 로써 데이터베이스와 연동됨을 스프링 프레임워크에 알려주는 어노테이션
// mybatis에서 제공하는 SQL 쿼리문 xml 파일과 1:1로 연동되어 있음
@Mapper
public interface BoardMapper {

//  Mapper 파일에 등록된 메소드 명과 데이터 타입을 xml 파일에서 그대로 사용함
//  전체 목록
  public List<BoardDTO> selectBoardList() throws Exception;
  
//  글 쓰기
  public void insertBoard(BoardDTO board) throws Exception;
  
//  글 상세보기
  public BoardDTO selectBoardDetail(int boardIdx) throws Exception;
  
//  글 수정
  public void updateBoard(BoardDTO board) throws Exception;
  
//  글 삭제
  public void deleteBoard(int boardIdx) throws Exception;
  
//  조회수 증가
  public void updateHitCount(int boardIdx) throws Exception;

//  첨부파일 정보 DB에 추가
  public void insertBoardFileList(List<BoardFileDTO> fileList) throws Exception;

//  @Param : mybatis의 xml에서 사용할 변수명을 지정하는 어노테이션, @Param을 사용하지 않을 경우 매개변수의 이름의 그대로 사용함
  public List<BoardFileDTO> selectBoardFileList(@Param("idx") int boardIdx) throws Exception;

  BoardFileDTO selectBoardFileInfo(@Param("fileIdx") int fileIdx, @Param("boardIdx") int boardIdx);
}








