--문제 1 
SELECT * FROM employees e INNER JOIN departments d ON e.department_id=d.department_id;
SELECT * FROM employees e LEFT OUTER JOIN departments d ON e.department_id=d.department_id;
SELECT * FROM employees e RIGHT OUTER  JOIN departments d ON e.department_id=d.department_id;
SELECT * FROM employees e FULL OUTER JOIN departments d ON e.department_id=d.department_id;
--INNER 106 / LEFT 107 /RIGHT 122 / FULL 123


--문제 2
SELECT
    e.first_name ||e.last_name,d.department_id
FROM employees e
INNER JOIN departments d
ON e.department_id=d.department_id
WHERE e.employee_id=200;

--문제3
SELECT
    e.first_name,e.job_id,j.job_title
FROM employees e 
INNER JOIN jobs j 
ON e.job_id=j.job_id
ORDER BY e.first_name ASC;



--문제4 
SELECT *
FROM jobs LEFT JOIN job_history 
ON jobs.job_id=job_history.job_id;

--문제5
SELECT
    d.department_name
FROM employees e INNER JOIN departments d 
ON e.department_id=d.department_id
WHERE concat(e.first_name,e.last_name)='StevenKing';

--강사 문제 5번
SELECT 
    e.first_name || '' || e.last_name,
    d.deparment_name
FROM employees e
LEFT JOIN departments d
ON e.department_id=d.department_id
WHERE e.first_name='Steven'
AND e.last_name='King';
--처음 데이터 접근할때에는 OUTTER JOIN으로 접근하는게 좋다.(NULL 값 들어가 있을 수 있어서)


--문제 6
SELECT *
FROM employees CROSS JOIN departments;


select * from departments;
select * from employees;
select * from jobs;
select * from job_history; 
select * from locations;

--문제 7
SELECT
    e.employee_id,e.first_name || ' '|| last_name,
    d.department_name,
    loc.country_id
FROM employees e 
INNER JOIN departments d 
ON e.department_id=d.department_id
INNER JOIN locations loc
ON d.location_id=loc.location_id
WHERE e.job_id='SA_MAN';

--문제 8
SELECT *
FROM employees e INNER JOIN jobs j ON e.job_id=j.job_id
WHERE j.job_title='Stock Manager' OR j.job_title='Stock Clerk'; 

--문제 9
SELECT *
FROM departments d LEFT OUTER JOIN employees e
ON d.department_id=e.department_id
WHERE d.manager_id iS NULL;

--문제 10
SELECT 
    e1.first_name AS 사원의이름,
    e2.first_name AS 사원의매니저이름
FROM 
    employees e1 
JOIN 
    employees e2 
ON e1.manager_id=e2.employee_id;


--문제 11
select * from employees;
-- employee_id ,first_name,last_name,email,phone,hire,
--job_id,salary,commision_pct,mager_id,department_id

SELECT 
    e1.first_name AS 사원의이름,
    e2.first_name AS 사원의매니저이름,e2.salary
FROM 
    employees e1 
LEFT JOIN 
    employees e2 
ON e1.manager_id=e2.employee_id
WHERE e2.manager_id is NOT NUll
ORDER BY e2.salary DESC;
