package bitc.fullstack405.xml_json_parser.service;

import bitc.fullstack405.xml_json_parser.dto.kobis.DailyBoxOfficeDTO;
import bitc.fullstack405.xml_json_parser.dto.pharmacy.FullDataItemDTO;

import java.util.List;

public interface ParserService {

  List<FullDataItemDTO> getItemListFile(String fileName) throws Exception;

  List<FullDataItemDTO> getItemListUrl(String serviceUrl) throws Exception;

  List<DailyBoxOfficeDTO> getDayilyBoxOfficeList(String serviceUrl) throws Exception;
}
