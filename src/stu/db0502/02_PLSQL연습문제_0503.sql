DROP TABLE emps;
CREATE TABLE emps AS (SELECT * FROM employees WHERE 1=2);


--1번
DECLARE
BEGIN
       DBMS_OUTPUT.put_line('3*1=3');
       DBMS_OUTPUT.put_line('3*2=6');
       DBMS_OUTPUT.put_line('3*3=9');
       DBMS_OUTPUT.put_line('3*4=12');
       DBMS_OUTPUT.put_line('3*5=15');
       DBMS_OUTPUT.put_line('3*6=18');
       DBMS_OUTPUT.put_line('3*7=21');
       DBMS_OUTPUT.put_line('3*8=24');
       DBMS_OUTPUT.put_line('3*9=27');
       DBMS_OUTPUT.put_line('3x10='||3*10);
       
END;

---2번
DECLARE
    e_name employees.first_name%TYPE;
    e_email VARCHAR2(100);
BEGIN
    SELECT
    first_name,email
    INTO e_name,e_email
    FROM employees
    WHERE employee_id=201;
    
    DBMS_OUTPUT.put_line(e_name || ':' || e_email);
END;

----3번

DECLARE
    e_emplyid employees.employee_id%TYPE;
BEGIN
    SELECT MAX(employee_id)
    INTO e_emplyid
    FROM employees;
    
    INSERT INTO emps(employee_id,last_name,email,hire_date,job_id)
    VALUES(e_emplyid+1,'steven','stevenjobs',sysdate,'CEO');
 
    COMMIT;
END;

select * FROM emps;
 
