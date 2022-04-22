-- 오라클의 주석입니다. 
/* 
여러줄 주석입니다.
호호호~
*/

--SELECT 컬럼명(여러개 가능) FROM 테이블 이름;

--모든 컬럼 조회
SELECT * FROM employees;

--특정 컬럼 조회 
SELECT employee_id,first_name,last_name from employees;

--특정 컬럼 조회 
SELECT email,phone_number,hire_date FROM employees;


--실존하지 않는 컬럼 만들어 연산후 조회
--컬럼을 조회하는 위치에서 * / + - 연산이 가능합니다.
SELECT 
    employee_id,
    first_name,
    last_name,
    salary,
    salary+salary*0.1
FROM 
    employees;

--NULL 값의 확인(숫자 0 이나 공백이랑은 다른 존재입니다.)   
SELECT department_id,commission_pct
FROM employees;

--alias(컬럼명,테이블명의 이름을 변경해서 조회합니다.):별명 
SELECT first_name as 이름,last_name as 성,
salary as 급여
FROM employees;

-- ' ''s:특수문자 표시'  
--컬럼값과 컬럼값의 연결 ||  : 연결자
--오라클은 홑따옴표 ' ' 로 문자를 표현하고 , 문자열 안에 홑따옴표를
--표현하고 싶으면 ''를 두번 연속으로 쓰면됩니다.
SELECT
first_name||' '||last_name||'''s salary is ${' ||salary||'}'
as 급여내역
FROM employees;



--DISTINCT (중복 행의 제거)
SELECT department_id FROM employees;
SELECT DISTINCT department_id FROM employees;


--ROWNUM,ROWID
--(**로우넘 : 쿼리에 의해 반환되는 행 번호를 출력)
--(로우아이디:데이터베이스에서 행의 주소값을 반환)
SELECT ROWNUM,ROWID,employee_id
FROM employees;

