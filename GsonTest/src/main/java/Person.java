public class Person {
  private int pNum;
  private String pName;

  public Person(int pNum, String pName) {
    this.pNum = pNum;
    this.pName = pName;
  }

  public int getpNum() {
    return pNum;
  }

  public String getpName() {
    return pName;
  }

  @Override
  public String toString() {
    return "Person [pNum = " + pNum + ", pName = " + pName + "]";
  }
}












