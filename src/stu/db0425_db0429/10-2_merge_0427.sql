
--MERGE :테이블 병합 \

/*
UPDATE와 INSERT를 한방에 처리 할 때  사용 : MERGE 

한 테이블에 해당하는 데이터가 있다면 UPDATE를,
없으면 INSER로 처리해라.

만약 MEGER 가 없었다면 해당 데이터의 존재 유무를 일일히 확인하고
IF문을 사용해서 데이터가 있다면 UPDATE , 없다면 ESLE 문을 사용해서
INSERT를 하라고 일일히 애기해야 하느데 , MERGE를 통해서 쉽게 처리 가능.
*/

--데이터 없이 구조만 복사 
CREATE TABLE emps_it AS (SELECT * FROM employees WHERE 1=2 ); 
SELECT* FROM emps_it;

INSERT INTO 
emps_it(employee_id,first_name,last_name,email,hire_date,job_id)
VALUES (105,'데이비드','김','DAVIDKIM','22/4/27','IT_PROG');

SELECT* FROM employees
WHERE job_id='IT_PROG';


MERGE INTO emps_it a --(머지를 할 타겟 테이블을 작성)a를 기준으로 b를 합침
USING --병합 시킬 데이터 
    (SELECT * FROM employees WHERE job_id='IT_PROG') b --조인 구문
    ON --병합 시킬 데이터의 연결 조건 
    (a.employee_id =b.employee_id) --조인 조건과 유사
WHEN MATCHED THEN -- 조건에 일치할 경우 타겟 테이블에 이렇게 실행해라.
    UPDATE SET 
        a.phone_number=b.phone_number,
        a.hire_date=b.hire_date,
        a.salary=b.salary,
        a.commission_pct=b.commission_pct,
        a.manager_id=b.manager_id,
        a.department_id=b.department_id
        /*
        oracle 10버전 이후 DELETE를 사용 할 수 있는데 ,
        DELETE만 단독으로 사용 불가 -->UPDATE 이후에 DELETE 작성이 가능
        UPDATE된 대상을 DELETE하도록 설계 되어 있기 때문에
        삭제할 대상 컬럼들을 동일한 값으로 일단 UPDATE를 진행하고
        DELETE의 WHERE절에 아까 지정한 동일한 값을 지정해서 삭제합니다.
        */
    DELETE    --어차피 DELETE할거면 UPDATE SET에서 위 처럼하지말고,
            --간단히 값만 변경해서 삭제하는게 더 낫다
        WHERE a.employee_id=b.employee_id 
        
        
        
WHEN NOT MATCHED THEN --조건에 일치하지 않는 경우 타겟 테이블에 실행
    INSERT /*속성(컬럼) : 다 안넣을거면 컬럼명 작성*/  
        VALUES(b.employee_id,b.first_name, b.last_name,b.email,
        b.phone_number,b.hire_date,b.job_id,b.salary,
        b.commission_pct,b.manager_id,b.department_id);  
        
SELECT * FROM emps_it;


---------------------------------------------------------------------------------
INSERT INTO emps_it
    (employee_id, first_name, last_name, email, hire_date, job_id)
VALUES(102, '렉스', '박', 'LEXPARK', '01/04/06', 'AD_VP');
INSERT INTO emps_it
    (employee_id, first_name, last_name, email, hire_date, job_id)
VALUES(101, '니나', '최', 'NINA', '20/04/06', 'AD_VP');
INSERT INTO emps_it
    (employee_id, first_name, last_name, email, hire_date, job_id)
VALUES(103, '흥민', '손', 'HMSON', '20/04/06', 'AD_VP');

--employees 테이블을 매번 수정되는 테이블이라고 가정하자 .
--기존의 데이터는 email,phone,salary,comm_pct,man_id,dept_id
--는 업데이트 하도록 처리 .
--새로 유입되는 데이터는 그대로 추가 .

MERGE INTO emps_it a 
    USING (SELECT * FROM employees) b
    ON 
        (a.employee_id=b.employee_id)
WHEN MATCHED THEN
    UPDATE SET
    a.email=b.email,
    a.phone_number=b.phone_number,
    a.salary=b.salary,
    a.commission_pct=b.commission_pct,
    a.manager_id=b.manager_id,
    a.department_id=b.department_id
WHEN NOT MATCHED THEN
    INSERT 
    VALUES(b.employee_id,b.first_name, b.last_name,b.email,
        b.phone_number,b.hire_date,b.job_id,b.salary,
        b.commission_pct,b.manager_id,b.department_id); 


SELECT * FROM emps_it ORDER BY employee_id ASC;

ROLLBACK;

SELECT * FROM emps_it;


