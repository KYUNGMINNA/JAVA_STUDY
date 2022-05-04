SET SERVEROUTPUT ON;

--프로시저(Procedure)  -->void 메서드랑 유사
-- 특정한 로직을 처리하고 결과값을 반환하지 않는 코드 덩어리(쿼리).
--PL/SQL에도 값을 전달받아서 코드를 실행 후 리턴하는 함수가 존재합니다.
--하지만 프로시저를 통해서도 값을 리턴하는 방법이 있습니다.


--매가값(인수) 없는 프로시저  ::프로시저에 이름 달아서 호출해야지만 출력된다.
CREATE PROCEDURE P_test
IS --선언부
    v_msg VARCHAR2(30) :='Hello Procedure!';
BEGIN  --실행부
    DBMS_OUTPUT.PUT_LINE(v_msg);
END;  --종료부

EXEC P_test;  --프로시저 호출문.

--IN 입력값을 받는 파라미터
CREATE PROCEDURE my_new_job_proc
(
    p_job_id IN jobs.job_id%TYPE,
    p_job_title IN jobs.job_title%TYPE,
    p_min_salary IN jobs.min_salary%TYPE,
    p_max_salary IN jobs.max_salary%TYPE
)
IS 

BEGIN
    INSERT INTO jobs 
    VALUES(p_job_id,p_job_title,p_min_salary,p_max_salary);
    COMMIT;   
END;

EXEC my_new_job_proc('JOB1','test job1',1000,5000);


SELECT * FROM jobs;


--CREATE OR REPLACE 
--이미 존재하면 ALTER ,없다면 CREATE : 뷰와 똑같음 
CREATE  OR REPLACE PROCEDURE my_new_job_proc
(
    p_job_id IN jobs.job_id%TYPE,
    p_job_title IN jobs.job_title%TYPE,
    p_min_salary IN jobs.min_salary%TYPE,
    p_max_salary IN jobs.max_salary%TYPE
)
IS 
    v_cnt NUMBER :=0;
BEGIN
    --동일한 job_id가 있는지 부터 먼저 체크
    --이미 존재한다면 1, 존재하지 않는다면 0  -->이를 v_cnt에 대입할 예정
    SELECT COUNT(*)
    INTO v_cnt 
    FROM jobs
    WHERE job_id =p_job_id;
    
    IF v_cnt=0 THEN --없다면 INSERT가 진행
        INSERT INTO jobs 
        VALUES(p_job_id,p_job_title,p_min_salary,p_max_salary);
    ELSE --있다면 UPDATE
        UPDATE jobs SET job_title=p_job_title,
                        min_salary=p_min_salary,
                        max_salary=p_max_salary
        WHERE job_id =p_job_id;
    END IF;
    
    COMMIT;
END;

EXEC my_new_job_proc('JOB2','test job2',2000,10000); --처음엔 INSERT 
EXEC my_new_job_proc('JOB2','test job2',5000,10000); --이후 UPDATE

EXEC my_new_job_proc('JOB2','test job2') -- 매개변수 다 안넣어서 오류!

SELECT * FROM jobs
WHERE job_id='JOB2';

----------------------------------------------
--매개변수(인수)의  디폴트 값(기본값) 설정   ':= '으로 값 설정 
CREATE  OR REPLACE PROCEDURE my_new_job_proc
(
    p_job_id IN jobs.job_id%TYPE,
    p_job_title IN jobs.job_title%TYPE,
    p_min_salary IN jobs.min_salary%TYPE :=0,
    p_max_salary IN jobs.max_salary%TYPE :=1000
)
IS 
    v_cnt NUMBER :=0;
BEGIN
    --동일한 job_id가 있는지 부터 먼저 체크
    --이미 존재한다면 1, 존재하지 않는다면 0  -->이를 v_cnt에 대입할 예정
    SELECT COUNT(*)
    INTO v_cnt 
    FROM jobs
    WHERE job_id =p_job_id;
    
    IF v_cnt=0 THEN --없다면 INSERT가 진행
        INSERT INTO jobs 
        VALUES(p_job_id,p_job_title,p_min_salary,p_max_salary);
    ELSE --있다면 UPDATE
        UPDATE jobs SET job_title=p_job_title,
                        min_salary=p_min_salary,
                        max_salary=p_max_salary
        WHERE job_id =p_job_id;
    END IF;
        
    COMMIT;
END;

EXEC my_new_job_proc('JOB2','test job2'); -- 디폴트 값 설정해놔서 오류 발생 안함!

SELECT * FROM jobs
WHERE job_id='JOB2';

--------------------------------------------------------------------------

--OUT , IN OUT 매개변수(인수) 사용

--OUT 변수를 사용하면 프로시저 바깥쪽으로 값을 보냅니다.
--OUT을 통해서 보낸 값은 바깥 익명블록에서 실행해야 합니다.

CREATE  OR REPLACE PROCEDURE my_new_job_proc
(
    p_job_id IN jobs.job_id%TYPE,
    p_job_title IN jobs.job_title%TYPE,
    p_min_salary IN jobs.min_salary%TYPE :=0,
    p_max_salary IN jobs.max_salary%TYPE :=1000,
    P_result OUT VARCHAR2 -- 바깥쪽에서 출력을 하기 위한 변수.
)
IS 
    v_cnt NUMBER :=0;
    v_result VARCHAR2(100) :='값이 존재하지 않아서 INSERT로  처리 되었습니다';
BEGIN
    --동일한 job_id가 있는지 부터 먼저 체크
    --이미 존재한다면 1, 존재하지 않는다면 0  -->이를 v_cnt에 대입할 예정
    SELECT COUNT(*)
    INTO v_cnt 
    FROM jobs
    WHERE job_id =p_job_id;
    
    IF v_cnt=0 THEN --없다면 INSERT가 진행
        INSERT INTO jobs 
        VALUES(p_job_id,p_job_title,p_min_salary,p_max_salary);
        
    ELSE --있다면 결과를 추출.
        SELECT 
            p_job_id || '의 최대 연봉은 :'|| max_salary || ', 최소 연봉은:'|| min_salary
            INTO v_result -- 조회 결과 대입 
        FROM jobs
        WHERE job_id=p_job_id;
    END IF;
    
    --OUT 매개 변수에 결과를 할당
    p_result :=v_result;
        
    COMMIT;
END;

DECLARE
    str VARCHAR2(100);
BEGIN
    --프로시저를 부를 때 OUT되는 값을 받을 변수를 하나 더 전달해 줘야 한다.
    my_new_job_proc('JOB1','test job1',2000,8000,str);
    DBMS_OUTPUT.PUT_LINE(str);
    
    my_new_job_proc('CEO','test CEO',10000,100000,str);
    DBMS_OUTPUT.PUT_LINE(str);   
END;

----IN,OUT을 동시에 처리-------------------------------------------------------------
CREATE OR REPLACE PROCEDURE my_parameter_test_proc
(
    --IN으로 선언된 경우 반환 불가 
    p_var1 IN VARCHAR2,
    
    --OUT 변수는 프로시저가 끝나기 전까지는 값의 할당이 안됨 
    --프로시저가 끝나야 OUT이 가능.
    P_var2 OUT VARCHAR2,
    
    -- IN,OUT이 둘다 가능함.
    p_var3 IN OUT VARCHAR2
    
)
IS 
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('P_var1:'|| p_var1);  --출력 가능  ::value1
    DBMS_OUTPUT.PUT_LINE('P_var2:'|| p_var2);  --값이 전달이 안됨 (공백 출력) :: 
    DBMS_OUTPUT.PUT_LINE('P_var3:'|| p_var3);  --IN의 성질을 가지고 있어 출력 됨 ::value3
    
    
    --p_var1:='결과1';  -> IN이라는 키워드로 이루어져 있어서 재 할당 불가.
                        -- (받아서 활용만 가능하지 재할당 불가):오류 나서 주석처리 해야 함
    p_var2:='결과2';
    p_var3:='결과3';

    DBMS_OUTPUT.PUT_LINE('------------------------------------');
END;


DECLARE
    v_var1 VARCHAR2(10) :='value1';
    v_var2 VARCHAR2(10) :='value2';
    v_var3 VARCHAR2(10) :='value3';
BEGIN
    my_parameter_test_proc(v_var1,v_var2,v_var3); --프로시저로 값 전달
    
    
      DBMS_OUTPUT.PUT_LINE('v_var1:'|| v_var1); -- :: value1
      DBMS_OUTPUT.PUT_LINE('v_var2:'|| v_var2); --:: 결과2
      DBMS_OUTPUT.PUT_LINE('v_var3:'|| v_var3); --:: 결과3
END;


--RETURN--------------------------------------------------------------------
CREATE  OR REPLACE PROCEDURE my_new_job_proc
(
    p_job_id IN jobs.job_id%TYPE,
    P_result OUT VARCHAR2 
)
IS 
    v_cnt NUMBER :=0;
    v_result VARCHAR2(100) :='값이 존재하지 않아서 INSERT로  처리 되었습니다';
BEGIN

    SELECT COUNT(*)
    INTO v_cnt 
    FROM jobs
    WHERE job_id =p_job_id;
    
    IF v_cnt=0 THEN 
        DBMS_OUTPUT.PUT_LINE(p_job_id || '는 테이블에 존재하지 않습니다');
        RETURN; --프로시저를 강제 종료 시킴. 이후의 문장 실행 안함.
    END IF;
      
    SELECT 
         p_job_id || '의 최대 연봉은 :'|| max_salary || ', 최소 연봉은:'|| min_salary
         INTO v_result -- 조회 결과 대입 
    FROM jobs
    WHERE job_id=p_job_id;
        
    --OUT 매개 변수에 결과를 할당
    p_result :=v_result;
        
    COMMIT;
    
    
END;


DECLARE
    str VARCHAR2(100);
BEGIN
 -- my_new_job_proc('CEO',str); ::CEO 의 최대 연봉은 :100000, 최소 연봉은:10000
 
    my_new_job_proc('STUDENT',str); --::STUDENT는 테이블에 존재하지 않습니다.
  
    DBMS_OUTPUT.PUT_LINE(str);
END;

---예외 처리 ------------------------------------------------------
DECLARE
    v_num NUMBER :=0;
BEGIN
    v_num :=10/0;

EXCEPTION WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('0으로 나눌 수 없습니다.');
    DBMS_OUTPUT.PUT_LINE('SQL ERROR CODE '|| SQLCODE);
    DBMS_OUTPUT.PUT_LINE('ERROR MSG :' || SQLERRM);
END;

