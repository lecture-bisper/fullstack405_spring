package bitc.fullstack405.ajaxtest.service;

import bitc.fullstack405.ajaxtest.dto.AreaDTO;

import java.util.List;

public interface AreaService {
  List<AreaDTO> getAreaList(String areaName) throws Exception;

  List<AreaDTO> getDistrictList(String areaName);

  List<AreaDTO> getTownList(String areaName);
}
