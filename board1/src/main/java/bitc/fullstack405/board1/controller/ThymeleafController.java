package bitc.fullstack405.board1.controller;

import bitc.fullstack405.board1.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

  @RequestMapping("/thymeleaf")
  public String thymeleaf() {
    return "thymeleaf/index";
  }

  @RequestMapping("/thymeleaf/study01")
  public ModelAndView study01() {
    ModelAndView mv = new ModelAndView("thymeleaf/study01");

//    view 파일로 데이터 전달하기
//    addObject(이름, 데이터) : ModelAndView 클래스 타입의 객체에 데이터를 추가하는 메소드
//    request.setAttribute()와 동일한 기능
    mv.addObject("value01", "안녕하세요");
    mv.addObject("value02", 100);
    mv.addObject("value03", 200);
    mv.addObject("utext", "문자열과 <strong>html 태그</strong>가 혼합된 문자열");
    mv.addObject("idx", 5);

    return mv;
  }

  @RequestMapping("/thymeleaf/study02")
  public ModelAndView study02() {
//    view 파일 설정
    ModelAndView mv = new ModelAndView("thymeleaf/study02");

    MemberDTO member = new MemberDTO();
    member.setMemberIdx(1);
    member.setMemberName("아이유");
    member.setMemberId("iu");
    member.setMemberAge(31);
    member.setMemberEmail("iu@bitc.ac.kr");

//    데이터 추가
    mv.addObject("member", member);

//    문자열 데이터 추가
    mv.addObject("str1", "첫번째");
    mv.addObject("str2", "두번째");
//    null 값을 추가
    mv.addObject("str3", null);

    return mv;
  }

  @RequestMapping("/thymeleaf/study03")
  public ModelAndView study03() {
    ModelAndView mv = new ModelAndView("thymeleaf/study03");

//    정수 데이터 추가
    mv.addObject("num1", 100);
    mv.addObject("num2", 200);
    mv.addObject("num3", 11);

    mv.addObject("grade", "B");

//    배열 데이터 생성
    String[] strArray = {"첫번째", "두번째", "세번째", "네번째", "다섯번째"};
//    list 타입의 데이터 생성
    List<String> strList = new ArrayList<>();
    strList.add("첫번째");
    strList.add("두번째");
    strList.add("세번째");
    strList.add("네번째");
    strList.add("다섯번째");

//    Array 데이터와 List 데이터를 추가
    mv.addObject("itemArray", strArray);
    mv.addObject("itemList", strList);

    MemberDTO member1 = new MemberDTO();
    member1.setMemberIdx(1);
    member1.setMemberId("test1");
    member1.setMemberName("테스터1");
    member1.setMemberAge(20);
    member1.setMemberEmail("tester@bitc.ac.kr");

    MemberDTO member2 = new MemberDTO();
    member2.setMemberIdx(2);
    member2.setMemberId("test2");
    member2.setMemberName("테스터2");
    member2.setMemberAge(30);
    member2.setMemberEmail("tester@bitc.ac.kr");

    MemberDTO member3 = new MemberDTO();
    member3.setMemberIdx(3);
    member3.setMemberId("test3");
    member3.setMemberName("테스터3");
    member3.setMemberAge(40);
    member3.setMemberEmail("tester@bitc.ac.kr");

    List<MemberDTO> memberList = new ArrayList<>();
    memberList.add(member1);
    memberList.add(member2);
    memberList.add(member3);

//    MemberDTO 클래스 타입의 객체를 memberList 라는 이름으로 저장
    mv.addObject("memberList", memberList);

    return mv;
  }

  @RequestMapping("/thymeleaf/study04")
  public ModelAndView study04() {
    ModelAndView mv = new ModelAndView("thymeleaf/study04");

    mv.addObject("checkedVal", true);
    mv.addObject("multipleVal", true);
    mv.addObject("selectedVal", true);
    mv.addObject("disabledVal", false);
    mv.addObject("readonlyVal", false);

    return mv;
  }

  @RequestMapping("/thymeleaf/study05")
  public String study05() {
    return "thymeleaf/study05";
  }
}












