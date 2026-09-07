# Current Status

## 최종 목표
서비스 회사에서 경쟁할 수 있는 Java/Spring 백엔드 개발자로 복귀한다.

## 현재 프로젝트
backend-study

## 현재 단계
Member 도메인 및 회원 생성 흐름 구현

## 완료
- Spring Boot 프로젝트 및 기본 패키지 구성
- Member, MemberCreateRequest, MemberController 생성
- POST /api/members 요청 처리
- Member.create()를 통한 Member 생성
- createdAt, modifiedAt 초기화

## 학습 / 설계 결정
- Request DTO가 Domain에 의존하도록 하지 않는다.
- Member 생성 책임을 Member 내부에 둔다.
- 정적 팩토리 메서드로 생성 의도를 표현하고 생성 규칙을 한곳에서 관리한다.
- 객체 상태 변경을 외부에 무분별하게 노출하지 않는다.

## 다음 작업
- Member 생성 API의 책임 구조 검토
- Service 계층 도입 여부 및 역할 학습
- 회원 저장을 위한 Persistence 계층 설계

## 재개 지점
Member 생성 흐름까지 구현 완료.
다음 작업 시작 전 현재 Controller → Member.create() 구조부터 다시 확인한다.