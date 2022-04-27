
--NUMBER(2) ->정수를 2자리까지 저장할 수 있는 숫자형 타입.
--NUMBER(5,2) ->정수부,실수부를 합친 총 자리수 5자리, 소수점 2자리 표현
--NUMBER -->괄호를 생략할 시 (38,0)으로 자동 지정 됩니다 ==정수 38자리
--VARCHAR2(byte) ->괄호 안에 들어올 문자열의 최대 길이를 지정(4000byte까지)
--DATE -> BC4712년 1월1일~AD 9999년 12월 31일까지 지정가능 
--DATE 시,분,초 지원 가능 (보이지 않을 뿐)


CREATE TABLE dept2(
    dept_no NUMBER(2), --2자리수
    dept_name VARCHAR2(14),--14byte
    loca VARCHAR2(15),  --15byte
    dept_date DATE , --날짜 타입 : DATE 
    dept_bonus NUMBER(10) --10자리수
);

DESC dept2;
SELECT * FROM dept2;

--NUMBER 타입에 들어가는 자리수를 확인
INSERT INTO dept2 VALUES(10,'영업','서울',sysdate,2000000); --OK
INSERT INTO dept2 VALUES(10,'영업','서울',sysdate,20000000000); --XX

--컬럼 추가 
ALTER TABLE dept2
ADD (dept_count NUMBER(3));

--열 이름 변경
 ALTER TABLE dept2
 RENAME COLUMN dept_count TO emp_count;
 
 --열 속성 수정
 ALTER TABLE dept2
 MODIFY (emp_count NUMBER(4));
 
 DESC dept2;
 
 --열 삭제
 ALTER TABLE dept2
 DROP COLUMN emp_count;
 
 --테이블 이름 변경
 ALTER TABLE dept2
 RENAME TO dept3;
 
 DESC dept3;
 
 --테이블 삭제 (구조는 남겨두고 내부 데이터만 모두 삭제)
 TRUNCATE TABLE dept3;
 
 SELECT * FROM dept3;
 
 --테이블과 데이터를 삭제
 DROP TABLE dept3;
 
 
 
