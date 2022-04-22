

--숫자함수 
--ROUND(반올림)  (값,위치)
--원하는 반올림 위치를 매개값으로 지정. 음수를 주는 것도 가능 . 
--양수는 소수점 우측 , 음수는 소수점 좌측
--                                            5에서 반올림
SELECT ROUND(3.1415,2),ROUND(45.923,0),ROUND(45.923,-1) 
FROM dual;

--TRUNC(절사)
--정해진 소수점 자리수까지 잘라냅니다.
SELECT TRUNC(3.1415,3),TRUNC(45.923,0),TRUNC(45.923,-1) 
FROM dual;

--ABS(절대값)
SELECT ABS(-34) FROM dual;

--CEIL(올림),FLOOR(내림)
SELECT CEIL(3.14) ,FLOOR(3.14) FROM dual;

--mod(나머지)
SELECT 10/2 ,mod(10,2) FROM dual;


--날짜 함수 
SELECT sysdate FROM dual;  --(오늘)현재 날짜
SELECT systimestamp FROM dual; --(오늘)현재 날짜 +시간정보 + GMT   

--날짜도 연산이 가능합니다.
SELECT first_name,sysdate-hire_date
FROM employees;

SELECT first_name,hire_date,
(sysdate-hire_date)/7 AS week
FROM employees; --주

SELECT first_name,hire_date,
(sysdate-hire_date)/365 AS year
FROM employees; --년 

--날짜 반올림,절사 
SELECT ROUND(sysdate) FROM dual; -- : 22/04/22

SELECT ROUND(sysdate,'year') FROM dual; --년 기준으로 반올림  :22/1/1

SELECT ROUND(sysdate,'month') FROM dual; --월 기준으로 반올림 :22/05/01 

SELECT ROUND(sysdate,'day') FROM dual;-- 일 기준으로 반올림 (해당 주의 일요일 날짜(일월화수목금토)) 
--:22/04/24


SELECT TRUNC(sysdate) FROM dual; -- : 22/04/22

SELECT TRUNC(sysdate,'year') FROM dual; --년 기준으로 절사  :22/1/1

SELECT TRUNC(sysdate,'month') FROM dual; --월 기준으로 절사 :22/04/01 

SELECT TRUNC(sysdate,'day') FROM dual;-- 일 기준으로 절사 (해당 주의 일요일 날짜(일월화수목금토) :일요일이 기준)
-- :22/04/17





