package bitc.fullstack405.board1.service;

import bitc.fullstack405.board1.dto.BoardDTO;
import bitc.fullstack405.board1.dto.BoardFileDTO;
import bitc.fullstack405.board1.mapper.BoardMapper;
import bitc.fullstack405.board1.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;

// @Service : 스프링 프레임워크에 해당 파일이 서비스 파일임을 알려주는 어노테이션
@Service
// BoardService를 상속받아 구현하는 클래스
public class BoardServiceImpl implements BoardService {

//  데이터베이스를 사용하기 위한 Mapper 인터페이스 타입의 변수 선언
//  @Autowired 어노테이션을 사용하여 스프링 프레임워크가 자동으로 객체를 생성하고 관리함
  @Autowired
  private BoardMapper boardMapper;

  @Autowired
  private FileUtils fileUtils;

//  BoardService 인터페이스에서 상속받아 구현한 메소드
  @Override
  public List<BoardDTO> selectBoardList() throws Exception {
//    BoardMapper에서 제공하는 selectBoardList() 메소드를 사용하여 데이터를 가져옴
    return boardMapper.selectBoardList();
  }

//  @Override
//  public void insertBoard(BoardDTO board) throws Exception {
////    데이터베이스에 데이터 추가를 위하여 mapper 에서 제공하는 insertBoard() 메소드 호출
//    boardMapper.insertBoard(board);
//  }

//  사용자가 입력한 Form 데이터와 업로드된 파일 정보를 매개변수로 받아서 사용
  @Override
  public void insertBoard(BoardDTO board, MultipartHttpServletRequest multipart) throws Exception {
//    매퍼를 사용하여 DB에 게시물 등록
    boardMapper.insertBoard(board);

//    업로드된 파일 정보를 모두 가져옴, 해당 정보를 가지고 DB의 t_files 테이블에 데이터를 저장할 수 있음
//    FileUtils 클래스 타입의 객체에서 제공하는 parseFileInfo()를 호출하여 BoardFileDTO 클래스 타입의 객체가 저장된 List 를 가져옴
    List<BoardFileDTO> fileList = fileUtils.parseFileInfo(board.getBoardIdx(), board.getCreateUser(), multipart);

//    if (fileList != null && fileList.size() > 0) {
//      boardMapper.insertBoardFileList(fileList);
//    }

//    CollectionUtils : 스프링 프레임워크에서 제공하는 컬렉션 타입의 객체를 활용할 수 있는 유틸 클래스
    if (CollectionUtils.isEmpty(fileList) == false) {
//      생성된 파일 정보 리스트를 DB에 추가
      boardMapper.insertBoardFileList(fileList);
    }

////    반복문으로 처리 시
//    if (CollectionUtils.isEmpty(fileList) == false) {
////      생성된 파일 정보 리스트를 DB에 추가
//      for (BoardFileDTO fileDTO : fileList) {
//        boardMapper.insertBoardFileList(fileDTO);
//      }
//    }


////    파일 정보가 서버로 업로드됐는지 확인
////    ObjectUtils.isEmpty() : 스프링 프레임워크에서 제공하는 클래스, 객체가 비었는지 아닌지 확인
//    if (ObjectUtils.isEmpty(multipart) == false) {
////      getFileNames() : 업로드된 파일 정보에서 모든 파일 이름을 출력
//      Iterator<String> iterator = multipart.getFileNames();
//      String name; // 파일명이 저장될 변수
//
////      hasNext() : Iterator 타입의 객체에 저장된 데이터 중 출력할 데이터가 있는지 확인
//      while (iterator.hasNext()) {
////        next() : Iterator 타입의 객체에 저장된 데이터를 하나 출력
//        name = iterator.next();
//
////        getFiles() : 가져온 파일 정보에서 지정한 파일 이름과 동일한 파일 객체를 출력
//        List<MultipartFile> fileInfoList = multipart.getFiles(name);
//
////        리스트에 저장된 내용 출력
//        for (MultipartFile fileInfo : fileInfoList) {
//          System.out.println("\n ***** 파일 정보 ***** \n");
//          System.out.println("file name : " + fileInfo.getOriginalFilename());
//          System.out.println("file size : " + fileInfo.getSize());
//          System.out.println("file content type : " + fileInfo.getContentType());
//          System.out.println("\n---------------------------------------------\n");
//        }
//      }
//    }
  }

  @Override
  public BoardDTO selectBoardDetail(int boardIdx) throws Exception {
//    조회수 업데이트
    boardMapper.updateHitCount(boardIdx);

//    DB에서 게시물 상세 내용 가져오기
    BoardDTO board = boardMapper.selectBoardDetail(boardIdx);
//    DB에서 해당 게시물의 첨부파일 목록 가져오기
    List<BoardFileDTO> boardFileList = boardMapper.selectBoardFileList(boardIdx);
//    가져온 첨부파일 목록을 게시물 상세 내용에 추가하기
    board.setFileList(boardFileList);
    
    return board;
  }

  @Override
  public void updateBoard(BoardDTO board) throws Exception {
    boardMapper.updateBoard(board);
  }

  @Override
  public void deleteBoard(int boardIdx) throws Exception {
    boardMapper.deleteBoard(boardIdx);
  }

  @Override
  public BoardFileDTO selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception {
    return boardMapper.selectBoardFileInfo(fileIdx, boardIdx);
  }
}












