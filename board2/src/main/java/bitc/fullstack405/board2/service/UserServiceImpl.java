package bitc.fullstack405.board2.service;

import bitc.fullstack405.board2.dto.UserDTO;
import bitc.fullstack405.board2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

//  로그인 여부 확인
  @Override
  public int isUserInfo(String userId, String userPw) throws Exception {
    return userMapper.isUserInfo(userId, userPw);
  }

//  사용자 정보 가져오기
  @Override
  public UserDTO getUserInfo(String userId) throws Exception {
    return userMapper.getUserInfo(userId);
  }
}












