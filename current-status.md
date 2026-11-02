# Current Status

## 최종 목표
서비스 회사에서 경쟁할 수 있는 Java/Spring 백엔드 개발자로 복귀한다.

## 현재 프로젝트
backend-study

## 현재 단계
회원 생성 흐름의 책임 분리 학습 완료, Persistence 계층 설계 전

## 완료
- Spring Boot 프로젝트 및 기본 패키지 구성
- Member, MemberCreateRequest, MemberController 생성
- POST /api/members 요청 처리
- Member.create()를 통한 Member 생성
- createdAt, modifiedAt 초기화
- Controller → CreateMemberCommand → MemberService → Member 생성 흐름 구성
- Service는 생성된 Member를 반환하고, Controller가 MemberCreateResponse를 구성
- Controller의 HTTP 요청 DTO와 Service의 유스케이스 입력 Command 분리

## 학습 / 설계 결정
- Request DTO가 Domain에 의존하도록 하지 않는다.
- Member 생성 책임을 Member 내부에 둔다.
- 정적 팩토리 메서드로 생성 의도를 표현하고 생성 규칙을 한곳에서 관리한다.
- 객체 상태 변경을 외부에 무분별하게 노출하지 않는다.
- Controller는 HTTP 요청/응답 표현을 담당하고, Service는 유스케이스 흐름을 조율한다.
- MemberCreateRequest는 HTTP JSON 입력 형식이고, CreateMemberCommand는 회원 생성 작업의 입력이다.
- Command 분리는 필드 수를 줄이기 위한 것이 아니라 HTTP 계층과 애플리케이션 입력의 변경 이유를 분리하기 위한 것이다.
- Service가 HTTP 응답 DTO에 의존하지 않도록 Member를 반환하고 Controller에서 응답 DTO를 구성한다.
- 현재 응답의 ID `1L`은 저장소/DB가 없는 상태의 임시 값이며 실제 식별자가 아니다.

## 다음 작업
- 현재 Controller, Command, Service, Member 사이의 입력/반환 흐름을 복습
- 회원 생성 결과를 어디서 저장하고 실제 ID를 어떻게 얻을지 Repository와 Persistence 계층 설계

## 재개 지점
회원 생성 흐름의 책임 분리까지 진행했다. 다음 시작 시에는 Controller가 요청 DTO를 Command로 변환하고, Service가 Member를 반환하며, Controller가 응답 DTO를 만드는 이유를 기억에서 먼저 설명한다. 그 다음 저장 책임을 Repository에 두는 이유와 저장 전후 흐름을 설계한다.
