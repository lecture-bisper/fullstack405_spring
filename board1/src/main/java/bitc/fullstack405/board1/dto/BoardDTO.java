package bitc.fullstack405.board1.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

// @Data : Lombok 라이브러리에서 제공하는 어노테이션
// 자동으로 getter/setter 메소드를 생성
// 자동으로 toString() 메소드를 생성
// @Getter, @Setter, @ToString 어노테이션이 합쳐진 어노테이션
// @Getter : Lombok 에서 제공하는 getter 메소드를 자동 생성하는 어노테이션
// @Setter : Lombok 에서 제공하는 setter 메소드를 자동 생성하는 어노테이션
// @ToString : Lombok 에서 제공하는 ToString 메소드를 자동으로 생성하는 어노테이션

@Data
//@Getter
//@Setter
//@ToString
public class BoardDTO {
  private int boardIdx;
  private String title;
  private String contents;
  private String createUser;
  private String createDate;
  private String updateUser;
  private String updateDate;
  private int hitCnt;
//  업로드된 파일 목록
  private List<BoardFileDTO> fileList;
}












