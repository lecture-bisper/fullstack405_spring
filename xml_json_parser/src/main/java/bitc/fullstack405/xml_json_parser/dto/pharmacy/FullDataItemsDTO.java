package bitc.fullstack405.xml_json_parser.dto.pharmacy;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "items")
public class FullDataItemsDTO {
  private List<FullDataItemDTO> itemList;

  @XmlElement(name = "item")
  public List<FullDataItemDTO> getItemList() {
    return itemList;
  }

  public void setItemList(List<FullDataItemDTO> itemList) {
    this.itemList = itemList;
  }
}












