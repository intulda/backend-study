## (주)흰곰 면접

### Q1. MSSQL에서 PostgreSQL로 어떻게 마이그레이션할 것인가?
내 답변:
- ERD 확인
- 연관관계 확인
- 프로시저/함수 분석

부족했던 것:
- 대용량 이관 전략
- 정합성 검증
- CDC
- Cutover / Rollback

### Q2. PostgreSQL에서는 어떻게 설계할 것인가?
내 답변:
- 일반 RDBMS와 비슷하게 설계

부족했던 것:
- PostgreSQL 특성
- MVCC
- EXPLAIN ANALYZE
- VACUUM
- JSONB