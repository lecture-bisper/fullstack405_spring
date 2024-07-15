package bitc.fullstack405.board2.controller;

import bitc.fullstack405.board2.dto.UserDTO;
import bitc.fullstack405.board2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

//로그인 및 회원가입을 위한 컨트롤러 클래스
@Controller
// 기본 주소를 설정
@RequestMapping("/board2/login")
public class LoginController {

  @Autowired
  private UserService userService;

//  로그인 페이지 (단순 View)
  @RequestMapping("/login.do")
  public String login() throws Exception {
    return "login/login";
  }

//  로그인 처리, 매개변수로 사용자 ID와 비밀번호를 받아옴
//  세션 정보가 필요하기 때문에 HttpServletRequest 를 매개변수로 받아옴
  @RequestMapping("/loginProcess.do")
  public String loginProcess(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, HttpServletRequest req) throws Exception {
//    사용자가 입력한 id/pw를 사용하는 사용자가 있는지 DB에서 검색
    int result = userService.isUserInfo(userId, userPw);

//    결과가 1 일때만 정상적인 로그인 상태, 0은 비로그인 상태
    if (result == 1) {
//      정상 로그인 상태일 경우 사용자가 입력한 ID에 대한 모든 정보를 DB에서 가져옴
      UserDTO user = userService.getUserInfo(userId);

//      request 객체를 통해서 세션 정보를 가져옴
      HttpSession session = req.getSession();
//      DB에서 가져온 정보를 세션에 저장
      session.setAttribute("userId", user.getUserId());
      session.setAttribute("userName", user.getUserName());
      session.setAttribute("userEmail", user.getUserEmail());
//      세션 유지 시간 설정
      session.setMaxInactiveInterval(60 * 60 * 1);

//      게시글 목록 페이지로 리다이렉트
      return "redirect:/board2/boardList.do";
    }
    else {
//      결과가 1이 아닐 경우 로그인 페이지로 다시 리다이렉트
      return "redirect:/board2/login/login.do?errorMsg=" + URLEncoder.encode("로그인 정보가 다릅니다.", "UTF-8");
    }
  }

//  로그아웃 처리, 세션에 저장된 모든 내용을 삭제하면 로그아웃
  @RequestMapping("/logout.do")
  public String logout(HttpServletRequest req) throws Exception {
//    request 객체를 통해서 세션 정보를 가져옴
    HttpSession session = req.getSession();

//    세션에 저장된 정보를 삭제
    session.removeAttribute("userId");
    session.removeAttribute("userName");
    session.removeAttribute("userEmail");

//    모든 세션 정보 삭제
    session.invalidate();

//    게시물 목록 페이지로 리다이렉트
    return "redirect:/board2/boardList.do";
  }
}












