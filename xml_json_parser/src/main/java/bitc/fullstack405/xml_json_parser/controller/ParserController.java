package bitc.fullstack405.xml_json_parser.controller;

import bitc.fullstack405.xml_json_parser.dto.kobis.DailyBoxOfficeDTO;
import bitc.fullstack405.xml_json_parser.dto.pharmacy.FullDataItemDTO;
import bitc.fullstack405.xml_json_parser.service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/parser")
public class ParserController {

  @Autowired
  private ParserService parserService;

//  application.properties 파일에 설정된 내용 가져오기
  @Value("${fullstack405.pharmacy.service.key}")
  private String pharmacyServiceMyKey;

  @Value("${fullstack405.pharmacy.service.fulldata.url}")
  private String pharmacyServiceFullDataUrl;

  @Value("${fullstack405.kobis.service.key}")
  private String kobisServiceMyKey;

  @Value("${fullstack405.kobis.service.dailyboxoffice.url}")
  private String kobisServiceDailyBoxOfficeUrl;

  @RequestMapping({"", "/"})
  public String index() {
    return "index";
  }

  @RequestMapping("/pharmacy/fullDataFile")
  public ModelAndView getFullDataFile() throws Exception {
    ModelAndView mv = new ModelAndView("pharmacy/fullDataList");

    List<FullDataItemDTO> dataList = parserService.getItemListFile("C:/fullstack405/pharmacy.xml");
    mv.addObject("dataList", dataList);

    return mv;
  }

  @ResponseBody
  @RequestMapping("/pharmacy/fullDataUrl")
  public Object getFullDataUrl(@RequestParam("pageNo") String pageNo, @RequestParam("numOfRows") String numOfRows) throws Exception {
//    1. URL 정보 가져오기
//    https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown?serviceKey=MQ8moCpDCqz42c3kxwz2LHfm%2BevXvXYOTYnrZjpLTYgYqArm4QD7hxWxCGM%2F24BBmgODLVMFUM6mAAH4XCFQcg%3D%3D&pageNo=1&numOfRows=10
//    전체 서비스 URL을 만들기 위해서 각 데이터를 변수에 입력
//    String serviceUrl = "https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown";
    String optKey = "?serviceKey=";
    String opt1 = "&pageNo=";
    String opt2 = "&numOfRows=";

//    서비스를 이용하기 위해 필요한 키 입력
//    String serviceKey = "MQ8moCpDCqz42c3kxwz2LHfm%2BevXvXYOTYnrZjpLTYgYqArm4QD7hxWxCGM%2F24BBmgODLVMFUM6mAAH4XCFQcg%3D%3D";
//    추가 옵션 값 입력
//    String pageNo = "1";
//    String numOfRows = "10";

//    2. 서비스에 URL 정보 전달
//    ParserService에서 제공하는 getItemListUrl 메소드를 사용하여 정보를 가져옴
//    매개변수로 서비스 URL 전체를 생성하여 전달함
//    List<FullDataItemDTO> itemList = parserService.getItemListUrl(serviceUrl + optKey + serviceKey + opt1 + pageNo + opt2 + numOfRows);
    List<FullDataItemDTO> itemList = parserService.getItemListUrl(pharmacyServiceFullDataUrl + optKey + pharmacyServiceMyKey + opt1 + pageNo + opt2 + numOfRows);
    
//    3. 파싱된 데이터를 클라이언트에 전달
    return itemList;
  }

//  view 페이지
  @RequestMapping("/kobis/dailyBoxOffice")
  public String dailyBoxOfficeView() throws Exception {
    return "kobis/dailyBoxOffice";
  }

//  ajax 통신 부분
  @ResponseBody
  @RequestMapping("/kobis/daliyBoxOfficeJson")
  public Object getDailyBoxOfficeJson(@RequestParam("targetDt") String targetDt) throws Exception {
//    1. 서비스 url 생성 (옵션 추가)
    String optKey = "?key=";
    String opt1 = "&targetDt=";
//    서비스 URL 완성
    String serviceUrl = kobisServiceDailyBoxOfficeUrl + optKey + kobisServiceMyKey + opt1 + targetDt;
//    2. 서비스를 사용하여 정보 가져오기
    List<DailyBoxOfficeDTO> dailyBoxOfficeList = parserService.getDayilyBoxOfficeList(serviceUrl);

//    3. ajax 통신으로 클라이언트에 데이터 전달
    return dailyBoxOfficeList;
  }
}












