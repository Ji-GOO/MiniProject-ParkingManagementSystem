# 주차장 관리 시스템

## 프로젝트 주제
차량 번호를 통해 입차와 정기권, 출차와 정산을 할 수 있도록 관리  
출차 시  
정기권이 유효한 경우, 바로 출차 가능  
정기권이 없거나 유효하지 않은 경우, 정산 후 출차 가능  

## 개발 인원
1명 (백엔드 + 프론트엔드)

## 기술 스택
- Back-end : Java 11, Servlet, Tomcat 8.5, MySQL, JDBC, JSP
- Front-end : HTML, CSS, Bootstrap
- Tool : Intellij IDEA

## 프로젝트 기간
2020년 2월 26일 ~ 3월 6일 (2주)

## 기능
- 입차 기능 (차량 번호를 입력해 입차, 입차되어 있는 차량 조회 가능)
- 정기권 기능 (한 번이라도 입차된 차량을 기준으로 정기권 신청 가능, 정기권 연장도 가능)
- 출차 기능 (입차되어 있는 차량에 한해 출차 가능, 출차 시 정산 진행)
- 정산 기능 (출차 시 정기권 유무를 판별해 정산 후 출차시킴)

### 입차
  - 입차 등록
  - 입차 차량 조회
  - 정기권 등록
  - 정기권 조회
  - 정기권 연장
  
### 출차
  - 정산
  - 출차 차량 조회

## 설계
### UML 다이어그램
<img src="https://user-images.githubusercontent.com/63104048/82642548-0e055e80-9c49-11ea-9a54-8a08d4a60de1.png" width="50%">

### 데이터베이스
<img src="https://user-images.githubusercontent.com/63104048/82642385-c5e63c00-9c48-11ea-8b0a-9ab9782d530d.png" width="50%">

## 실행 화면
### 입차

<img src="https://user-images.githubusercontent.com/63104048/87003681-0bf65f80-c1f7-11ea-8dd8-2c3c92a7d4ce.png" width="65%">

### 정기권

<img src="https://user-images.githubusercontent.com/63104048/87003743-2a5c5b00-c1f7-11ea-9c52-86039d02c7dd.png" width="65%">

### 출차

<img src="https://user-images.githubusercontent.com/63104048/87003775-3c3dfe00-c1f7-11ea-9a7e-438a1cdb6b0f.png" width="65%">
