package bitc.fullstack405.board2.mapper;

import bitc.fullstack405.board2.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

//  사용자 로그인 여부 확인
  public int isUserInfo(@Param("userId") String userId, @Param("userPw") String userPw) throws Exception;

//  사용자 정보 가져오기
  public UserDTO getUserInfo(@Param("userId") String userId) throws Exception;
}






