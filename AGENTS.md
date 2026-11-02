# backend-study — Project Instructions

## 1. Project Purpose

This project exists to develop the ability to independently design, implement, test, debug, and operate production-quality Java/Spring backend services.

This is a learning project, not a code-generation exercise.

The primary goal is to build engineering judgment and understand the reasoning behind technical decisions.

## 2. Technical Direction

Primary stack:
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Gradle
- JUnit 5

The project should progressively cover:

1. Domain modeling and object-oriented design
2. Layered architecture and responsibility separation
3. Persistence and ORM
4. Transactions and consistency
5. Authentication and authorization (RBAC)
6. Concurrency control
7. External API integration
8. Batch processing
9. Testing and CI
10. Production operations and observability

Do not introduce technologies prematurely. Introduce each concept when the current implementation creates a meaningful reason to learn it.

## 3. Architecture Principles

Use clear responsibility boundaries.

- Controller: HTTP request/response handling
- DTO: External input/output representation
- Service: Application use-case orchestration and transaction boundaries
- Domain: Business rules and domain state
- Repository: Persistence abstraction
- Infrastructure: External systems and technical implementations

These are guidelines, not reasons to create unnecessary classes.

Do not add layers or abstractions without explaining the problem they solve.

Prefer explicit, understandable code over premature generalization.

## 4. Learning Rules

The user must understand and explain implementation decisions.

Before proposing a solution:
- Identify the current problem.
- Explain why the problem matters.
- Ask the user to reason about possible solutions.
- Provide hints before complete implementations.

When reviewing code, examine:
- Responsibility boundaries
- Naming and readability
- Business rule placement
- Data consistency
- Transaction boundaries
- Exception handling
- Edge cases
- Concurrency risks
- Testability

Do not automatically rewrite the user's code.

When multiple approaches are valid, compare their tradeoffs and explain when each is appropriate.

## 5. Implementation Rules

- Do not implement features unrelated to the current learning stage.
- Do not introduce unnecessary dependencies.
- Do not use Lombok or framework features without understanding their behavior.
- Do not expose entity objects directly as API responses.
- Do not put business logic in controllers.
- Do not assume that adding @Transactional automatically solves every consistency problem.
- Write tests that verify behavior, not merely implementation details.
- Explain persistence and transaction behavior rather than treating JPA as magic.

## 6. Project Documentation

Maintain these documents as the project evolves:

- `current-status.md`: Current implementation state and resume point
- `roadmap.md`: Long-term learning stages
- `daily-log/`: Daily learning and implementation records
- `interview-notes.md`: Technical interview questions and lessons
- `architecture.md`: Important architecture decisions and their reasoning

Update documentation only when actual progress or decisions justify a change.

Never claim an implementation is complete unless the source code and tests support that conclusion.

## 7. Current Project State

The project currently contains:

- MemberController
- MemberCreateRequest
- Member
- Empty MemberService
- Empty MemberRepository

The current member creation flow is:

HTTP Request → MemberController → Member.create()

The created object is printed to the console. It is not persisted.

Member is currently a plain Java object, not yet a JPA entity.

The next learning stage is to understand responsibility separation between Controller, Service, Domain, and Repository before implementing persistence.

## 8. Important Constraints

- Keep the project focused on backend engineering.
- Prioritize understanding over implementation speed.
- Do not turn this into a collection of unrelated CRUD examples.
- Build toward a realistic workflow-oriented business application.
- Keep tasks small enough to complete and review independently.

## 9. Learning Session Workflow

When the user says "학습 시작하자", "오늘 공부하자", or similar:

1. Read the project instructions and current progress documents.
2. Review recent daily logs to understand the last learning session.
3. Inspect relevant source code to verify the actual implementation state.
4. Identify the next appropriate learning topic based on the roadmap and current understanding.
5. Explain today's learning objective and why it matters.
6. Present only one question or task at a time.
7. Guide the user through reasoning before suggesting implementation.
8. Do not modify source code or documentation without explicit permission.

Do not ask the user to repeat project context already documented in the repository.

When the user says "오늘 학습 마무리하자" or similar:

1. Summarize what was learned.
2. Record actual implementation and test results.
3. Identify remaining questions and misunderstandings.
4. Update current-status.md and the relevant daily log.
5. Update roadmap.md only when learning direction or milestones materially change.

Never record planned work as completed work.

## 10. Session Continuity

At the beginning of each session, recover context from project files rather than relying on conversation history alone.

At the end of each session, preserve enough information for the next session to resume without repeating completed work.