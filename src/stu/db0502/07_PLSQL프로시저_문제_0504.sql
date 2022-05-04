/*
프로시저명 guguProc
구구단 단수를 전달받아 해당 단수를 출력하는 procedure을 생성하세요. 
*/
CREATE PROCEDURE guguProc
(
    v_no IN NUMBER
)
IS   
BEGIN
    DBMS_OUTPUT.PUT_LINE('해당 단수는 :'||v_no);
    FOR i in 1..9
    LOOP
      DBMS_OUTPUT.PUT_LINE(v_no||'x'|| i||'=' || v_no*i);
    END LOOP;
END;

EXEC guguProc(5);



/*
부서번호, 부서명, 작업 flag(I: insert, U:update, D:delete)을 매개변수로 받아 
depts 테이블에 
각각 INSERT, UPDATE, DELETE 하는 depts_proc 란 이름의 프로시저를 만들어보자.
그리고 정상종료라면 commit, 예외라면 롤백 처리하도록 처리하세요.
*/

DROP TABLE depts;

CREATE TABLE depts AS SELECT department_id, department_name FROM departments;

ALTER TABLE depts ADD CONSTRAINTS depts_pk PRIMARY KEY(department_id);

select * FROM depts;

CREATE OR REPLACE PROCEDURE depts_proc
(
     v_department_id IN depts.department_id%TYPE,
     v_department_name IN depts.department_name%TYPE,
     v_flag IN VARCHAR2
)
IS
BEGIN
    IF v_flag = 'I'THEN
        INSERT INTO depts VALUES(v_department_id,v_department_name);
    
    ELSIF v_flag = 'U'THEN
        UPDATE depts SET department_name=v_department_name  WHERE department_id=v_department_id;
    
    ELSIF v_flag = 'D'THEN 
        DELETE FROM depts WHERE department_id=v_department_id;
    ELSE
        DBMS_OUTPUT.PUT_LINE('올바른 작업 플래그가 아닙니다.');
    END IF;
    COMMIT;
                --예외 종류
    EXCEPTION WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('예외가 발생했습니다.');
        DBMS_OUTPUT.PUT_LINE('예외 메시지:'||SQLERRM);
        ROLLBACK;
END;


EXEC depts_proc(320,'마케팅부','I');
EXEC depts_proc(500,'dddd','U');
EXEC depts_proc(320,'마케팅부','D');

SELECT * FROM depts;


/*
employee_id를 입력받아 employees에 존재하면,
근속년수를 out하는 프로시저를 작성하세요. (익명블록에서 프로시저를 실행)
없다면 exception처리하세요
*/

DROP PROCEDURE year_proc;


CREATE OR REPLACE  PROCEDURE year_proc
(
    v_employee_id IN employees.employee_id%TYPE,
    v_date OUT NUMBER
)
IS
    v_hire_date employees.hire_date%TYPE;
BEGIN
      
    SELECT ((sysdate-hire_date)/365)  --강사  v :  SELECT hire_date
    INTO v_hire_date
    FROM employees
    WHERE employee_id=v_employee_id;

    --강사 version
    --v_date :=TRUNC((sysdate-v_hire_date/365);
    

   v_date:=v_hire_date;
   dbms_output.put_line('입력한 회원의 번호는 '|| v_employee_id);
    
    EXCEPTION WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(v_employee_id||'(은)는 없는 데이터 입니다');
        
END;




DECLARE
    no NUMBER;
BEGIN
    year_proc(10,no);
    dbms_output.put_line('근속년수는 :'||TRUNC(no)||'년');
END;



/*
프로시저명 - new_emp_proc
employees 테이블의 복사 테이블 emps를 생성합니다.
employee_id, last_name, email, hire_date, job_id를 입력받아
존재하면 이름, 이메일, 입사일, 직업을 update, 
없다면 insert하는 merge문을 작성하세요
*/

DROP TABLE emps;

CREATE TABLE emps(
    employee_id NUMBER(20),
    last_name VARCHAR2(100),
    email VARCHAR2(100),
    hire_date DATE,
    job_id VARCHAR2(100)
);


SELECT * FROM emps;





DROP PROCEDURE new_emp_proc;

CREATE OR REPLACE PROCEDURE new_emp_proc (
    p_employee_id IN emps.employee_id%TYPE,
    p_last_name IN emps.last_name%TYPE,
    p_email IN emps.email%TYPE,
    p_hire_date IN emps.hire_date%TYPE,
    p_job_id IN emps.job_id%TYPE
)
IS

BEGIN
    MERGE INTO emps a
    USING(SELECT p_employee_id AS employee_id FROM dual) b
    ON(a.employee_id = b.employee_id)
    WHEN MATCHED THEN
        UPDATE SET
            a.last_name = p_last_name,
            a.email = p_email,
            a.hire_date = p_hire_date,
            a.job_id = p_job_id
    WHEN NOT MATCHED THEN
        INSERT (a.employee_id, a.last_name, a.email, a.hire_date, a.job_id)
        VALUES (p_employee_id, p_last_name, p_email, p_hire_date, p_job_id);
END;



EXEC new_emp_proc(100,'kim','kim123123',sysdate,'re_test');

SELECT * FROM emps;

