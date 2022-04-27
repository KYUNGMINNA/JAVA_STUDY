
--오토커밋 상태 확인 :default는 OFF
SHOW AUTOCOMMIT;

--오토커밋 온
SET AUTOCOMMIT ON; 

--오토커밋 오프
SET AUTOCOMMIT OFF;

SELECT* FROM emps;

INSERT INTO emps(employee_id,last_name,email,hire_date,job_id)
VALUES(300,'kim','abc@naver.com',sysdate,1800);

--보류중인 모든 데이터 변경사항을 취소(폐기), 직전 커밋 단계로 회귀 (돌아가기)및 트랜잭션 종료
ROLLBACK;

--세이브포인트 생성.
--롤백할 포인트(지점)를 직접 이름을 붙여서 지정.
--ANSI 표준 먼법이 아니기 때문에 그렇게 권장하지는 않음.
SAVEPOINT insert_kim;

INSERT INTO emps(employee_id,last_name,email,hire_date,job_id)
VALUES(301,'park','park@naver.com',sysdate,1800);

ROLLBACK TO SAVEPOINT insert_kim;


--보류중인 모든 데이터 변경사항을 영구적으로 적용하면서 트랜잭션을 종료
--커밋한 이후에는 어떤 방법을 사용하더라도 되돌릴 수 없습니다.
COMMIT;

-- DDL ,DCL: ROLLBACK,COMMIT의 대상이 아님 --기본적으로 AUTOCOMMIT이기 때문
-- DML : ROLLBACK,COMM의 적용 대상임





