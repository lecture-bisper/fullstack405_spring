package bitc.fullstack405.board4.service;

import bitc.fullstack405.board4.entity.JpaBoardEntity;

import java.util.List;

public interface JpaBoardService {

  List<JpaBoardEntity> selectBoardList() throws Exception;

  JpaBoardEntity selectBoardDetail(int boardIdx) throws Exception;

  void saveBoard(JpaBoardEntity board) throws Exception;

  void deleteBoard(int boardIdx) throws Exception;

}
