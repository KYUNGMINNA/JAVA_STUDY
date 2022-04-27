
--insert
--테이블 구조 확인
--DESCRIBE
DESC departments;

--INSERT의 첫번째 방법(모든 컬럼 데이터를 한번에 지정)
INSERT INTO departments VALUES(280,'개발자',null,1700);

SELECT * FROM departments;
ROLLBACK;--실행 시점을 다시 뒤로 되돌리는 키워드.(앞의 실행을 취소)

--INSERT의 두번째 방법(직접 컬럼을 지정하고 저장)
INSERT INTO departments(department_id,department_name,location_id)
VALUES(280,'개발자',1700);

--INSERT 연습
INSERT INTO departments(department_id,department_name,location_id)
VALUES (290,'디자이너',1700);

INSERT INTO departments(department_id,department_name,location_id)
VALUES (300,'DB관리자',1800);

INSERT INTO departments(department_id,department_name,location_id)
VALUES (310,'데이터분석가',1800);

INSERT INTO departments
VALUES (320,'퍼블리셔',200,1800);

INSERT INTO departments
VALUES (330,'서버관리자',200,1800);

ROLLBACK;

SELECT* FROM employees;


--CTAS : 사본테이블 생성
CREATE TABLE managers AS 
(SELECT employee_id,first_name,job_id,hire_date FROM employees
WHERE 1=2); -- 1=2  : flase값 표현 , 1=1 : true 값 표현
--WHERE 절에 논리값 false면 TABLE 구조만 복사
--WHERE 절에 논리값 TRUE면 데이터,구조 모두 복사

DROP TABLE managers; --테이블 삭제

SELECT * FROM managers;

--INSERT (서브쿼리)
INSERT INTO managers
(SELECT employee_id,first_name,job_id,hire_date
FROM employees);


--UPDATE                                  ::WHERE 값 없으면, TRUE
CREATE TABLE emps AS( SELECT * FROM employees); 
SELECT * FROM emps;

--CTAS를 사용하면 제약 조건은 NOT NULL 말고는 복사되지 않습니다.
--제약 조건은 업무규칙을 지키는 데이터만 저장하고, 그렇지 않은 것들이
--DB에 저장되는 것을 방지하는 목적으로 사용합니다.

--UPDATE를 진행할 때는 누구를 수정할 지 잘 지목해야 합니다.
--그렇지 않으면 수정 대상이 테이블 전체로 지목됩니다.
UPDATE emps SET salary=30000; --테이블 전체
SELECT * FROM emps;
ROLLBACK;

UPDATE emps SET salary=30000 --특정 대상에만 적용
WHERE employee_id=100;


UPDATE emps SET salary=salary+salary*0.1
WHERE employee_id=100;

UPDATE emps SET phone_number='515.123.4566',manager_id=102
WHERE employee_id=100;

--UPDATE (서브쿼리)
UPDATE emps   
SET (job_id, salary , manager_id )=
(SELECT job_id,salary,manager_id FROM emps WHERE employee_id=100)
WHERE employee_id=101;
SELECT* FROM emps;

ROLLBACK;


--DELETE 
DELETE FROM emps WHERE employee_id=103;

SELECT * FROM emps WHERE employee_id=103;

--사본 테이블 생성
CREATE TABLE depts AS (SELECT * FROM departments);



--DELETE(서브쿼리)
DELETE FROM emps
WHERE department_id=(SELECT department_id FROM depts
WHERE department_id=100);

SELECT * FROM emps;


DELETE FROM emps WHERE department_id=
(SELECT department_id FROM depts WHERE department_name='IT');

SELECT* FROM depts;
