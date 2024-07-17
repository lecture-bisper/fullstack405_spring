package bitc.fullstack405.xml_json_parser.dto.pharmacy;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class FullDataBodyDTO {
  private int numOfRows;
  private int pageNo;
  private int totalCount;
  private FullDataItemsDTO items;

  @XmlElement
  public int getNumOfRows() {
    return numOfRows;
  }

  public void setNumOfRows(int numOfRows) {
    this.numOfRows = numOfRows;
  }

  public int getPageNo() {
    return pageNo;
  }

  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  @XmlElement(name = "items")
  public FullDataItemsDTO getItems() {
    return items;
  }

  public void setItems(FullDataItemsDTO items) {
    this.items = items;
  }
}












