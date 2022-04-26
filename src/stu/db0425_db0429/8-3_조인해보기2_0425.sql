
--INNER JOIN : 내부 조인 
-- INNER JOIN에서 INNER 빼도, 기본적으로 INNER JOIN으로 동작
SELECT *
FROM info i JOIN auth a
ON i.auth_id=a.auth_id;

--오라클 문법(잘 사용 안합니다)
SELECT *
FROM info ,auth
WHERE info.auth_id=auth.auth_id;

--auth_id 컬럼을 그냥 쓰면 모호하다 라고 뜹니다.
--그 이유는 양쪽 테이블에 모두 존재하기 때문입니다.
--이럴 때 컬럼에 테이블 이름을 붙이던지, 별칭을 쓰셔서
--지목을 확실하게 해 주세요 .
SELECT  info.auth_id,title,content,name
FROM info INNER JOIN auth
ON info.auth_id=auth.auth_id;

--필요한 데이터만 조회하겠다 라고 한다면
--WHERE 구문을 통해 일반 조건을 걸어주시면 됩니다.
SELECT
    i.auth_id,i.title,i.content,
    a.name
FROM info i
INNER JOIN auth a
ON i.auth_id=a.auth_id
WHERE a.name='홍길자';


--외부조인 : OUTER JOIN  :빈 자리 null로 채워짐 
SELECT *
FROM info i LEFT OUTER JOIN auth a -- LEFT JOIN라고 해도 동작
ON i.auth_id=a.auth_id;

--오라클 문법
SELECT *
FROM info i,auth a
WHERE i.auth_id=a.auth_id(+);


SELECT *
FROM info i RIGHT OUTER JOIN auth a -- RIGHT JOIN라고 해도 동작
ON i.auth_id=a.auth_id;

--좌측 테이블과 우측테이블 데이터를 모두 읽어서 중복된 데이터는 삭제되는 외부 조인.
SELECT *
FROM info i FULL OUTER JOIN auth a -- FULL JOIN라고 해도 동작
ON i.auth_id=a.auth_id;

--CROSS JOIN 은 JOIN조건을 설정하지 않기 때문에
--모든 컬럼에 대해 JOIN을 진행합니다
--실제로는 거의 사용하지 않습니다.
SELECT *
FROM info 
CROSS JOIN auth
ORDER BY id ASC;

--여러 개 테이블 조인 -> 공통된 키 값만 찾아서 구문을 연결해서 쓰면 됩니다.
SELECT * 
FROM employees e
LEFT OUTER JOIN departments d ON e.department_id=d.department_id
LEFT OUTER JOIN locations loc ON d.department_id=loc.location_id;


/*
-테이블 별칭 a , i를 이용하여 LEFT OUTTER JOIN 사용
-info, auth 테이블 사용
-job 컬럼이 scientis인 사람의 id,title,content,job을 출력.
*/
-- info  : id ,title , content, regdate ,auth_id
-- auth : auth_id,name,job
--주로 기준이 되는 테이블은 왼쪽에 작성.
SELECT 
    i.id,i.title,i.content,a.job
FROM auth a
LEFT OUTER JOIN info i  --scientis는 info에 존재하지 않기 때문에 
ON i.auth_id=a.auth_id  --기준을 적절히 설정해야 한다.
WHERE a.job='scientist';
--조인의 기준에 따라 결과가 달라질 수 있다.


--SELF JOIN : 조인 조건에 일치하는 조건 아니면 조회 대상에 포함되지않음(삭제됨)
--여기서 Steven삭제 되었음
SELECT 
    e1.employee_id,e1.first_name,e1.manager_id,
    e2.first_name,e2.employee_id
FROM 
    employees e1 
JOIN 
    employees e2 
ON e1.manager_id=e2.employee_id;

