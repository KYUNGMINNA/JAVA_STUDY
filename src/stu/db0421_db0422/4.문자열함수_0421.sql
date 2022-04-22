-- lower(소문자),initcap(앞글자만 대문자),upper(대문자)
--lower: 모두 소문자로 변환 , upper : 모두 대문자로 변환
/*
sys :최고 관리자 -> system :하위 관리자 
dual 이라는 테이블은 sys가 소유하는 오라클의 표준 테이블로서,
오직 한 행에 한 컬럼만 담고 있는 dummy 테이블이다.
일시적인 산술 연산이나 날짜 연산 등을 주로 사용한다.
모든 사용자가 접근할 수 있다. 주로 테스트에서 사용함
*/
SELECT * FROM dual;

SELECT 'abcDEF',lower('abcDEF'),upper('abcDEF')
FROM dual; 

SELECT last_name,lower(last_name),INITCAP(last_name),upper(last_name)
FROM employees;

SELECT last_name FROM employees
WHERE lower(last_name)='austin';  --DB의 값을 바꾸지 않음

--length(길이) , instr(문자 찾기. 없으면 0 값 나옴, 인덱스값으로 처리)
SELECT 'abcdef' AS ex,LENGTH('abcdef'),INSTR('abcdef','a')
FROM dual;

SELECT first_name,LENGTH(first_name),INSTR(first_name,'a')
FROM employees;

--substr(문자열 자르기) : 내가 원하는 범위로 자름
--concat(문자 연결) 2개밖에((abc,def)) 사용 불가   || ** 문자열은 1부터 시작(배열 인덱스 1부터)
SELECT 'abcdef' AS ex ,SUBSTR('abcdef',1,4),CONCAT('abc','def')
FROM dual;

SELECT first_name,SUBSTR(first_name,1,3),CONCAT(first_name,last_name)
FROM employees;

--LPAD ,RPAD (좌,우측 지정문자열로 채우기)
-- 주민등록번호 뒷자리 가리거나 할 때 
SELECT LPAD('abc',10,'*') FROM dual;
--(기준,총문자열길이,채울문자)
--문자열 abc를 포함한 길이가 10이며 남은 공간은 *으로 채워짐
SELECT RPAD('abc',10,'*') FROM dual;

-------0422-------------------------------------------------------------------------------
--LTRIM(), RTRIM() ,TRIM()  공백 제거
SELECT LTRIM('javascript_java','java') FROM dual;  -- : script_java :왼쪽문자를 제거

SELECT RTRIM('javascript_java','java') FROM dual; -- : javascrtipt_ :오른쪽문자를 제거

SELECT TRIM('  JAVA   ') FROM dual;  --java  :공백 제거 


--REPLACE(기준문자열,기존문자열,새로운문자열) :기존 문자열을 새로운 문자열로 대체할 때 사용
SELECT REPLACE('My dream is a president','president','doctor') FROM dual;

SELECT REPLACE('My dream is a president',' ','') FROM dual; 
--기존문자열의 공백을 빈 문자열로 대체  :Mydreamisapresident

--내부 부터 해석 
SELECT REPLACE(REPLACE('My dream is a president','president','doctor'),' ','')
FROM dual; 

SELECT REPLACE(CONCAT('hello ','world!'),'!','?')
FROM dual;

--연습 문제 3번
SELECT 
    RPAD(SUBSTR(first_name,1,3),LENGTH(first_name),'*') AS name ,
    LPAD(salary,10,'*') AS salary
FROM employees
WHERE lower(job_id)='it_prog';

--연습문제 1번
SELECT 
    CONCAT(first_name,last_name) AS 이름,
    REPLACE(hire_date,'/','') AS 입사일자 
FROM employees
ORDER BY 이름 ASC;

--연습문제 2번
SELECT REPLACE(phone_number,SUBSTR(phone_number,1,3),'02')
FROM employees;

