package bitc.fullstack405.xml_json_parser.dto.pharmacy;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "header")
public class FullDataHeaderDTO {
  private String resultCode;
  private String resultMsg;

  @XmlElement
  public String getResultCode() {
    return resultCode;
  }

  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }

  public String getResultMsg() {
    return resultMsg;
  }

  public void setResultMsg(String resultMsg) {
    this.resultMsg = resultMsg;
  }
}












