package bitc.fullstack405.board2.service;

import bitc.fullstack405.board2.dto.UserDTO;

public interface UserService {

  public int isUserInfo(String userId, String userPw) throws Exception;

  public UserDTO getUserInfo(String userId) throws Exception;
}
