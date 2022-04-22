
--그룹 함수 AVG ,MAX , MIN , SUM , COUNT  :기준(즉 대상)이 있어야 그룹 함수 사용

SELECT 
    AVG(salary),
    MAX(salary),
    MIN(salary),
    SUM(salary),
    COUNT(salary)
FROM employees;  -- 그룹화를 하지 않으면 , 테이블 전체를 대상 

--COUNT(컬럼 값): 이면 NULL값을 제외하고 개수 파악 
SELECT COUNT(*) FROM employees; --전체 컬럼의 수 :107 | 총 행의 데이터의 수 
SELECT COUNT(first_name) FROM employees; --first_name의 컬럼의 수 :107 | null이 아닌 행의 수 
SELECT COUNT(commission_pct) FROM employees; --commission_pct의 컬럼의 수 :35 | null이 아닌 행의 수  
SELECT COUNT(manager_id) FROM employees; --manager_id의 컬럼의 수 :106 |null이 아닌 행의 수 


--부서별로 그룹화 , 그룹함수의 사용
SELECT
    department_id,
    AVG(salary)
FROM employees
GROUP BY department_id; 
--그룹 함수만 단독적으로 사용에 문제가 없으나(department_id 없이 AVG만) , 
--그룹함수만 단독으로 사용하지 않을 시(그룹함수와 다른거와 함께 사용시) 그룹을 형성하지 않으면 오류발생
--주의할 점
--그룹 함수는 그룹화를 하지 않고 일반 컬럼과 동시에 그냥 출력할 수 없습니다.
SELECT
    department_id,
    AVG(salary)
FROM employees ;--에러 발생
-- 그룹화 하지 않고 일반 컬럼과 동시에 사용해서 에러 발생 

SELECT 
    job_id,
    department_id,
    AVG(salary)
FROM employees
GROUP BY department_id;--에러발생 
--GROUP BY절을 사용할 때 GROUP절에 묶이지 않으면 다른 컬럼을 조회할 수 없다 

--GROUP BY절 2개 이상 사용
SELECT 
    job_id,
    department_id,
    AVG(salary)
FROM employees
GROUP BY department_id,job_id
ORDER BY department_id; 


SELECT 
    department_id,
    SUM(salary)
FROM employees   
GROUP BY department_id
HAVING SUM(salary)>100000; 
--그룹화 한 이후에는 조건식 사용하려면 WHERE대신 HAVING을 사용해야 한다(SQL 실행순서때문에)

SELECT
    job_id,
    COUNT(*)
FROM employees
GROUP BY job_id
HAVING COUNT(*)>=20;

--부서 아이디가 50이상인 것들을 그룹화 시키고 ,그룹 월급 평균 중 5000이상만 조회
SELECT 
    department_id,
    AVG(salary)
FROM employees
WHERE department_id>=50
GROUP BY department_id
HAVING AVG(salary)>=5000
ORDER BY department_id ASC;
