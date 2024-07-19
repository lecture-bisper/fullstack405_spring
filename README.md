# 풀스택 405반
## Spring 수업 자료

---

1. 1일차 수업 (test1, test2, board1)
   1. spring boot 프로젝트 생성하기
   2. start.spring.io 사이트에서 spring boot 프로젝트 생성하기
   3. spring MVC 게시판 - 프로젝트 생성
   4. spring MVC 게시판 - 종속성 추가, 데이터베이스 설정 정보 추가, 데이터베이스 설정 클래스 추가, sql 쿼리 xml 파일 추가
   5. spring MVC 게시판 - controller 파일 추가
   6. spring MVC 게시판 - service 파일 및 구현 클래스 추가
   7. spring MVC 게시판 - mapper 파일 추가
   8. spring MVC 게시판 - 목록 페이지 view 파일 추가 및 구현
2. 2일차 수업 (board1)
   1. spring MVC 게시판 - 글쓰기 페이지 view 파일 추가 및 구현
   2. spring MVC 게시판 - 글 상세보기 페이지 view 파일 추가 및 구현
   3. spring MVC 게시판 - 글 수정 및 글 삭제 구현
   4. thymeleaf 문법 - 변수 사용, 선택 변수 사용, 리소스 번들 사용, 링크 주소 사용, 문자열 출력, 숫자 출력, boolean 출력
   5. thymeleaf 문법 - 산술 연산자 사용, 비교 연산자 사용, 삼항 연산자 사용
3. 3일차 수업 (board1)
   1. thymeleaf 문법 - if, unless, switch ~ case, foreach 사용
   2. thymeleaf 문법 - html 속성에 데이터 추가 수정
   3. thymeleaf 문법 - fragment, insert, replace, include 사용하기
   4. spring MVC 게시판 - view 페이지에서 첨부파일 기능 추가, 업로드된 파일 정보 확인
   5. spring MVC 게시판 - BoardFileDTO 파일 추가, 파일 정보 분석 및 디스크에 저장하는 FileUtils 클래스 추가
   6. spring MVC 게시판 - BoardMapper 수정, BoardController 수정, BoardService 수정, sql-board.xml 수정
4. 4일차 수업 (board1, ajaxTest)
   1. spring MVC 게시판 - 게시글 상세보기 페이지에 업로드된 파일 목록 보기 기능 및 다운로드 기능 추가
   2. spring MVC 게시판 - BoardDTO 에 파일 목록을 위한 List<BoardFileDTO> fileList 필드 추가, controller 에 다운로드를 위한 메소드 추가
   3. spring MVC 게시판 - service에 다운로드를 위한 selectBoardFileInfo() 메소드 추가 및 구현, 게시글 상세보기를 위한 selectBoardDetail() 메소드에 조회수 업데이트 기능 추가 및 첨부파일 목록 기능 추가
   4. spring MVC 게시판 - mapper에 첨부파일 목록을 위한 selectBoardFileList() 메소드 추가, 다운로드를 위한 selectBoardFileInfo() 메소드 추가, xml에 selectBoardFileList 와 selectBoardFileInfo 를 위한 SQL쿼리문 추가
   5. Ajax 사용 - ajax를 사용한 것과 사용하지 않은 비교
   6. Ajax 사용 - ajax를 사용하여 select box 정보 변경하기
   7. Ajax 사용 - ajax를 사용한 문제 2개
5. 5일차 수업 (board2)
   1. Login 처리 : Spring MVC 게시판 프로젝트 생성, DB설정
   2. Login 처리 : BoardController, BoardDTO, BoardService, BoardMapper, View 생성
   3. Login 처리 : LoginController, UserService, UserMapper, Login View 생성
   4. Login 처리 : Interceptor 사용, LoginCheck 추가, WebMVCConfiguration 추가
6. 6일차 수업 (board3)
   1. REST 방식 사용하기 : 프로젝트 생성 및 DB 설정, service, mapper, xml, View 파일 작성
   2. REST 방식 사용하기 : REST 방식을 사용하기 위한 프로그램 설정 추가, REST 방식을 사용하는 방식으로 Controller 작성
   3. REST API 방식 사용하기 : REST API를 위한 Controller 추가
   4. 페이징 : PageHelper 라이브러리 종속성 추가, 페이징을 위한 Controller, Service, Mapper, View 추가
7. 7일차 수업 (board3, xml_json_parser)
   1. 페이징 : 페이지 이동 버튼 생성
   2. xml 파싱 : 공공데이터 포털의 전국 약국 정보 서비스 데이터 파싱, DTO 클래스 생성
   3. xml 파싱 : JAXB 라이브러리 종속성 추가, controller, service 파일 생성
   4. xml 파싱 : js를 통한 ajax 통신 및 화면 그리기
   5. json 파싱 : 영화진흥원의 일일박스오피스 데이터 파싱, DTO 클래스 생성
   6. json 파싱 : Gson 라이브러리 종속성 추가, controller, service 파일 생성
   7. json 파싱 : js를 통한 ajax 통신 및 화면 그리기
8. 8일차 수업 (GsonTest, outsideDir, board4)
   1. Gson 사용법
   2. 외부 폴더를 스프링 프레임워크의 내부 폴더로 등록하기
   3. JPA를 사용한 게시판
9. 9일차 수업 (JPATest)
   1. JPA를 사용한 테이블 생성
   2. JPA를 사용한 테이블 관계 설정
   3. JPA를 사용한 쿼리 메소드 만들기
   4. JPA의 @Query를 사용하여 쿼리 만들기