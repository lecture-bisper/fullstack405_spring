package bitc.fullstack405.board2.dto;

import lombok.Data;

// t_user 테이블과 데이터를 주고 받기 위한 DTO 클래스
@Data
public class UserDTO {
  private String userId;
  private String userPw;
  private String userName;
  private String userEmail;
  private String createDate;
  private String updateDate;
}












