--문제1
INSERT INTO depts(department_id,department_name,location_id)
VALUES(280,'개발',1800);
INSERT INTO depts(department_id,department_name,location_id)
VALUES(290,'회계부',1800);
INSERT INTO depts VALUES(300,'재정',301,1800);
INSERT INTO depts VALUES(310,'인사',302,1800);
INSERT INTO depts VALUES(320,'영업',303,1700);

SELECT * FROM depts;
commit;

--문제2
UPDATE depts SET department_name='IT bank' 
WHERE department_name='IT Support';

UPDATE depts SET manager_id=301 
WHERE department_id=290;

UPDATE depts 
SET department_name='IT Help',manager_id=303,location_id=1800 
WHERE department_name='IT Helpdesk';

UPDATE depts SET manager_id=301 
WHERE department_id=290 OR department_id=300 OR
department_id=310 OR department_id=320; 
--department_id IN (290,300,310,320)

SELECT * FROM depts;
commit;

--문제3
DELETE FROM depts WHERE department_name='영업';
DELETE FROM depts WHERE department_name='NOC';
-- department_id=320  , department_id=220
SELECT * FROM depts;
commit;

-------문제4 -1
DELETE FROM depts WHERE department_id>200;


--문제 4-2
UPDATE depts SET manager_id=100
WHERE manager_id IS NOT NULL;


--문제 4_3&4_4
MERGE INTO depts a
    USING (SELECT * FROM departments) b
    ON (a.department_id=b.department_id)
WHEN MATCHED THEN 
    UPDATE 
    SET
    a.department_name=b.department_name,
    a.manager_id=b.manager_id,
    a.location_id=b.location_id
WHEN NOT MATCHED THEN
    INSERT VALUES
    (b.department_id,b.department_name,
    b.manager_id,b.location_id);

SELECT * FROM depts;


--문제 5-1
select * FROM jobs;
CREATE TABLE jobs_it AS(SELECT * FROM jobs WHERE min_salary>6000);
 select * FROM jobs_it;
 
 --문제 5-2
 INSERT INTO jobs_it VALUES('IT_DEV','아이티개발팀',6000,20000);
 INSERT INTO jobs_it VALUES('NET_DEV','네트워크개발팀',5000,20000);
 INSERT INTO jobs_it VALUES('SEC_DEV','보안개발팀',6000,19000);

--문제 5-3&4
MERGE INTO jobs_it ji
    USING (SELECT * FROM jobs WHERE min_salary>=0) j
    ON (ji.job_id =j.job_id)
WHEN MATCHED THEN
    UPDATE SET 
    ji.min_salary=j.min_salary,
    ji.max_salary=j.max_salary
WHEN NOT MATCHED THEN
    INSERT VALUES(
    j.job_id,j.job_title,j.min_salary,j.max_salary);
    

    
