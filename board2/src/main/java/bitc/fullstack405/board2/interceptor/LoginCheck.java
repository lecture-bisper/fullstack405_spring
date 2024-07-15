package bitc.fullstack405.board2.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;


//  Interceptor를 사용하기 위해서 HandlerInterceptor 인터페이스를 상속받아 구현
public class LoginCheck implements HandlerInterceptor {
//  preHandle() : 지정한 컨트롤러가 동작하기 이전에 먼저 수행됨
//  postHandle() : 지정한 컨트롤러가 동작 후 view 페이지가 동작하기 이전에 수행됨
//  afterCompletion() : 모든 동작이 완료된 후 수행됨

  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

//    현재 연결의 세션 정보 가져옴
    HttpSession session = req.getSession();

    System.out.println("\n =============== Interceptor 동작 =============== \n");
    
//    세션에 저장된 정보 중 사용자 ID 정보를 가져옴, 세션에 저장 시 Object 타입으로 저장되므로 강제 타입 변환이 필요함
    String userId = (String) session.getAttribute("userId");
    System.out.println("User ID : " + userId);

//    세션에서 가져온 정보가 존재하는지 확인
    if (userId == null || userId.equals("")) {
//      세션에 저장된 정보가 없을 경우
      System.out.println("\n ********** interceptor ********** \n");
      System.out.println("비 로그인 상태");
      System.out.println("User ID : " + (String) session.getAttribute("userId"));

//      로그인 페이지로 리다이렉트
      resp.sendRedirect("/board2/login/login.do");

//      반환값을 false로 전달, 통과 못함, 컨트롤러로 연결되지 않음
      return false;
    }
    else {
//      세션에 저장된 정보가 있을 경우
      System.out.println("\n ********** interceptor *********** \n");
      System.out.println("로그인 상태");
      System.out.println("User ID : " + (String) session.getAttribute("userId"));

//      세션 유지 시간 설정
      session.setMaxInactiveInterval(60);

//      반환값을 true로 전달, 필터 통과, 원래 접속하고자 했던 controller로 접속
      return true;
    }
  }
}












