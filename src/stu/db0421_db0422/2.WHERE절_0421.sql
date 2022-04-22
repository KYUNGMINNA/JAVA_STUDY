SELECT * FROM employees;

--WHERE절 비교 (데이터 값은 대/소문자를 구분합니다.)
SELECT first_name,last_name,job_id 
FROM employees 
WHERE job_id='IT_PROG';

SELECT * FROM employees
WHERE last_name='King';

SELECT * FROM employees
WHERE department_id=90;  --숫자 90 

SELECT * FROM employees
WHERE salary>=15000;

SELECT * FROM employees
WHERE hire_date='04/01/30';

--데이터 행 제한(BETWEEN , IN , LIKE)

-- BETWEEN 15000 AND 20000 : WHERE 보다 연산속도 느림
-- WHERE salary>15000 AND WHERE salary<20000 
--범위를 지정 하여 조회할 때 BETWWEN 키워드를 사용
SELECT * FROM employees
WHERE salary BETWEEN 15000 AND 20000;

SELECT * FROM employees
WHERE hire_date BETWEEN '03/01/01' AND '03/12/31';


--IN연산자의 사용(특정 값들과 비교할 때 사용)
--괄호안의 값이 포함되어 있는 경우 조회
SELECT * FROM employees
WHERE manager_id IN (100,101,102);

SELECT * FROM employees
WHERE job_id  IN ('IT_PROG','AD_VP');

--LIKE 연산자
-- %는 뭐든(anything :어느것이든) ,_는 데이터의 위치를 찾아낼 때
SELECT first_name,hire_date FROM employees
WHERE hire_date LIKE '03%';
--hire_date의 값이 03으로 시작하고 뒤에 어떤값이 붙어있던 상관없음

SELECT first_name,hire_date FROM employees
WHERE hire_date LIKE '%15';
--hire_date의 값이 15로 끝나고 , 앞에 어떤값이 붙어 있던 상관없음

SELECT first_name,hire_date FROM employees
WHERE hire_date LIKE '%05%';
--hire_date의 값에 05라는 단어만 있으면,
--위치 관계없이 모두 조회해라  || 게시판 Query 

SELECT first_name,hire_date FROM employees
WHERE hire_date LIKE '___05%';
-- _는 자리수를 나타냄 : _ _ _05 는 hire_date가 05월 인 것만 조회

--IS NULL (NULL값을 찾음)
--manager_id가 NULL인 값 조회
SELECT * FROM employees
WHERE manager_id IS NULL;

SELECT * FROM employees
WHERE commission_pct IS NULL;


SELECT * FROM employees
WHERE commission_pct IS NOT NULL;

--AND ,OR ,
--AND가 OR보다 연산순서가 빠름.

SELECT * FROM employees
WHERE job_id='IT_PROG'
OR job_id='FI_MGR'
AND salary>=6000;


SELECT * FROM employees
WHERE (job_id='IT_PROG'
OR job_id='FI_MGR')
AND salary>=6000;

--데이터의 정렬 (SELECT 구문의 가장 마지막에 배치됩니다.)
--항상 정렬이 마지막에 작성
--ASC :ascending 오름차순  , DESC : descending 내림차순


SELECT *FROM employees
ORDER BY hire_date ASC;

SELECT *FROM employees
ORDER BY hire_date DESC;

SELECT * FROM employees
WHERE job_id='IT_PROG'
ORDER BY first_name ASC;

SELECT * FROM employees
WHERE salary>=5000
ORDER BY employee_id DESC;

SELECT first_name,salary*12 AS pay 
FROM employees
ORDER BY pay ASC;


