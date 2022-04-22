
--집합 연산자
--UNION(합집합  -중복 X)  , UNION ALL (합집합 -중복O) , INTERSECT(교집합),MINUS(차집합)
--위 아래 column 개수가 정확히 일치해야 집합연산자가 정상적으로 동작함.


SELECT employee_id,first_name
FROM employees
WHERE hire_date  LIKE '04%'
UNION   -- 두개의 SLECT문의 합집합 연산=UNION :중복 불가  을 수행
SELECT 
    employee_id,first_name
FROM employees
WHERE department_id=20;



SELECT employee_id,first_name
FROM employees
WHERE hire_date  LIKE '04%'
UNION ALL   -- 두개의 SLECT문의  UNION ALL연산:중복 허용 수행
SELECT 
    employee_id,first_name
FROM employees
WHERE department_id=20;

SELECT employee_id,first_name
FROM employees
WHERE hire_date  LIKE '04%'
INTERSECT   -- 두개의 SLECT문의  INTERSECT 연산:교집합 수행
SELECT 
    employee_id,first_name
FROM employees
WHERE department_id=20;


SELECT employee_id,first_name
FROM employees
WHERE hire_date  LIKE '04%'
MINUS   -- 두개의 SLECT문의  MINUS 연산:차집합 수행
SELECT 
    employee_id,first_name
FROM employees
WHERE department_id=20;
