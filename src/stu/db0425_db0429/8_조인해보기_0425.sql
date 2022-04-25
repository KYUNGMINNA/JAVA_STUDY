

/*
# 조인 : 서로 다른 테이블간에 설정된 관계가 결합하여 
1개 이상의 테이블에서 데이터를 조회하기 위해서 사용합니다.
-SELECT 컬럼리스트 FROM 조인대상이 되는 테이블 (1개 이상)
 WHERE 조인 조건(오라클 조인 문법)

*/

--employees 테이블의 부서 id와 일치하는 departments 테이블의 부서 id를 찾아서
--SELECT 이하에 있는 컬럼들을 출력하는 쿼리문.

--ORACLE의 JOIN 문법 사용법 
SELECT 
    e.first_name,e.last_name,e.hire_date,
    e.salary,e.job_id,e.department_id,d.department_name
FROM employees e,departments d
WHERE e.department_id=d.department_id;

--ANSI JOIN 문법 :: 표준 문법 --다른 DBMS에서도 정상적으로 동작
SELECT
    e.first_name,e.last_name,e.hire_date,
    e.salary,e.job_id,e.department_id,d.department_name
FROM employees e INNER JOIN departments d
ON e.department_id=d.department_id;

/*  테이블이름에 별칭을 붙일 때에는 AS를 안쓴다(employees e....)
각각의 테이블에 독립적으로 존재하는 컬럼의 경우에는 별칭을 생략을 해도 무방합니다(first_name,..)
그러나 , 해석의 명확성을 위해 테이블 이름을 작성하셔서 소속을 표현해 주는것이 바람직합니다.(e.first_name,..)
테이블 이름이 너무 길 시에는 ALIAS 를 작성하여  칭합니다.
*****두 테이블 모두 가지고 있는 컬럼의 경우  반드시 명시해 주셔야 합니다.*****(e.department_id)

*/

--3개의 테이블을 이용한 내부 조인(INNER JOIN)
--내부 조인 :두 테이블의 모두에서 일치하는 값을 가진 행만 반환합니다.
--EX) ON ( 10,20,30,...100  = 10,20,30,....200) -->일치하는 '10,20,30,...100' 만 반환 한다.
SELECT 
    e.first_name,e.last_name,e.department_id,
    d.department_name,
    j.job_title
FROM employees e ,departments d,jobs j
WHERE e.department_id=d.department_id 
AND e.job_id =j.job_id;

--ORACLE의 where은  조인 조건 먼저 쓰고 , 마지막에 일반 조건 작성
-
SELECT 
    e.first_name,e.last_name,e.department_id,
    d.department_name,e.job_id,j.job_title,loc.city
FROM
    employees e,
    departments d,
    jobs j,
    locations loc
WHERE e.department_id=d.department_id          -- ::조인 조건
AND e.job_id=j.job_id               --3,4         ::조인 조건
AND d.location_id=loc.location_id   --2           ::조인 조건
AND loc.state_province='California';  --해석순서 1  ::일반조건
/*
실행 순서 -- 마지막에 작성한 일반조건 먼저 해석 ->이후 조인 조건 해석  
1.loc 테이블의 province ='California' 조건에 맞는 값을 대상으로 
2.location_id 값과 같은 값을 가지는 데이터를
departments에서 찾아서 조인
3.위의 결과와 동일한 department_id를 가진
employees테이블의 데이터를 찾아 조인
4.위의 결과와 jobs테이블을 비교하여 조인하고 최종 결과를 출력.
*/


--외부 조인
/*
외부조인 : 상호 테이블간에 일치되는 값으로 연결되는 내부 조인과는 다르게 
어느 한 테이블에 공통 값이 없더라도 해당 row들이 조회 결과에
모두 포함되는 조인을 말합니다.
*/

--오라클 외부 조인 문법
SELECT 
    e.first_name,e.last_name,
    e.department_id,d.department_name
FROM employees e,departments d,locations loc
WHERE e.department_id=d.department_id(+) --외부 조인
AND d.location_id=loc.location_id;  -- 내부 조인 
-- 기준으로 잡은 테이블( (+)가 없는게 기준)에 대한 모든 데이터를 가져 옴 .
/*
WHERE e.department_id=d.department_id(+)
employees 테이블에는 존재하고 ,departments 테이블에는 존재하지 않아도
(+)가 붙지 않은 테이블을 기준으로 하여 departments 테이블이 조인에
참여하라는 의미를 부여하기 위해 기호를 붙입니다.  
::employees가 기반이되어 employees 테이블의 데이터 모두 조회된다

외부조인- 내부조인  동시에 작성 , 내부조인 -> 외부조인 순서로 해석 된다.
외부조인을 사용했더라도 ,이후에 내부 조인을 사용하면 내부조인을 우선적으로 인식합니다.
WHERE e.department_id=d.department_id(+) --외부 조인
AND d.location_id=loc.location_id;  -- 내부 조인 
*/

--외부 조인 진행 시 모든 조건에 (+)를 붙여야 하며
--일반 조건에도 (+)를 붙이지 않으면 데이터가 누락되는 현상이 발생.
--일반 조건에 (+)붙이는 경우에, 내가 원하는 데이터가 정상적으로 나오지 않을 수 있다.
SELECT 
    e.employee_id,e.first_name,
    e.department_id,
    j.start_date,j.end_date,j.job_id
FROM employees e,job_history j
WHERE e.employee_id=j.employee_id(+)  --외부 조인 조건
AND j.department_id(+)=80;  --일반 조건 
--외부조인에 값 없을 시 NULL 값 들어 감 
--외부조인을 사용할 때 ,일반 조건에도 (+) 기호를 붙여서 사용해야 한다.

