# Current Status

## 최종 목표
서비스 회사에서 경쟁할 수 있는 Java/Spring 백엔드 개발자로 복귀한다.

## 현재 프로젝트
backend-study

## 현재 단계
회원 생성·조회 Persistence 연결 완료, 동작 검증을 자동화하는 테스트 학습 전

## 완료
- Spring Boot 프로젝트 및 기본 패키지 구성
- Member, MemberCreateRequest, MemberController 생성
- POST /api/members 요청 처리
- Member.create()를 통한 Member 생성
- createdAt, modifiedAt 초기화
- Controller → CreateMemberCommand → MemberService → Member 생성 흐름 구성
- Service는 생성된 Member를 반환하고, Controller가 MemberCreateResponse를 구성
- Controller의 HTTP 요청 DTO와 Service의 유스케이스 입력 Command 분리
- Spring Data JPA와 PostgreSQL 연결
- Member를 JPA 엔티티로 매핑하고 Repository의 save/findById 흐름 구성
- 회원 생성 결과에서 DB가 생성한 ID를 응답에 사용
- 회원 단건 조회 API와 MemberNotFoundException, 전역 404 오류 응답 처리 추가
- ApiResponse 오류 응답에서 `Void` 타입을 사용해 데이터 없음 표현

## 학습 / 설계 결정
- Request DTO가 Domain에 의존하도록 하지 않는다.
- Member 생성 책임을 Member 내부에 둔다.
- 정적 팩토리 메서드로 생성 의도를 표현하고 생성 규칙을 한곳에서 관리한다.
- 객체 상태 변경을 외부에 무분별하게 노출하지 않는다.
- Controller는 HTTP 요청/응답 표현을 담당하고, Service는 유스케이스 흐름을 조율한다.
- MemberCreateRequest는 HTTP JSON 입력 형식이고, CreateMemberCommand는 회원 생성 작업의 입력이다.
- Command 분리는 필드 수를 줄이기 위한 것이 아니라 HTTP 계층과 애플리케이션 입력의 변경 이유를 분리하기 위한 것이다.
- Service가 HTTP 응답 DTO에 의존하지 않도록 Member를 반환하고 Controller에서 응답 DTO를 구성한다.
- Repository는 `Repository<Member, Long>`을 확장하고 필요한 `save`, `findById`만 노출한다.
- Service는 회원 생성·조회 흐름을 조율하고, 조회 결과가 없으면 도메인 기능 예외를 던진다.
- GlobalExceptionHandler가 MemberNotFoundException을 HTTP 404와 오류 응답 본문으로 변환한다.
- 로컬 학습 환경의 `ddl-auto: create-drop`은 스키마와 실습 데이터가 애플리케이션 재시작 후 유지되지 않게 하려는 의도적 선택이다.

## 다음 작업
- 회원 생성/조회 및 존재하지 않는 ID의 404 응답을 검증하는 자동화 테스트 작성
- 테스트로 성공·실패 동작을 고정한 뒤 입력 검증과 중복 이메일 등 데이터 무결성 규칙 학습
- 인증 단계에서 비밀번호 평문 저장 문제와 안전한 해싱을 원리부터 학습

## 재개 지점
PostgreSQL에 회원 저장과 ID 조회가 되는 것을 사용자가 직접 확인했다. 존재하지 않는 회원 조회도 HTTP 404와 JSON 오류 응답으로 확인했다. 자동 테스트는 작성하거나 실행하지 않았다. 다음 시작 시에는 Controller → Command → Service → Repository → DB 흐름과 예외가 404로 변환되는 경로를 기억에서 먼저 복습한 뒤, 이 동작을 자동화 테스트로 검증한다. 비밀번호는 현재 평문 저장이므로 실제 계정 정보를 사용하지 말고, 해싱은 인증·보안 학습 단계에서 다룬다.
