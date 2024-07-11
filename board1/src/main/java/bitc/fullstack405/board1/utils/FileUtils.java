package bitc.fullstack405.board1.utils;

import bitc.fullstack405.board1.dto.BoardFileDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// @Component, @Bean  은 스프링 프레임워크에서 객체를 생성하여 사용하고 관리하는 라이브러리를 뜻하는 어노테이션
// @Bean : 스프링 프레임워크 혹은 각종 서드파티 회사에서 제공하는 라이브러리의 클래스를 사용 시 사용하는 어노테이션
// @Component : 사용자가 직접 작성한 클래스를 스프링 프레임워크에 관리를 맡기기 위해서 사용하는 어노테이션
@Component
public class FileUtils {

  public List<BoardFileDTO> parseFileInfo(int boardIdx, String createId, MultipartHttpServletRequest multipart) throws Exception {

//    업로드된 파일정보가 있는지 확인
    if (ObjectUtils.isEmpty(multipart)) {
//      업로드된 파일 정보가 없으면 null 반환, 첨부파일이 없는 게시물이라는 뜻
      return null;
    }

//    업로드된 파일 정보 리스트를 저장한 변수
    List<BoardFileDTO> fileList = new ArrayList<>();

//    사용자가 지정한 형식으로 날짜 데이터 출력 형식을 설정
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    현재 위치를 기준으로 현재 시간을 가져옴
    ZonedDateTime current = ZonedDateTime.now();

//    파일이 저장될 폴더 위치 설정, 기본 위치 + 현재 시간을 기준으로 지정된 형식의 전체 경로를 설정
    String path = "C:/fullstack405/images/" + current.format(format);

//    File 클래스를 통해서 파일 객체 생성, 위에서 생성한 파일이 저장될 폴더를 가지고 File 클래스 객체 생성
    File file = new File(path);

//    위에서 지정한 경로가 실제로 존재하는지 여부 확인
    if (file.exists() == false) {
//      위에서 지정한 경로가 없을 경우 해당 폴더를 생성
//      mkdirs() : 지정한 경로대로 모든 폴더를 다 생성
      file.mkdirs();
    }

//    업로드된 파일 정보에서 전체 파일 이름 목록을 가져옴
    Iterator<String> iterator = multipart.getFileNames();

    String newFileName; // 새 파일 이름을 저장할 변수
    String originalFileExt; // 파일 확장자를 저장할 변수
    String contentType; // 파일 타입을 저장할 변수

//    가져올 데이터가 있는지 확인
    while (iterator.hasNext()) {
//      파일 이름 하나 가져옴
      String name = iterator.next();
//      파일 이름을 가지고 있는 파일의 전체 파일 정보를 가져옴
      List<MultipartFile> multipartFileList = multipart.getFiles(name);

      for (MultipartFile uploadFile : multipartFileList) {
//        파일 타입 정보를 가져옴
        contentType = uploadFile.getContentType();

//        가져온 파일 타입 정보가 존재하는지 확인
        if (ObjectUtils.isEmpty(contentType)) {
          break;
        }
        else {
//          jpg 파일
          if (contentType.contains("image/jpeg")) {
            originalFileExt = ".jpg";
          }
//          png 파일
          else if (contentType.contains("image/png")) {
            originalFileExt = ".png";
          }
//          gif
          else if (contentType.contains("image/gif")) {
            originalFileExt = ".gif";
          }
          else {
            break;
          }
        }

//        현재 시간을 기준으로 파일의 새이름을 생성함
        newFileName = System.nanoTime() + originalFileExt;

//        BoardFileDTO 클래스 타입의 객체 생성
        BoardFileDTO boardFile = new BoardFileDTO();
//        가져온 파일 정보를 BoardFileDTO 클래스 타입의 객체에 저장
        boardFile.setBoardIdx(boardIdx);
        boardFile.setFileSize(uploadFile.getSize());
        boardFile.setOriginalFileName(uploadFile.getOriginalFilename());
        boardFile.setStoredFileName(path + "/" + newFileName);
        boardFile.setCreateUser(createId);

//        첨부파일 리스트에 데이터 추가
        fileList.add(boardFile);

//        파일 저장 기본 경로와 새 파일명을 합하여 File 클래스 타입의 객체를 생성
        file = new File(path + "/" + newFileName);
//        서버의 디스크에 파일을 저장함
        uploadFile.transferTo(file);
      }
    }

//    생성된 첨부파일 리스트를 반환
    return fileList;
  }
}












