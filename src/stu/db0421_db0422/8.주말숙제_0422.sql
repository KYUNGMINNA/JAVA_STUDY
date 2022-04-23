--문제1
SELECT 
    job_id,
    AVG(salary)
FROM employees
GROUP BY job_id
ORDER BY AVG(salary) DESC;

--문제2
SELECT
    SUBSTR(hire_date,1,2),
    COUNT( SUBSTR(hire_date,1,2))
FROM employees
GROUP BY  SUBSTR(hire_date,1,2);

--문제3
SELECT
    department_id,
    AVG(salary)
FROM employees
WHERE salary>=1000 --AND department_id IS NOT NULL
GROUP BY department_id
HAVING AVG(salary)>=2000 ;

--문제4
SELECT 
    department_id,
    SUM(salary+(salary*commission_pct)),
    TRUNC(AVG(salary+(salary*commission_pct)),2),
    COUNT(salary+(salary*commission_pct))
FROM employees
WHERE commission_pct IS NOT NULL
GROUP BY department_id;

    
