
/*
# 서브 쿼리  :기본적으로는  where절 안에 작성한 것을  서브쿼리라 함 

- 서브쿼리의 사용방법은  ( ) 안에 명시함.
서브쿼리절의 리턴행이 1줄 이하여야 합니다.
-서브쿼리 절에는 비교할 대상이 하나 반드시 들어가야 합니다.
-해석할 때는 서브쿼리절부터 먼저 해석하면 됩니다.

--서브쿼리 내부에서는 ORDER BY 사용 불가--문장에 단 한번만 작용 
*/

--'Nancy'의 급여보다 급여가 많은 사람을 검색하는 문장
SELECT salary FROM employees WHERE first_name='Nancy';

SELECT * FROM employees WHERE salary>12008;

---단일 행 서브쿼리 --------------------------------------

-- 두 개의 쿼리를 하나의 쿼리로 작성
SELECT * FROM employees 
WHERE salary>(SELECT salary 
              FROM employees
              WHERE first_name='Nancy');

--employee_id가 103번인 사람과 job_id가 동일한 사람을 검색하는 문장.
SELECT * FROM employees 
WHERE job_id=(SELECT job_id
              FROM employees
              WHERE employee_id=103);

--다음 문장은 서브쿼리의 리턴 행이 여러개라서 단일행 연산자를 사용할 수 없습니다.
--이런 경우에는 다중행 연산자를 사용해야 합니다.
SELECT * FROM employees
WHERE job_id=(SELECT job_id
              FROM employees 
              WHERE job_id ='IT_PROG');-- 에러 발생
              
----다중행 서브쿼리 -------------------------------------------
--다중행 연산자
-- IN :목록의 어떤 값과 같은지 확인합니다.
SELECT * FROM employees
WHERE job_id IN(SELECT job_id
              FROM employees 
              WHERE job_id ='IT_PROG');
              
--first_name이 David인 사람 중 가장 작은 값보다 급여가 큰 사람을 조회.
SELECT salary FROM employees WHERE first_name='David';

--ANY : 값을 서브쿼리에 의해 리턴된 각각의 값과 비교합니다.
--하나라도 만족하면 됩니다. 
SELECT * FROM employees WHERE salary >ANY(SELECT salary 
                                      FROM employees 
                                      WHERE first_name='David');
--서브쿼리 실행시 4800,6000,9500 -> ANY 사용해서 3개중 하나라도 만족하면 전체 적용
-- > 4800   , >6000 , >9500 인데 결국엔 제일작은 >4800의 값이 다 적용됨


--ALL : 값을 서브쿼리에 의해 리턴된 값과 모두 비교해서 
-- 모두 만족해야 합니다.
SELECT * FROM employees WHERE salary >ALL(SELECT salary 
                                      FROM employees 
                                      WHERE first_name='David');
-- 모두 만족해야 하므로 >9500 이상인것만 적용됨 
--왜냐면 4800~9400사이는 9500이상을 만족시키지않기때문


--스칼라 서브쿼리 
--SELECT 구문에 서브쿼리가 오는것. LEFT OUTER JOIN과 거의 유사한 결과 도출
SELECT
    e.first_name,d.department_name
FROM employees e 
LEFT JOIN departments d
ON e.department_id=d.department_id
ORDER BY e.first_name ASC;
--위 , 아래 같은 결과 
SELECT 
    e.first_name,
    (
        SELECT department_name
        FROM departments d
        WHERE d.department_id=e.department_id
    ) AS department_name
FROM employees e
ORDER BY first_name ASC;

/*
-스칼라 서브쿼리가 조인보다 좋은 경우
: 함수처럼 한 레코드당 정확히 하나의 값만을 리턴할 때 

-조인이 스칼라 서브쿼리보다 좋은 경우 
:조회할 데이터가 대용량인 경우 혹은 해당 데이터가 
수정 ,삭제 등이 빈번한 경우.
*/

--각 부서의 매니저 이름
--LEFT OUTER JOIN 
SELECT
    d.*,e.first_name
FROM departments d
LEFT JOIN employees e
ON d.manager_id=e.employee_id
ORDER BY d.manager_id ASC;

--스칼라 
SELECT
    d.*,
    (
    SELECT e.first_name
    FROM employees e 
    WHERE e.employee_id=d.manager_id
    )AS manager_name
FROM departments d
ORDER BY d.manager_id ASC;

--각 부서별 사원수 뽑기 (deparments의 모든 컬럼 ,사원 수 별칭을 지어서 출력)
SELECT 
    COUNT(*)
FROM employees e
GROUP BY department_id;

SELECT
    d.*,
    (
    SELECT 
        COUNT(*)
        FROM employees e
        WHERE e.department_id=d.department_id
        GROUP BY department_id
    )AS 사원수
FROM departments d;  -- SELECT 절에 들어가는 서브쿼리 =스칼라 서브쿼리


--인라인 뷰 (FROM 구문에 서브쿼리가 오는것) : 뷰 =가상의 테이블 객체
--순번을 정해놓은 조회 자료를 범위를 지정해서 가지고 오는 경우 

-- salary로 정렬을 진행하면서 ROWNUM을 붙이면 
--ROWNUM이 정렬이 되지 않는 사태가 발생합니다 
--이유는 ROWNUM이 먼저 붙고 정렬이 진행되기 때문 ->ORDER BY는 항상 마지막에 진행됨
--해결: 정렬이 미리 진행된 자료에 ROWNUM을 붙여서 다시 조회하는 것이 좋을 것 같다.
----(**ROWNUM : 쿼리에 의해 반환되는 행 번호를 출력)
SELECT ROWNUM AS rn,employee_id,first_name,salary
FROM employees
ORDER BY salary DESC; -- 오류


--ROWNUM을 붙이고 나서 범위를 지정해서 조회하려고 하는데,
--범위 지정도 불가능 하고 ,지목할 수 없는 문제가 발생하더라.
--이유는 WHERE절이 먼저 실행하고 나서 ,ROWNUM이 SELECT 되기 때문에 문제 발생
--해결 : ROWNUM까지 붙여 놓고 다시  한 번 자료를 SELECT 해서 범위를 지정해야 됨
SELECT 
    ROWNUM AS rn,
    tbl.* 
    FROM(
        SELECT employee_id,first_name,salary
        FROM employees
        ORDER BY salary DESC
        )tbl; -- 여기에 WHERE rn 바로 적용 불가능 


--가장 안쪽 SELECT절에서 필요한 테이블 형식(인라인 뷰)을 생성.
--바깥쪽 SELECT 절에서 ROWNUM을 붙여서 다시 조회 
--가장 바깥쪽 SELECT절에서는 이미 붙어 있는 ROWNUM의 범위를 지정해서 조회
-- SQL의 실행 순서 .
-- FROM -> wHERE ->GROUP BY -> HAVING ->SELECT -> ORDER BY 
-- FROM -> ON ->JOIN -> WHERE ->GROUP BY ->HAVING ->SELECT ->DISTINCT>ORDER BY
SELECT * 
FROM (
        SELECT ROWNUM AS rn,tbl.* 
        FROM(
                SELECT employee_id,first_name,salary
                FROM employees
                ORDER BY salary DESC
            )tbl
     )    
WHERE rn<=20 AND rn>10;

SELECT * 
FROM(
    SELECT TO_CHAR(TO_DATE(test,'YY/MM/DD'),'MMDD') as mm,name FROM
        (
            SELECT '홍길동' AS name, '20211126' AS test FROM dual UNION ALL
            SELECT '김철수', '20210301' FROM dual UNION ALL
            SELECT '박영희', '20210401' FROM dual UNION ALL
            SELECT '김뽀삐', '20210501' FROM dual UNION ALL
            SELECT '박뚜띠', '20210601' FROM dual UNION ALL
            SELECT '김테스트', '20210701' FROM dual
         )
    )
WHERE mm='1126';


