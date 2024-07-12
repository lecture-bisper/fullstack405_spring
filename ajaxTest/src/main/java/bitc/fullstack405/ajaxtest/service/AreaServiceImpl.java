package bitc.fullstack405.ajaxtest.service;

import bitc.fullstack405.ajaxtest.dto.AreaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

  @Override
  public List<AreaDTO> getAreaList(String areaName) throws Exception {
    List<AreaDTO> areaList = new ArrayList<>();

    if (areaName.equals("서울")) {
      AreaDTO se1 = new AreaDTO();
      AreaDTO se2 = new AreaDTO();
      AreaDTO se3 = new AreaDTO();
      AreaDTO se4 = new AreaDTO();

      se1.setAreaName("강북구");
      se2.setAreaName("강남구");
      se3.setAreaName("강서구");
      se4.setAreaName("강동구");

      areaList.add(se1);
      areaList.add(se2);
      areaList.add(se3);
      areaList.add(se4);
    }
    else if (areaName.equals("대전")) {
      AreaDTO dj1 = new AreaDTO();
      AreaDTO dj2 = new AreaDTO();
      AreaDTO dj3 = new AreaDTO();
      AreaDTO dj4 = new AreaDTO();

      dj1.setAreaName("동구");
      dj2.setAreaName("중구");
      dj3.setAreaName("서구");
      dj4.setAreaName("유성구");

      areaList.add(dj1);
      areaList.add(dj2);
      areaList.add(dj3);
      areaList.add(dj4);
    }
    else if (areaName.equals("대구")) {
      AreaDTO dg1 = new AreaDTO();
      AreaDTO dg2 = new AreaDTO();
      AreaDTO dg3 = new AreaDTO();
      AreaDTO dg4 = new AreaDTO();

      dg1.setAreaName("북구");
      dg2.setAreaName("남구");
      dg3.setAreaName("서구");
      dg4.setAreaName("동구");

      areaList.add(dg1);
      areaList.add(dg2);
      areaList.add(dg3);
      areaList.add(dg4);
    }
    else if (areaName.equals("부산")) {
      AreaDTO bs1 = new AreaDTO();
      AreaDTO bs2 = new AreaDTO();
      AreaDTO bs3 = new AreaDTO();
      AreaDTO bs4 = new AreaDTO();

      bs1.setAreaName("부산진구");
      bs2.setAreaName("동래구");
      bs3.setAreaName("해운대구");
      bs4.setAreaName("수영구");

      areaList.add(bs1);
      areaList.add(bs2);
      areaList.add(bs3);
      areaList.add(bs4);
    }

    return areaList;
  }

  @Override
  public List<AreaDTO> getDistrictList(String areaName) {
    List<AreaDTO> areaList = new ArrayList<>();

    if (areaName.equals("서울")) {
      AreaDTO se1 = new AreaDTO();
      AreaDTO se2 = new AreaDTO();
      AreaDTO se3 = new AreaDTO();
      AreaDTO se4 = new AreaDTO();

      se1.setAreaName("강북구");
      se2.setAreaName("강남구");
      se3.setAreaName("강서구");
      se4.setAreaName("강동구");

      areaList.add(se1);
      areaList.add(se2);
      areaList.add(se3);
      areaList.add(se4);
    }
    else if (areaName.equals("대전")) {
      AreaDTO dj1 = new AreaDTO();
      AreaDTO dj2 = new AreaDTO();
      AreaDTO dj3 = new AreaDTO();
      AreaDTO dj4 = new AreaDTO();

      dj1.setAreaName("동구");
      dj2.setAreaName("중구");
      dj3.setAreaName("서구");
      dj4.setAreaName("유성구");

      areaList.add(dj1);
      areaList.add(dj2);
      areaList.add(dj3);
      areaList.add(dj4);
    }
    else if (areaName.equals("대구")) {
      AreaDTO dg1 = new AreaDTO();
      AreaDTO dg2 = new AreaDTO();
      AreaDTO dg3 = new AreaDTO();
      AreaDTO dg4 = new AreaDTO();

      dg1.setAreaName("북구");
      dg2.setAreaName("남구");
      dg3.setAreaName("서구");
      dg4.setAreaName("동구");

      areaList.add(dg1);
      areaList.add(dg2);
      areaList.add(dg3);
      areaList.add(dg4);
    }
    else if (areaName.equals("부산")) {
      AreaDTO bs1 = new AreaDTO();
      AreaDTO bs2 = new AreaDTO();
      AreaDTO bs3 = new AreaDTO();
      AreaDTO bs4 = new AreaDTO();

      bs1.setAreaName("부산진구");
      bs2.setAreaName("동래구");
      bs3.setAreaName("해운대구");
      bs4.setAreaName("수영구");

      areaList.add(bs1);
      areaList.add(bs2);
      areaList.add(bs3);
      areaList.add(bs4);
    }

    return areaList;
  }

  @Override
  public List<AreaDTO> getTownList(String areaName) {
    List<AreaDTO> areaList = new ArrayList<>();

    switch (areaName) {
      case "강남구":
        AreaDTO kn1 = new AreaDTO();
        AreaDTO kn2 = new AreaDTO();
        AreaDTO kn3 = new AreaDTO();
        AreaDTO kn4 = new AreaDTO();
        kn1.setAreaName("강남 1동");
        kn2.setAreaName("강남 2동");
        kn3.setAreaName("강남 3동");
        kn4.setAreaName("강남 4동");

        areaList.add(kn1);
        areaList.add(kn2);
        areaList.add(kn3);
        areaList.add(kn4);
        break;

      case "유성구":
        AreaDTO ys1 = new AreaDTO();
        AreaDTO ys2 = new AreaDTO();
        AreaDTO ys3 = new AreaDTO();
        AreaDTO ys4 = new AreaDTO();

        ys1.setAreaName("유성1동");
        ys2.setAreaName("유성2동");
        ys3.setAreaName("유성3동");
        ys4.setAreaName("유성4동");

        areaList.add(ys1);
        areaList.add(ys2);
        areaList.add(ys3);
        areaList.add(ys4);
        break;

      case "남구":
        AreaDTO ng1 = new AreaDTO();
        AreaDTO ng2 = new AreaDTO();
        AreaDTO ng3 = new AreaDTO();
        AreaDTO ng4 = new AreaDTO();

        ng1.setAreaName("남1동");
        ng2.setAreaName("남2동");
        ng3.setAreaName("남3동");
        ng4.setAreaName("남4동");

        areaList.add(ng1);
        areaList.add(ng2);
        areaList.add(ng3);
        areaList.add(ng4);
        break;

      case "부산진구":
        AreaDTO bj1 = new AreaDTO();
        AreaDTO bj2 = new AreaDTO();
        AreaDTO bj3 = new AreaDTO();
        AreaDTO bj4 = new AreaDTO();

        bj1.setAreaName("전포1동");
        bj2.setAreaName("전포2동");
        bj3.setAreaName("부전1동");
        bj4.setAreaName("부전2동");

        areaList.add(bj1);
        areaList.add(bj2);
        areaList.add(bj3);
        areaList.add(bj4);
        break;
    }

    return areaList;
  }
}

// 문제 1) ajaxCalView 파일을 참고하여 계산기 프로그램을 작성하세요
// * 입력 데이터 3개 (숫자 2개, 연산자 1개)
// * 연산자는 +, -, *, / 4개중 하나를 입력받기
// * 입력된 숫자와 연산자를 선택하고 "계산" 버튼을 클릭 시 화면 아래에 연산 결과를 출력
// * 파일명 : quiz1.html
// * 컨트롤러 : url - /ajax/quiz1, method - get, post

// 문제 2) selectBox 파일을 수정하여 시, 구 정보를 선택 시 동 정보가 출력되도록 select 버튼을 1개 더 추가하고 주소 출력 버튼을 클릭 시 전체 주소가 화면에 출력되는 프로그램을 작성하세요
// * 세번째 select box id는 'sel3'
// * 주소 출력 버튼은 type='button', id='btn-addr'
// * 내용 처리를 위한 함수를 따로 생성하여 사용해도 상관없음
// * 파일명 : quiz2.html
// 컨트롤러 : url - /ajax/quiz2, method - get, post










