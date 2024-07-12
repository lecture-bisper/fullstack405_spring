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