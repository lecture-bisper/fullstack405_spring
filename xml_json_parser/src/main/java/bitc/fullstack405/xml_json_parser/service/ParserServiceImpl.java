package bitc.fullstack405.xml_json_parser.service;

import bitc.fullstack405.xml_json_parser.dto.kobis.BoxOfficeResultDTO;
import bitc.fullstack405.xml_json_parser.dto.kobis.DailyBoxOfficeDTO;
import bitc.fullstack405.xml_json_parser.dto.kobis.KobisDailyBoxOfficeDTO;
import bitc.fullstack405.xml_json_parser.dto.pharmacy.*;
import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParserServiceImpl implements ParserService {

  @Override
  public List<FullDataItemDTO> getItemListFile(String fileName) throws Exception {
//    jaxb : 자바에서 xml 데이터 파싱을 도와주는 라이브러리
//    jaxb 가 자바 9버전부터 기본 라이브러리에서 제외됨

//    Marshal(마샬) : 자바 클래스를 xml 데이터로 변환
//    UnMarshal(언마샬) : xml 데이터를 자바 클래스 타입의 객체로 변환
    
//    JAXB 라이브러리 사용 선언
//    FullDataResponseDTO 클래스 타입으로 xml 데이터를 파싱하도록 설정
    JAXBContext jc = JAXBContext.newInstance(FullDataResponseDTO.class);
//    JAXB 라이브러리를 사용하여 XML 데이터를 자바 클래스 타입의 객체로 변환하는 언마샬 객체 생성
    Unmarshaller um = jc.createUnmarshaller();

//    기존에 제공된 xml 데이터를 기반으로 FullDataResponseDTO 클래스의 객체를 생성하므로 xml 데이터를 파싱하여 가져온 데이터를 FullDataResponseDTO 클래스 타입의 객체에 타입 변환하여 저장함
//    unmarshal() : 언마샬을 수행하는 메소드, 매개변수로 파일이나 URL을 받음
    FullDataResponseDTO fullData = (FullDataResponseDTO) um.unmarshal(new File(fileName));
    FullDataHeaderDTO header = fullData.getHeader();
    FullDataBodyDTO body = fullData.getBody();
    FullDataItemsDTO items = body.getItems();
    List<FullDataItemDTO> itemList = items.getItemList();

    return itemList;
  }

//  매개변수로 서비스 URL을 받아옴
  @Override
  public List<FullDataItemDTO> getItemListUrl(String serviceUrl) throws Exception {
//    결과가 저장될 LIST
    List<FullDataItemDTO> itemList = new ArrayList<>();
//    서비스 URL을 저장할 객체
    URL url = null;
//    HttpURLConnection : 자바에서 웹 브라우저 없이 Http 서비스에 접속하기 위한 클래스
    HttpURLConnection urlConn = null;

    try {
      url = new URL(serviceUrl);
//      지정한 웹 서비스에 접속
      urlConn = (HttpURLConnection) url.openConnection();
//      접속 방식 설정
      urlConn.setRequestMethod("GET");

//      xml 데이터를 파싱하기 위해서 JAXB 라이브러리를 사용함
      JAXBContext jc = JAXBContext.newInstance(FullDataResponseDTO.class);
//      xml 데이터를 자바 클래스 타입으로 변환하는 객체 생성
      Unmarshaller um = jc.createUnmarshaller();

//      xml 데이터를 자바 클래스 타입으로 변환하는 unmarshal() 메소드 호출 시 매개변수로 서비스 URL 정보를 전달함
      FullDataResponseDTO fullData = (FullDataResponseDTO) um.unmarshal(url);
//      FullDataBodyDTO body = fullData.getBody();
//      FullDataItemsDTO items = body.getItems();
//      itemList = items.getItemList();
      itemList = fullData.getBody().getItems().getItemList();
    }
    catch (JAXBException e) {
      e.printStackTrace();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
//      네트워크 연결은 외부 리소스를 사용하는 것이므로 사용 후 반드시 리소스를 해제해야 함
      if (urlConn != null) { urlConn.disconnect(); }
    }

    return itemList;
  }

  @Override
  public List<DailyBoxOfficeDTO> getDayilyBoxOfficeList(String serviceUrl) throws Exception {
//    최종 출력 결과를 저장할 변수
    List<DailyBoxOfficeDTO> dayilyBoxOfficeList = new ArrayList<>();
//    서비스 URL을 저장할 객체
    URL url = null;
//    자바로 http 서비스를 이용하기 위한 클래스
    HttpURLConnection urlConn = null;
    BufferedReader reader = null;

    try {
      url = new URL(serviceUrl);
      urlConn = (HttpURLConnection) url.openConnection();
      urlConn.setRequestMethod("GET");

//    JAXB 라이브러리는 클래스 내부에 네트워크 데이터 처리를 위한 부분이 이미 존재함
//    json 파싱 라이브러리에는 네트워크 데이터 처리 부분이 없기 때문에 InputStreamReader를 통하여 네트워크에서 데이터를 가져오는 부분과 가져온 데이터를 처리하는 부분이 필요함
      
//      지정한 서버에서 json 데이터를 가져옴, 가져온 데이터를 BufferedReader에 저장함
      reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

//      네트워크를 통해서 전달된 데이터가 너무 길기 때문에 하나의 문자열로 합할 클래스
      StringBuilder sb = new StringBuilder();
//      json 데이터가 저장될 변수
      String line;

//      BufferedReader에 저장된 데이터를 한 라인씩 가져옴, 변수 line에 저장
      while ((line = reader.readLine()) != null) {
//        StringBuilder가져온 데이터를 저장
        sb.append(line);
      }

//      json 파싱을 위해 사용하는 Gson 라이브러리 객체 생성
      Gson gson = new Gson();
//      fromJson() : json 문자열을 자바 클래스 타입으로 변환
      KobisDailyBoxOfficeDTO boxOffice = gson.fromJson(sb.toString(), KobisDailyBoxOfficeDTO.class);
      dayilyBoxOfficeList = boxOffice.getBoxOfficeResult().getDailyBoxOfficeList();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (reader != null) { reader.close(); }
      if (urlConn != null) { urlConn.disconnect(); }
    }

    return dayilyBoxOfficeList;
  }
}












