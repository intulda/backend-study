# Current Status

## 최종 목표
서비스 회사에서 경쟁할 수 있는 백엔드 개발자로 복귀한다.

## 현재 프로젝트
backend-study

## 완료한 작업
- Spring Boot 프로젝트 생성
- Spring Web, Lombok 의존성 추가
- 기본 패키지 구조 생성
- Member, MemberCreateRequest, MemberController 초안 작성

## 학습한 내용
- @RestController와 @RequestBody의 역할 차이
- record를 요청 DTO로 사용하는 이유
- Builder는 필요성과 가독성을 기준으로 선택
- Domain이 Request DTO에 의존하지 않도록 설계

## 현재 수정할 내용
- Member에서 MemberCreateRequest로 변환하는 from 메서드 제거
- createAt을 createdAt으로 변경
- @EqualsAndHashCode 제거 검토
- Member 생성 메서드 설계
- Controller에 @RequestBody 추가
- API 경로를 /api/members로 정리

## 다음 작업
Member 관련 코드 수정 후 코드 리뷰 요청

## 컨디션
B마트 적응 기간. 근무일에는 10~30분 분량으로 진행한다.