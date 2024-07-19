import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class GsonTest {
  public static void method01() {
    Gson gson = new Gson();

//    자바에서 JSON 객체를 생성
    JsonObject jsonObj = new JsonObject();
//    addProperty(key, value) : 생성된 JSON 객체에 데이터 추가, JSON이 자바스크립트의 object 타입과 비슷한 형태이므로 key와 value가 1:1로 연동되어 있음, 자바의 HashMap과 비슷함
//    생성된 json 객체에 데이터 추가하기
    jsonObj.addProperty("name", "아이유");
    jsonObj.addProperty("id", 1);

//    gson의 toJson()메소드를 사용하여 Json 객체를 json 문자열로 변환
//    toJson(json객체) : Json객체를 문자열로 변환하여 출력
    String jsonStr = gson.toJson(jsonObj);

    System.out.println(jsonStr);
  }

//    자바 object -> json 으로 변환
  public static void javaObj2json() {
//    일반 Java 클래스인 Person 클래스 타입의 객체 생성
    Person person = new Person(1, "아이유");

    Gson gson = new Gson();
//    json 문자열로 변환
    String jsonStr = gson.toJson(person);

    System.out.println(jsonStr);
  }

//  json 문자열 -> java Object로 변환
  public static void json2javaObj() {
//    json 문자열
    String jsonStr = "{\"pNum\": 1, \"pName\": \"아이유\"}";

    Gson gson = new Gson();

//    fromJson(json문자열, 변환할 클래스) : 첫번째 매개변수로 주어진 json 타입의 문자열을 두번째 매개변수로 주어진 java 클래스 타입의 객체로 변환
    Person p = gson.fromJson(jsonStr, Person.class);

    System.out.println(p);
    System.out.println(p.getpNum());
    System.out.println(p.getpName());
  }

//  HashMap -> json 문자열
  public static void map2json() {
//    HashMap 변수 생성
    Map<String, String> map = new HashMap<>();
//    HashMap 변수에 데이터 추가
    map.put("pNum", "1");
    map.put("pName", "아이유");

    Gson gson = new Gson();
//    toJson을 사용하여 HashMap 데이터를 json 문자열로 변환
    String jsonStr = gson.toJson(map);

    System.out.println(jsonStr);
  }

//  json 문자열 -> HashMap
  public static void json2map() {
//    json 문자열 생성
    String jsonStr = "{\"pNum\": 1, \"pName\": \"아이유\"}";

    Gson gson = new Gson();

    Map<String, Object> map = gson.fromJson(jsonStr, Map.class);

    System.out.println("pNum : " + map.get("pNum"));
    System.out.println("pName : " + map.get("pName"));
  }

  public static void main(String[] args) {
    // GSON : JSON 데이터를 파싱하고 생성하기 위해 구글에서 개발한 라이브러리
    // Java 객체를 JSON 문자열로 변환하고, JSON 문자열을 Java 객체로 변환할 때 사용

    // Gson 객체 생성
    //  1. new 사용(일반적인 객체 생성 방식)
    //  Gson gson = new Gson();

    //  2. Bulider 사용
    //  Gson gson = new GsonBuilder().create();

//    method01();
//    javaObj2json();
//    json2javaObj();
//    map2json();
    json2map();


  }
}























